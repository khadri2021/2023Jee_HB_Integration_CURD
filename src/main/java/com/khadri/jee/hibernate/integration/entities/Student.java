package com.khadri.jee.hibernate.integration.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity(name = "Student")
@Table(name = "STUDENT_REGISTER")
@NamedQuery(name = Student.NamedQueriesConstants.SEARCH_BY_ID, query = "select s from Student s where id=:stdId")
@NamedNativeQuery(name = Student.NamedQueriesConstants.DELETE_BY_ID, query = "DELETE from STUDENT_REGISTER s where s.id=?1")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUD_ID")
	private Long id;

	@Column(name = "STUD_NAME")
	private String studName;

	@Column(name = "STUD_AGE")
	private int studAge;

	@Column(name = "STUD_BRANCH")
	private String studBranch;

	@Column(name = "STUD_PHONE")
	private Long studPhone;

	@Column(name = "STUD_PARENT_PHONE")
	private Long studParentPhone;

	@Column(name = "STUD_ADDRESS")
	private String studAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getStudAge() {
		return studAge;
	}

	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}

	public String getStudBranch() {
		return studBranch;
	}

	public void setStudBranch(String studBranch) {
		this.studBranch = studBranch;
	}

	public Long getStudPhone() {
		return studPhone;
	}

	public void setStudPhone(Long studPhone) {
		this.studPhone = studPhone;
	}

	public Long getStudParentPhone() {
		return studParentPhone;
	}

	public void setStudParentPhone(Long studParentPhone) {
		this.studParentPhone = studParentPhone;
	}

	public String getStudAddress() {
		return studAddress;
	}

	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}

	public class NamedQueriesConstants {
		public static final String SEARCH_BY_ID = "SEARCH_BY_ID";
		public static final String DELETE_BY_ID = "DELETE_BY_ID";

	}

}
