package com.pahanez.restest.network;

import com.pahanez.restest.network.service.AuthService;
import com.pahanez.restest.network.service.ToyService;
import com.pahanez.restest.network.util.CloudInitializer;

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
                    return null;

            }
            throw new IllegalStateException("not configured");
        }
    }
}
