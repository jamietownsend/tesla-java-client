package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.AuthenticationApi;
import com.servebeer.please.tesla_client.generated.model.AccessTokenInput;
import com.servebeer.please.tesla_client.generated.model.GetAnAccessTokenResponse;


public class ConnectionManager {

    /**
     * TODO this is currently rather inefficient as it logs in and retrieves an access token every time
     * @param userEmailAddress
     * @param userPassword
     * @return
     * @throws ApiException
     */
    public static String getAuthorization(final String userEmailAddress, final String userPassword) throws ApiException {
        final AuthenticationApi api = new AuthenticationApi();

        AccessTokenInput accessTokenInput = new AccessTokenInput();
        accessTokenInput.setEmail(userEmailAddress);
        accessTokenInput.setPassword(userPassword);

        try {
            GetAnAccessTokenResponse response = api.getAnAccessToken(accessTokenInput);
            return "Bearer " + response.getAccessToken();
        } catch (ApiException e) {
            System.out.println("ApiExcetion: " + e.getMessage());
            throw e;
        }
    }
}
