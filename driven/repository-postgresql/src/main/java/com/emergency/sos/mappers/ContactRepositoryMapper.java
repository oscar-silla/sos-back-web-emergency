package com.emergency.sos.mappers;

import com.emergency.sos.domain.Contact;
import com.emergency.sos.models.ContactMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactRepositoryMapper {
  ContactMO toContactMO(Contact contact);

  Contact toContact(ContactMO contact);
}
