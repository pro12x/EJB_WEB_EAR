package com.schoolWebapp.controller.courses;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.entities.CourseModel;
import com.groupeisi.schoolEjb.service.interfaces.ICourseService;


@WebServlet("/courses")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ICourseService courseServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CourseModel> courses = courseServiceEJB.list();
		request.setAttribute("courses", courses);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/courses/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
