package com.emergency.sos.mappers;

import com.emergency.sos.domain.Contact;
import openapi.emergency_sos.model.ContactRequestBodyType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactControllerMapper {
  Contact toContact(ContactRequestBodyType contactRequestBodyType);
}
