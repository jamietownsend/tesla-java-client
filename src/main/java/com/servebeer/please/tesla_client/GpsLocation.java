package com.servebeer.please.tesla_client;

import java.math.BigDecimal;

public class GpsLocation {
    // declare private class level variables
    private float latitude;
    private float longitude;

    public GpsLocation(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}

