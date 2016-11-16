# AuthenticationApi

All URIs are relative to *https://owner-api.teslamotors.com/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAnAccessToken**](AuthenticationApi.md#getAnAccessToken) | **POST** /oauth/token | 


<a name="getAnAccessToken"></a>
# **getAnAccessToken**
> GetAnAccessTokenResponse getAnAccessToken(accessTokenInput)



Performs the login. Takes in an plain text email and password, matching the owner&#39;s login information for [https://my.teslamotors.com/user/login](https://my.teslamotors.com/user/login). Returns a &#x60;access_token&#x60; which is passed along as a header with all future requests to authenticate the user. You must provide the &#x60;Authorization: Bearer {access_token}&#x60; header in all other requests. The current client ID and secret are [available here](http://pastebin.com/fX6ejAHd)

### Example
```java
// Import classes:
//import com.servebeer.please.tesla_client.generated.handler.ApiException;
//import com.servebeer.please.tesla_client.generated.handler.AuthenticationApi;


AuthenticationApi apiInstance = new AuthenticationApi();
AccessTokenInput accessTokenInput = new AccessTokenInput(); // AccessTokenInput | Attributes of the access token
try {
    GetAnAccessTokenResponse result = apiInstance.getAnAccessToken(accessTokenInput);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#getAnAccessToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accessTokenInput** | [**AccessTokenInput**](AccessTokenInput.md)| Attributes of the access token | [optional]

### Return type

[**GetAnAccessTokenResponse**](GetAnAccessTokenResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

