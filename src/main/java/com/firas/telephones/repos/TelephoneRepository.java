package com.firas.telephones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firas.telephones.entities.Telephone;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {

}
