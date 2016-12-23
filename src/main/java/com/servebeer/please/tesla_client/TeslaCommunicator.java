package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;
import com.servebeer.please.tesla_client.generated.model.AlterVehicleStateResponse;
import com.servebeer.please.tesla_client.generated.model.ChargeStateResponse;
import com.servebeer.please.tesla_client.generated.model.ChargeStateResponseResponse;
import com.servebeer.please.tesla_client.generated.model.ListAllVehiclesResponseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

import static com.servebeer.please.tesla_client.TeslaSecurityManager.getAuthorizationToken;


public class TeslaCommunicator {

    private static final Logger log = LoggerFactory.getLogger(TeslaCommunicator.class);

    private static final VehiclesApi vehiclesApi = new VehiclesApi();
    private static final boolean DEBUGGING_ENABLED = false;
    private static String authorizationToken = "";
    private static long vehicleId = 0L;
    private static List<ListAllVehiclesResponseResponse> managedVehicles = new ArrayList<>();

    /**
     * hides the default constructor
     */
    private TeslaCommunicator() {
    }

    public TeslaCommunicator(final String userEmailAddress, final String userPassword) {
        try {
            authorizationToken = getAuthorizationToken(userEmailAddress, userPassword);
            vehiclesApi.setApiClient(vehiclesApi.getApiClient().setDebugging(DEBUGGING_ENABLED));
            List<ListAllVehiclesResponseResponse> managedVehicles = vehiclesApi.listAllVehicles(authorizationToken).getResponse();
            vehicleId = managedVehicles.get(0).getId();
        } catch (ApiException e) {
            log.error("Error initialising TeslaCommunicator: " + e.getMessage());
        }
    }

    /**
     * Watts of Power being drawn by the charger
     */
    public int getChargerPower() throws ApiException {

        ChargeStateResponseResponse response = vehiclesApi.getChargeState(authorizationToken, vehicleId).getResponse();

        // getChargerPower returns kW, but this number doesn't correlate to the formula below
        Integer teslaSaysPower = response.getChargerPower();

        // formula from http://www.rapidtables.com/convert/electric/Amp_to_kW.htm
        // watts = sqrt(Phases) * PowerFactor * amps * volts
        //
        // tesla seems to not sqare root the number of phases, so use my calculation instead of the number returned

        // assuming a PowerFactor of 1
        int iCalculatePower = 0;

        // if the chargingState isn't "Charging", there's nothing to calculate
        if (response.getChargingState().equals("Charging")) {
            double iCalculatePowerAsDouble = Math.sqrt(response.getChargerPhases()) * response.getChargerActualCurrent() * response.getChargerVoltage();
            iCalculatePower = Math.toIntExact(Math.round(iCalculatePowerAsDouble));
        }

        return iCalculatePower;
    }


    ChargeStateResponse getChargeState() throws ApiException {
        return vehiclesApi.getChargeState(authorizationToken, vehicleId);
    }

    /**
     * although this is a synchronous command, it might take a moment before it actually starts.
     */
    public AlterVehicleStateResponse startCharging() throws ApiException {
        AlterVehicleStateResponse response = vehiclesApi.startCharging(authorizationToken, vehicleId);
        log.debug("startCharging response:" + response);
        return response;
    }

    /**
     * although this is a synchronous command, it might take a moment before it actually stops.
     */
    public AlterVehicleStateResponse stopCharging() throws ApiException {
        AlterVehicleStateResponse response = vehiclesApi.stopCharging(authorizationToken, vehicleId);
        log.debug("stopCharging response:" + response);
        return response;
    }

    AlterVehicleStateResponse setChargeLimitToMinimum() throws ApiException {
        return vehiclesApi.setChargeLimitToMinimum(authorizationToken, vehicleId);
    }

    AlterVehicleStateResponse setChargeLimitToStandard() throws ApiException {
        // there's a bug with this one, so set to maximum first and then to standard
        vehiclesApi.setChargeLimitToMaximum(authorizationToken, vehicleId);
        return vehiclesApi.setChargeLimitToStandard(authorizationToken, vehicleId);
    }

    AlterVehicleStateResponse setChargeLimitToMaximum() throws ApiException {
        return vehiclesApi.setChargeLimitToMaximum(authorizationToken, vehicleId);
    }

    AlterVehicleStateResponse wakeVehicle() throws ApiException {
        return vehiclesApi.wakeVehicle(authorizationToken, vehicleId);
    }

    AlterVehicleStateResponse setValetMode(Boolean enabled, Integer password) throws ApiException {
        return vehiclesApi.setValetMode(authorizationToken, vehicleId, enabled, password);
    }
}
