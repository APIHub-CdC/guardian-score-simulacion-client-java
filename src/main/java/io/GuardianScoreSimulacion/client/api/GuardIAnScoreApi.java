package io.GuardianScoreSimulacion.client.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import io.GuardianScoreSimulacion.client.ApiCallback;
import io.GuardianScoreSimulacion.client.ApiClient;
import io.GuardianScoreSimulacion.client.ApiException;
import io.GuardianScoreSimulacion.client.ApiResponse;
import io.GuardianScoreSimulacion.client.Configuration;
import io.GuardianScoreSimulacion.client.Pair;
import io.GuardianScoreSimulacion.client.ProgressRequestBody;
import io.GuardianScoreSimulacion.client.ProgressResponseBody;
import io.GuardianScoreSimulacion.client.model.RequestBody;
import io.GuardianScoreSimulacion.client.model.ResponseBody;

public class GuardIAnScoreApi {
    private ApiClient apiClient;
    public GuardIAnScoreApi() {
        this(Configuration.getDefaultApiClient());
    }
    public GuardIAnScoreApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call creditreportCall(String xApiKey, RequestBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "/v1/guardian-score";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    private okhttp3.Call creditreportValidateBeforeCall(String xApiKey, RequestBody body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling creditreport(Async)");
        }
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling creditreport(Async)");
        }
        
        okhttp3.Call call = creditreportCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public ResponseBody creditreport(String xApiKey, RequestBody body) throws ApiException {
        ApiResponse<ResponseBody> resp = creditreportWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<ResponseBody> creditreportWithHttpInfo(String xApiKey, RequestBody body) throws ApiException {
        okhttp3.Call call = creditreportValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<ResponseBody>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call creditreportAsync(String xApiKey, RequestBody body, final ApiCallback<ResponseBody> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = creditreportValidateBeforeCall(xApiKey, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ResponseBody>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
