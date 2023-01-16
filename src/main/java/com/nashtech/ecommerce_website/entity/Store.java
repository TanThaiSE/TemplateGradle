package com.nashtech.ecommerce_website.entity;

import java.util.Set;

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
@Table(name = "P_STORE")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Store {
  @Id
  @Column(name = "ID")
  private String id;
  @Column(name = "NAME")
  private String name;

  @OneToMany(mappedBy = "store", fetch = FetchType.LAZY)
  private Set<MemberRegisterStore> memberRegisterStores;
}
