package org.application.notecalendardesktop.webinteraction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.application.notecalendardesktop.webinteraction.model.request.SignInRequest;
import org.application.notecalendardesktop.webinteraction.model.request.SignUpRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String H_NAME = "Content-Type";
    private static final String H_VALUE = "application/json";
    private static final HttpClient client = HttpClient.newBuilder().build();
    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static HttpResponse<String> trySignUp(String login, String password) {
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setLogin(login);
        signUpRequest.setPassword(password);
        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(signUpRequest);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL))
                    .header(H_NAME, H_VALUE)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpResponse<String> trySignIn(String login, String password) {
        SignInRequest signInRequest = new SignInRequest();
        signInRequest.setLogin(login);
        signInRequest.setPassword(password);
        try {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(signInRequest);
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL)).header(H_NAME, H_VALUE).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
