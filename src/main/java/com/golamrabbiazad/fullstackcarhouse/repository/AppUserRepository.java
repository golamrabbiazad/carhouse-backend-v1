package com.golamrabbiazad.fullstackcarhouse.repository;

import com.golamrabbiazad.fullstackcarhouse.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String name);
}
