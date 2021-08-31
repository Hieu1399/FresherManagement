package com.vmo.FresherManagement.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "fresher")
@EntityListeners(AuditingEntityListener.class)
public class Fresher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String name;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;

	@NotBlank
	private String phone;

	@NotBlank
	private String mail;
	@NotBlank
	private String language;
		
	private Double diem1;
	
	private Double diem2;
	
	private Double diem3;
	
	@Column(name="diemTB")
	private Double diemTB;
	
	@ManyToOne
	@JoinColumn(name="center_id",referencedColumnName = "id")
	private Center center;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getDiem1() {
		return diem1;
	}

	public void setDiem1(Double diem1) {
		this.diem1 = diem1;
	}

	public Double getDiem2() {
		return diem2;
	}

	public void setDiem2(Double diem2) {
		this.diem2 = diem2;
	}

	public Double getDiem3() {
		return diem3;
	}

	public void setDiem3(Double diem3) {
		this.diem3 = diem3;
	}

	public Double getDiemTB() {
		return diemTB=(diem1+diem2+diem3)/3;
	}

	public void setDiemTB(Double diemTB) {
		this.diemTB = diemTB;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
