package p000ai.api;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import p000ai.api.model.AIContext;
import p000ai.api.model.AIRequest;
import p000ai.api.model.AIResponse;
import p000ai.api.model.Entity;
import p000ai.api.util.IOUtils;
import p000ai.api.util.StringUtils;

/* renamed from: ai.api.AIDataService */
public class AIDataService {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String DEFAULT_REQUEST_METHOD = "POST";
    private static final Gson GSON = GsonFactory.getDefaultFactory().getGson();
    private static final Logger Log = LogManager.getLogger((Class<?>) AIDataService.class);
    private static final String REQUEST_METHOD_DELETE = "DELETE";
    private static final String REQUEST_METHOD_GET = "GET";
    private static final String REQUEST_METHOD_POST = "POST";
    private static final AIServiceContext UNDEFINED_SERVICE_CONTEXT = null;
    private final AIConfiguration config;
    private final AIServiceContext defaultServiceContext;

    /* renamed from: ai.api.AIDataService$ApiActiveContextListResponse */
    private interface ApiActiveContextListResponse extends List<AIContext> {
    }

    public AIDataService(AIConfiguration aIConfiguration, AIServiceContext aIServiceContext) {
        if (aIConfiguration != null) {
            this.config = aIConfiguration.clone();
            if (aIServiceContext == null) {
                this.defaultServiceContext = new AIServiceContextBuilder().generateSessionId().build();
            } else {
                this.defaultServiceContext = aIServiceContext;
            }
        } else {
            throw new IllegalArgumentException("config should not be null");
        }
    }

    public AIDataService(AIConfiguration aIConfiguration) {
        this(aIConfiguration, (AIServiceContext) null);
    }

    public AIServiceContext getContext() {
        return this.defaultServiceContext;
    }

    public AIResponse request(AIRequest aIRequest) throws AIServiceException {
        return request(aIRequest, (RequestExtras) null);
    }

    public AIResponse request(AIRequest aIRequest, AIServiceContext aIServiceContext) throws AIServiceException {
        return request(aIRequest, (RequestExtras) null, aIServiceContext);
    }

    public AIResponse request(AIRequest aIRequest, RequestExtras requestExtras) throws AIServiceException {
        return request(aIRequest, requestExtras, UNDEFINED_SERVICE_CONTEXT);
    }

    public AIResponse request(AIRequest aIRequest, RequestExtras requestExtras, AIServiceContext aIServiceContext) throws AIServiceException {
        if (aIRequest != null) {
            Log.debug("Start request");
            try {
                aIRequest.setLanguage(this.config.getApiAiLanguage());
                aIRequest.setSessionId(getSessionId(aIServiceContext));
                if (StringUtils.isEmpty(aIRequest.getTimezone())) {
                    aIRequest.setTimezone(getTimeZone(aIServiceContext));
                }
                Map<String, String> map = null;
                if (requestExtras != null) {
                    fillRequest(aIRequest, requestExtras);
                    map = requestExtras.getAdditionalHeaders();
                }
                String doTextRequest = doTextRequest(this.config.getQuestionUrl(getSessionId(aIServiceContext)), GSON.toJson((Object) aIRequest), map);
                if (!StringUtils.isEmpty(doTextRequest)) {
                    Logger logger = Log;
                    logger.debug("Response json: " + doTextRequest.replaceAll("[\r\n]+", org.apache.commons.lang3.StringUtils.SPACE));
                    AIResponse aIResponse = (AIResponse) GSON.fromJson(doTextRequest, AIResponse.class);
                    if (aIResponse == null) {
                        throw new AIServiceException("API.AI response parsed as null. Check debug log for details.");
                    } else if (!aIResponse.isError()) {
                        aIResponse.cleanup();
                        return aIResponse;
                    } else {
                        throw new AIServiceException(aIResponse);
                    }
                } else {
                    throw new AIServiceException("Empty response from ai service. Please check configuration and Internet connection.");
                }
            } catch (MalformedURLException e) {
                Log.error("Malformed url should not be raised", (Throwable) e);
                throw new AIServiceException("Wrong configuration. Please, connect to API.AI Service support", e);
            } catch (JsonSyntaxException e2) {
                throw new AIServiceException("Wrong service answer format. Please, connect to API.AI Service support", e2);
            }
        } else {
            throw new IllegalArgumentException("Request argument must not be null");
        }
    }

    public AIResponse voiceRequest(InputStream inputStream) throws AIServiceException {
        return voiceRequest(inputStream, new RequestExtras());
    }

