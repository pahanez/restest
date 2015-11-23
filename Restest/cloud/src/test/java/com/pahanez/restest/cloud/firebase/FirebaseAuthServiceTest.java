package com.pahanez.restest.cloud.firebase;

import com.pahanez.restest.cloud.CloudProvider;
import com.pahanez.restest.cloud.CloudType;
import com.pahanez.restest.cloud.FirebaseCloudProvider;
import com.pahanez.restest.cloud.callback.AuthCallback;
import com.pahanez.restest.cloud.callback.CompletionCallback;
import com.pahanez.restest.cloud.callback.ErrorType;
import com.pahanez.restest.cloud.entity.AuthData;
import com.pahanez.restest.cloud.service.AuthService;
import com.pahanez.restest.cloud.service.FirebaseAuthService;
import com.pahanez.restest.cloud.util.CloudInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 23/11/15.
 */
public class FirebaseAuthServiceTest {

    public static final String TAG = FirebaseAuthServiceTest.class.getSimpleName();

    private static final String WRONG_EMAIL = "wrongemail@wrong.com";
    private static final String WRONG_PSWD  = "wrongpass1";
    private static final String OK_EMAIL = "roboadmin@robo.cop";
    private static final String OK_PSWD = "robopass";
    private static final String UP_EMAIL = "kittenfinger@kf.com";
    private static final String UP_PSWD = "awekittness";
    private static final int DEFAULT_SLEEP = 3;

    private CloudProvider mCloudProvider;

    @Before
    public void setup() {
        mCloudProvider = new CloudProvider.CloudProviderBuilder()
                .setType(CloudType.FIREBASE)
                .build();
        mCloudProvider.init(new CloudInitializer() {
            @Override
            public void init() {
                System.out.println(TAG + " setup " + " inited");
            }
        });
        Assert.assertTrue(mCloudProvider instanceof FirebaseCloudProvider);
    }

    @Test
    public void testFirebaseServiceAuthWithWrongCreds() {
        final String METHOD = " [testFirebaseServiceAuthWithWrongCreds] ";
        System.out.println(TAG + METHOD + "start");

        AuthService authService = getAuthService();

        AuthCallback callback = createAuthCallback();
        authService.signin(WRONG_EMAIL, WRONG_PSWD, callback);
        sleep();
        Mockito.verify(callback).authError(ErrorType.AUTH);
    }

    @Test
    public void testFirebaseServiceAuthWithOkCreds() {
        final String METHOD = " [testFirebaseServiceAuthWithOkCreds] ";
        System.out.println(TAG + METHOD + "start");

        AuthService authService = getAuthService();

        AuthCallback callback = createAuthCallback();
        authService.signin(OK_EMAIL, OK_PSWD, callback);
        sleep();

        Mockito.verify(callback, Mockito.times(1)).authComplete((AuthData) Mockito.notNull());
    }

    @Test
    public void testAuthCreateUser() {
        final String METHOD = " [testAuthCreateUser] ";
        System.out.println(TAG + METHOD + "start");

        AuthService authService = getAuthService();

        CompletionCallback preremoveUserCallback = createCompletionCallback();
        authService.removeUser(UP_EMAIL, UP_PSWD, preremoveUserCallback);
        sleep();

        //registration
        CompletionCallback signUpCallback = createCompletionCallback();
        authService.signup(UP_EMAIL, UP_PSWD, signUpCallback);
        sleep();
        Mockito.verify(signUpCallback, Mockito.times(1)).onSuccess();

        //authorization
        AuthCallback callback = createAuthCallback();
        authService.signin(UP_EMAIL, UP_PSWD, callback);
        sleep();
        Mockito.verify(callback, Mockito.times(1)).authComplete((AuthData) Mockito.notNull());

        //clean user
        CompletionCallback removeUserCallback = createCompletionCallback();
        authService.removeUser(UP_EMAIL, UP_PSWD, removeUserCallback);
        sleep();
        Mockito.verify(removeUserCallback, Mockito.times(1)).onSuccess();
    }

    @Test
    public void testAuthSignout() {
        final String METHOD = " [testAuthCreateUser] ";
        System.out.println(TAG + METHOD + "start");

        AuthService authService = getAuthService();

        CompletionCallback errorUnauthCallback = createCompletionCallback();
        authService.signout(errorUnauthCallback);
        sleep();
        Assert.assertFalse(authService.isLoggedIn());

        AuthCallback callback = createAuthCallback();
        authService.signin(OK_EMAIL, OK_PSWD, callback);
        sleep();
        Mockito.verify(callback, Mockito.times(1)).authComplete((AuthData) Mockito.notNull());

        CompletionCallback unauthCallback = createCompletionCallback();
        authService.signout(unauthCallback);
        sleep();
        Mockito.verify(unauthCallback, Mockito.times(1)).onSuccess();
    }

    private AuthService getAuthService() {
        AuthService authService = mCloudProvider.getAuthService();
        Assert.assertTrue(authService instanceof FirebaseAuthService);
        return authService;
    }

    private AuthCallback createAuthCallback() {
        return Mockito.spy(new AuthCallback() {
            @Override
            public void authComplete(AuthData authData) {
                System.out.println(TAG + " AuthCallback authComplete " + authData.contains(ConstFirebase.AUTH_DATA_KEY) );
            }

            @Override
            public void authError(ErrorType type) {
                System.out.println(TAG + " AuthCallback error type " + type );
            }
        });
    }

    private CompletionCallback createCompletionCallback() {
        return Mockito.spy(new CompletionCallback() {
            @Override
            public void onSuccess() {
                System.out.println(TAG + " CompletionCallback success ");
            }

            @Override
            public void onError(ErrorType errorType) {
                System.out.println(TAG + " CompletionCallback error : " + errorType);
            }
        });
    }

    private void sleep() {
        sleep(DEFAULT_SLEEP);
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
