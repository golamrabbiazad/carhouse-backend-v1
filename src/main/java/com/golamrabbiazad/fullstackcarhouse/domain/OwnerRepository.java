package com.golamrabbiazad.fullstackcarhouse.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByFirstName(String firstName);
}