    public AIResponse voiceRequest(InputStream inputStream, List<AIContext> list) throws AIServiceException {
        return voiceRequest(inputStream, new RequestExtras(list, (List<Entity>) null));
    }

    public AIResponse voiceRequest(InputStream inputStream, RequestExtras requestExtras) throws AIServiceException {
        return voiceRequest(inputStream, requestExtras, UNDEFINED_SERVICE_CONTEXT);
    }

    public AIResponse voiceRequest(InputStream inputStream, RequestExtras requestExtras, AIServiceContext aIServiceContext) throws AIServiceException {
        Log.debug("Start voice request");
        try {
            AIRequest aIRequest = new AIRequest();
            aIRequest.setLanguage(this.config.getApiAiLanguage());
            aIRequest.setSessionId(getSessionId(aIServiceContext));
            aIRequest.setTimezone(getTimeZone(aIServiceContext));
            Map<String, String> map = null;
            if (requestExtras != null) {
                fillRequest(aIRequest, requestExtras);
                map = requestExtras.getAdditionalHeaders();
            }
            String json = GSON.toJson((Object) aIRequest);
            Logger logger = Log;
            logger.debug("Request json: " + json);
            String doSoundRequest = doSoundRequest(inputStream, json, map);
            if (!StringUtils.isEmpty(doSoundRequest)) {
                Logger logger2 = Log;
                logger2.debug("Response json: " + doSoundRequest);
                AIResponse aIResponse = (AIResponse) GSON.fromJson(doSoundRequest, AIResponse.class);
                if (aIResponse == null) {
                    throw new AIServiceException("API.AI response parsed as null. Check debug log for details.");
                } else if (!aIResponse.isError()) {
                    aIResponse.cleanup();
                    return aIResponse;
                } else {
                    throw new AIServiceException(aIResponse);
                }
            } else {
                throw new AIServiceException("Empty response from ai service. Please check configuration.");
            }
        } catch (MalformedURLException e) {
            Log.error("Malformed url should not be raised", (Throwable) e);
            throw new AIServiceException("Wrong configuration. Please, connect to AI Service support", e);
        } catch (JsonSyntaxException e2) {
            throw new AIServiceException("Wrong service answer format. Please, connect to API.AI Service support", e2);
        }
    }

    public boolean resetContexts() {
        AIRequest aIRequest = new AIRequest();
        aIRequest.setQuery("empty_query_for_resetting_contexts");
        aIRequest.setResetContexts(true);
        try {
            return !request(aIRequest).isError();
        } catch (AIServiceException e) {
            Log.error("Exception while contexts clean.", (Throwable) e);
            return false;
        }
    }

    public List<AIContext> getActiveContexts() throws AIServiceException {
        return getActiveContexts(UNDEFINED_SERVICE_CONTEXT);
    }

