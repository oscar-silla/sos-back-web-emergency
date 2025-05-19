package com.emergency.sos.models;

import jakarta.persistence.*;

@Entity(name = "ContactMO")
@Table(name = "contacts")
public class ContactMO {
  @Id
  @SequenceGenerator(
      name = "contacts_sequence_generator",
      sequenceName = "contacts_seq",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_sequence_generator")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
