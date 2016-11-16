# VehiclesApi

All URIs are relative to *https://owner-api.teslamotors.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getChargeState**](VehiclesApi.md#getChargeState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/charge_state | 
[**getClimateState**](VehiclesApi.md#getClimateState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/climate_state | 
[**getDriveState**](VehiclesApi.md#getDriveState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/drive_state | 
[**getGuiSettings**](VehiclesApi.md#getGuiSettings) | **GET** /api/1/vehicles/{vehicle_id}/data_request/gui_settings | 
[**getVehicleState**](VehiclesApi.md#getVehicleState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/vehicle_state | 
[**isMobileEnabled**](VehiclesApi.md#isMobileEnabled) | **GET** /api/1/vehicles/{vehicle_id}/mobile_enabled | 
[**listAllVehicles**](VehiclesApi.md#listAllVehicles) | **GET** /api/1/vehicles | 


<a name="getChargeState"></a>
# **getChargeState**
> ChargeStateResponse getChargeState(authorization, vehicleId)



Returns the state of charge in the battery.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    ChargeStateResponse result = apiInstance.getChargeState(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getChargeState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**ChargeStateResponse**](ChargeStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getClimateState"></a>
# **getClimateState**
> ClimateStateResponse getClimateState(authorization, vehicleId)



Returns the current temperature and climate control state.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    ClimateStateResponse result = apiInstance.getClimateState(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getClimateState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**ClimateStateResponse**](ClimateStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getDriveState"></a>
# **getDriveState**
> DriveStateResponse getDriveState(authorization, vehicleId)



Returns the driving and position state of the vehicle.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    DriveStateResponse result = apiInstance.getDriveState(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getDriveState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**DriveStateResponse**](DriveStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getGuiSettings"></a>
# **getGuiSettings**
> GuiSettingsResponse getGuiSettings(authorization, vehicleId)



Returns various information about the GUI settings of the car, such as unit format and range display.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    GuiSettingsResponse result = apiInstance.getGuiSettings(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getGuiSettings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**GuiSettingsResponse**](GuiSettingsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getVehicleState"></a>
# **getVehicleState**
> VehicleStateResponse getVehicleState(authorization, vehicleId)



Returns the vehicle&#39;s physical state, such as which doors are open.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    VehicleStateResponse result = apiInstance.getVehicleState(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#getVehicleState");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**VehicleStateResponse**](VehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="isMobileEnabled"></a>
# **isMobileEnabled**
> MobileAccessResponse isMobileEnabled(authorization, vehicleId)



Determines if mobile access to the vehicle is enabled.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    MobileAccessResponse result = apiInstance.isMobileEnabled(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#isMobileEnabled");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**MobileAccessResponse**](MobileAccessResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listAllVehicles"></a>
# **listAllVehicles**
> ListAllVehiclesResponse listAllVehicles(authorization)



Retrieve a list of your owned vehicles (includes vehicles not yet shipped!)

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | 
try {
    ListAllVehiclesResponse result = apiInstance.listAllVehicles(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#listAllVehicles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**|  |

### Return type

[**ListAllVehiclesResponse**](ListAllVehiclesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

