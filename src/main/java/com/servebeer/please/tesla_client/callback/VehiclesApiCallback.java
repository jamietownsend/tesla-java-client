package com.servebeer.please.tesla_client.callback;

import com.servebeer.please.tesla_client.generated.handler.ApiCallback;
import com.servebeer.please.tesla_client.generated.handler.ApiException;
import com.servebeer.please.tesla_client.generated.handler.VehiclesApi;

import java.util.List;
import java.util.Map;

public class VehiclesApiCallback implements ApiCallback<VehiclesApi> {
    @Override
    public void onFailure(ApiException e, int statusCode, Map<String, List<String>> responseHeaders) {
        System.out.println("Oh no, something bad happened.");
        System.out.println("Status code: " + statusCode);
        System.out.println("Response headers:");
        for (String key:responseHeaders.keySet()) {
            System.out.println("  " + key);

            List<String> valueList = responseHeaders.get(key);
            for (String value:valueList) {
                System.out.println("    " + value);
            }
        }
    }

    @Override
    public void onSuccess(VehiclesApi result, int statusCode, Map<String, List<String>> responseHeaders) {

    }

    @Override
    public void onUploadProgress(long bytesWritten, long contentLength, boolean done) {

    }

    @Override
    public void onDownloadProgress(long bytesRead, long contentLength, boolean done) {

    }
}
