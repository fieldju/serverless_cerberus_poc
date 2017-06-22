package com.fieldju.cerberus.model;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayProxyResponse {

    private int statusCode;
    private Map<String, String> headers = new HashMap<>();
    private String body;

    public int getStatusCode() {
        return statusCode;
    }

    public ApiGatewayProxyResponse withStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public ApiGatewayProxyResponse withHeader(String key, String value) {
        headers.put(key, value);
        return this;
    }

    public String getBody() {
        return body;
    }

    public ApiGatewayProxyResponse withBody(String body) {
        this.body = body;
        return this;
    }
}
