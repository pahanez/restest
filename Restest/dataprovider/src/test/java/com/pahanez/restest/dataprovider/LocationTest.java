package com.pahanez.restest.dataprovider;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import org.junit.Test;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLocationManager;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by pindziukou on 12/11/15.
 */
public class LocationTest extends BaseTest {

    @Test
    public void shouldReturnTheLatestLocation() {
        LocationManager locationManager = (LocationManager)
                RuntimeEnvironment.application.getSystemService(Context.LOCATION_SERVICE);
        ShadowLocationManager shadowLocationManager = shadowOf(locationManager);
        Location expectedLocation = location(LocationManager.GPS_PROVIDER, 12.0, 20.0);
        shadowLocationManager.simulateLocation(expectedLocation);
        System.out.println(""+expectedLocation.toString());
//        Location actualLocation = mainActivity.latestLocation();
//        assertEquals(expectedLocation, actualLocation);
    }

    private Location location(String provider, double latitude, double longitude) {
        Location location = new Location(provider);
        location.setLatitude(latitude);
        location.setLongitude(longitude);
        location.setTime(System.currentTimeMillis());
        return location;
    }

    @Test
    public void testWithMockito() {
        LocationManager locationManager = Mockito.mock(LocationManager.class);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100, .2f, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                System.out.println("onLocationChanged"+location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                System.out.println("onStatusChanged"+provider);
            }

            @Override
            public void onProviderEnabled(String provider) {
                System.out.println("onProviderEnabled"+provider);
            }

            @Override
            public void onProviderDisabled(String provider) {
                System.out.println("onProviderDisabled"+provider);
            }
        });
//        lot.setLocationManager(locationManager);

        long refTime = 100;
        int refreshDistance = 2;

//        lot.setRefreshTime(refTime);
//        lot.setRefreshDistance(refreshDistance);
//        lot.startSniffing();

        verify(locationManager, times(1)).requestLocationUpdates(eq(LocationManager.GPS_PROVIDER),
                eq(refTime), eq(.2f), any(LocationListener.class));
    }

}
