package com.servebeer.please.tesla_client;

import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.AuthenticationApi;
import com.servebeer.please.tesla_client.generated.model.AccessTokenInput;
import com.servebeer.please.tesla_client.generated.model.GetAnAccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class TeslaSecurityManager {

    private static final Logger log = LoggerFactory.getLogger(TeslaSecurityManager.class);

    /**
     * TODO this is currently rather inefficient as it logs in and retrieves an access token every time
     */
    static String getAuthorizationToken(final String userEmailAddress, final String userPassword) throws ApiException {
        final AuthenticationApi api = new AuthenticationApi();

        AccessTokenInput accessTokenInput = new AccessTokenInput();
        accessTokenInput.setEmail(userEmailAddress);
        accessTokenInput.setPassword(userPassword);

        try {
            GetAnAccessTokenResponse response = api.getAnAccessToken(accessTokenInput);
            return "Bearer " + response.getAccessToken();
        } catch (ApiException e) {
            log.error("ApiExcetion: " + e.getMessage());
            throw e;
        }
    }
}
