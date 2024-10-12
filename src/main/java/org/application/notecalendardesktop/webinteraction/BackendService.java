package org.application.notecalendardesktop.webinteraction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.application.notecalendardesktop.webinteraction.model.response.SignInResponse;
import org.application.notecalendardesktop.webinteraction.model.response.SignUpResponse;

import java.net.http.HttpResponse;

public class BackendService {

    public static SignUpResponse getSignUpResponse(String login, String password) {
        HttpResponse<String> response = RestClient.trySignUp(login, password);
        try {
            return RestClient.getMapper().readValue(response.body(), SignUpResponse.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static SignInResponse getSignInResponse(String login, String password) {
        HttpResponse<String> response = RestClient.trySignIn(login, password);
        try {
            return RestClient.getMapper().readValue(response.body(), SignInResponse.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
