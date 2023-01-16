package com.nashtech.ecommerce_website.entity.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Embeddable
public class NotificationHistoryKey implements Serializable {
  @Column(name = "MEMBER_ID")
  private String memberId;
  @Column(name = "NOTIFICATION_ID")
  private String notificationId;
}