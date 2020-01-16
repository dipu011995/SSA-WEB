package com.pk.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pk.entity.PersonDetailsEntity;
/**
 * This is PersonDetailsRepositeries Interface
 * @author Pankaj Kumar
 *
 */
@Repository
public interface PersonDetailsRepositeries extends JpaRepository<PersonDetailsEntity, Integer> {

}
