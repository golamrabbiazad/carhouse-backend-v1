package com.golamrabbiazad.fullstackcarhouse;

import com.golamrabbiazad.fullstackcarhouse.domain.Owner;
import com.golamrabbiazad.fullstackcarhouse.repository.OwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OwnerRepositoryTest {
    @Autowired
    private OwnerRepository repository;

    @Test
    void saveOwner() {
        repository.save(new Owner("Brian", "Holt"));

        assertThat(repository.findByFirstName("Brian").isPresent()).isTrue();
    }

    @Test
    void findOwners() {
        repository.save(new Owner("Brian", "Holt"));

        Iterable<Owner> owners = repository.findAll();

        assertThat(owners).hasSize(3);
    }

    @Test
    void deleteOwners() {
        repository.save(new Owner("abc", "efg"));

        repository.deleteAll();

        assertThat(repository.count()).isEqualTo(0);
    }
}
