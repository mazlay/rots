package com.helmes.hackday.rots.listener;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PirListenerTwo {

  @Autowired
  private GpioPinDigitalInput gpioPinDigitalInput;

  public static Boolean pirStatus = false;

  @PostConstruct
  private void start() {
    startListener();
  }

  public void startListener() {
    gpioPinDigitalInput.addTrigger(new GpioCallbackTrigger(PinState.HIGH, () -> {
      pirStatus = true;
      return null;
    }));
    gpioPinDigitalInput.addTrigger(new GpioCallbackTrigger(PinState.LOW, () -> {
      pirStatus = true;
      return null;
    }));

    Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Checkers stopped...")));
  }
}
