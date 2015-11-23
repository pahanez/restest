package com.pahanez.restest.cloud;


import com.pahanez.restest.cloud.service.AuthService;
import com.pahanez.restest.cloud.service.ToyService;
import com.pahanez.restest.cloud.util.CloudInitializer;

/**
 * Created by pindziukou on 21/11/15.
 */
public interface CloudProvider {

    void init(CloudInitializer initializer);
    ToyService getToyService();
    AuthService getAuthService();


    class CloudProviderBuilder {
        private CloudType mType = CloudType.UNKNOWN;

        public CloudProviderBuilder() {}

        public CloudProviderBuilder setType(CloudType type) {
            mType = type;
            return this;
        }

        public CloudProvider build() {
            switch (mType) {
                case ENDPOINT:
                    return new EndpointsCloudProvider();
                case FIREBASE:
                    return new FirebaseCloudProvider();

            }
            throw new IllegalStateException("not configured");
        }
    }
}
