package com.khadri.jee.hibernate.integration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khadri.jee.hibernate.integration.dao.StudentDAO;
import com.khadri.jee.hibernate.integration.dto.StudentDTO;
import com.khadri.jee.hibernate.integration.entities.Student;

public class StudentController extends HttpServlet {
	
	
	private  StudentDAO dao = new StudentDAO();


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Eneterd into RegisterServlet:service(-,-) ");
		
		String MODE = req.getParameter("mode");
		
		
		if("VIEW".equals(MODE)) {
			
			List<Student> listOfStudents = dao.selectStudentForms();
			
			RequestDispatcher rd = req.getRequestDispatcher("modify_student.jsp");
			req.setAttribute("edit_result", listOfStudents);
			rd.forward(req, resp);
			
			
		}else if("DELETE".equals(MODE)) {
			
			List<Student> listOfStudents = dao.selectStudentForms();
			
			RequestDispatcher rd = req.getRequestDispatcher("delete_student.jsp");
			req.setAttribute("delete_result", listOfStudents);
			rd.forward(req, resp);
			
			
		}else if("DELETE_RECORD".equals(MODE)) {
			String studentId = req.getParameter("sId");
			  dao.deleteStudentForm(studentId);
			  
			List<Student> listOfStudents = dao.selectStudentForms();
			RequestDispatcher rd = req.getRequestDispatcher("delete_student.jsp");
			req.setAttribute("delete_result", listOfStudents);
			rd.forward(req, resp);
			
			
		}else if("EDIT".equals(MODE)) {
			
			StudentDTO  studentDTO =  modifyDTO(req);
			dao.modifyStudentForm(studentDTO);
			
			
			
		}else if("SEARCH".equals(MODE)) {
			
			String studentId = req.getParameter("stdid");
			Student searchRecord = dao.searchStudentForm(studentId);
			
			RequestDispatcher rd = req.getRequestDispatcher("view_student.jsp");
			req.setAttribute("search_result", searchRecord);
			rd.forward(req, resp);
			
			
		}else {
			StudentDTO studentDTO = createDTO(req);

			System.out.println("Invoked RegisterDao from Servlet ");
			dao.saveStudentForm(studentDTO);	
		}
 
		
	}

	private StudentDTO createDTO(HttpServletRequest req) {
		
		String studentName = req.getParameter("sName");
		String studentAge = req.getParameter("sAge");
		String studentBranch = req.getParameter("sBranch");
		String studentPhone = req.getParameter("sPhone");
		String studentAddress = req.getParameter("sAddress");
		String studentParentPhone = req.getParameter("sParentPhone");

		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentName(studentName);
		studentDTO.setStudentAge(studentAge);
		studentDTO.setStudentBranch(studentBranch);
		studentDTO.setStudentPhone(studentPhone);
		studentDTO.setStudentAddress(studentAddress);
		studentDTO.setStudentParentPhone(studentParentPhone);
		return studentDTO;
	}
	private StudentDTO modifyDTO(HttpServletRequest req) {
		
		String studentId = req.getParameter("sId");
		String studentName = req.getParameter("sName");
		String studentAge = req.getParameter("sAge");
		String studentBranch = req.getParameter("sBranch");
		String studentPhone = req.getParameter("sPhone");
		String studentAddress = req.getParameter("sAddress");
		String studentParentPhone = req.getParameter("sParentPhone");
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setStudentId(Long.valueOf(studentId));
		studentDTO.setStudentName(studentName);
		studentDTO.setStudentAge(studentAge);
		studentDTO.setStudentBranch(studentBranch);
		studentDTO.setStudentPhone(studentPhone);
		studentDTO.setStudentAddress(studentAddress);
		studentDTO.setStudentParentPhone(studentParentPhone);
		return studentDTO;
	}
}
