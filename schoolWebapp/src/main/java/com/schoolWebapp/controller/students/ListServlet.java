package com.schoolWebapp.controller.students;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.entities.StudentModel;
import com.groupeisi.schoolEjb.service.interfaces.IStudentService;


@WebServlet("/students")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private IStudentService studentServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentModel> students = studentServiceEJB.list();
		request.setAttribute("students", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/students/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
