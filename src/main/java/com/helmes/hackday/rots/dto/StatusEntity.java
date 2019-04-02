package com.helmes.hackday.rots.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusEntity {
  private String isRoomOccupied;
  private String eventTime;
}
