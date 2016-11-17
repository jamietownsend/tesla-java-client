/*
 * Tesla REST API - Tests for the Vehicles API
 */
package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;
import com.servebeer.please.tesla_client.generated.model.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * API tests for VehiclesApi - un-@Ignore the tests you want to run
 */
public class VehiclesApiAlterVehicleStateIT {

    private static long testId = 0;

    private static final VehiclesApi vehiclesApi = new VehiclesApi();
    private static String authorization = "";

    /**
     * Retieves the id of the first vehicleId so it can be used for further tests
     *
     * @throws ApiException if the Api call fails
     */
    private static long getFirstId() throws ApiException {
        ListAllVehiclesResponse listAllVehiclesResponse = vehiclesApi.listAllVehicles(authorization);
        return listAllVehiclesResponse.getResponse().get(0).getId();

    }

    /**
     * run once for the class before any tests are executed
     */
    @BeforeClass
    public static void beforeClass() throws ApiException {

        authorization = ConnectionManager.getAuthorization(TestDefaults.TEST_USER_EMAIL_ADDRESS, TestDefaults.TEST_USER_PASSWORD);
        vehiclesApi.setApiClient(vehiclesApi.getApiClient().setDebugging(TestDefaults.DEBUGGING_ENABLED));
        VehiclesApiAlterVehicleStateIT.testId = getFirstId();
    }

    // I can't test this as my Model X doesn't have a sun roof. So this throws a 400-er, which I tried to catch with the swagger configuration
    // but I haven't got that to work properly yet.
    @Ignore
    @Test
    public void controlSunRoofTest() throws Exception {

        // because of the mutliple return code handling, we should do the following
        // vehiclesApi.controlSunRoofAsync(authorization, testId, "open", null, new VehiclesApiCallback());

        // unfortunately this returns nothing any more
        vehiclesApi.controlSunRoof(authorization, testId, "open", null);

        // String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        // assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Test
    public void flashLightsTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.flashLights(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void enableRemoteDrivingTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.enableRemoteDriving(authorization, testId, TestDefaults.TEST_USER_PASSWORD);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    // Don't wake the whole neighbourhood like I did ;-)
    @Ignore
    @Test
    public void honkHornTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.honkHorn(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void lockDoorsTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.lockDoors(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void unlockDoorsTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.unlockDoors(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    // I've never tried this one yet
    @Ignore
    @Test
    public void openTrunkTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.openTrunk(authorization, testId, "rear");

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void setChargeTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.setChargeLimit(authorization, testId, 23);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void setChargeMaxTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.setChargeMaxRange(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    // this one is always failing. I don't know why,  do YOU ??
    @Ignore
    @Test
    public void setValetTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.setValetMode(authorization, testId, true, 1234);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void startChargingTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.startCharging(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void stopChargingTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.stopCharging(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void wakeVehicleTest() throws Exception {
        AlterVehicleStateResponse response = vehiclesApi.wakeVehicle(authorization, testId);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }
}
