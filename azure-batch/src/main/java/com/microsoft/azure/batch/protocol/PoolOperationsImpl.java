/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.batch.protocol;

import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.batch.protocol.models.AutoScaleRun;
import com.microsoft.azure.batch.protocol.models.BatchErrorException;
import com.microsoft.azure.batch.protocol.models.CloudPool;
import com.microsoft.azure.batch.protocol.models.NodeRemoveParameter;
import com.microsoft.azure.batch.protocol.models.PageImpl;
import com.microsoft.azure.batch.protocol.models.PoolAddHeaders;
import com.microsoft.azure.batch.protocol.models.PoolAddOptions;
import com.microsoft.azure.batch.protocol.models.PoolAddParameter;
import com.microsoft.azure.batch.protocol.models.PoolDeleteHeaders;
import com.microsoft.azure.batch.protocol.models.PoolDeleteOptions;
import com.microsoft.azure.batch.protocol.models.PoolDisableAutoScaleHeaders;
import com.microsoft.azure.batch.protocol.models.PoolDisableAutoScaleOptions;
import com.microsoft.azure.batch.protocol.models.PoolEnableAutoScaleHeaders;
import com.microsoft.azure.batch.protocol.models.PoolEnableAutoScaleOptions;
import com.microsoft.azure.batch.protocol.models.PoolEnableAutoScaleParameter;
import com.microsoft.azure.batch.protocol.models.PoolEvaluateAutoScaleHeaders;
import com.microsoft.azure.batch.protocol.models.PoolEvaluateAutoScaleOptions;
import com.microsoft.azure.batch.protocol.models.PoolEvaluateAutoScaleParameter;
import com.microsoft.azure.batch.protocol.models.PoolExistsHeaders;
import com.microsoft.azure.batch.protocol.models.PoolExistsOptions;
import com.microsoft.azure.batch.protocol.models.PoolGetAllPoolsLifetimeStatisticsHeaders;
import com.microsoft.azure.batch.protocol.models.PoolGetAllPoolsLifetimeStatisticsOptions;
import com.microsoft.azure.batch.protocol.models.PoolGetHeaders;
import com.microsoft.azure.batch.protocol.models.PoolGetOptions;
import com.microsoft.azure.batch.protocol.models.PoolListHeaders;
import com.microsoft.azure.batch.protocol.models.PoolListNextOptions;
import com.microsoft.azure.batch.protocol.models.PoolListOptions;
import com.microsoft.azure.batch.protocol.models.PoolListPoolUsageMetricsHeaders;
import com.microsoft.azure.batch.protocol.models.PoolListPoolUsageMetricsNextOptions;
import com.microsoft.azure.batch.protocol.models.PoolListPoolUsageMetricsOptions;
import com.microsoft.azure.batch.protocol.models.PoolPatchHeaders;
import com.microsoft.azure.batch.protocol.models.PoolPatchOptions;
import com.microsoft.azure.batch.protocol.models.PoolPatchParameter;
import com.microsoft.azure.batch.protocol.models.PoolRemoveNodesHeaders;
import com.microsoft.azure.batch.protocol.models.PoolRemoveNodesOptions;
import com.microsoft.azure.batch.protocol.models.PoolResizeHeaders;
import com.microsoft.azure.batch.protocol.models.PoolResizeOptions;
import com.microsoft.azure.batch.protocol.models.PoolResizeParameter;
import com.microsoft.azure.batch.protocol.models.PoolStatistics;
import com.microsoft.azure.batch.protocol.models.PoolStopResizeHeaders;
import com.microsoft.azure.batch.protocol.models.PoolStopResizeOptions;
import com.microsoft.azure.batch.protocol.models.PoolUpdatePropertiesHeaders;
import com.microsoft.azure.batch.protocol.models.PoolUpdatePropertiesOptions;
import com.microsoft.azure.batch.protocol.models.PoolUpdatePropertiesParameter;
import com.microsoft.azure.batch.protocol.models.PoolUpgradeOSHeaders;
import com.microsoft.azure.batch.protocol.models.PoolUpgradeOSOptions;
import com.microsoft.azure.batch.protocol.models.PoolUpgradeOSParameter;
import com.microsoft.azure.batch.protocol.models.PoolUsageMetrics;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.DateTimeRfc1123;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponseCallback;
import com.microsoft.rest.ServiceResponseEmptyCallback;
import com.microsoft.rest.ServiceResponseWithHeaders;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import org.joda.time.DateTime;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * An instance of this class provides access to all the operations defined
 * in PoolOperations.
 */
public final class PoolOperationsImpl implements PoolOperations {
    /** The Retrofit service to perform REST calls. */
    private PoolService service;
    /** The service client containing this operation class. */
    private BatchServiceClient client;

