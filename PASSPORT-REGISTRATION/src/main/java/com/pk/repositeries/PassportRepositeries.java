package com.pk.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.entity.PassportAppDetailsEntity;
/**
 * This is PassportRepositeries to get All Passport details
 * @author Pankaj Kumar
 *
 */
public interface PassportRepositeries extends JpaRepository<PassportAppDetailsEntity, Integer> {

}
