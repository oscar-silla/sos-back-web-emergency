package com.emergency.sos.application.usecases;

import com.emergency.sos.application.ports.driving.GetContactUseCasePort;
import com.emergency.sos.application.services.ContactService;
import com.emergency.sos.domain.Contact;
import org.springframework.stereotype.Service;

@Service
public class GetContactUseCase implements GetContactUseCasePort {
  private final ContactService contactService;

  public GetContactUseCase(final ContactService contactService) {
    this.contactService = contactService;
  }

  @Override
  public Contact execute(Long id) {
    return this.contactService.findById(id);
  }
}
