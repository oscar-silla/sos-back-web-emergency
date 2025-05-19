package com.emergency.sos.domain;

public class Contact {
  private Long id;
  private String name;
  private String phoneNumber;

  public Contact() {}

  public Contact(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public boolean hasName() {
    return this.name != null && !this.name.trim().isBlank();
  }

  public boolean hasPhoneNumber() {
    return this.phoneNumber != null && !this.phoneNumber.isBlank();
  }
}
