package com.helmes.hackday.rots.config;

import com.pi4j.io.gpio.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Configuration
@Slf4j
@ComponentScan("com.helmes.hackday.rots")
public class RotsConfig {

  @Value("${raspberry.pir.pin.address}")
  private String pirPinNum;

  @Bean
  public GpioPinDigitalInput gpioPinDigitalInput() {
    GpioController gpioController = GpioFactory.getInstance();
    Pin pikPin = RaspiPin.getPinByAddress(Integer.parseInt(pirPinNum));
    return gpioController.provisionDigitalInputPin(pikPin);
  }

  @Bean
  @Primary
  public RestTemplate restTemplate() throws Exception {
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    SSLContext sslContext = SSLContexts.custom()
            .loadTrustMaterial(null, (X509Certificate[] chain, String authType) -> true)
            .build();
    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(new SSLConnectionSocketFactory(sslContext))
            .build();
    requestFactory.setHttpClient(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    return restTemplate;
  }
}
