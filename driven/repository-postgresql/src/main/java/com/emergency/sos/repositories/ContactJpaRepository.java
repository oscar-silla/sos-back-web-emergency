package com.emergency.sos.repositories;

import com.emergency.sos.models.ContactMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactJpaRepository
    extends JpaRepository<ContactMO, Long>, JpaSpecificationExecutor<ContactMO> {}
