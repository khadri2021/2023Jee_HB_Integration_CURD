package com.khadri.jee.hibernate.integration.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Eneterd into ResponseController:service(-,-) ");
		
	 
		RequestDispatcher rd = req.getRequestDispatcher("/admin.jsp");
		rd.forward(req, resp);
		
	}

	 
}
