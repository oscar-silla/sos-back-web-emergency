package com.emergency.sos.adapters;

import com.emergency.sos.application.ports.driving.GetContactUseCasePort;
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
  private final GetContactUseCasePort getContactUseCase;

  public ContactControllerAdapter(
      final ContactControllerMapper mapper,
      final SaveContactUseCasePort saveContactUseCase,
      final GetContactUseCasePort getContactUseCase) {
    this.mapper = mapper;
    this.saveContactUseCase = saveContactUseCase;
    this.getContactUseCase = getContactUseCase;
  }

  @Override
  public ResponseEntity<ContactResponseType> getContact(Long id) {
    this.log.info("GET /emergency/v1/contacts with id: {}", id);
    return ResponseEntity.ok(this.mapper.toContactResponseType(this.getContactUseCase.execute(id)));
  }

  @Override
  public ResponseEntity<ContactsResponseType> getContacts(Integer pageSize, Integer pageNumber) {
    return null;
  }

  @Override
  public ResponseEntity<Void> postContact(ContactRequestBodyType contactRequestBodyType) {
    this.log.info("POST /emergency/v1/contacts with body: {}", contactRequestBodyType.toString());
    this.saveContactUseCase.execute(this.mapper.toContact(contactRequestBodyType));
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @Override
  public ResponseEntity<Void> putContact(Long id) {
    return null;
  }
}
