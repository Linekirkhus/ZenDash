package com.zendashproject.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long   id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "postalcode")
	private String postalcode;

	@Column(name = "phone")
	private String phone;

	@Column (name = "dateofbirth")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat (pattern = "yyyy/MM/dd hh:mm:ss")
	private Date   dateofbirth = new Date( );

	public Person ( ) {
	}

	public Person ( Long id , String firstname , String lastname , String email , String address , String postalcode , String phone , Date dateofbirth ) {
		this.id          = id;
		this.firstname   = firstname;
		this.lastname    = lastname;
		this.email       = email;
		this.address     = address;
		this.postalcode  = postalcode;
		this.phone       = phone;
		this.dateofbirth = dateofbirth;
	}

	public Long getId ( ) {
		return id;
	}

	public void setId ( Long id ) {
		this.id = id;
	}

	public String getFirstname ( ) {
		return firstname;
	}

	public void setFirstname ( String firstname ) {
		this.firstname = firstname;
	}

	public String getLastname ( ) {
		return lastname;
	}

	public void setLastname ( String lastname ) {
		this.lastname = lastname;
	}

	public String getEmail ( ) {
		return email;
	}

	public void setEmail ( String email ) {
		this.email = email;
	}

	public String getAddress ( ) {
		return address;
	}

	public void setAddress ( String address ) {
		this.address = address;
	}

	public String getPostalcode ( ) {
		return postalcode;
	}

	public void setPostalcode ( String postalcode ) {
		this.postalcode = postalcode;
	}

	public String getPhone ( ) {
		return phone;
	}

	public void setPhone ( String phone ) {
		this.phone = phone;
	}

	public Date getDateofbirth ( ) {
		return dateofbirth;
	}

	public void setDateofbirth ( Date dateofbirth ) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString ( ) {
		return "Person{" +
		       "id=" + id +
		       ", firstname='" + firstname + '\'' +
		       ", lastname='" + lastname + '\'' +
		       ", email='" + email + '\'' +
		       ", address='" + address + '\'' +
		       ", postalcode='" + postalcode + '\'' +
		       ", phone='" + phone + '\'' +
		       ", dateofbirth=" + dateofbirth +
		       '}';
	}
}
