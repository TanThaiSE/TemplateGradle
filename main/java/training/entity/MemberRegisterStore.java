package training.entity;

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
import training.entity.composite.MemberRegisterStoreKey;

@Entity
@Table(name = "P_MEMBER_REGISTER_STORE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MemberRegisterStore {
  @EmbeddedId
  private MemberRegisterStoreKey memberRegisterStoreKey;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "MEMBER_ID")
  @MapsId("memberId")
  private Member member;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "STORE_ID")
  @MapsId("storeId")
  private Store store;

}
