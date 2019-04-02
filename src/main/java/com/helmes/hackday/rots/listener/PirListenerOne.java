package com.helmes.hackday.rots.listener;

import com.helmes.hackday.rots.service.RemoteService;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PirListenerOne {

  @Autowired
  private final RemoteService remoteService;

  @Autowired
  private GpioPinDigitalInput gpioPinDigitalInput;

  @Scheduled(fixedDelay = 20000)
  public void checkPirStatus() {
    if (gpioPinDigitalInput.getState().isHigh() || PirListenerTwo.pirStatus) {
      remoteService.sendPirStatus(true);
      PirListenerTwo.pirStatus = false;
    }
  }
}
