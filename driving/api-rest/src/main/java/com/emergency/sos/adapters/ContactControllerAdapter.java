package com.emergency.sos.adapters;

import com.emergency.sos.application.ports.driving.SaveContactUseCasePort;
import com.emergency.sos.mappers.ContactControllerMapper;
import openapi.emergency_sos.api.ContactsApi;
import openapi.emergency_sos.model.ContactRequestBodyType;
import openapi.emergency_sos.model.ContactResponseType;
import openapi.emergency_sos.model.ContactsResponseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/emergency/v1")
public class ContactControllerAdapter implements ContactsApi {
  private final Logger log = LoggerFactory.getLogger(ContactControllerAdapter.class);
  private final ContactControllerMapper mapper;
  private final SaveContactUseCasePort saveContactUseCase;

  public ContactControllerAdapter(
      final ContactControllerMapper mapper, final SaveContactUseCasePort saveContactUseCase) {
    this.mapper = mapper;
    this.saveContactUseCase = saveContactUseCase;
  }

  @Override
  public ResponseEntity<ContactResponseType> getContact(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<ContactsResponseType> getContacts(Integer pageSize, Integer pageNumber) {
    return null;
  }

  @Override
  public ResponseEntity<Void> postContact(ContactRequestBodyType contactRequestBodyType) {
    this.log.info("/emergency/v1/contacts with body: {}", contactRequestBodyType.toString());
    this.saveContactUseCase.execute(this.mapper.toContact(contactRequestBodyType));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  public ResponseEntity<Void> putContact(Long id) {
    return null;
  }
}
