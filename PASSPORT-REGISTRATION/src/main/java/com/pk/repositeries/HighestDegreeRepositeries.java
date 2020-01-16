package com.pk.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pk.entity.HighestDegreeEntity;
/**
 * This is HighestDegreeRepositeries Interface
 * @author Pankaj Kumar
 *
 */
public interface HighestDegreeRepositeries extends JpaRepository<HighestDegreeEntity, Integer> {

	@Query(value = "select degreeName from HighestDegreeEntity" )
	public List<String> findAllDegrees();
	
}
