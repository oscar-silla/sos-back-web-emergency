package com.emergency.sos.adapters;

import com.emergency.sos.application.ports.driven.ContactRepositoryPort;
import com.emergency.sos.domain.Contact;
import com.emergency.sos.domain.ContactFilter;
import com.emergency.sos.mappers.ContactRepositoryMapper;
import com.emergency.sos.models.ContactMO;
import com.emergency.sos.repositories.ContactJpaRepository;
import com.emergency.sos.specifications.ContactSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactRepositoryAdapter implements ContactRepositoryPort {
  private final ContactRepositoryMapper mapper;
  private final ContactJpaRepository jpaRepository;
  private final ContactSpecification contactSpecification;

  public ContactRepositoryAdapter(
      final ContactRepositoryMapper mapper,
      final ContactJpaRepository jpaRepository,
      final ContactSpecification contactSpecification) {
    this.mapper = mapper;
    this.jpaRepository = jpaRepository;
    this.contactSpecification = contactSpecification;
  }

  @Override
  public void save(Contact contact) {
    this.jpaRepository.save(this.mapper.toContactMO(contact));
  }

  @Override
  public Optional<Contact> findOne(ContactFilter filter) {
    Specification<ContactMO> spec = this.contactSpecification.getSpecification(filter);
    return this.jpaRepository.findOne(spec).map(this.mapper::toContact);
  }
}
