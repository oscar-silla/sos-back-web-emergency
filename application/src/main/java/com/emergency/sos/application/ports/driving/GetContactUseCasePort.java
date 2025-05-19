package com.emergency.sos.application.ports.driving;

import com.emergency.sos.domain.Contact;

public interface GetContactUseCasePort {
  Contact execute(Long id);
}
