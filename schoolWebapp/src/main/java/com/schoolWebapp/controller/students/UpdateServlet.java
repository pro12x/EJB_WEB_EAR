package com.schoolWebapp.controller.students;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.dto.StudentDto;
import com.groupeisi.schoolEjb.data.entities.StudentModel;
import com.groupeisi.schoolEjb.service.interfaces.IStudentService;

@WebServlet("/students/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IStudentService studentServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentModel student = studentServiceEJB.get(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("student", student);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/students/form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDto studentData = new StudentDto(request.getParameterMap());

		studentServiceEJB.update(Integer.parseInt(request.getParameter("id")), studentData);

		response.sendRedirect(request.getContextPath() + "/students");
	}

}
