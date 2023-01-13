package training.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "P_NOTIFICATION")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notification {
  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "STORE_ID")
  private String storeId;

  @Column(name = "TITLE")
  private String title;

  @Column(name = "CONTENT")
  private String content;

  @Column(name = "PUBLIC_STATUS")
  private boolean publicStatus;

  @Column(name = "START_DATE")
  private Date startDate;

  @Column(name = "END_DATE")
  private Date endDate;

  @Column(name = "DELETE_FLAG")
  private boolean deleteFlag;

  @OneToMany(mappedBy = "notification", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<NotificationHistory> notificationHistories;

}