    /**
     * Initializes an instance of PoolOperations.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public PoolOperationsImpl(Retrofit retrofit, BatchServiceClient client) {
        this.service = retrofit.create(PoolService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for PoolOperations to be
     * used by Retrofit to perform actually REST calls.
     */
    interface PoolService {
        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("poolusagemetrics")
        Call<ResponseBody> listPoolUsageMetrics(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("starttime") DateTime startTime, @Query("endtime") DateTime endTime, @Query("$filter") String filter, @Query("maxresults") Integer maxResults, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("lifetimepoolstats")
        Call<ResponseBody> getAllPoolsLifetimeStatistics(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools")
        Call<ResponseBody> add(@Body PoolAddParameter pool, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("pools")
        Call<ResponseBody> list(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("$filter") String filter, @Query("$select") String select, @Query("$expand") String expand, @Query("maxresults") Integer maxResults, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @HTTP(path = "pools/{poolId}", method = "DELETE", hasBody = true)
        Call<ResponseBody> delete(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @HEAD("pools/{poolId}")
        Call<Void> exists(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("$select") String select, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("pools/{poolId}")
        Call<ResponseBody> get(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("$select") String select, @Query("$expand") String expand, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @PATCH("pools/{poolId}")
        Call<ResponseBody> patch(@Path("poolId") String poolId, @Body PoolPatchParameter poolPatchParameter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/disableautoscale")
        Call<ResponseBody> disableAutoScale(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/enableautoscale")
        Call<ResponseBody> enableAutoScale(@Path("poolId") String poolId, @Body PoolEnableAutoScaleParameter poolEnableAutoScaleParameter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/evaluateautoscale")
        Call<ResponseBody> evaluateAutoScale(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Body PoolEvaluateAutoScaleParameter poolEvaluateAutoScaleParameter);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/resize")
        Call<ResponseBody> resize(@Path("poolId") String poolId, @Body PoolResizeParameter poolResizeParameter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/stopresize")
        Call<ResponseBody> stopResize(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/updateproperties")
        Call<ResponseBody> updateProperties(@Path("poolId") String poolId, @Body PoolUpdatePropertiesParameter poolUpdatePropertiesParameter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/upgradeos")
        Call<ResponseBody> upgradeOS(@Path("poolId") String poolId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince, @Body PoolUpgradeOSParameter poolUpgradeOSParameter);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @POST("pools/{poolId}/removenodes")
        Call<ResponseBody> removeNodes(@Path("poolId") String poolId, @Body NodeRemoveParameter nodeRemoveParameter, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("If-Match") String ifMatch, @Header("If-None-Match") String ifNoneMatch, @Header("If-Modified-Since") DateTimeRfc1123 ifModifiedSince, @Header("If-Unmodified-Since") DateTimeRfc1123 ifUnmodifiedSince);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET
        Call<ResponseBody> listPoolUsageMetricsNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET
        Call<ResponseBody> listNext(@Url String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate);

    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;PoolUsageMetrics&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetrics() throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolListPoolUsageMetricsOptions poolListPoolUsageMetricsOptions = null;
        DateTime startTime = null;
        DateTime endTime = null;
        String filter = null;
        Integer maxResults = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listPoolUsageMetrics(this.client.getApiVersion(), this.client.getAcceptLanguage(), startTime, endTime, filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> response = listPoolUsageMetricsDelegate(call.execute());
        PagedList<PoolUsageMetrics> result = new PagedList<PoolUsageMetrics>(response.getBody()) {
            @Override
            public Page<PoolUsageMetrics> nextPage(String nextPageLink) throws BatchErrorException, IOException {
                return listPoolUsageMetricsNext(nextPageLink, null).getBody();
            }
        };
        return new ServiceResponseWithHeaders<>(result, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listPoolUsageMetricsAsync(final ListOperationCallback<PoolUsageMetrics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolListPoolUsageMetricsOptions poolListPoolUsageMetricsOptions = null;
        DateTime startTime = null;
        DateTime endTime = null;
        String filter = null;
        Integer maxResults = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listPoolUsageMetrics(this.client.getApiVersion(), this.client.getAcceptLanguage(), startTime, endTime, filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<PoolUsageMetrics>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> result = listPoolUsageMetricsDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listPoolUsageMetricsNextAsync(result.getBody().getNextPageLink(), null, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param poolListPoolUsageMetricsOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;PoolUsageMetrics&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetrics(final PoolListPoolUsageMetricsOptions poolListPoolUsageMetricsOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolListPoolUsageMetricsOptions);
        DateTime startTime = null;
        if (poolListPoolUsageMetricsOptions != null) {
            startTime = poolListPoolUsageMetricsOptions.getStartTime();
        }
        DateTime endTime = null;
        if (poolListPoolUsageMetricsOptions != null) {
            endTime = poolListPoolUsageMetricsOptions.getEndTime();
        }
        String filter = null;
        if (poolListPoolUsageMetricsOptions != null) {
            filter = poolListPoolUsageMetricsOptions.getFilter();
        }
        Integer maxResults = null;
        if (poolListPoolUsageMetricsOptions != null) {
            maxResults = poolListPoolUsageMetricsOptions.getMaxResults();
        }
        Integer timeout = null;
        if (poolListPoolUsageMetricsOptions != null) {
            timeout = poolListPoolUsageMetricsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolListPoolUsageMetricsOptions != null) {
            clientRequestId = poolListPoolUsageMetricsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListPoolUsageMetricsOptions != null) {
            returnClientRequestId = poolListPoolUsageMetricsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListPoolUsageMetricsOptions != null) {
            ocpDate = poolListPoolUsageMetricsOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listPoolUsageMetrics(this.client.getApiVersion(), this.client.getAcceptLanguage(), startTime, endTime, filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> response = listPoolUsageMetricsDelegate(call.execute());
        PagedList<PoolUsageMetrics> result = new PagedList<PoolUsageMetrics>(response.getBody()) {
            @Override
            public Page<PoolUsageMetrics> nextPage(String nextPageLink) throws BatchErrorException, IOException {
                PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions = null;
                if (poolListPoolUsageMetricsOptions != null) {
                    poolListPoolUsageMetricsNextOptions = new PoolListPoolUsageMetricsNextOptions();
                    poolListPoolUsageMetricsNextOptions.setClientRequestId(poolListPoolUsageMetricsOptions.getClientRequestId());
                    poolListPoolUsageMetricsNextOptions.setReturnClientRequestId(poolListPoolUsageMetricsOptions.getReturnClientRequestId());
                    poolListPoolUsageMetricsNextOptions.setOcpDate(poolListPoolUsageMetricsOptions.getOcpDate());
                }
                return listPoolUsageMetricsNext(nextPageLink, poolListPoolUsageMetricsNextOptions).getBody();
            }
        };
        return new ServiceResponseWithHeaders<>(result, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param poolListPoolUsageMetricsOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listPoolUsageMetricsAsync(final PoolListPoolUsageMetricsOptions poolListPoolUsageMetricsOptions, final ListOperationCallback<PoolUsageMetrics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolListPoolUsageMetricsOptions, serviceCallback);
        DateTime startTime = null;
        if (poolListPoolUsageMetricsOptions != null) {
            startTime = poolListPoolUsageMetricsOptions.getStartTime();
        }
        DateTime endTime = null;
        if (poolListPoolUsageMetricsOptions != null) {
            endTime = poolListPoolUsageMetricsOptions.getEndTime();
        }
        String filter = null;
        if (poolListPoolUsageMetricsOptions != null) {
            filter = poolListPoolUsageMetricsOptions.getFilter();
        }
        Integer maxResults = null;
        if (poolListPoolUsageMetricsOptions != null) {
            maxResults = poolListPoolUsageMetricsOptions.getMaxResults();
        }
        Integer timeout = null;
        if (poolListPoolUsageMetricsOptions != null) {
            timeout = poolListPoolUsageMetricsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolListPoolUsageMetricsOptions != null) {
            clientRequestId = poolListPoolUsageMetricsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListPoolUsageMetricsOptions != null) {
            returnClientRequestId = poolListPoolUsageMetricsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListPoolUsageMetricsOptions != null) {
            ocpDate = poolListPoolUsageMetricsOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listPoolUsageMetrics(this.client.getApiVersion(), this.client.getAcceptLanguage(), startTime, endTime, filter, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<PoolUsageMetrics>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> result = listPoolUsageMetricsDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions = null;
                        if (poolListPoolUsageMetricsOptions != null) {
                            poolListPoolUsageMetricsNextOptions = new PoolListPoolUsageMetricsNextOptions();
                            poolListPoolUsageMetricsNextOptions.setClientRequestId(poolListPoolUsageMetricsOptions.getClientRequestId());
                            poolListPoolUsageMetricsNextOptions.setReturnClientRequestId(poolListPoolUsageMetricsOptions.getReturnClientRequestId());
                            poolListPoolUsageMetricsNextOptions.setOcpDate(poolListPoolUsageMetricsOptions.getOcpDate());
                        }
                        listPoolUsageMetricsNextAsync(result.getBody().getNextPageLink(), poolListPoolUsageMetricsNextOptions, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetricsDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<PoolUsageMetrics>, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<PoolUsageMetrics>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolListPoolUsageMetricsHeaders.class);
    }

    /**
     * Gets lifetime summary statistics for all of the pools in the specified account. Statistics are aggregated across all pools that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PoolStatistics object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PoolStatistics, PoolGetAllPoolsLifetimeStatisticsHeaders> getAllPoolsLifetimeStatistics() throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolGetAllPoolsLifetimeStatisticsOptions poolGetAllPoolsLifetimeStatisticsOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.getAllPoolsLifetimeStatistics(this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return getAllPoolsLifetimeStatisticsDelegate(call.execute());
    }

    /**
     * Gets lifetime summary statistics for all of the pools in the specified account. Statistics are aggregated across all pools that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAllPoolsLifetimeStatisticsAsync(final ServiceCallback<PoolStatistics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolGetAllPoolsLifetimeStatisticsOptions poolGetAllPoolsLifetimeStatisticsOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.getAllPoolsLifetimeStatistics(this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<PoolStatistics>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAllPoolsLifetimeStatisticsDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets lifetime summary statistics for all of the pools in the specified account. Statistics are aggregated across all pools that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param poolGetAllPoolsLifetimeStatisticsOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the PoolStatistics object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PoolStatistics, PoolGetAllPoolsLifetimeStatisticsHeaders> getAllPoolsLifetimeStatistics(PoolGetAllPoolsLifetimeStatisticsOptions poolGetAllPoolsLifetimeStatisticsOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolGetAllPoolsLifetimeStatisticsOptions);
        Integer timeout = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            timeout = poolGetAllPoolsLifetimeStatisticsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            clientRequestId = poolGetAllPoolsLifetimeStatisticsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            returnClientRequestId = poolGetAllPoolsLifetimeStatisticsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            ocpDate = poolGetAllPoolsLifetimeStatisticsOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.getAllPoolsLifetimeStatistics(this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return getAllPoolsLifetimeStatisticsDelegate(call.execute());
    }

    /**
     * Gets lifetime summary statistics for all of the pools in the specified account. Statistics are aggregated across all pools that have ever existed in the account, from account creation to the last update time of the statistics.
     *
     * @param poolGetAllPoolsLifetimeStatisticsOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAllPoolsLifetimeStatisticsAsync(PoolGetAllPoolsLifetimeStatisticsOptions poolGetAllPoolsLifetimeStatisticsOptions, final ServiceCallback<PoolStatistics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolGetAllPoolsLifetimeStatisticsOptions, serviceCallback);
        Integer timeout = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            timeout = poolGetAllPoolsLifetimeStatisticsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            clientRequestId = poolGetAllPoolsLifetimeStatisticsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            returnClientRequestId = poolGetAllPoolsLifetimeStatisticsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolGetAllPoolsLifetimeStatisticsOptions != null) {
            ocpDate = poolGetAllPoolsLifetimeStatisticsOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.getAllPoolsLifetimeStatistics(this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<PoolStatistics>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getAllPoolsLifetimeStatisticsDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<PoolStatistics, PoolGetAllPoolsLifetimeStatisticsHeaders> getAllPoolsLifetimeStatisticsDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PoolStatistics, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PoolStatistics>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolGetAllPoolsLifetimeStatisticsHeaders.class);
    }

    /**
     * Adds a pool to the specified account.
     *
     * @param pool Specifies the pool to be added.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolAddHeaders> add(PoolAddParameter pool) throws BatchErrorException, IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("Parameter pool is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(pool);
        final PoolAddOptions poolAddOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.add(pool, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return addDelegate(call.execute());
    }

    /**
     * Adds a pool to the specified account.
     *
     * @param pool Specifies the pool to be added.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall addAsync(PoolAddParameter pool, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (pool == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter pool is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(pool, serviceCallback);
        final PoolAddOptions poolAddOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.add(pool, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(addDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Adds a pool to the specified account.
     *
     * @param pool Specifies the pool to be added.
     * @param poolAddOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolAddHeaders> add(PoolAddParameter pool, PoolAddOptions poolAddOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("Parameter pool is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(pool);
        Validator.validate(poolAddOptions);
        Integer timeout = null;
        if (poolAddOptions != null) {
            timeout = poolAddOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolAddOptions != null) {
            clientRequestId = poolAddOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolAddOptions != null) {
            returnClientRequestId = poolAddOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolAddOptions != null) {
            ocpDate = poolAddOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.add(pool, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return addDelegate(call.execute());
    }

    /**
     * Adds a pool to the specified account.
     *
     * @param pool Specifies the pool to be added.
     * @param poolAddOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall addAsync(PoolAddParameter pool, PoolAddOptions poolAddOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (pool == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter pool is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(pool, serviceCallback);
        Validator.validate(poolAddOptions, serviceCallback);
        Integer timeout = null;
        if (poolAddOptions != null) {
            timeout = poolAddOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolAddOptions != null) {
            clientRequestId = poolAddOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolAddOptions != null) {
            returnClientRequestId = poolAddOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolAddOptions != null) {
            ocpDate = poolAddOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.add(pool, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(addDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolAddHeaders> addDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(201, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolAddHeaders.class);
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudPool&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<CloudPool>, PoolListHeaders> list() throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolListOptions poolListOptions = null;
        String filter = null;
        String select = null;
        String expand = null;
        Integer maxResults = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.list(this.client.getApiVersion(), this.client.getAcceptLanguage(), filter, select, expand, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> response = listDelegate(call.execute());
        PagedList<CloudPool> result = new PagedList<CloudPool>(response.getBody()) {
            @Override
            public Page<CloudPool> nextPage(String nextPageLink) throws BatchErrorException, IOException {
                return listNext(nextPageLink, null).getBody();
            }
        };
        return new ServiceResponseWithHeaders<>(result, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listAsync(final ListOperationCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolListOptions poolListOptions = null;
        String filter = null;
        String select = null;
        String expand = null;
        Integer maxResults = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.list(this.client.getApiVersion(), this.client.getAcceptLanguage(), filter, select, expand, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<CloudPool>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> result = listDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), null, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param poolListOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudPool&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<CloudPool>, PoolListHeaders> list(final PoolListOptions poolListOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolListOptions);
        String filter = null;
        if (poolListOptions != null) {
            filter = poolListOptions.getFilter();
        }
        String select = null;
        if (poolListOptions != null) {
            select = poolListOptions.getSelect();
        }
        String expand = null;
        if (poolListOptions != null) {
            expand = poolListOptions.getExpand();
        }
        Integer maxResults = null;
        if (poolListOptions != null) {
            maxResults = poolListOptions.getMaxResults();
        }
        Integer timeout = null;
        if (poolListOptions != null) {
            timeout = poolListOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolListOptions != null) {
            clientRequestId = poolListOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListOptions != null) {
            returnClientRequestId = poolListOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListOptions != null) {
            ocpDate = poolListOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.list(this.client.getApiVersion(), this.client.getAcceptLanguage(), filter, select, expand, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> response = listDelegate(call.execute());
        PagedList<CloudPool> result = new PagedList<CloudPool>(response.getBody()) {
            @Override
            public Page<CloudPool> nextPage(String nextPageLink) throws BatchErrorException, IOException {
                PoolListNextOptions poolListNextOptions = null;
                if (poolListOptions != null) {
                    poolListNextOptions = new PoolListNextOptions();
                    poolListNextOptions.setClientRequestId(poolListOptions.getClientRequestId());
                    poolListNextOptions.setReturnClientRequestId(poolListOptions.getReturnClientRequestId());
                    poolListNextOptions.setOcpDate(poolListOptions.getOcpDate());
                }
                return listNext(nextPageLink, poolListNextOptions).getBody();
            }
        };
        return new ServiceResponseWithHeaders<>(result, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param poolListOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listAsync(final PoolListOptions poolListOptions, final ListOperationCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolListOptions, serviceCallback);
        String filter = null;
        if (poolListOptions != null) {
            filter = poolListOptions.getFilter();
        }
        String select = null;
        if (poolListOptions != null) {
            select = poolListOptions.getSelect();
        }
        String expand = null;
        if (poolListOptions != null) {
            expand = poolListOptions.getExpand();
        }
        Integer maxResults = null;
        if (poolListOptions != null) {
            maxResults = poolListOptions.getMaxResults();
        }
        Integer timeout = null;
        if (poolListOptions != null) {
            timeout = poolListOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolListOptions != null) {
            clientRequestId = poolListOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListOptions != null) {
            returnClientRequestId = poolListOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListOptions != null) {
            ocpDate = poolListOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.list(this.client.getApiVersion(), this.client.getAcceptLanguage(), filter, select, expand, maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<List<CloudPool>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> result = listDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        PoolListNextOptions poolListNextOptions = null;
                        if (poolListOptions != null) {
                            poolListNextOptions = new PoolListNextOptions();
                            poolListNextOptions.setClientRequestId(poolListOptions.getClientRequestId());
                            poolListNextOptions.setReturnClientRequestId(poolListOptions.getReturnClientRequestId());
                            poolListNextOptions.setOcpDate(poolListOptions.getOcpDate());
                        }
                        listNextAsync(result.getBody().getNextPageLink(), poolListNextOptions, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> listDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<CloudPool>, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<CloudPool>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolListHeaders.class);
    }

    /**
     * Deletes a pool from the specified account.
     *
     * @param poolId The id of the pool to delete.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolDeleteHeaders> delete(String poolId) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolDeleteOptions poolDeleteOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.delete(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return deleteDelegate(call.execute());
    }

    /**
     * Deletes a pool from the specified account.
     *
     * @param poolId The id of the pool to delete.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deleteAsync(String poolId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolDeleteOptions poolDeleteOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.delete(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Deletes a pool from the specified account.
     *
     * @param poolId The id of the pool to delete.
     * @param poolDeleteOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolDeleteHeaders> delete(String poolId, PoolDeleteOptions poolDeleteOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolDeleteOptions);
        Integer timeout = null;
        if (poolDeleteOptions != null) {
            timeout = poolDeleteOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolDeleteOptions != null) {
            clientRequestId = poolDeleteOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolDeleteOptions != null) {
            returnClientRequestId = poolDeleteOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolDeleteOptions != null) {
            ocpDate = poolDeleteOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolDeleteOptions != null) {
            ifMatch = poolDeleteOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolDeleteOptions != null) {
            ifNoneMatch = poolDeleteOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolDeleteOptions != null) {
            ifModifiedSince = poolDeleteOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolDeleteOptions != null) {
            ifUnmodifiedSince = poolDeleteOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.delete(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return deleteDelegate(call.execute());
    }

    /**
     * Deletes a pool from the specified account.
     *
     * @param poolId The id of the pool to delete.
     * @param poolDeleteOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall deleteAsync(String poolId, PoolDeleteOptions poolDeleteOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolDeleteOptions, serviceCallback);
        Integer timeout = null;
        if (poolDeleteOptions != null) {
            timeout = poolDeleteOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolDeleteOptions != null) {
            clientRequestId = poolDeleteOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolDeleteOptions != null) {
            returnClientRequestId = poolDeleteOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolDeleteOptions != null) {
            ocpDate = poolDeleteOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolDeleteOptions != null) {
            ifMatch = poolDeleteOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolDeleteOptions != null) {
            ifNoneMatch = poolDeleteOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolDeleteOptions != null) {
            ifModifiedSince = poolDeleteOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolDeleteOptions != null) {
            ifUnmodifiedSince = poolDeleteOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.delete(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(deleteDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolDeleteHeaders> deleteDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolDeleteHeaders.class);
    }

    /**
     * Gets basic properties of a pool.
     *
     * @param poolId The id of the pool to get.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the boolean object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<Boolean, PoolExistsHeaders> exists(String poolId) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolExistsOptions poolExistsOptions = null;
        String select = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<Void> call = service.exists(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return existsDelegate(call.execute());
    }

    /**
     * Gets basic properties of a pool.
     *
     * @param poolId The id of the pool to get.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall existsAsync(String poolId, final ServiceCallback<Boolean> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolExistsOptions poolExistsOptions = null;
        String select = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<Void> call = service.exists(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseEmptyCallback<Boolean>(serviceCallback) {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    serviceCallback.success(existsDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets basic properties of a pool.
     *
     * @param poolId The id of the pool to get.
     * @param poolExistsOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the boolean object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<Boolean, PoolExistsHeaders> exists(String poolId, PoolExistsOptions poolExistsOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolExistsOptions);
        String select = null;
        if (poolExistsOptions != null) {
            select = poolExistsOptions.getSelect();
        }
        Integer timeout = null;
        if (poolExistsOptions != null) {
            timeout = poolExistsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolExistsOptions != null) {
            clientRequestId = poolExistsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolExistsOptions != null) {
            returnClientRequestId = poolExistsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolExistsOptions != null) {
            ocpDate = poolExistsOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolExistsOptions != null) {
            ifMatch = poolExistsOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolExistsOptions != null) {
            ifNoneMatch = poolExistsOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolExistsOptions != null) {
            ifModifiedSince = poolExistsOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolExistsOptions != null) {
            ifUnmodifiedSince = poolExistsOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<Void> call = service.exists(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return existsDelegate(call.execute());
    }

    /**
     * Gets basic properties of a pool.
     *
     * @param poolId The id of the pool to get.
     * @param poolExistsOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall existsAsync(String poolId, PoolExistsOptions poolExistsOptions, final ServiceCallback<Boolean> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolExistsOptions, serviceCallback);
        String select = null;
        if (poolExistsOptions != null) {
            select = poolExistsOptions.getSelect();
        }
        Integer timeout = null;
        if (poolExistsOptions != null) {
            timeout = poolExistsOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolExistsOptions != null) {
            clientRequestId = poolExistsOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolExistsOptions != null) {
            returnClientRequestId = poolExistsOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolExistsOptions != null) {
            ocpDate = poolExistsOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolExistsOptions != null) {
            ifMatch = poolExistsOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolExistsOptions != null) {
            ifNoneMatch = poolExistsOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolExistsOptions != null) {
            ifModifiedSince = poolExistsOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolExistsOptions != null) {
            ifUnmodifiedSince = poolExistsOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<Void> call = service.exists(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseEmptyCallback<Boolean>(serviceCallback) {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    serviceCallback.success(existsDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Boolean, PoolExistsHeaders> existsDelegate(Response<Void> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Boolean, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .register(404, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildEmptyWithHeaders(response, PoolExistsHeaders.class);
    }

    /**
     * Gets information about the specified pool.
     *
     * @param poolId The id of the pool to get.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CloudPool object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<CloudPool, PoolGetHeaders> get(String poolId) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolGetOptions poolGetOptions = null;
        String select = null;
        String expand = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.get(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, expand, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return getDelegate(call.execute());
    }

    /**
     * Gets information about the specified pool.
     *
     * @param poolId The id of the pool to get.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAsync(String poolId, final ServiceCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolGetOptions poolGetOptions = null;
        String select = null;
        String expand = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.get(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, expand, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<CloudPool>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets information about the specified pool.
     *
     * @param poolId The id of the pool to get.
     * @param poolGetOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the CloudPool object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<CloudPool, PoolGetHeaders> get(String poolId, PoolGetOptions poolGetOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolGetOptions);
        String select = null;
        if (poolGetOptions != null) {
            select = poolGetOptions.getSelect();
        }
        String expand = null;
        if (poolGetOptions != null) {
            expand = poolGetOptions.getExpand();
        }
        Integer timeout = null;
        if (poolGetOptions != null) {
            timeout = poolGetOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolGetOptions != null) {
            clientRequestId = poolGetOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolGetOptions != null) {
            returnClientRequestId = poolGetOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolGetOptions != null) {
            ocpDate = poolGetOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolGetOptions != null) {
            ifMatch = poolGetOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolGetOptions != null) {
            ifNoneMatch = poolGetOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolGetOptions != null) {
            ifModifiedSince = poolGetOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolGetOptions != null) {
            ifUnmodifiedSince = poolGetOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.get(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, expand, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return getDelegate(call.execute());
    }

    /**
     * Gets information about the specified pool.
     *
     * @param poolId The id of the pool to get.
     * @param poolGetOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall getAsync(String poolId, PoolGetOptions poolGetOptions, final ServiceCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolGetOptions, serviceCallback);
        String select = null;
        if (poolGetOptions != null) {
            select = poolGetOptions.getSelect();
        }
        String expand = null;
        if (poolGetOptions != null) {
            expand = poolGetOptions.getExpand();
        }
        Integer timeout = null;
        if (poolGetOptions != null) {
            timeout = poolGetOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolGetOptions != null) {
            clientRequestId = poolGetOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolGetOptions != null) {
            returnClientRequestId = poolGetOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolGetOptions != null) {
            ocpDate = poolGetOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolGetOptions != null) {
            ifMatch = poolGetOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolGetOptions != null) {
            ifNoneMatch = poolGetOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolGetOptions != null) {
            ifModifiedSince = poolGetOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolGetOptions != null) {
            ifUnmodifiedSince = poolGetOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.get(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), select, expand, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<CloudPool>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(getDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<CloudPool, PoolGetHeaders> getDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<CloudPool, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<CloudPool>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolGetHeaders.class);
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolPatchParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolPatchHeaders> patch(String poolId, PoolPatchParameter poolPatchParameter) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolPatchParameter == null) {
            throw new IllegalArgumentException("Parameter poolPatchParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolPatchParameter);
        final PoolPatchOptions poolPatchOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.patch(poolId, poolPatchParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return patchDelegate(call.execute());
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolPatchParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall patchAsync(String poolId, PoolPatchParameter poolPatchParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolPatchParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolPatchParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolPatchParameter, serviceCallback);
        final PoolPatchOptions poolPatchOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.patch(poolId, poolPatchParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(patchDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolPatchParameter The parameters for the request.
     * @param poolPatchOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolPatchHeaders> patch(String poolId, PoolPatchParameter poolPatchParameter, PoolPatchOptions poolPatchOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolPatchParameter == null) {
            throw new IllegalArgumentException("Parameter poolPatchParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolPatchParameter);
        Validator.validate(poolPatchOptions);
        Integer timeout = null;
        if (poolPatchOptions != null) {
            timeout = poolPatchOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolPatchOptions != null) {
            clientRequestId = poolPatchOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolPatchOptions != null) {
            returnClientRequestId = poolPatchOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolPatchOptions != null) {
            ocpDate = poolPatchOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolPatchOptions != null) {
            ifMatch = poolPatchOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolPatchOptions != null) {
            ifNoneMatch = poolPatchOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolPatchOptions != null) {
            ifModifiedSince = poolPatchOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolPatchOptions != null) {
            ifUnmodifiedSince = poolPatchOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.patch(poolId, poolPatchParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return patchDelegate(call.execute());
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolPatchParameter The parameters for the request.
     * @param poolPatchOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall patchAsync(String poolId, PoolPatchParameter poolPatchParameter, PoolPatchOptions poolPatchOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolPatchParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolPatchParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolPatchParameter, serviceCallback);
        Validator.validate(poolPatchOptions, serviceCallback);
        Integer timeout = null;
        if (poolPatchOptions != null) {
            timeout = poolPatchOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolPatchOptions != null) {
            clientRequestId = poolPatchOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolPatchOptions != null) {
            returnClientRequestId = poolPatchOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolPatchOptions != null) {
            ocpDate = poolPatchOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolPatchOptions != null) {
            ifMatch = poolPatchOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolPatchOptions != null) {
            ifNoneMatch = poolPatchOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolPatchOptions != null) {
            ifModifiedSince = poolPatchOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolPatchOptions != null) {
            ifUnmodifiedSince = poolPatchOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.patch(poolId, poolPatchParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(patchDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolPatchHeaders> patchDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolPatchHeaders.class);
    }

    /**
     * Disables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to disable automatic scaling.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolDisableAutoScaleHeaders> disableAutoScale(String poolId) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolDisableAutoScaleOptions poolDisableAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.disableAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return disableAutoScaleDelegate(call.execute());
    }

    /**
     * Disables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to disable automatic scaling.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall disableAutoScaleAsync(String poolId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolDisableAutoScaleOptions poolDisableAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.disableAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(disableAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Disables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to disable automatic scaling.
     * @param poolDisableAutoScaleOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolDisableAutoScaleHeaders> disableAutoScale(String poolId, PoolDisableAutoScaleOptions poolDisableAutoScaleOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolDisableAutoScaleOptions);
        Integer timeout = null;
        if (poolDisableAutoScaleOptions != null) {
            timeout = poolDisableAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolDisableAutoScaleOptions != null) {
            clientRequestId = poolDisableAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolDisableAutoScaleOptions != null) {
            returnClientRequestId = poolDisableAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolDisableAutoScaleOptions != null) {
            ocpDate = poolDisableAutoScaleOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.disableAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return disableAutoScaleDelegate(call.execute());
    }

    /**
     * Disables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to disable automatic scaling.
     * @param poolDisableAutoScaleOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall disableAutoScaleAsync(String poolId, PoolDisableAutoScaleOptions poolDisableAutoScaleOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolDisableAutoScaleOptions, serviceCallback);
        Integer timeout = null;
        if (poolDisableAutoScaleOptions != null) {
            timeout = poolDisableAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolDisableAutoScaleOptions != null) {
            clientRequestId = poolDisableAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolDisableAutoScaleOptions != null) {
            returnClientRequestId = poolDisableAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolDisableAutoScaleOptions != null) {
            ocpDate = poolDisableAutoScaleOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.disableAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(disableAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolDisableAutoScaleHeaders> disableAutoScaleDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolDisableAutoScaleHeaders.class);
    }

    /**
     * Enables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to enable automatic scaling.
     * @param poolEnableAutoScaleParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolEnableAutoScaleHeaders> enableAutoScale(String poolId, PoolEnableAutoScaleParameter poolEnableAutoScaleParameter) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolEnableAutoScaleParameter == null) {
            throw new IllegalArgumentException("Parameter poolEnableAutoScaleParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolEnableAutoScaleParameter);
        final PoolEnableAutoScaleOptions poolEnableAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.enableAutoScale(poolId, poolEnableAutoScaleParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return enableAutoScaleDelegate(call.execute());
    }

    /**
     * Enables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to enable automatic scaling.
     * @param poolEnableAutoScaleParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall enableAutoScaleAsync(String poolId, PoolEnableAutoScaleParameter poolEnableAutoScaleParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolEnableAutoScaleParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolEnableAutoScaleParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolEnableAutoScaleParameter, serviceCallback);
        final PoolEnableAutoScaleOptions poolEnableAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.enableAutoScale(poolId, poolEnableAutoScaleParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(enableAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Enables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to enable automatic scaling.
     * @param poolEnableAutoScaleParameter The parameters for the request.
     * @param poolEnableAutoScaleOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolEnableAutoScaleHeaders> enableAutoScale(String poolId, PoolEnableAutoScaleParameter poolEnableAutoScaleParameter, PoolEnableAutoScaleOptions poolEnableAutoScaleOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolEnableAutoScaleParameter == null) {
            throw new IllegalArgumentException("Parameter poolEnableAutoScaleParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolEnableAutoScaleParameter);
        Validator.validate(poolEnableAutoScaleOptions);
        Integer timeout = null;
        if (poolEnableAutoScaleOptions != null) {
            timeout = poolEnableAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolEnableAutoScaleOptions != null) {
            clientRequestId = poolEnableAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolEnableAutoScaleOptions != null) {
            returnClientRequestId = poolEnableAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolEnableAutoScaleOptions != null) {
            ocpDate = poolEnableAutoScaleOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolEnableAutoScaleOptions != null) {
            ifMatch = poolEnableAutoScaleOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolEnableAutoScaleOptions != null) {
            ifNoneMatch = poolEnableAutoScaleOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolEnableAutoScaleOptions != null) {
            ifModifiedSince = poolEnableAutoScaleOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolEnableAutoScaleOptions != null) {
            ifUnmodifiedSince = poolEnableAutoScaleOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.enableAutoScale(poolId, poolEnableAutoScaleParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return enableAutoScaleDelegate(call.execute());
    }

    /**
     * Enables automatic scaling for a pool.
     *
     * @param poolId The id of the pool on which to enable automatic scaling.
     * @param poolEnableAutoScaleParameter The parameters for the request.
     * @param poolEnableAutoScaleOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall enableAutoScaleAsync(String poolId, PoolEnableAutoScaleParameter poolEnableAutoScaleParameter, PoolEnableAutoScaleOptions poolEnableAutoScaleOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolEnableAutoScaleParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolEnableAutoScaleParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolEnableAutoScaleParameter, serviceCallback);
        Validator.validate(poolEnableAutoScaleOptions, serviceCallback);
        Integer timeout = null;
        if (poolEnableAutoScaleOptions != null) {
            timeout = poolEnableAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolEnableAutoScaleOptions != null) {
            clientRequestId = poolEnableAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolEnableAutoScaleOptions != null) {
            returnClientRequestId = poolEnableAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolEnableAutoScaleOptions != null) {
            ocpDate = poolEnableAutoScaleOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolEnableAutoScaleOptions != null) {
            ifMatch = poolEnableAutoScaleOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolEnableAutoScaleOptions != null) {
            ifNoneMatch = poolEnableAutoScaleOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolEnableAutoScaleOptions != null) {
            ifModifiedSince = poolEnableAutoScaleOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolEnableAutoScaleOptions != null) {
            ifUnmodifiedSince = poolEnableAutoScaleOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.enableAutoScale(poolId, poolEnableAutoScaleParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(enableAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolEnableAutoScaleHeaders> enableAutoScaleDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolEnableAutoScaleHeaders.class);
    }

    /**
     * Gets the result of evaluating an automatic scaling formula on the pool.
     *
     * @param poolId The id of the pool on which to evaluate the automatic scaling formula.
     * @param autoScaleFormula Sets a formula for the desired number of compute nodes in the pool.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the AutoScaleRun object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<AutoScaleRun, PoolEvaluateAutoScaleHeaders> evaluateAutoScale(String poolId, String autoScaleFormula) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (autoScaleFormula == null) {
            throw new IllegalArgumentException("Parameter autoScaleFormula is required and cannot be null.");
        }
        final PoolEvaluateAutoScaleOptions poolEvaluateAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        PoolEvaluateAutoScaleParameter poolEvaluateAutoScaleParameter = new PoolEvaluateAutoScaleParameter();
        poolEvaluateAutoScaleParameter.setAutoScaleFormula(autoScaleFormula);
        Call<ResponseBody> call = service.evaluateAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, poolEvaluateAutoScaleParameter);
        return evaluateAutoScaleDelegate(call.execute());
    }

    /**
     * Gets the result of evaluating an automatic scaling formula on the pool.
     *
     * @param poolId The id of the pool on which to evaluate the automatic scaling formula.
     * @param autoScaleFormula Sets a formula for the desired number of compute nodes in the pool.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall evaluateAutoScaleAsync(String poolId, String autoScaleFormula, final ServiceCallback<AutoScaleRun> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (autoScaleFormula == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter autoScaleFormula is required and cannot be null."));
            return null;
        }
        final PoolEvaluateAutoScaleOptions poolEvaluateAutoScaleOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        PoolEvaluateAutoScaleParameter poolEvaluateAutoScaleParameter = new PoolEvaluateAutoScaleParameter();
        poolEvaluateAutoScaleParameter.setAutoScaleFormula(autoScaleFormula);
        Call<ResponseBody> call = service.evaluateAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, poolEvaluateAutoScaleParameter);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<AutoScaleRun>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(evaluateAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Gets the result of evaluating an automatic scaling formula on the pool.
     *
     * @param poolId The id of the pool on which to evaluate the automatic scaling formula.
     * @param autoScaleFormula Sets a formula for the desired number of compute nodes in the pool.
     * @param poolEvaluateAutoScaleOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the AutoScaleRun object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<AutoScaleRun, PoolEvaluateAutoScaleHeaders> evaluateAutoScale(String poolId, String autoScaleFormula, PoolEvaluateAutoScaleOptions poolEvaluateAutoScaleOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (autoScaleFormula == null) {
            throw new IllegalArgumentException("Parameter autoScaleFormula is required and cannot be null.");
        }
        Validator.validate(poolEvaluateAutoScaleOptions);
        Integer timeout = null;
        if (poolEvaluateAutoScaleOptions != null) {
            timeout = poolEvaluateAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolEvaluateAutoScaleOptions != null) {
            clientRequestId = poolEvaluateAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolEvaluateAutoScaleOptions != null) {
            returnClientRequestId = poolEvaluateAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolEvaluateAutoScaleOptions != null) {
            ocpDate = poolEvaluateAutoScaleOptions.getOcpDate();
        }
        PoolEvaluateAutoScaleParameter poolEvaluateAutoScaleParameter = new PoolEvaluateAutoScaleParameter();
        poolEvaluateAutoScaleParameter.setAutoScaleFormula(autoScaleFormula);
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.evaluateAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, poolEvaluateAutoScaleParameter);
        return evaluateAutoScaleDelegate(call.execute());
    }

    /**
     * Gets the result of evaluating an automatic scaling formula on the pool.
     *
     * @param poolId The id of the pool on which to evaluate the automatic scaling formula.
     * @param autoScaleFormula Sets a formula for the desired number of compute nodes in the pool.
     * @param poolEvaluateAutoScaleOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall evaluateAutoScaleAsync(String poolId, String autoScaleFormula, PoolEvaluateAutoScaleOptions poolEvaluateAutoScaleOptions, final ServiceCallback<AutoScaleRun> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (autoScaleFormula == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter autoScaleFormula is required and cannot be null."));
            return null;
        }
        Validator.validate(poolEvaluateAutoScaleOptions, serviceCallback);
        Integer timeout = null;
        if (poolEvaluateAutoScaleOptions != null) {
            timeout = poolEvaluateAutoScaleOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolEvaluateAutoScaleOptions != null) {
            clientRequestId = poolEvaluateAutoScaleOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolEvaluateAutoScaleOptions != null) {
            returnClientRequestId = poolEvaluateAutoScaleOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolEvaluateAutoScaleOptions != null) {
            ocpDate = poolEvaluateAutoScaleOptions.getOcpDate();
        }
        PoolEvaluateAutoScaleParameter poolEvaluateAutoScaleParameter = new PoolEvaluateAutoScaleParameter();
        poolEvaluateAutoScaleParameter.setAutoScaleFormula(autoScaleFormula);
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.evaluateAutoScale(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, poolEvaluateAutoScaleParameter);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<AutoScaleRun>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(evaluateAutoScaleDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<AutoScaleRun, PoolEvaluateAutoScaleHeaders> evaluateAutoScaleDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<AutoScaleRun, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<AutoScaleRun>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolEvaluateAutoScaleHeaders.class);
    }

    /**
     * Changes the number of compute nodes that are assigned to a pool.
     *
     * @param poolId The id of the pool to resize.
     * @param poolResizeParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolResizeHeaders> resize(String poolId, PoolResizeParameter poolResizeParameter) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolResizeParameter == null) {
            throw new IllegalArgumentException("Parameter poolResizeParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolResizeParameter);
        final PoolResizeOptions poolResizeOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.resize(poolId, poolResizeParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return resizeDelegate(call.execute());
    }

    /**
     * Changes the number of compute nodes that are assigned to a pool.
     *
     * @param poolId The id of the pool to resize.
     * @param poolResizeParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall resizeAsync(String poolId, PoolResizeParameter poolResizeParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolResizeParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolResizeParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolResizeParameter, serviceCallback);
        final PoolResizeOptions poolResizeOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.resize(poolId, poolResizeParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(resizeDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Changes the number of compute nodes that are assigned to a pool.
     *
     * @param poolId The id of the pool to resize.
     * @param poolResizeParameter The parameters for the request.
     * @param poolResizeOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolResizeHeaders> resize(String poolId, PoolResizeParameter poolResizeParameter, PoolResizeOptions poolResizeOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolResizeParameter == null) {
            throw new IllegalArgumentException("Parameter poolResizeParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolResizeParameter);
        Validator.validate(poolResizeOptions);
        Integer timeout = null;
        if (poolResizeOptions != null) {
            timeout = poolResizeOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolResizeOptions != null) {
            clientRequestId = poolResizeOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolResizeOptions != null) {
            returnClientRequestId = poolResizeOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolResizeOptions != null) {
            ocpDate = poolResizeOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolResizeOptions != null) {
            ifMatch = poolResizeOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolResizeOptions != null) {
            ifNoneMatch = poolResizeOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolResizeOptions != null) {
            ifModifiedSince = poolResizeOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolResizeOptions != null) {
            ifUnmodifiedSince = poolResizeOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.resize(poolId, poolResizeParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return resizeDelegate(call.execute());
    }

    /**
     * Changes the number of compute nodes that are assigned to a pool.
     *
     * @param poolId The id of the pool to resize.
     * @param poolResizeParameter The parameters for the request.
     * @param poolResizeOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall resizeAsync(String poolId, PoolResizeParameter poolResizeParameter, PoolResizeOptions poolResizeOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolResizeParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolResizeParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolResizeParameter, serviceCallback);
        Validator.validate(poolResizeOptions, serviceCallback);
        Integer timeout = null;
        if (poolResizeOptions != null) {
            timeout = poolResizeOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolResizeOptions != null) {
            clientRequestId = poolResizeOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolResizeOptions != null) {
            returnClientRequestId = poolResizeOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolResizeOptions != null) {
            ocpDate = poolResizeOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolResizeOptions != null) {
            ifMatch = poolResizeOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolResizeOptions != null) {
            ifNoneMatch = poolResizeOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolResizeOptions != null) {
            ifModifiedSince = poolResizeOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolResizeOptions != null) {
            ifUnmodifiedSince = poolResizeOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.resize(poolId, poolResizeParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(resizeDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolResizeHeaders> resizeDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolResizeHeaders.class);
    }

    /**
     * Stops an ongoing resize operation on the pool. This does not restore the pool to its previous state before the resize operation: it only stops any further changes being made, and the pool maintains its current state.
     *
     * @param poolId The id of the pool whose resizing you want to stop.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolStopResizeHeaders> stopResize(String poolId) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        final PoolStopResizeOptions poolStopResizeOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.stopResize(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return stopResizeDelegate(call.execute());
    }

    /**
     * Stops an ongoing resize operation on the pool. This does not restore the pool to its previous state before the resize operation: it only stops any further changes being made, and the pool maintains its current state.
     *
     * @param poolId The id of the pool whose resizing you want to stop.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall stopResizeAsync(String poolId, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        final PoolStopResizeOptions poolStopResizeOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.stopResize(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(stopResizeDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Stops an ongoing resize operation on the pool. This does not restore the pool to its previous state before the resize operation: it only stops any further changes being made, and the pool maintains its current state.
     *
     * @param poolId The id of the pool whose resizing you want to stop.
     * @param poolStopResizeOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolStopResizeHeaders> stopResize(String poolId, PoolStopResizeOptions poolStopResizeOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolStopResizeOptions);
        Integer timeout = null;
        if (poolStopResizeOptions != null) {
            timeout = poolStopResizeOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolStopResizeOptions != null) {
            clientRequestId = poolStopResizeOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolStopResizeOptions != null) {
            returnClientRequestId = poolStopResizeOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolStopResizeOptions != null) {
            ocpDate = poolStopResizeOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolStopResizeOptions != null) {
            ifMatch = poolStopResizeOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolStopResizeOptions != null) {
            ifNoneMatch = poolStopResizeOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolStopResizeOptions != null) {
            ifModifiedSince = poolStopResizeOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolStopResizeOptions != null) {
            ifUnmodifiedSince = poolStopResizeOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.stopResize(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return stopResizeDelegate(call.execute());
    }

    /**
     * Stops an ongoing resize operation on the pool. This does not restore the pool to its previous state before the resize operation: it only stops any further changes being made, and the pool maintains its current state.
     *
     * @param poolId The id of the pool whose resizing you want to stop.
     * @param poolStopResizeOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall stopResizeAsync(String poolId, PoolStopResizeOptions poolStopResizeOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolStopResizeOptions, serviceCallback);
        Integer timeout = null;
        if (poolStopResizeOptions != null) {
            timeout = poolStopResizeOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolStopResizeOptions != null) {
            clientRequestId = poolStopResizeOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolStopResizeOptions != null) {
            returnClientRequestId = poolStopResizeOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolStopResizeOptions != null) {
            ocpDate = poolStopResizeOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolStopResizeOptions != null) {
            ifMatch = poolStopResizeOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolStopResizeOptions != null) {
            ifNoneMatch = poolStopResizeOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolStopResizeOptions != null) {
            ifModifiedSince = poolStopResizeOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolStopResizeOptions != null) {
            ifUnmodifiedSince = poolStopResizeOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.stopResize(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(stopResizeDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolStopResizeHeaders> stopResizeDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolStopResizeHeaders.class);
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolUpdatePropertiesParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolUpdatePropertiesHeaders> updateProperties(String poolId, PoolUpdatePropertiesParameter poolUpdatePropertiesParameter) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolUpdatePropertiesParameter == null) {
            throw new IllegalArgumentException("Parameter poolUpdatePropertiesParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolUpdatePropertiesParameter);
        final PoolUpdatePropertiesOptions poolUpdatePropertiesOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.updateProperties(poolId, poolUpdatePropertiesParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return updatePropertiesDelegate(call.execute());
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolUpdatePropertiesParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall updatePropertiesAsync(String poolId, PoolUpdatePropertiesParameter poolUpdatePropertiesParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolUpdatePropertiesParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolUpdatePropertiesParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolUpdatePropertiesParameter, serviceCallback);
        final PoolUpdatePropertiesOptions poolUpdatePropertiesOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.updateProperties(poolId, poolUpdatePropertiesParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(updatePropertiesDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolUpdatePropertiesParameter The parameters for the request.
     * @param poolUpdatePropertiesOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolUpdatePropertiesHeaders> updateProperties(String poolId, PoolUpdatePropertiesParameter poolUpdatePropertiesParameter, PoolUpdatePropertiesOptions poolUpdatePropertiesOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (poolUpdatePropertiesParameter == null) {
            throw new IllegalArgumentException("Parameter poolUpdatePropertiesParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(poolUpdatePropertiesParameter);
        Validator.validate(poolUpdatePropertiesOptions);
        Integer timeout = null;
        if (poolUpdatePropertiesOptions != null) {
            timeout = poolUpdatePropertiesOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolUpdatePropertiesOptions != null) {
            clientRequestId = poolUpdatePropertiesOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolUpdatePropertiesOptions != null) {
            returnClientRequestId = poolUpdatePropertiesOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolUpdatePropertiesOptions != null) {
            ocpDate = poolUpdatePropertiesOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.updateProperties(poolId, poolUpdatePropertiesParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        return updatePropertiesDelegate(call.execute());
    }

    /**
     * Updates the properties of a pool.
     *
     * @param poolId The id of the pool to update.
     * @param poolUpdatePropertiesParameter The parameters for the request.
     * @param poolUpdatePropertiesOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall updatePropertiesAsync(String poolId, PoolUpdatePropertiesParameter poolUpdatePropertiesParameter, PoolUpdatePropertiesOptions poolUpdatePropertiesOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (poolUpdatePropertiesParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolUpdatePropertiesParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(poolUpdatePropertiesParameter, serviceCallback);
        Validator.validate(poolUpdatePropertiesOptions, serviceCallback);
        Integer timeout = null;
        if (poolUpdatePropertiesOptions != null) {
            timeout = poolUpdatePropertiesOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolUpdatePropertiesOptions != null) {
            clientRequestId = poolUpdatePropertiesOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolUpdatePropertiesOptions != null) {
            returnClientRequestId = poolUpdatePropertiesOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolUpdatePropertiesOptions != null) {
            ocpDate = poolUpdatePropertiesOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.updateProperties(poolId, poolUpdatePropertiesParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(updatePropertiesDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolUpdatePropertiesHeaders> updatePropertiesDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(204, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolUpdatePropertiesHeaders.class);
    }

    /**
     * Upgrades the operating system of the specified pool.
     *
     * @param poolId The id of the pool to upgrade.
     * @param targetOSVersion Sets the Azure Guest OS version to be installed on the virtual machines in the pool.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolUpgradeOSHeaders> upgradeOS(String poolId, String targetOSVersion) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (targetOSVersion == null) {
            throw new IllegalArgumentException("Parameter targetOSVersion is required and cannot be null.");
        }
        final PoolUpgradeOSOptions poolUpgradeOSOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        PoolUpgradeOSParameter poolUpgradeOSParameter = new PoolUpgradeOSParameter();
        poolUpgradeOSParameter.setTargetOSVersion(targetOSVersion);
        Call<ResponseBody> call = service.upgradeOS(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted, poolUpgradeOSParameter);
        return upgradeOSDelegate(call.execute());
    }

    /**
     * Upgrades the operating system of the specified pool.
     *
     * @param poolId The id of the pool to upgrade.
     * @param targetOSVersion Sets the Azure Guest OS version to be installed on the virtual machines in the pool.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall upgradeOSAsync(String poolId, String targetOSVersion, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (targetOSVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter targetOSVersion is required and cannot be null."));
            return null;
        }
        final PoolUpgradeOSOptions poolUpgradeOSOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        PoolUpgradeOSParameter poolUpgradeOSParameter = new PoolUpgradeOSParameter();
        poolUpgradeOSParameter.setTargetOSVersion(targetOSVersion);
        Call<ResponseBody> call = service.upgradeOS(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted, poolUpgradeOSParameter);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(upgradeOSDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Upgrades the operating system of the specified pool.
     *
     * @param poolId The id of the pool to upgrade.
     * @param targetOSVersion Sets the Azure Guest OS version to be installed on the virtual machines in the pool.
     * @param poolUpgradeOSOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolUpgradeOSHeaders> upgradeOS(String poolId, String targetOSVersion, PoolUpgradeOSOptions poolUpgradeOSOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        if (targetOSVersion == null) {
            throw new IllegalArgumentException("Parameter targetOSVersion is required and cannot be null.");
        }
        Validator.validate(poolUpgradeOSOptions);
        Integer timeout = null;
        if (poolUpgradeOSOptions != null) {
            timeout = poolUpgradeOSOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolUpgradeOSOptions != null) {
            clientRequestId = poolUpgradeOSOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolUpgradeOSOptions != null) {
            returnClientRequestId = poolUpgradeOSOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolUpgradeOSOptions != null) {
            ocpDate = poolUpgradeOSOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolUpgradeOSOptions != null) {
            ifMatch = poolUpgradeOSOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolUpgradeOSOptions != null) {
            ifNoneMatch = poolUpgradeOSOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolUpgradeOSOptions != null) {
            ifModifiedSince = poolUpgradeOSOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolUpgradeOSOptions != null) {
            ifUnmodifiedSince = poolUpgradeOSOptions.getIfUnmodifiedSince();
        }
        PoolUpgradeOSParameter poolUpgradeOSParameter = new PoolUpgradeOSParameter();
        poolUpgradeOSParameter.setTargetOSVersion(targetOSVersion);
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.upgradeOS(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted, poolUpgradeOSParameter);
        return upgradeOSDelegate(call.execute());
    }

    /**
     * Upgrades the operating system of the specified pool.
     *
     * @param poolId The id of the pool to upgrade.
     * @param targetOSVersion Sets the Azure Guest OS version to be installed on the virtual machines in the pool.
     * @param poolUpgradeOSOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall upgradeOSAsync(String poolId, String targetOSVersion, PoolUpgradeOSOptions poolUpgradeOSOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        if (targetOSVersion == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter targetOSVersion is required and cannot be null."));
            return null;
        }
        Validator.validate(poolUpgradeOSOptions, serviceCallback);
        Integer timeout = null;
        if (poolUpgradeOSOptions != null) {
            timeout = poolUpgradeOSOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolUpgradeOSOptions != null) {
            clientRequestId = poolUpgradeOSOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolUpgradeOSOptions != null) {
            returnClientRequestId = poolUpgradeOSOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolUpgradeOSOptions != null) {
            ocpDate = poolUpgradeOSOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolUpgradeOSOptions != null) {
            ifMatch = poolUpgradeOSOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolUpgradeOSOptions != null) {
            ifNoneMatch = poolUpgradeOSOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolUpgradeOSOptions != null) {
            ifModifiedSince = poolUpgradeOSOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolUpgradeOSOptions != null) {
            ifUnmodifiedSince = poolUpgradeOSOptions.getIfUnmodifiedSince();
        }
        PoolUpgradeOSParameter poolUpgradeOSParameter = new PoolUpgradeOSParameter();
        poolUpgradeOSParameter.setTargetOSVersion(targetOSVersion);
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.upgradeOS(poolId, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted, poolUpgradeOSParameter);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(upgradeOSDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolUpgradeOSHeaders> upgradeOSDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolUpgradeOSHeaders.class);
    }

    /**
     * Removes compute nodes from the specified pool.
     *
     * @param poolId The id of the pool from which you want to remove nodes.
     * @param nodeRemoveParameter The parameters for the request.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolRemoveNodesHeaders> removeNodes(String poolId, NodeRemoveParameter nodeRemoveParameter) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (nodeRemoveParameter == null) {
            throw new IllegalArgumentException("Parameter nodeRemoveParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(nodeRemoveParameter);
        final PoolRemoveNodesOptions poolRemoveNodesOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.removeNodes(poolId, nodeRemoveParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return removeNodesDelegate(call.execute());
    }

    /**
     * Removes compute nodes from the specified pool.
     *
     * @param poolId The id of the pool from which you want to remove nodes.
     * @param nodeRemoveParameter The parameters for the request.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall removeNodesAsync(String poolId, NodeRemoveParameter nodeRemoveParameter, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (nodeRemoveParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nodeRemoveParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(nodeRemoveParameter, serviceCallback);
        final PoolRemoveNodesOptions poolRemoveNodesOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        String ifMatch = null;
        String ifNoneMatch = null;
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        Call<ResponseBody> call = service.removeNodes(poolId, nodeRemoveParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(removeNodesDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Removes compute nodes from the specified pool.
     *
     * @param poolId The id of the pool from which you want to remove nodes.
     * @param nodeRemoveParameter The parameters for the request.
     * @param poolRemoveNodesOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the {@link ServiceResponseWithHeaders} object if successful.
     */
    public ServiceResponseWithHeaders<Void, PoolRemoveNodesHeaders> removeNodes(String poolId, NodeRemoveParameter nodeRemoveParameter, PoolRemoveNodesOptions poolRemoveNodesOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (poolId == null) {
            throw new IllegalArgumentException("Parameter poolId is required and cannot be null.");
        }
        if (nodeRemoveParameter == null) {
            throw new IllegalArgumentException("Parameter nodeRemoveParameter is required and cannot be null.");
        }
        if (this.client.getApiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null.");
        }
        Validator.validate(nodeRemoveParameter);
        Validator.validate(poolRemoveNodesOptions);
        Integer timeout = null;
        if (poolRemoveNodesOptions != null) {
            timeout = poolRemoveNodesOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolRemoveNodesOptions != null) {
            clientRequestId = poolRemoveNodesOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolRemoveNodesOptions != null) {
            returnClientRequestId = poolRemoveNodesOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolRemoveNodesOptions != null) {
            ocpDate = poolRemoveNodesOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolRemoveNodesOptions != null) {
            ifMatch = poolRemoveNodesOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolRemoveNodesOptions != null) {
            ifNoneMatch = poolRemoveNodesOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolRemoveNodesOptions != null) {
            ifModifiedSince = poolRemoveNodesOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolRemoveNodesOptions != null) {
            ifUnmodifiedSince = poolRemoveNodesOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.removeNodes(poolId, nodeRemoveParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        return removeNodesDelegate(call.execute());
    }

    /**
     * Removes compute nodes from the specified pool.
     *
     * @param poolId The id of the pool from which you want to remove nodes.
     * @param nodeRemoveParameter The parameters for the request.
     * @param poolRemoveNodesOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall removeNodesAsync(String poolId, NodeRemoveParameter nodeRemoveParameter, PoolRemoveNodesOptions poolRemoveNodesOptions, final ServiceCallback<Void> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (poolId == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter poolId is required and cannot be null."));
            return null;
        }
        if (nodeRemoveParameter == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nodeRemoveParameter is required and cannot be null."));
            return null;
        }
        if (this.client.getApiVersion() == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter this.client.getApiVersion() is required and cannot be null."));
            return null;
        }
        Validator.validate(nodeRemoveParameter, serviceCallback);
        Validator.validate(poolRemoveNodesOptions, serviceCallback);
        Integer timeout = null;
        if (poolRemoveNodesOptions != null) {
            timeout = poolRemoveNodesOptions.getTimeout();
        }
        String clientRequestId = null;
        if (poolRemoveNodesOptions != null) {
            clientRequestId = poolRemoveNodesOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolRemoveNodesOptions != null) {
            returnClientRequestId = poolRemoveNodesOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolRemoveNodesOptions != null) {
            ocpDate = poolRemoveNodesOptions.getOcpDate();
        }
        String ifMatch = null;
        if (poolRemoveNodesOptions != null) {
            ifMatch = poolRemoveNodesOptions.getIfMatch();
        }
        String ifNoneMatch = null;
        if (poolRemoveNodesOptions != null) {
            ifNoneMatch = poolRemoveNodesOptions.getIfNoneMatch();
        }
        DateTime ifModifiedSince = null;
        if (poolRemoveNodesOptions != null) {
            ifModifiedSince = poolRemoveNodesOptions.getIfModifiedSince();
        }
        DateTime ifUnmodifiedSince = null;
        if (poolRemoveNodesOptions != null) {
            ifUnmodifiedSince = poolRemoveNodesOptions.getIfUnmodifiedSince();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        DateTimeRfc1123 ifModifiedSinceConverted = null;
        if (ifModifiedSince != null) {
            ifModifiedSinceConverted = new DateTimeRfc1123(ifModifiedSince);
        }
        DateTimeRfc1123 ifUnmodifiedSinceConverted = null;
        if (ifUnmodifiedSince != null) {
            ifUnmodifiedSinceConverted = new DateTimeRfc1123(ifUnmodifiedSince);
        }
        Call<ResponseBody> call = service.removeNodes(poolId, nodeRemoveParameter, this.client.getApiVersion(), this.client.getAcceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, ifMatch, ifNoneMatch, ifModifiedSinceConverted, ifUnmodifiedSinceConverted);
        final ServiceCall serviceCall = new ServiceCall(call);
        call.enqueue(new ServiceResponseCallback<Void>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    serviceCallback.success(removeNodesDelegate(response));
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<Void, PoolRemoveNodesHeaders> removeNodesDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<Void, BatchErrorException>(this.client.getMapperAdapter())
                .register(202, new TypeToken<Void>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolRemoveNodesHeaders.class);
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;PoolUsageMetrics&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetricsNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        final PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listPoolUsageMetricsNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        return listPoolUsageMetricsNextDelegate(call.execute());
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listPoolUsageMetricsNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<PoolUsageMetrics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        final PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listPoolUsageMetricsNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<PoolUsageMetrics>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> result = listPoolUsageMetricsNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listPoolUsageMetricsNextAsync(result.getBody().getNextPageLink(), null, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param poolListPoolUsageMetricsNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;PoolUsageMetrics&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetricsNext(final String nextPageLink, final PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Validator.validate(poolListPoolUsageMetricsNextOptions);
        String clientRequestId = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            clientRequestId = poolListPoolUsageMetricsNextOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            returnClientRequestId = poolListPoolUsageMetricsNextOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            ocpDate = poolListPoolUsageMetricsNextOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listPoolUsageMetricsNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        return listPoolUsageMetricsNextDelegate(call.execute());
    }

    /**
     * Lists the usage metrics, aggregated by pool across individual time intervals, for the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param poolListPoolUsageMetricsNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listPoolUsageMetricsNextAsync(final String nextPageLink, final PoolListPoolUsageMetricsNextOptions poolListPoolUsageMetricsNextOptions, final ServiceCall serviceCall, final ListOperationCallback<PoolUsageMetrics> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Validator.validate(poolListPoolUsageMetricsNextOptions, serviceCallback);
        String clientRequestId = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            clientRequestId = poolListPoolUsageMetricsNextOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            returnClientRequestId = poolListPoolUsageMetricsNextOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListPoolUsageMetricsNextOptions != null) {
            ocpDate = poolListPoolUsageMetricsNextOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listPoolUsageMetricsNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<PoolUsageMetrics>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> result = listPoolUsageMetricsNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listPoolUsageMetricsNextAsync(result.getBody().getNextPageLink(), poolListPoolUsageMetricsNextOptions, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<PageImpl<PoolUsageMetrics>, PoolListPoolUsageMetricsHeaders> listPoolUsageMetricsNextDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<PoolUsageMetrics>, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<PoolUsageMetrics>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolListPoolUsageMetricsHeaders.class);
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudPool&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> listNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        final PoolListNextOptions poolListNextOptions = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        return listNextDelegate(call.execute());
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listNextAsync(final String nextPageLink, final ServiceCall serviceCall, final ListOperationCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        final PoolListNextOptions poolListNextOptions = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTimeRfc1123 ocpDateConverted = null;
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<CloudPool>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> result = listNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), null, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param poolListNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;CloudPool&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> listNext(final String nextPageLink, final PoolListNextOptions poolListNextOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Validator.validate(poolListNextOptions);
        String clientRequestId = null;
        if (poolListNextOptions != null) {
            clientRequestId = poolListNextOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListNextOptions != null) {
            returnClientRequestId = poolListNextOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListNextOptions != null) {
            ocpDate = poolListNextOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        return listNextDelegate(call.execute());
    }

    /**
     * Lists all of the pools in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param poolListNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if callback is null
     * @return the {@link Call} object
     */
    public ServiceCall listNextAsync(final String nextPageLink, final PoolListNextOptions poolListNextOptions, final ServiceCall serviceCall, final ListOperationCallback<CloudPool> serviceCallback) throws IllegalArgumentException {
        if (serviceCallback == null) {
            throw new IllegalArgumentException("ServiceCallback is required for async calls.");
        }
        if (nextPageLink == null) {
            serviceCallback.failure(new IllegalArgumentException("Parameter nextPageLink is required and cannot be null."));
            return null;
        }
        Validator.validate(poolListNextOptions, serviceCallback);
        String clientRequestId = null;
        if (poolListNextOptions != null) {
            clientRequestId = poolListNextOptions.getClientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (poolListNextOptions != null) {
            returnClientRequestId = poolListNextOptions.getReturnClientRequestId();
        }
        DateTime ocpDate = null;
        if (poolListNextOptions != null) {
            ocpDate = poolListNextOptions.getOcpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        Call<ResponseBody> call = service.listNext(nextPageLink, this.client.getAcceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted);
        serviceCall.newCall(call);
        call.enqueue(new ServiceResponseCallback<List<CloudPool>>(serviceCallback) {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> result = listNextDelegate(response);
                    serviceCallback.load(result.getBody().getItems());
                    if (result.getBody().getNextPageLink() != null
                            && serviceCallback.progress(result.getBody().getItems()) == ListOperationCallback.PagingBahavior.CONTINUE) {
                        listNextAsync(result.getBody().getNextPageLink(), poolListNextOptions, serviceCall, serviceCallback);
                    } else {
                        serviceCallback.success(new ServiceResponseWithHeaders<>(serviceCallback.get(), result.getHeaders(), result.getResponse()));
                    }
                } catch (BatchErrorException | IOException exception) {
                    serviceCallback.failure(exception);
                }
            }
        });
        return serviceCall;
    }

    private ServiceResponseWithHeaders<PageImpl<CloudPool>, PoolListHeaders> listNextDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<CloudPool>, BatchErrorException>(this.client.getMapperAdapter())
                .register(200, new TypeToken<PageImpl<CloudPool>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, PoolListHeaders.class);
    }

}