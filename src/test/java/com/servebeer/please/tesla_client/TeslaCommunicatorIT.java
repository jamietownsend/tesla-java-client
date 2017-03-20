/*
 * Tesla REST API - Tests for the Vehicles API
 */
package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.model.AlterVehicleStateResponse;
import com.servebeer.please.tesla_client.generated.model.ChargeStateResponseResponse;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * API tests for VehiclesApi - un-@Ignore the tests you want to run
 */
public class TeslaCommunicatorIT {

    private static TeslaCommunicator teslaCommunicator = null;

    /**
     * run once for the class before any tests are executed
     */
    @BeforeClass
    public static void beforeClass() throws ApiException {
        teslaCommunicator = new TeslaCommunicator(TestDefaults.TEST_USER_EMAIL_ADDRESS, TestDefaults.TEST_USER_PASSWORD);
    }

    @Test
    public void getChargerPowerTest() throws Exception {
        System.out.println("getChargerPower: " + teslaCommunicator.getChargerPower());
    }

    /**
     * WARNING - if the current limit is not one of the minimum, standard or maximum limits, executing this test
     * will reset the current limit to the standard limit.
     */
    @Test
    public void setChargeLimitToMinimumTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = teslaCommunicator.getChargeState().getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the minimum limit, set the limit to the maximum limit first
        if (originalLimit == minLimit) {
            teslaCommunicator.setChargeLimitToMaximum();

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", maxLimit, (int) teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the minimum value
        AlterVehicleStateResponse setLimitResponse = teslaCommunicator.setChargeLimitToMinimum();
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to minimum", minLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit != currentLimit) {
            // setting directly to standard doesn't always work, so set to max first
            teslaCommunicator.setChargeLimitToMaximum();
            if (originalLimit != maxLimit) {
                teslaCommunicator.setChargeLimitToStandard();
            }
        }

    }

    @Test
    public void setChargeLimitToStandardTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = teslaCommunicator.getChargeState().getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int stdLimit = getStateResponse.getChargeLimitSocStd();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the maximum limit, set the limit to the maximum limit first
        if (originalLimit == stdLimit) {
            teslaCommunicator.setChargeLimitToMaximum();

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", maxLimit, (int) teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the standard value
        AlterVehicleStateResponse setLimitResponse = teslaCommunicator.setChargeLimitToStandard();
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to standard", stdLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit == maxLimit) {
            teslaCommunicator.setChargeLimitToMaximum();
        } else if (originalLimit == minLimit) {
            teslaCommunicator.setChargeLimitToMinimum();
        }

    }

    @Test
    public void setChargeLimitToMaximumTest() throws Exception {

        // figure out what the current limit is set to
        ChargeStateResponseResponse getStateResponse = teslaCommunicator.getChargeState().getResponse();
        int originalLimit = getStateResponse.getChargeLimitSoc();
        int minLimit = getStateResponse.getChargeLimitSocMin();
        int maxLimit = getStateResponse.getChargeLimitSocMax();

        // if the original limit is already the maximum limit, set the limit to the minimum limit first
        if (originalLimit == maxLimit) {
            teslaCommunicator.setChargeLimitToMinimum();

            // check to see if that worked okay.
            assertEquals("Whoops - problems setting up the test", minLimit, (int) teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc());
        }

        // this is the actual test - set the charge limit to the maximum value
        AlterVehicleStateResponse setLimitResponse = teslaCommunicator.setChargeLimitToMaximum();
        String reason = (setLimitResponse.getResponse() != null && setLimitResponse.getResponse().getReason() != null) ? setLimitResponse.getResponse().getReason() : "Reason found in response";

        // test the response
        int currentLimit = teslaCommunicator.getChargeState().getResponse().getChargeLimitSoc();
        assertEquals("Charge limit was not successfully set to maximum", maxLimit, currentLimit);

        // reset the limit if necessary
        if (originalLimit != currentLimit) {
            // setting directly to standard doesn't always work, so set to min first
            if (originalLimit == minLimit) {
                teslaCommunicator.setChargeLimitToMinimum();
            } else {
                teslaCommunicator.setChargeLimitToStandard();
            }
        }

    }

    // this one is always failing. I don't know why,  do YOU ??
    @Ignore
    @Test
    public void setValetTest() throws Exception {
        AlterVehicleStateResponse response = teslaCommunicator.setValetMode(true, 1234);

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void startChargingTest() throws Exception {
        AlterVehicleStateResponse response = teslaCommunicator.startCharging();

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void stopChargingTest() throws Exception {
        AlterVehicleStateResponse response = teslaCommunicator.stopCharging();

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }

    @Ignore
    @Test
    public void wakeVehicleTest() throws Exception {
        AlterVehicleStateResponse response = teslaCommunicator.wakeVehicle();

        String reason = (response.getResponse() != null && response.getResponse().getReason() != null) ? response.getResponse().getReason() : "Reason found in response";
        assertTrue("Error - server reason: " + reason, response.getResponse().getResult());
    }
}
