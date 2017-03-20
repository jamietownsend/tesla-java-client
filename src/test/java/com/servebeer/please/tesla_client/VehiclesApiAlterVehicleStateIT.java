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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * API tests for VehiclesApi - un-@Ignore the tests you want to run
 */
public class VehiclesApiAlterVehicleStateIT {

    private static final VehiclesApi vehiclesApi = new VehiclesApi();
    private static long testId = 0;
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

        authorization = TeslaSecurityManager.getAuthorizationToken(TestDefaults.TEST_USER_EMAIL_ADDRESS, TestDefaults.TEST_USER_PASSWORD);
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

    // TODO this should be able to be deleted
    /**
     * WARNING - if the current limit is not one of the minimum, standard or maximum limits, executing this test
     * will reset the current limit to the standard limit.
     */
/*
    @Ignore
    @Test
    public void setChargeLimitToMinimumTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = vehiclesApi.getChargeState(authorization, testId).getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the minimum limit, set the limit to the maximum limit first
        if (originalLimit == minLimit) {
            vehiclesApi.setChargeLimitToMaximum(authorization, testId);

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", maxLimit, (int) vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the minimum value
        AlterVehicleStateResponse setLimitResponse = vehiclesApi.setChargeLimit(authorization, testId, "50");
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to minimum", minLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit != currentLimit) {
            // setting directly to standard doesn't always work, so set to max first
            vehiclesApi.setChargeLimitToMaximum(authorization, testId);
            if (originalLimit != maxLimit) {
                vehiclesApi.setChargeLimitToStandard(authorization, testId);
            }
        }

    }
    */

    @Test
    public void setChargeLimitToSpecificLimitTest() throws Exception {
        SetChargeLimitBody body = new SetChargeLimitBody();
        body.setPercent(75);
        vehiclesApi.setChargeLimit(authorization, testId, body);

    }

    @Test
    public void setChargeLimitToMinimumTest() throws Exception {
        SetChargeLimitBody body = new SetChargeLimitBody();
        body.setPercent(50);
        vehiclesApi.setChargeLimit(authorization, testId, body);

    }

    @Test
    public void setChargeLimitToStandardTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = vehiclesApi.getChargeState(authorization, testId).getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int stdLimit = getStateResponse.getChargeLimitSocStd();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the maximum limit, set the limit to the maximum limit first
        if (originalLimit == stdLimit) {
            vehiclesApi.setChargeLimitToMaximum(authorization, testId);

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", maxLimit, (int) vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the standard value
        AlterVehicleStateResponse setLimitResponse = vehiclesApi.setChargeLimitToStandard(authorization, testId);
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to standard", stdLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit == maxLimit) {
            vehiclesApi.setChargeLimitToMaximum(authorization, testId);
        } else if (originalLimit == minLimit) {
//TODO reenable            vehiclesApi.setChargeLimitToMinimum(authorization, testId);
        }

    }

    @Ignore
    @Test
    public void setChargeLimitToMaximumTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = vehiclesApi.getChargeState(authorization, testId).getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the maximum limit, set the limit to the minimum limit first
        if (originalLimit == maxLimit) {
//TODO reenable this            vehiclesApi.setChargeLimitToMinimum(authorization, testId);

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", minLimit, (int) vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the maximum value
        AlterVehicleStateResponse setLimitResponse = vehiclesApi.setChargeLimitToMaximum(authorization, testId);
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = vehiclesApi.getChargeState(authorization, testId).getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to maximum", maxLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit != currentLimit) {
            // setting directly to standard doesn't always work, so set to min first
            if (originalLimit == minLimit) {
//TODO reenable this                vehiclesApi.setChargeLimitToMinimum(authorization, testId);
            } else {
                vehiclesApi.setChargeLimitToStandard(authorization, testId);
            }
        }

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
