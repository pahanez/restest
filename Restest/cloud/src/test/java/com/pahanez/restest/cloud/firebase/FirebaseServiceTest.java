package com.pahanez.restest.cloud.firebase;

import com.pahanez.restest.cloud.CloudProvider;
import com.pahanez.restest.cloud.CloudType;
import com.pahanez.restest.cloud.FirebaseCloudProvider;
import com.pahanez.restest.cloud.callback.AuthCallback;
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
public class FirebaseServiceTest {

    public static final String TAG = FirebaseServiceTest.class.getSimpleName();

    private static final String WRONG_EMAIL = "wrongemail@wrong.com";
    private static final String WRONG_PSWD  = "wrongpass1";
    private static final String OK_EMAIL = "roboadmin@robo.cop";
    private static final String OK_PSWD = "robopass";

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
        System.out.println(TAG + METHOD + "start" );

        AuthService authService = mCloudProvider.getAuthService();
        Assert.assertTrue(authService instanceof FirebaseAuthService);

        AuthCallback callback = createAuthCallback();
        authService.signin(WRONG_EMAIL, WRONG_PSWD, callback);
        sleep(3);
        Mockito.verify(callback).authError(ErrorType.AUTH);
    }

    @Test
    public void testFirebaseServiceAuthWithOkCreds() {
        final String METHOD = " [testFirebaseServiceAuthWithOkCreds] ";
        System.out.println(TAG + METHOD + "start");

        AuthService authService = mCloudProvider.getAuthService();
        Assert.assertTrue(authService instanceof FirebaseAuthService);

        AuthCallback callback = createAuthCallback();
        authService.signin(OK_EMAIL, OK_PSWD, callback);
        sleep(3);

        Mockito.verify(callback, Mockito.times(1)).authComplete((AuthData) Mockito.notNull());

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

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
