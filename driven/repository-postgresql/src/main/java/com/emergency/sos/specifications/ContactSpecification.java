package com.emergency.sos.specifications;

import com.emergency.sos.domain.ContactFilter;
import com.emergency.sos.models.ContactMO;
import org.springframework.data.jpa.domain.Specification;

public interface ContactSpecification {
  Specification<ContactMO> getSpecification(ContactFilter filter);
}
