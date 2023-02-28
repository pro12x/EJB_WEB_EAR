package com.schoolWebapp.controller.courses;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.dto.CourseDto;
import com.groupeisi.schoolEjb.data.entities.CourseModel;
import com.groupeisi.schoolEjb.service.interfaces.ICourseService;

@WebServlet("/courses/create")
public class CreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICourseService courseServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("course", new CourseModel());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/courses/form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseDto courseData = new CourseDto(request.getParameterMap());

		courseServiceEJB.create(courseData);

		response.sendRedirect(request.getContextPath() + "/courses");
	}
}
