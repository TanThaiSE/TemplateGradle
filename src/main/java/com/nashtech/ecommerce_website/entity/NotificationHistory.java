package com.nashtech.ecommerce_website.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.nashtech.ecommerce_website.entity.composite.NotificationHistoryKey;

@Entity
@Table(name = "P_NOTIFICATION_HISTORY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationHistory {
  @EmbeddedId
  private NotificationHistoryKey notificationHistoryKey;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("memberId")
  @JoinColumn(name = "MEMBER_ID")
  private Member memberHistory;

  @ManyToOne(fetch = FetchType.EAGER)
  @MapsId("notificationId")
  @JoinColumn(name = "NOTIFICATION_ID")
  private Notification notification;
}
