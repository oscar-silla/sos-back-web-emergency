package com.emergency.sos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "ContactMO")
@Table(name = "contacts")
public class ContactMO {
  @Column(name = "name", nullable = false)
  private String name;

  @Id
  @Column(name = "phoneNumber", nullable = false)
  private String phoneNumber;

  public ContactMO() {}

  public ContactMO(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
