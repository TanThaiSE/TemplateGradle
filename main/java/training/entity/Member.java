package training.entity;

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
@Table(name = "P_MEMBER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Member {
  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "AGE")
  private int age;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "ADDRESS")
  private String address;

  @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<MemberRegisterStore> memberRegisterStores;

  @OneToMany(mappedBy = "memberHistory")
  private Set<NotificationHistory> notificationHistories;
}
