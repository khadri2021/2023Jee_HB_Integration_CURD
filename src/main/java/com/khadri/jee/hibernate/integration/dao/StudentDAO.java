package com.khadri.jee.hibernate.integration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.khadri.jee.hibernate.integration.dto.StudentDTO;
import com.khadri.jee.hibernate.integration.entities.Student;
import com.khadri.jee.hibernate.integration.util.EntityManagerUtil;

/*
 * Insert into Database (Data Access Object)
 */
public class StudentDAO {

	private EntityManager entityManager = EntityManagerUtil
			.createEntityManager();

	public void saveStudentForm(StudentDTO studentDTO) {
		System.out.println("Entered into RegisterDAO : saveStudentForm(-)");

		Student student = createEntity(studentDTO);

		System.out.println("Saving object starts");

		entityManager.getTransaction().begin();

		entityManager.persist(student);

		entityManager.getTransaction().commit();

		System.out.println("Saving object ends");

	}

	public void modifyStudentForm(StudentDTO studentDTO) {
		System.out.println("Entered into RegisterDAO : modifyStudentForm(-)");

		Student student = modifyEntity(studentDTO);

		System.out.println("updating object starts");

		entityManager.getTransaction().begin();

		entityManager.merge(student);

		entityManager.getTransaction().commit();

		System.out.println("updating object ends");

	}
	public Student searchStudentForm(String studentId) {
		System.out.println("Entered into RegisterDAO : searchStudentForm(-)");

		System.out.println("searching student  starts");

		TypedQuery<Student> studentNamedQuery = entityManager.createNamedQuery(
				Student.NamedQueriesConstants.SEARCH_BY_ID, Student.class);

		studentNamedQuery.setParameter("stdId", Long.valueOf(studentId));

		Student student = studentNamedQuery.getResultStream().findFirst()
				.orElse(null);

		System.out.println("searching student  ends");

		return student;

	}
	public void deleteStudentForm(String studentId) {
		System.out.println("Entered into RegisterDAO : deleteStudentForm(-)");

		System.out.println("deleting student  starts");

		Query studentNativeQuery = entityManager.createNativeQuery(
				Student.NamedQueriesConstants.DELETE_BY_ID, Student.class);

		studentNativeQuery.setParameter(1, Long.valueOf(studentId));

		studentNativeQuery.executeUpdate();

		System.out.println("deleting student  ends");

	}

	public List<Student> selectStudentForms() {

		TypedQuery<Student> query = entityManager
				.createQuery("select s from Student s", Student.class);

		List<Student> resultList = query.getResultList();

		return resultList;
	}

	private Student createEntity(StudentDTO studentDTO) {
		Student std = new Student();
		std.setStudName(studentDTO.getStudentName());
		std.setStudAge(Integer.parseInt(studentDTO.getStudentAge()));
		std.setStudBranch(studentDTO.getStudentBranch());
		std.setStudAddress(studentDTO.getStudentAddress());
		std.setStudPhone(Long.parseLong(studentDTO.getStudentPhone()));
		std.setStudParentPhone(
				Long.parseLong(studentDTO.getStudentParentPhone()));
		return std;
	}
	private Student modifyEntity(StudentDTO studentDTO) {
		Student std = new Student();
		std.setId(studentDTO.getStudentId());
		std.setStudName(studentDTO.getStudentName());
		std.setStudAge(Integer.parseInt(studentDTO.getStudentAge()));
		std.setStudBranch(studentDTO.getStudentBranch());
		std.setStudAddress(studentDTO.getStudentAddress());
		std.setStudPhone(Long.parseLong(studentDTO.getStudentPhone()));
		std.setStudParentPhone(
				Long.parseLong(studentDTO.getStudentParentPhone()));
		return std;
	}

}
