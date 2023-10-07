package br.fai.lds.frontendspringlds.port.impl;

import br.fai.lds.domain.UserModel;
import br.fai.lds.frontend.usecases.port.RestService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestApiController<T> implements RestService<T> {

    private static final String BASE_ENDPOINT = "http://localhost:8081/api";

    private String getEndpoint(final String resource) {
        return BASE_ENDPOINT + resource;
    }

    @Override
    public List<T> get(String resource) {
        final String endpoint = getEndpoint(resource);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpEntity<String> httpEntity = new HttpEntity<>("");

        ResponseEntity<List<T>> responseEntity = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity,
                new ParameterizedTypeReference<List<T>>() {
                });

        List<T> body = responseEntity.getBody();

        return body;
    }

    @Override
    public int post(String resource, T entity) {
        return 0;
    }

    @Override
    public boolean put(String resource, T entity) {
        return false;
    }

    @Override
    public boolean delete(String resource) {
        return false;
    }

    @Override
    public T getById(String resource, Class<T> clazz) {
        return null;
    }
}
