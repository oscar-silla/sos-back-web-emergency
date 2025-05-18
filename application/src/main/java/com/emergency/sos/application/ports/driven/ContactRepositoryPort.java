package com.emergency.sos.application.ports.driven;

import com.emergency.sos.domain.Contact;
import com.emergency.sos.domain.ContactFilter;

import java.util.Optional;

public interface ContactRepositoryPort {
  void save(Contact contact);
  Optional<Contact> findOne(ContactFilter filter);
}
