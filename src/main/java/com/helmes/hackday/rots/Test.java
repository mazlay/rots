/*
package com.helmes.hackday.rots;

import com.helmes.hackday.rots.dto.StatusEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    String URI = "https://roomtracking.cfapps.io/rots/occupy";
    RestTemplate restTemplate = new RestTemplate();
    //restTemplate.setMessageConverters(getMessageConverters());
    StatusEntity statusEntity = new StatusEntity(Boolean.TRUE.toString(), LocalDateTime.now().toString());
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<StatusEntity> request = new HttpEntity<>(statusEntity, headers);
    ResponseEntity<String> response = restTemplate.postForEntity(URI, request, String.class);
    System.out.println(response.getBody());
    //ResponseEntity<String> response = restTemplate.exchange(URI, HttpMethod.GET, request, String.class);
  }

  private static List<HttpMessageConverter<?>> getMessageConverters() {
    List<HttpMessageConverter<?>> converters =
            new ArrayList<>();
    converters.add(new MappingJackson2HttpMessageConverter());
    return converters;
  }
}
*/