    public List<AIContext> getActiveContexts(AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            return (List) doRequest(ApiActiveContextListResponse.class, this.config.getContextsUrl(getSessionId(aIServiceContext)), REQUEST_METHOD_GET);
        } catch (BadResponseStatusException e) {
            throw new AIServiceException(e.response);
        }
    }

    public AIContext getActiveContext(String str) throws AIServiceException {
        return getActiveContext(str, UNDEFINED_SERVICE_CONTEXT);
    }

    public AIContext getActiveContext(String str, AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            return (AIContext) doRequest(AIContext.class, this.config.getContextsUrl(getSessionId(aIServiceContext), str), REQUEST_METHOD_GET);
        } catch (BadResponseStatusException e) {
            if (e.response.getStatus().getCode().intValue() == 404) {
                return null;
            }
            throw new AIServiceException(e.response);
        }
    }

    public List<String> addActiveContext(Iterable<AIContext> iterable) throws AIServiceException {
        return addActiveContext(iterable, UNDEFINED_SERVICE_CONTEXT);
    }

    public List<String> addActiveContext(Iterable<AIContext> iterable, AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            return ((ApiActiveContextNamesResponse) doRequest(iterable, (Type) ApiActiveContextNamesResponse.class, this.config.getContextsUrl(getSessionId(aIServiceContext)), "POST")).names;
        } catch (BadResponseStatusException e) {
            throw new AIServiceException(e.response);
        }
    }

    public String addActiveContext(AIContext aIContext) throws AIServiceException {
        return addActiveContext(aIContext, UNDEFINED_SERVICE_CONTEXT);
    }

    public String addActiveContext(AIContext aIContext, AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            ApiActiveContextNamesResponse apiActiveContextNamesResponse = (ApiActiveContextNamesResponse) doRequest(aIContext, (Type) ApiActiveContextNamesResponse.class, this.config.getContextsUrl(getSessionId(aIServiceContext)), "POST");
            if (apiActiveContextNamesResponse.names == null || apiActiveContextNamesResponse.names.size() <= 0) {
                return null;
            }
            return apiActiveContextNamesResponse.names.get(0);
        } catch (BadResponseStatusException e) {
            throw new AIServiceException(e.response);
        }
    }

    public void resetActiveContexts() throws AIServiceException {
        resetActiveContexts(UNDEFINED_SERVICE_CONTEXT);
    }

    public void resetActiveContexts(AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            doRequest(AIResponse.class, this.config.getContextsUrl(getSessionId(aIServiceContext)), REQUEST_METHOD_DELETE);
        } catch (BadResponseStatusException e) {
            throw new AIServiceException(e.response);
        }
    }

    public boolean removeActiveContext(String str) throws AIServiceException {
        return removeActiveContext(str, UNDEFINED_SERVICE_CONTEXT);
    }

    public boolean removeActiveContext(String str, AIServiceContext aIServiceContext) throws AIServiceException {
        try {
            doRequest(AIResponse.class, this.config.getContextsUrl(getSessionId(aIServiceContext), str), REQUEST_METHOD_DELETE);
            return true;
        } catch (BadResponseStatusException e) {
            if (e.response.getStatus().getCode().intValue() == 404) {
                return false;
            }
            throw new AIServiceException(e.response);
        }
    }

    public AIResponse uploadUserEntity(Entity entity) throws AIServiceException {
        return uploadUserEntity(entity, UNDEFINED_SERVICE_CONTEXT);
    }

    public AIResponse uploadUserEntity(Entity entity, AIServiceContext aIServiceContext) throws AIServiceException {
        return uploadUserEntities(Collections.singleton(entity), aIServiceContext);
    }

    public AIResponse uploadUserEntities(Collection<Entity> collection) throws AIServiceException {
        return uploadUserEntities(collection, UNDEFINED_SERVICE_CONTEXT);
    }

    public AIResponse uploadUserEntities(Collection<Entity> collection, AIServiceContext aIServiceContext) throws AIServiceException {
        if (collection == null || collection.size() == 0) {
            throw new AIServiceException("Empty entities list");
        }
        try {
            String doTextRequest = doTextRequest(this.config.getUserEntitiesEndpoint(getSessionId(aIServiceContext)), GSON.toJson((Object) collection));
            if (!StringUtils.isEmpty(doTextRequest)) {
                Logger logger = Log;
                logger.debug("Response json: " + doTextRequest);
                AIResponse aIResponse = (AIResponse) GSON.fromJson(doTextRequest, AIResponse.class);
                if (aIResponse == null) {
                    throw new AIServiceException("API.AI response parsed as null. Check debug log for details.");
                } else if (!aIResponse.isError()) {
                    aIResponse.cleanup();
                    return aIResponse;
                } else {
                    throw new AIServiceException(aIResponse);
                }
            } else {
                throw new AIServiceException("Empty response from ai service. Please check configuration and Internet connection.");
            }
        } catch (MalformedURLException e) {
            Log.error("Malformed url should not be raised", (Throwable) e);
            throw new AIServiceException("Wrong configuration. Please, connect to AI Service support", e);
        } catch (JsonSyntaxException e2) {
            throw new AIServiceException("Wrong service answer format. Please, connect to API.AI Service support", e2);
        }
    }

    /* access modifiers changed from: protected */
    public String doTextRequest(String str, AIServiceContext aIServiceContext) throws MalformedURLException, AIServiceException {
        return doTextRequest(this.config.getQuestionUrl(getSessionId(aIServiceContext)), str);
    }

    /* access modifiers changed from: protected */
    public String doTextRequest(String str) throws MalformedURLException, AIServiceException {
        return doTextRequest(str, UNDEFINED_SERVICE_CONTEXT);
    }

    /* access modifiers changed from: protected */
    public String doTextRequest(String str, String str2) throws MalformedURLException, AIServiceException {
        return doTextRequest(str, str2, (Map<String, String>) null);
    }

    /* access modifiers changed from: protected */
    public String doTextRequest(String str, String str2, Map<String, String> map) throws MalformedURLException, AIServiceException {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            URL url = new URL(str);
            Logger logger = Log;
            logger.debug("Request json: " + str2);
            if (this.config.getProxy() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(this.config.getProxy());
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            HttpURLConnection httpURLConnection3 = httpURLConnection;
            httpURLConnection3.setRequestMethod("POST");
            httpURLConnection3.setDoOutput(true);
            httpURLConnection3.addRequestProperty("Authorization", "Bearer " + this.config.getApiKey());
            httpURLConnection3.addRequestProperty("Content-Type", "application/json; charset=utf-8");
            httpURLConnection3.addRequestProperty("Accept", "application/json");
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    httpURLConnection3.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
            }
            httpURLConnection3.connect();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection3.getOutputStream());
            IOUtils.writeAll(str2, bufferedOutputStream);
            bufferedOutputStream.close();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
            String readAll = IOUtils.readAll((InputStream) bufferedInputStream);
            bufferedInputStream.close();
            if (httpURLConnection3 != null) {
                httpURLConnection3.disconnect();
            }
            return readAll;
        } catch (IOException e) {
            if (httpURLConnection2 != null) {
                InputStream errorStream = httpURLConnection2.getErrorStream();
                if (errorStream != null) {
                    String readAll2 = IOUtils.readAll(errorStream);
                    Log.debug(readAll2);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return readAll2;
                }
                throw new AIServiceException("Can't connect to the api.ai service.", e);
            }
        } catch (IOException e2) {
            Log.warn("Can't read error response", (Throwable) e2);
        } catch (Throwable th) {
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        Log.error("Can't make request to the API.AI service. Please, check connection settings and API access token.", (Throwable) e);
        throw new AIServiceException("Can't make request to the API.AI service. Please, check connection settings and API access token.", e);
    }

    /* access modifiers changed from: protected */
    public String doSoundRequest(InputStream inputStream, String str) throws MalformedURLException, AIServiceException {
        return doSoundRequest(inputStream, str, (Map<String, String>) null, UNDEFINED_SERVICE_CONTEXT);
    }

    /* access modifiers changed from: protected */
    public String doSoundRequest(InputStream inputStream, String str, Map<String, String> map) throws MalformedURLException, AIServiceException {
        return doSoundRequest(inputStream, str, map, UNDEFINED_SERVICE_CONTEXT);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c4 A[SYNTHETIC, Splitter:B:28:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doSoundRequest(java.io.InputStream r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, p000ai.api.AIServiceContext r10) throws java.net.MalformedURLException, p000ai.api.AIServiceException {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            ai.api.AIConfiguration r2 = r6.config     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.lang.String r10 = r6.getSessionId(r10)     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.lang.String r10 = r2.getQuestionUrl(r10)     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            r1.<init>(r10)     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            org.apache.logging.log4j.Logger r10 = Log     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.lang.String r2 = "Connecting to {}"
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            r5 = 0
            r4[r5] = r1     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            r10.debug((java.lang.String) r2, (java.lang.Object[]) r4)     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            ai.api.AIConfiguration r10 = r6.config     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.net.Proxy r10 = r10.getProxy()     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            if (r10 == 0) goto L_0x0032
            ai.api.AIConfiguration r10 = r6.config     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.net.Proxy r10 = r10.getProxy()     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.net.URLConnection r10 = r1.openConnection(r10)     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            goto L_0x0038
        L_0x0032:
            java.net.URLConnection r10 = r1.openConnection()     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
            java.net.HttpURLConnection r10 = (java.net.HttpURLConnection) r10     // Catch:{ IOException -> 0x00c0, all -> 0x00bd }
        L_0x0038:
            java.lang.String r1 = "Authorization"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb }
            r2.<init>()     // Catch:{ IOException -> 0x00bb }
            java.lang.String r4 = "Bearer "
            r2.append(r4)     // Catch:{ IOException -> 0x00bb }
            ai.api.AIConfiguration r4 = r6.config     // Catch:{ IOException -> 0x00bb }
            java.lang.String r4 = r4.getApiKey()     // Catch:{ IOException -> 0x00bb }
            r2.append(r4)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00bb }
            r10.addRequestProperty(r1, r2)     // Catch:{ IOException -> 0x00bb }
            java.lang.String r1 = "Accept"
            java.lang.String r2 = "application/json"
            r10.addRequestProperty(r1, r2)     // Catch:{ IOException -> 0x00bb }
            if (r9 == 0) goto L_0x0081
            java.util.Set r9 = r9.entrySet()     // Catch:{ IOException -> 0x00bb }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ IOException -> 0x00bb }
        L_0x0065:
            boolean r1 = r9.hasNext()     // Catch:{ IOException -> 0x00bb }
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r9.next()     // Catch:{ IOException -> 0x00bb }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x00bb }
            java.lang.Object r2 = r1.getKey()     // Catch:{ IOException -> 0x00bb }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x00bb }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x00bb }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x00bb }
            r10.addRequestProperty(r2, r1)     // Catch:{ IOException -> 0x00bb }
            goto L_0x0065
        L_0x0081:
            java.lang.String r9 = "POST"
            r10.setRequestMethod(r9)     // Catch:{ IOException -> 0x00bb }
            r10.setDoInput(r3)     // Catch:{ IOException -> 0x00bb }
            r10.setDoOutput(r3)     // Catch:{ IOException -> 0x00bb }
            ai.api.http.HttpClient r9 = new ai.api.http.HttpClient     // Catch:{ IOException -> 0x00bb }
            r9.<init>(r10)     // Catch:{ IOException -> 0x00bb }
            ai.api.AIConfiguration r0 = r6.config     // Catch:{ IOException -> 0x00b8 }
            boolean r0 = r0.isWriteSoundLog()     // Catch:{ IOException -> 0x00b8 }
            r9.setWriteSoundLog(r0)     // Catch:{ IOException -> 0x00b8 }
            r9.connectForMultipart()     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r0 = "request"
            r9.addFormPart(r0, r8)     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r8 = "voiceData"
            java.lang.String r0 = "voice.wav"
            r9.addFilePart(r8, r0, r7)     // Catch:{ IOException -> 0x00b8 }
            r9.finishMultipart()     // Catch:{ IOException -> 0x00b8 }
            java.lang.String r7 = r9.getResponse()     // Catch:{ IOException -> 0x00b8 }
            if (r10 == 0) goto L_0x00b7
            r10.disconnect()
        L_0x00b7:
            return r7
        L_0x00b8:
            r7 = move-exception
            r0 = r9
            goto L_0x00c2
        L_0x00bb:
            r7 = move-exception
            goto L_0x00c2
        L_0x00bd:
            r7 = move-exception
            r10 = r0
            goto L_0x0110
        L_0x00c0:
            r7 = move-exception
            r10 = r0
        L_0x00c2:
            if (r0 == 0) goto L_0x0101
            java.lang.String r8 = r0.getErrorString()     // Catch:{ all -> 0x00ff }
            org.apache.logging.log4j.Logger r9 = Log     // Catch:{ all -> 0x00ff }
            r9.debug((java.lang.String) r8)     // Catch:{ all -> 0x00ff }
            boolean r9 = p000ai.api.util.StringUtils.isEmpty(r8)     // Catch:{ all -> 0x00ff }
            if (r9 != 0) goto L_0x00d9
            if (r10 == 0) goto L_0x00d8
            r10.disconnect()
        L_0x00d8:
            return r8
        L_0x00d9:
            boolean r8 = r7 instanceof java.net.HttpRetryException     // Catch:{ all -> 0x00ff }
            if (r8 == 0) goto L_0x0101
            ai.api.model.AIResponse r8 = new ai.api.model.AIResponse     // Catch:{ all -> 0x00ff }
            r8.<init>()     // Catch:{ all -> 0x00ff }
            r9 = r7
            java.net.HttpRetryException r9 = (java.net.HttpRetryException) r9     // Catch:{ all -> 0x00ff }
            int r9 = r9.responseCode()     // Catch:{ all -> 0x00ff }
            ai.api.model.Status r9 = p000ai.api.model.Status.fromResponseCode(r9)     // Catch:{ all -> 0x00ff }
            java.net.HttpRetryException r7 = (java.net.HttpRetryException) r7     // Catch:{ all -> 0x00ff }
            java.lang.String r7 = r7.getReason()     // Catch:{ all -> 0x00ff }
            r9.setErrorDetails(r7)     // Catch:{ all -> 0x00ff }
            r8.setStatus(r9)     // Catch:{ all -> 0x00ff }
            ai.api.AIServiceException r7 = new ai.api.AIServiceException     // Catch:{ all -> 0x00ff }
            r7.<init>((p000ai.api.model.AIResponse) r8)     // Catch:{ all -> 0x00ff }
            throw r7     // Catch:{ all -> 0x00ff }
        L_0x00ff:
            r7 = move-exception
            goto L_0x0110
        L_0x0101:
            org.apache.logging.log4j.Logger r8 = Log     // Catch:{ all -> 0x00ff }
            java.lang.String r9 = "Can't make request to the API.AI service. Please, check connection settings and API.AI keys."
            r8.error((java.lang.String) r9, (java.lang.Throwable) r7)     // Catch:{ all -> 0x00ff }
            ai.api.AIServiceException r8 = new ai.api.AIServiceException     // Catch:{ all -> 0x00ff }
            java.lang.String r9 = "Can't make request to the API.AI service. Please, check connection settings and API.AI keys."
            r8.<init>(r9, r7)     // Catch:{ all -> 0x00ff }
            throw r8     // Catch:{ all -> 0x00ff }
        L_0x0110:
            if (r10 == 0) goto L_0x0115
            r10.disconnect()
        L_0x0115:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000ai.api.AIDataService.doSoundRequest(java.io.InputStream, java.lang.String, java.util.Map, ai.api.AIServiceContext):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public <TResponse> TResponse doRequest(Type type, String str, String str2) throws AIServiceException, BadResponseStatusException {
        return doRequest(type, str, str2, (Map<String, String>) null);
    }

    /* access modifiers changed from: protected */
    public <TRequest, TResponse> TResponse doRequest(TRequest trequest, Type type, String str, String str2) throws AIServiceException, BadResponseStatusException {
        return doRequest(trequest, type, str, str2, (Map<String, String>) null);
    }

    /* access modifiers changed from: protected */
    public <TResponse> TResponse doRequest(Type type, String str, String str2, Map<String, String> map) throws AIServiceException, BadResponseStatusException {
        return doRequest((Object) null, type, str, str2, map);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|(1:4)(1:5)|(1:7)(1:8)|9|(1:11)(1:12)|13|(2:15|(1:17)(2:18|19))|20|(1:22)|23|(3:25|(2:28|26)|64)|29|(1:31)|32|33|34|(2:36|(1:38)(2:39|40))|41|42|(1:44)|45|(1:(2:59|60))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0104 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TRequest, TResponse> TResponse doRequest(TRequest r5, java.lang.reflect.Type r6, java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) throws p000ai.api.AIServiceException, p000ai.api.AIDataService.BadResponseStatusException {
        /*
            r4 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x0112 }
            r1.<init>(r7)     // Catch:{ IOException -> 0x0112 }
            if (r5 == 0) goto L_0x000f
            com.google.gson.Gson r7 = GSON     // Catch:{ IOException -> 0x0112 }
            java.lang.String r5 = r7.toJson((java.lang.Object) r5)     // Catch:{ IOException -> 0x0112 }
            goto L_0x0010
        L_0x000f:
            r5 = r0
        L_0x0010:
            if (r8 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            java.lang.String r8 = "POST"
        L_0x0015:
            org.apache.logging.log4j.Logger r7 = Log     // Catch:{ IOException -> 0x0112 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0112 }
            r2.<init>()     // Catch:{ IOException -> 0x0112 }
            java.lang.String r3 = "Request json: "
            r2.append(r3)     // Catch:{ IOException -> 0x0112 }
            r2.append(r5)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0112 }
            r7.debug((java.lang.String) r2)     // Catch:{ IOException -> 0x0112 }
            ai.api.AIConfiguration r7 = r4.config     // Catch:{ IOException -> 0x0112 }
            java.net.Proxy r7 = r7.getProxy()     // Catch:{ IOException -> 0x0112 }
            if (r7 == 0) goto L_0x0040
            ai.api.AIConfiguration r7 = r4.config     // Catch:{ IOException -> 0x0112 }
            java.net.Proxy r7 = r7.getProxy()     // Catch:{ IOException -> 0x0112 }
            java.net.URLConnection r7 = r1.openConnection(r7)     // Catch:{ IOException -> 0x0112 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0112 }
            goto L_0x0046
        L_0x0040:
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ IOException -> 0x0112 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0112 }
        L_0x0046:
            r0 = r7
            if (r5 == 0) goto L_0x005a
            java.lang.String r7 = "POST"
            boolean r7 = r7.equals(r8)     // Catch:{ IOException -> 0x0112 }
            if (r7 == 0) goto L_0x0052
            goto L_0x005a
        L_0x0052:
            ai.api.AIServiceException r5 = new ai.api.AIServiceException     // Catch:{ IOException -> 0x0112 }
            java.lang.String r6 = "Non-empty request should be sent using POST method"
            r5.<init>((java.lang.String) r6)     // Catch:{ IOException -> 0x0112 }
            throw r5     // Catch:{ IOException -> 0x0112 }
        L_0x005a:
            r0.setRequestMethod(r8)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r7 = "POST"
            boolean r7 = r7.equals(r8)     // Catch:{ IOException -> 0x0112 }
            if (r7 == 0) goto L_0x0069
            r7 = 1
            r0.setDoOutput(r7)     // Catch:{ IOException -> 0x0112 }
        L_0x0069:
            java.lang.String r7 = "Authorization"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0112 }
            r8.<init>()     // Catch:{ IOException -> 0x0112 }
            java.lang.String r1 = "Bearer "
            r8.append(r1)     // Catch:{ IOException -> 0x0112 }
            ai.api.AIConfiguration r1 = r4.config     // Catch:{ IOException -> 0x0112 }
            java.lang.String r1 = r1.getApiKey()     // Catch:{ IOException -> 0x0112 }
            r8.append(r1)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0112 }
            r0.addRequestProperty(r7, r8)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r7 = "Content-Type"
            java.lang.String r8 = "application/json; charset=utf-8"
            r0.addRequestProperty(r7, r8)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r7 = "Accept"
            java.lang.String r8 = "application/json"
            r0.addRequestProperty(r7, r8)     // Catch:{ IOException -> 0x0112 }
            if (r9 == 0) goto L_0x00b9
            java.util.Set r7 = r9.entrySet()     // Catch:{ IOException -> 0x0112 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ IOException -> 0x0112 }
        L_0x009d:
            boolean r8 = r7.hasNext()     // Catch:{ IOException -> 0x0112 }
            if (r8 == 0) goto L_0x00b9
            java.lang.Object r8 = r7.next()     // Catch:{ IOException -> 0x0112 }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ IOException -> 0x0112 }
            java.lang.Object r9 = r8.getKey()     // Catch:{ IOException -> 0x0112 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ IOException -> 0x0112 }
            java.lang.Object r8 = r8.getValue()     // Catch:{ IOException -> 0x0112 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0112 }
            r0.addRequestProperty(r9, r8)     // Catch:{ IOException -> 0x0112 }
            goto L_0x009d
        L_0x00b9:
            r0.connect()     // Catch:{ IOException -> 0x0112 }
            if (r5 == 0) goto L_0x00cd
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0112 }
            java.io.OutputStream r8 = r0.getOutputStream()     // Catch:{ IOException -> 0x0112 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0112 }
            p000ai.api.util.IOUtils.writeAll(r5, r7)     // Catch:{ IOException -> 0x0112 }
            r7.close()     // Catch:{ IOException -> 0x0112 }
        L_0x00cd:
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0112 }
            java.io.InputStream r7 = r0.getInputStream()     // Catch:{ IOException -> 0x0112 }
            r5.<init>(r7)     // Catch:{ IOException -> 0x0112 }
            java.lang.String r7 = p000ai.api.util.IOUtils.readAll((java.io.InputStream) r5)     // Catch:{ IOException -> 0x0112 }
            r5.close()     // Catch:{ IOException -> 0x0112 }
            com.google.gson.Gson r5 = GSON     // Catch:{ JsonParseException -> 0x0104 }
            java.lang.Class<ai.api.model.AIResponse> r8 = p000ai.api.model.AIResponse.class
            java.lang.Object r5 = r5.fromJson((java.lang.String) r7, r8)     // Catch:{ JsonParseException -> 0x0104 }
            ai.api.model.AIResponse r5 = (p000ai.api.model.AIResponse) r5     // Catch:{ JsonParseException -> 0x0104 }
            ai.api.model.Status r8 = r5.getStatus()     // Catch:{ JsonParseException -> 0x0104 }
            if (r8 == 0) goto L_0x0104
            ai.api.model.Status r8 = r5.getStatus()     // Catch:{ JsonParseException -> 0x0104 }
            java.lang.Integer r8 = r8.getCode()     // Catch:{ JsonParseException -> 0x0104 }
            int r8 = r8.intValue()     // Catch:{ JsonParseException -> 0x0104 }
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 != r9) goto L_0x00fe
            goto L_0x0104
        L_0x00fe:
            ai.api.AIDataService$BadResponseStatusException r8 = new ai.api.AIDataService$BadResponseStatusException     // Catch:{ JsonParseException -> 0x0104 }
            r8.<init>(r5)     // Catch:{ JsonParseException -> 0x0104 }
            throw r8     // Catch:{ JsonParseException -> 0x0104 }
        L_0x0104:
            com.google.gson.Gson r5 = GSON     // Catch:{ IOException -> 0x0112 }
            java.lang.Object r5 = r5.fromJson((java.lang.String) r7, (java.lang.reflect.Type) r6)     // Catch:{ IOException -> 0x0112 }
            if (r0 == 0) goto L_0x010f
            r0.disconnect()
        L_0x010f:
            return r5
        L_0x0110:
            r5 = move-exception
            goto L_0x0149
        L_0x0112:
            r5 = move-exception
            if (r0 == 0) goto L_0x013a
            java.io.InputStream r6 = r0.getErrorStream()     // Catch:{ IOException -> 0x0132 }
            if (r6 == 0) goto L_0x012a
            java.lang.String r6 = p000ai.api.util.IOUtils.readAll((java.io.InputStream) r6)     // Catch:{ IOException -> 0x0132 }
            org.apache.logging.log4j.Logger r7 = Log     // Catch:{ IOException -> 0x0132 }
            r7.debug((java.lang.String) r6)     // Catch:{ IOException -> 0x0132 }
            ai.api.AIServiceException r7 = new ai.api.AIServiceException     // Catch:{ IOException -> 0x0132 }
            r7.<init>(r6, r5)     // Catch:{ IOException -> 0x0132 }
            throw r7     // Catch:{ IOException -> 0x0132 }
        L_0x012a:
            ai.api.AIServiceException r6 = new ai.api.AIServiceException     // Catch:{ IOException -> 0x0132 }
            java.lang.String r7 = "Can't connect to the api.ai service."
            r6.<init>(r7, r5)     // Catch:{ IOException -> 0x0132 }
            throw r6     // Catch:{ IOException -> 0x0132 }
        L_0x0132:
            r6 = move-exception
            org.apache.logging.log4j.Logger r7 = Log     // Catch:{ all -> 0x0110 }
            java.lang.String r8 = "Can't read error response"
            r7.warn((java.lang.String) r8, (java.lang.Throwable) r6)     // Catch:{ all -> 0x0110 }
        L_0x013a:
            org.apache.logging.log4j.Logger r6 = Log     // Catch:{ all -> 0x0110 }
            java.lang.String r7 = "Can't make request to the API.AI service. Please, check connection settings and API access token."
            r6.error((java.lang.String) r7, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0110 }
            ai.api.AIServiceException r6 = new ai.api.AIServiceException     // Catch:{ all -> 0x0110 }
            java.lang.String r7 = "Can't make request to the API.AI service. Please, check connection settings and API access token."
            r6.<init>(r7, r5)     // Catch:{ all -> 0x0110 }
            throw r6     // Catch:{ all -> 0x0110 }
        L_0x0149:
            if (r0 == 0) goto L_0x014e
            r0.disconnect()
        L_0x014e:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000ai.api.AIDataService.doRequest(java.lang.Object, java.lang.reflect.Type, java.lang.String, java.lang.String, java.util.Map):java.lang.Object");
    }

    private void fillRequest(AIRequest aIRequest, RequestExtras requestExtras) {
        if (requestExtras.hasContexts()) {
            aIRequest.setContexts(requestExtras.getContexts());
        }
        if (requestExtras.hasEntities()) {
            aIRequest.setEntities(requestExtras.getEntities());
        }
        if (requestExtras.getLocation() != null) {
            aIRequest.setLocation(requestExtras.getLocation());
        }
    }

    private String getSessionId(AIServiceContext aIServiceContext) {
        if (aIServiceContext != null) {
            return aIServiceContext.getSessionId();
        }
        return this.defaultServiceContext.getSessionId();
    }

    private String getTimeZone(AIServiceContext aIServiceContext) {
        TimeZone timeZone;
        if (aIServiceContext != null) {
            timeZone = aIServiceContext.getTimeZone();
        } else {
            timeZone = this.defaultServiceContext.getTimeZone();
        }
        if (timeZone == null) {
            timeZone = Calendar.getInstance().getTimeZone();
        }
        return timeZone.getID();
    }

    /* renamed from: ai.api.AIDataService$ApiActiveContextNamesResponse */
    private static class ApiActiveContextNamesResponse extends AIResponse {
        private static final long serialVersionUID = 1;
        public List<String> names;

        private ApiActiveContextNamesResponse() {
        }
    }

    /* renamed from: ai.api.AIDataService$BadResponseStatusException */
    private static class BadResponseStatusException extends Exception {
        private static final long serialVersionUID = 1;
        /* access modifiers changed from: private */
        public final AIResponse response;

        public BadResponseStatusException(AIResponse aIResponse) {
            this.response = aIResponse;
        }
    }
}
