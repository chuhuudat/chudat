package com.example.demo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;import org.springframework.web.jsf.FacesContextUtils;

import lombok.Data;

@Data
@Entity
@Table(name="employees1")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name ="firstName" , nullable = false)
	private String first_name;
	@Column(name ="lastName")
	private String last_name;
	@Column(name ="email")
	private String email;
}
