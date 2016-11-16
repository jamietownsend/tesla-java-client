/*
 * Tesla REST API - Tests for the Vehicles API
 */
package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;
import com.servebeer.please.tesla_client.generated.model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * API tests for VehiclesApi
 */
public class VehiclesApiIT {

    public static long testId = 0;

    private static final VehiclesApi vehiclesApi = new VehiclesApi();
    private static String authorization = "";

    /**
     *
     * Retieves the id of the first vehicleId so it can be used for further tests
     *
     * @throws ApiException
     *          if the Api call fails
     */
    public static long getFirstId() throws ApiException {
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
        VehiclesApiIT.testId = getFirstId();
    }

    /**
     *
     *
     * Returns the state of charge in the battery.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getChargeStateTest() throws ApiException {
        ChargeStateResponse response = vehiclesApi.getChargeState(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);

    }

    /**
     *
     *
     * Returns the current temperature and climate control state.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getClimateStateTest() throws ApiException {
        ClimateStateResponse response = vehiclesApi.getClimateState(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

    /**
     *
     *
     * Returns the driving and position state of the vehicle.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDriveStateTest() throws ApiException {
        DriveStateResponse response = vehiclesApi.getDriveState(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

    /**
     *
     *
     * Returns various information about the GUI settings of the car, such as unit format and range display.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getGuiSettingsTest() throws ApiException {
        GuiSettingsResponse response = vehiclesApi.getGuiSettings(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

    /**
     *
     *
     * Determines if mobile access to the vehicle is enabled.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void isMobileEnabledTest() throws ApiException {
        MobileAccessResponse response = vehiclesApi.isMobileEnabled(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

    /**
     *
     *
     * Retrieve a list of your owned vehicles (includes vehicles not yet shipped!)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void listAllVehiclesTest() throws ApiException {
        // sampleResponse = {"response":[{"id":45800807942393617,"vehicle_id":1419973848,"vin":"5YJXCCE22GF009859","display_name":"009859","option_codes":"MDLX,REEU,AD15,AF00,AH00,AU00,BC0B,BP00,BS00,BTX4,CC03,CDM0,CF00,CH04,COCH,PPSB,CW00,DA02,DRLH,DSH5,DV4W,FG00,FR01,GLFR,HP00,IDHM,IX00,LP00,LT1B,ME02,MI00,MX01,OSSB,PA00,PF00,PI00,PK00,PS00,QPBT,RFPX,S01B,SC01,SP01,SR01,ST01,SU01,TIM7,TM00,TP00,TR01,TRA1,TW01,UM01,UTPW,WT20,X001,X003,X007,X011,X014,X021,X025,X026,X028,X031,X037,X039,X041,X043,YFCC","color":null,"tokens":["411434a7220f4567","f9d2b505406ee14b"],"state":"online","in_service":null,"id_s":"45800807942393617","remote_start_enabled":true,"calendar_enabled":true,"notifications_enabled":true,"backseat_token":null,"backseat_token_updated_at":null}],"count":1}
        ListAllVehiclesResponse response = vehiclesApi.listAllVehicles(authorization);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

    /**
     *
     *
     * Returns the vehicle&#39;s physical state, such as which doors are open.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getVehicleStateTest() throws ApiException {
        VehicleStateResponse response = vehiclesApi.getVehicleState(authorization, testId);

        assertTrue("Expected response not received", response.getResponse() != null);
    }

}
