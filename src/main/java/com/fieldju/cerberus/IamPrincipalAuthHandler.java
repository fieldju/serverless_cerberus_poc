package com.fieldju.cerberus;

import com.fieldju.cerberus.model.ApiGatewayProxyResponse;
import com.google.gson.Gson;
import com.nike.vault.client.model.VaultAuthResponse;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class IamPrincipalAuthHandler {

    Gson gson = new Gson();
    private final Logger log = Logger.getLogger(getClass());

    public ApiGatewayProxyResponse handle() {
        ApiGatewayProxyResponse response;
        try {
            VaultAuthResponse vaultAuthResponse = new VaultAuthResponse()
                    .setClientToken(UUID.randomUUID().toString()) // not secure, just for POC
                    .setPolicies(new HashSet<>())
                    .setMetadata(new HashMap<>())
                    .setLeaseDuration(3600)
                    .setRenewable(false);

            String encryptedSerializedVaultAuthResponse = encryptVaultAuthResponse(vaultAuthResponse);
            Map<String, String> encryptedAuthResponse = new HashMap<>();
            encryptedAuthResponse.put("auth_data", encryptedSerializedVaultAuthResponse);

            response = new ApiGatewayProxyResponse()
                    .withStatusCode(200)
                    .withHeader("Content-Type", "application/json")
                    .withBody(gson.toJson(encryptedAuthResponse));
        } catch (Throwable t) {
            response =  new ApiGatewayProxyResponse()
                .withStatusCode(500)
                .withHeader("Content-Type", "application/json")
                .withBody("\"msg\":\"" + t.getMessage() + "\"");
        }

        return response;
    }

    private String encryptVaultAuthResponse(VaultAuthResponse response) {
        String plainTextAuthPayload = gson.toJson(response);

        return "";
    }

}
