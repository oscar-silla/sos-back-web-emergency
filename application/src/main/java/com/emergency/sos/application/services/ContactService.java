package com.emergency.sos.application.services;

import com.emergency.sos.application.exceptions.ConflictException;
import com.emergency.sos.application.ports.driven.ContactRepositoryPort;
import com.emergency.sos.domain.Contact;
import com.emergency.sos.domain.ContactFilter;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
  private final ContactRepositoryPort contactRepository;

  public ContactService(final ContactRepositoryPort contactRepository) {
    this.contactRepository = contactRepository;
  }

  public void save(Contact contact) {
    this.contactRepository
        .findOne(new ContactFilter(null, contact.getPhoneNumber()))
        .ifPresent(
            c -> {
              throw new ConflictException();
            });
    this.contactRepository.save(contact);
  }
}
