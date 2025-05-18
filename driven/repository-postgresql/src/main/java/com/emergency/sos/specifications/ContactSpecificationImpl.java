package com.emergency.sos.specifications;

import com.emergency.sos.domain.ContactFilter;
import com.emergency.sos.models.ContactMO;
import com.emergency.sos.models.ContactMO_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactSpecificationImpl implements ContactSpecification {
  @Override
  public Specification<ContactMO> getSpecification(ContactFilter filter) {
    List<Specification<ContactMO>> specifications = new ArrayList<>();
    if (filter.name() != null) {
      specifications.add(this.equalsName(filter.name()));
    }
    if (filter.phoneNumber() != null) {
      specifications.add(this.equalsPhoneNumber(filter.phoneNumber()));
    }
    return specifications.stream().reduce(Specification::and).orElse(null);
  }

  private Specification<ContactMO> equalsName(String name) {
    return (root, query, cb) -> cb.equal(root.get(ContactMO_.NAME), name);
  }

  private Specification<ContactMO> equalsPhoneNumber(String phoneNumber) {
    return (root, query, cb) -> cb.equal(root.get(ContactMO_.phoneNumber), phoneNumber);
  }
}
