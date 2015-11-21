/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.pahanez.restest.endpoint.toys;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "toys.endpoint.restest.pahanez.com",
    ownerName = "toys.endpoint.restest.pahanez.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi", httpMethod = ApiMethod.HttpMethod.GET)
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    //http://localhost:8080/_ah/api/myApi/v1/test пельмешка°
    @ApiMethod(name = "test", httpMethod = ApiMethod.HttpMethod.GET)
    public MyBean test() {
        MyBean response = new MyBean();
        response.setData("Hi, 1111 TEST");

        return response;
    }

}
