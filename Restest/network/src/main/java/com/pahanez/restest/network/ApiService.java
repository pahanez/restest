package com.pahanez.restest.network;

import android.support.annotation.IntDef;

import com.pahanez.restest.network.api.ToyApi;
import com.pahanez.restest.network.util.Constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by pindziukou on 13/11/15.
 */
public class ApiService {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MOCKABLE_API, GOOGLE_ENDPOINTS_API})
    public @interface ApiType {}

    public static final int MOCKABLE_API = 500;
    public static final int GOOGLE_ENDPOINTS_API = 501;

    private ApiService(ToyApi api) {
        mApi = api;
    }
    public static class ApiServiceBuilder {

        private String mUrl;

        public ApiServiceBuilder setType(@ApiType int type) {
            switch (type) {
                case MOCKABLE_API:
                    mUrl = Constants.MOCKABLE_IO_API_URL;
                    break;
                case GOOGLE_ENDPOINTS_API:

                    break;
            }
            return this;
        }

        public ApiService build() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(mUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ToyApi api = retrofit.create(ToyApi.class);
            return new ApiService(api);
        }
    }

    private final ToyApi mApi;

    public ToyApi getCommonApi() {
        return mApi;
    }

}
