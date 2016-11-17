/*
 * Tesla REST API - Default values to be used for testing
 */
package com.servebeer.please.tesla_client;

class TestDefaults {

    // if you want to run the integration tests (*IT.java), you will have to modify these
    static final String TEST_USER_EMAIL_ADDRESS = "elon@teslamotors";
    static final String TEST_USER_PASSWORD = "edisonsux";

    // if you have more than one vehicle and don't want to test with the first one, you will have to modify this
    static final int TEST_VEHICLE_NUMBER = 0;

    static final boolean DEBUGGING_ENABLED = true;

}
