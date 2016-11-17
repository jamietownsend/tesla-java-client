# VehiclesApi

All URIs are relative to *https://owner-api.teslamotors.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**controlSunRoof**](VehiclesApi.md#controlSunRoof) | **POST** /api/1/vehicles/{vehicle_id}/command/sun_roof_control | 
[**enableRemoteDriving**](VehiclesApi.md#enableRemoteDriving) | **POST** /api/1/vehicles/{vehicle_id}/command/remote_start_drive | 
[**flashLights**](VehiclesApi.md#flashLights) | **POST** /api/1/vehicles/{vehicle_id}/command/flash_lights | 
[**getChargeState**](VehiclesApi.md#getChargeState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/charge_state | 
[**getClimateState**](VehiclesApi.md#getClimateState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/climate_state | 
[**getDriveState**](VehiclesApi.md#getDriveState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/drive_state | 
[**getGuiSettings**](VehiclesApi.md#getGuiSettings) | **GET** /api/1/vehicles/{vehicle_id}/data_request/gui_settings | 
[**getVehicleState**](VehiclesApi.md#getVehicleState) | **GET** /api/1/vehicles/{vehicle_id}/data_request/vehicle_state | 
[**honkHorn**](VehiclesApi.md#honkHorn) | **POST** /api/1/vehicles/{vehicle_id}/command/honk_horn | 
[**isMobileEnabled**](VehiclesApi.md#isMobileEnabled) | **GET** /api/1/vehicles/{vehicle_id}/mobile_enabled | 
[**listAllVehicles**](VehiclesApi.md#listAllVehicles) | **GET** /api/1/vehicles | 
[**lockDoors**](VehiclesApi.md#lockDoors) | **POST** /api/1/vehicles/{vehicle_id}/command/door_lock | 
[**openChargePortDoor**](VehiclesApi.md#openChargePortDoor) | **POST** /api/1/vehicles/{vehicle_id}/command/charge_port_door_open | 
[**openTrunk**](VehiclesApi.md#openTrunk) | **POST** /api/1/vehicles/{vehicle_id}/command/trunk_open | 
[**resetValetMode**](VehiclesApi.md#resetValetMode) | **POST** /api/1/vehicles/{vehicle_id}/command/reset_valet_pin | 
[**setChargeLimit**](VehiclesApi.md#setChargeLimit) | **POST** /api/1/vehicles/{vehicle_id}/command/set_charge_limit | 
[**setChargeMaxRange**](VehiclesApi.md#setChargeMaxRange) | **POST** /api/1/vehicles/{vehicle_id}/command/charge_max_range | 
[**setValetMode**](VehiclesApi.md#setValetMode) | **POST** /api/1/vehicles/{vehicle_id}/command/set_valet_mode | 
[**startCharging**](VehiclesApi.md#startCharging) | **POST** /api/1/vehicles/{vehicle_id}/command/charge_start | 
[**startTemperatureRegulation**](VehiclesApi.md#startTemperatureRegulation) | **POST** /api/1/vehicles/{vehicle_id}/command/auto_conditioning_start | 
[**stopCharging**](VehiclesApi.md#stopCharging) | **POST** /api/1/vehicles/{vehicle_id}/command/charge_stop | 
[**stopTemperatureRegulation**](VehiclesApi.md#stopTemperatureRegulation) | **POST** /api/1/vehicles/{vehicle_id}/command/auto_conditioning_stop | 
[**unlockDoors**](VehiclesApi.md#unlockDoors) | **POST** /api/1/vehicles/{vehicle_id}/command/door_unlock | 
[**wakeVehicle**](VehiclesApi.md#wakeVehicle) | **POST** /api/1/vehicles/{vehicle_id}/command/wake_up | 


<a name="controlSunRoof"></a>
# **controlSunRoof**
> controlSunRoof(authorization, vehicleId, state, percent)



Controls the car&#39;s panoramic roof, if installed.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
String state = "state_example"; // String | 
Integer percent = 56; // Integer | The percentage to move the roof to.
try {
    apiInstance.controlSunRoof(authorization, vehicleId, state, percent);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#controlSunRoof");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |
 **state** | **String**|  | [optional]
 **percent** | **Integer**| The percentage to move the roof to. | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="enableRemoteDriving"></a>
# **enableRemoteDriving**
> AlterVehicleStateResponse enableRemoteDriving(authorization, vehicleId, password)



Start the car for keyless driving. Must start driving within 2 minutes of issuing this request.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
String password = "password_example"; // String | The password to the authenticated my.teslamotors.com account.
try {
    AlterVehicleStateResponse result = apiInstance.enableRemoteDriving(authorization, vehicleId, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#enableRemoteDriving");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |
 **password** | **String**| The password to the authenticated my.teslamotors.com account. | [optional]

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="flashLights"></a>
# **flashLights**
> AlterVehicleStateResponse flashLights(authorization, vehicleId)



Flash the lights once.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.flashLights(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#flashLights");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**VehicleStateResponse**](VehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="honkHorn"></a>
# **honkHorn**
> AlterVehicleStateResponse honkHorn(authorization, vehicleId)



Honk the horn once.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.honkHorn(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#honkHorn");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |
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
String authorization = "authorization_example"; // String | Bearer {access_token}
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
 **authorization** | **String**| Bearer {access_token} |

### Return type

[**ListAllVehiclesResponse**](ListAllVehiclesResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="lockDoors"></a>
# **lockDoors**
> AlterVehicleStateResponse lockDoors(authorization, vehicleId)



Lock the car&#39;s doors.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.lockDoors(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#lockDoors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="openChargePortDoor"></a>
# **openChargePortDoor**
> AlterVehicleStateResponse openChargePortDoor(authorization, vehicleId)



Opens the charge port. Does not close the charge port

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.openChargePortDoor(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#openChargePortDoor");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="openTrunk"></a>
# **openTrunk**
> AlterVehicleStateResponse openTrunk(authorization, vehicleId, whichTrunk)



Open the trunk or frunk.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
String whichTrunk = "whichTrunk_example"; // String | The trunk to open. `rear` is the only one known currently.
try {
    AlterVehicleStateResponse result = apiInstance.openTrunk(authorization, vehicleId, whichTrunk);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#openTrunk");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |
 **whichTrunk** | **String**| The trunk to open. &#x60;rear&#x60; is the only one known currently. | [optional]

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resetValetMode"></a>
# **resetValetMode**
> AlterVehicleStateResponse resetValetMode(authorization, vehicleId)



Resets the PIN set for valet mode, if set.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.resetValetMode(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#resetValetMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setChargeLimit"></a>
# **setChargeLimit**
> AlterVehicleStateResponse setChargeLimit(authorization, vehicleId, percent)



Set the charge limit to a custom percentage.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
Integer percent = 56; // Integer | 
try {
    AlterVehicleStateResponse result = apiInstance.setChargeLimit(authorization, vehicleId, percent);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#setChargeLimit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |
 **percent** | **Integer**|  |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setChargeMaxRange"></a>
# **setChargeMaxRange**
> AlterVehicleStateResponse setChargeMaxRange(authorization, vehicleId)



Set the charge mode to max range (100% under the new percentage system introduced in 4.5). Use sparingly!

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.setChargeMaxRange(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#setChargeMaxRange");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="setValetMode"></a>
# **setValetMode**
> AlterVehicleStateResponse setValetMode(authorization, vehicleId, enabled, password)



Sets valet mode on or off with a PIN to disable it from within the car. Reuses last PIN from previous valet session. Valet Mode limits the car&#39;s top speed to 70MPH and 80kW of acceleration power. It also disables Homelink, Bluetooth and Wifi settings, and the ability to disable mobile access to the car. It also hides your favorites, home, and work locations in navigation.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
Boolean enabled = true; // Boolean | Whether to enable or disable valet mode.
Integer password = 56; // Integer | A 4 digit PIN code to unlock the car - required if on = true
try {
    AlterVehicleStateResponse result = apiInstance.setValetMode(authorization, vehicleId, enabled, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#setValetMode");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |
 **enabled** | **Boolean**| Whether to enable or disable valet mode. | [optional]
 **password** | **Integer**| A 4 digit PIN code to unlock the car - required if on &#x3D; true | [optional]

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="startCharging"></a>
# **startCharging**
> AlterVehicleStateResponse startCharging(authorization, vehicleId)



Start charging. Must be plugged in, have power available, and not have reached your charge limit.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.startCharging(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#startCharging");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="startTemperatureRegulation"></a>
# **startTemperatureRegulation**
> AlterVehicleStateResponse startTemperatureRegulation(authorization, vehicleId)



Start the climate control system. Will cool or heat automatically, depending on set temperature.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.startTemperatureRegulation(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#startTemperatureRegulation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="stopCharging"></a>
# **stopCharging**
> AlterVehicleStateResponse stopCharging(authorization, vehicleId)



Stop charging. Must already be charging.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.stopCharging(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#stopCharging");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="stopTemperatureRegulation"></a>
# **stopTemperatureRegulation**
> AlterVehicleStateResponse stopTemperatureRegulation(authorization, vehicleId)



Stop the climate control system.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.stopTemperatureRegulation(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#stopTemperatureRegulation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="unlockDoors"></a>
# **unlockDoors**
> AlterVehicleStateResponse unlockDoors(authorization, vehicleId)



Unlock the car&#39;s doors. (All of them??)

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.unlockDoors(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#unlockDoors");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="wakeVehicle"></a>
# **wakeVehicle**
> AlterVehicleStateResponse wakeVehicle(authorization, vehicleId)



Wakes up the car from the sleep state. Necessary to get some data from the car.

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;


VehiclesApi apiInstance = new VehiclesApi();
String authorization = "authorization_example"; // String | Bearer {access_token}
Long vehicleId = 789L; // Long | The id of the Vehicle.
try {
    AlterVehicleStateResponse result = apiInstance.wakeVehicle(authorization, vehicleId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VehiclesApi#wakeVehicle");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Bearer {access_token} |
 **vehicleId** | **Long**| The id of the Vehicle. |

### Return type

[**AlterVehicleStateResponse**](AlterVehicleStateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

