package com.pk.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
/**
 * This is PassportAppDetailsEntity Class
 * @author Pankaj Kumar
 *
 */
@Data
@Entity
@Table(name = "PASSPORT_APP_DETAILS")
public class PassportAppDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PASSPORT_ID", length = 10)
	private Integer passportId;
	
	@Column(name = "PASSPORT_NUMBER",length = 12)
	private String passportNumber;
	
	@Column(name = "PID",length = 20)
	private Integer pid;
	
	@Column(name = "CREATED_DATE",nullable = false,updatable = false  )
	@CreationTimestamp
	private Timestamp createdDate;
	
	@Column(name = "UPDATED_DATE")
	@UpdateTimestamp
	private Timestamp updatedDate;
}
