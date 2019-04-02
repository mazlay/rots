package com.helmes.hackday.rots.service;

import com.helmes.hackday.rots.dto.StatusEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RemoteServiceImpl implements RemoteService {

  @Autowired
  private RestTemplate restTemplate = new RestTemplate();

  @Value("${pcf.url}")
  private String pcfUrl;

  @Override
  public void sendPirStatus(Boolean isRoomOccupied) {
    StatusEntity statusEntity = new StatusEntity(isRoomOccupied.toString(), LocalDateTime.now().toString());
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<StatusEntity> request = new HttpEntity<>(statusEntity, headers);
    try {
      ResponseEntity<String> response = restTemplate.postForEntity(pcfUrl, request, String.class);
      System.out.println("Status was sent");
    }catch (Exception ex) {
    }
  }
}
