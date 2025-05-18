package com.emergency.sos.application.usecases;

import com.emergency.sos.application.exceptions.BadRequestException;
import com.emergency.sos.application.ports.driving.SaveContactUseCasePort;
import com.emergency.sos.application.services.ContactService;
import com.emergency.sos.domain.Contact;
import org.springframework.stereotype.Service;

@Service
public class SaveContactUseCase implements SaveContactUseCasePort {
  private final ContactService contactService;

  public SaveContactUseCase(final ContactService contactService) {
    this.contactService = contactService;
  }

  @Override
  public void execute(Contact contact) {
    this.validate(contact);
    this.contactService.save(contact);
  }

  private void validate(Contact contact) {
    if (!contact.hasName() || !contact.hasPhoneNumber()) {
      throw new BadRequestException();
    }
  }
}
