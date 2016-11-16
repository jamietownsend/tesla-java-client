/*
 * Tesla REST API - Tests for the Authentication API
 */
package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.AuthenticationApi;
import com.servebeer.please.tesla_client.generated.model.AccessTokenInput;
import com.servebeer.please.tesla_client.generated.model.GetAnAccessTokenResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * API tests for AuthenticationApi
 */
public class AuthenticationApiIT {

    private static AuthenticationApi authenticationApi = new AuthenticationApi();

    /**
     * run once for the class before any tests are executed
     */
    @BeforeClass
    public static void beforeClass() throws ApiException {

        authenticationApi.setApiClient(authenticationApi.getApiClient().setDebugging(TestDefaults.DEBUGGING_ENABLED));
    }


    /**
     *
     *
     * Performs the login. Takes in an plain text email and password, matching the owner's login information for [https://my.teslamotors.com/user/login](https://my.teslamotors.com/user/login). Returns a &#x60;access_token&#x60; which is passed along as a header with all future requests to authenticate the user. You must provide the &#x60;Authorization: Bearer {access_token}&#x60; header in all other requests. The current client ID and secret are [available here](http://pastebin.com/fX6ejAHd)
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getAnAccessTokenTest() throws ApiException {
        AccessTokenInput accessTokenInput = new AccessTokenInput();
        accessTokenInput.setEmail(TestDefaults.TEST_USER_EMAIL_ADDRESS);
        accessTokenInput.setPassword(TestDefaults.TEST_USER_PASSWORD);

        GetAnAccessTokenResponse response = authenticationApi.getAnAccessToken(accessTokenInput);

        assertEquals("Expected result not received", "bearer", response.getTokenType());

    }

}
