package com.jdl.wps.util;


import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

import java.io.IOException;

public class RestUtils {
    public static String get(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ClassicHttpRequest httpRequest = ClassicRequestBuilder.get(url).build();
            httpRequest.addHeader("Content-Type", ContentType.APPLICATION_JSON);
            return httpClient.execute(httpRequest, response -> EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            return null;
        }
    }


}
