package com.pk.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.entity.EducationalDetailsEntity;
/**
 * This is EducationalDetailsRepositeries Interface
 * @author Pankaj Kumar
 *
 */
public interface EducationalDetailsRepositeries extends JpaRepository<EducationalDetailsEntity, Integer> {

}
