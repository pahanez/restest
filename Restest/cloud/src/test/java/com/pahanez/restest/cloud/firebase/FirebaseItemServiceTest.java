package com.pahanez.restest.cloud.firebase;

import com.pahanez.restest.cloud.CloudProvider;
import com.pahanez.restest.cloud.CloudType;
import com.pahanez.restest.cloud.FirebaseCloudProvider;
import com.pahanez.restest.cloud.callback.AuthCallback;
import com.pahanez.restest.cloud.callback.CompletionCallback;
import com.pahanez.restest.cloud.callback.CompletionCallbackExtended;
import com.pahanez.restest.cloud.callback.ErrorType;
import com.pahanez.restest.cloud.entity.AuthData;
import com.pahanez.restest.cloud.service.AuthService;
import com.pahanez.restest.cloud.service.FirebaseToyService;
import com.pahanez.restest.cloud.service.ToyService;
import com.pahanez.restest.cloud.util.CloudInitializer;
import com.pahanez.restest.data.entity.Toy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by pindziukou on 24/11/15.
 */
public class FirebaseItemServiceTest {

    private static final String TAG =  FirebaseItemServiceTest.class.getSimpleName();
    private static final String OK_EMAIL = "roboadmin@robo.cop";
    private static final String OK_PSWD = "robopass";
    private static final int DEFAULT_SLEEP_SEC = 3;

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
    public void testUnauthAccess() {
        ToyService toyService = getToyService();
        mCloudProvider.getAuthService().signout(createCompletionCallback());
        sleep();

        CompletionCallback notAuthCallback = createCompletionCallback();
        toyService.createToy(null, notAuthCallback);
        sleep();

        Mockito.verify(notAuthCallback).onError(ErrorType.NOT_AUTHORIZED);
    }

    //redundant
    public void testCreateItemWithService() {
        auth();
        ToyService toyService = getToyService();

        Toy toyToCreate = generateToy();
        CompletionCallback createToyCallback = createCompletionCallback();
        toyService.createToy(toyToCreate, createToyCallback);
        sleep();
        Mockito.verify(createToyCallback).onSuccess();
    }

    @Test
    public void testCreateAndRemoveItemWithSerice() {
        auth();
        ToyService toyService = getToyService();

        Toy toyToCreate = generateToy();
        CompletionCallback createToyCallback = createCompletionCallback();
        toyService.createToy(toyToCreate, createToyCallback);
        sleep();
        Mockito.verify(createToyCallback).onSuccess();

        CompletionCallback removeToyCallback = createCompletionCallback();
        toyService.removeToy(toyToCreate, removeToyCallback);
        sleep();
        Mockito.verify(removeToyCallback).onSuccess();
    }

    @Test
    public void testGetAllItemsWithService() {
        auth();

        ToyService toyService = getToyService();
        createToy(toyService);

        CompletionCallbackExtended<List<Toy>> getAllToysCallback = createCompletionCallbackExtended();
        toyService.getAllToys(getAllToysCallback);
        sleep();

        Mockito.verify(getAllToysCallback, Mockito.times(1)).onSuccess((List<Toy>) Mockito.notNull());




    }

    private void createToy(ToyService toyService) {
        Toy toyToCreate = generateToy();
        CompletionCallback createToyCallback = createCompletionCallback();
        toyService.createToy(toyToCreate, createToyCallback);
        sleep();
        Mockito.verify(createToyCallback).onSuccess();
    }

    private void auth() {
        AuthService authService = mCloudProvider.getAuthService();

        AuthCallback callback = createAuthCallback();
        authService.signin(OK_EMAIL, OK_PSWD, callback);
        sleep(5);

        Mockito.verify(callback, Mockito.times(1)).authComplete((AuthData) Mockito.notNull());
    }

    private ToyService getToyService() {
        ToyService toyService = mCloudProvider.getToyService();
        Assert.assertTrue(toyService instanceof FirebaseToyService);
        return toyService;
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

    private CompletionCallbackExtended createCompletionCallbackExtended() {
        return Mockito.spy(new CompletionCallbackExtended<List<Toy>>() {
            @Override
            public void onSuccess(List<Toy> result) {
                System.out.println(TAG + " CompletionCallback success: result: " + result);
            }

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

    private void sleep() {
        sleep(DEFAULT_SLEEP_SEC);
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Toy generateToy() {
        Random random = new Random();
        Toy toy = new Toy();
        toy.setId(UUID.randomUUID().toString());
        toy.setChangedTime(System.currentTimeMillis());
        toy.setName("gen toy : " + random.nextInt(5000));
        toy.setRed(random.nextBoolean());
        return toy;
    }
}
