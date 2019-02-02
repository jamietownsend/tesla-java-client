package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;
import com.servebeer.please.tesla_client.generated.model.*;
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

    // the power that was drawn at some stage
    int iCalculatedPower = 0;

    /**
     * hides the default constructor
     */
    private TeslaCommunicator() {
    }

    public TeslaCommunicator(final String userEmailAddress, final String userPassword) {
        try {
            authorizationToken = getAuthorizationToken(userEmailAddress, userPassword);
            vehiclesApi.setApiClient(vehiclesApi.getApiClient().setDebugging(DEBUGGING_ENABLED));
            managedVehicles = vehiclesApi.listAllVehicles(authorizationToken).getResponse();
            vehicleId = managedVehicles.get(0).getId();
        } catch (ApiException e) {
            log.error("Error initialising TeslaCommunicator: " + e.getMessage());
        }
    }

    /**
     * @return the number of watts of power that is being (or would be) drawn by the charger
     * @throws com.servebeer.please.tesla_client.generated.handler.ApiException
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

        // if the chargingState isn't "Charging", there's nothing to calculate
        if (response.getChargingState().equals("Charging")) {
            double iCalculatePowerAsDouble = Math.sqrt(response.getChargerPhases()) * response.getChargerActualCurrent() * response.getChargerVoltage();
            iCalculatedPower = Math.toIntExact(Math.round(iCalculatePowerAsDouble));
        }

        return iCalculatedPower;
    }

    public boolean isConnected() throws ApiException {
        return !vehiclesApi.getChargeState(authorizationToken, vehicleId).getResponse().getChargingState().equals("Disconnected");
    }

    public boolean isCharging() throws ApiException {
        return vehiclesApi.getChargeState(authorizationToken, vehicleId).getResponse().getChargingState().equals("Charging");
    }

    ChargeStateResponse getChargeState() throws ApiException {
        return vehiclesApi.getChargeState(authorizationToken, vehicleId);
    }

    /**
     * Note: although this is a synchronous command, it might take a moment before it actually starts.
     * 
     * @return the standard Tesla response when state altering requests are made
     * @throws com.servebeer.please.tesla_client.generated.handler.ApiException
     */
    public AlterVehicleStateResponse startCharging() throws ApiException {
        AlterVehicleStateResponse response = vehiclesApi.startCharging(authorizationToken, vehicleId);
        log.debug("startCharging response:" + response);
        return response;
    }

    /**
     * although this is a synchronous command, it might take a moment before it actually stops.
     * @return the standard Tesla response when state altering requests are made
     * @throws com.servebeer.please.tesla_client.generated.handler.ApiException 
     */
    public AlterVehicleStateResponse stopCharging() throws ApiException {
        AlterVehicleStateResponse response = vehiclesApi.stopCharging(authorizationToken, vehicleId);
        log.debug("stopCharging response:" + response);
        return response;
    }

    public Integer getBatteryLevel() throws ApiException {
        ChargeStateResponse response = vehiclesApi.getChargeState(authorizationToken, vehicleId);
        return response.getResponse().getBatteryLevel();
    }

    public Integer getChargeLimit() throws ApiException {
        ChargeStateResponse response = vehiclesApi.getChargeState(authorizationToken, vehicleId);
        return response.getResponse().getChargeLimitSoc();
    }

    public Boolean getScheduledChargingPending() throws ApiException {
        ChargeStateResponse response = vehiclesApi.getChargeState(authorizationToken, vehicleId);
        return response.getResponse().getScheduledChargingPending();
    }
    
    AlterVehicleStateResponse setChargeLimitToMinimum() throws ApiException {
        SetChargeLimitBody body = new SetChargeLimitBody();
        // TODO this should be retrieved from the car
        body.setPercent(50);
        return vehiclesApi.setChargeLimit(authorizationToken, vehicleId, body);
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

    public GpsLocation getGpsLocation() throws ApiException {
        DriveStateResponse response = vehiclesApi.getDriveState(authorizationToken, vehicleId);
        GpsLocation vehicleLocation = new GpsLocation(response.getResponse().getLatitude().floatValue(), response.getResponse().getLongitude().floatValue());
        return vehicleLocation;
    }
}
