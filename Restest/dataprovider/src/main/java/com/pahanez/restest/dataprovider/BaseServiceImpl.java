package com.pahanez.restest.dataprovider;

import com.pahanez.restest.network.CloudProvider;
import com.pahanez.restest.network.CloudType;

/**
 * Created by pindziukou on 21/11/15.
 */
public class BaseServiceImpl implements BaseService {


    @Override
    public CloudProvider getCloudProvider() {
        return new CloudProvider.CloudProviderBuilder().setType(CloudType.FIREBASE).build();
    }

}
