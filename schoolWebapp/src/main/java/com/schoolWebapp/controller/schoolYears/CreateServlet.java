package com.schoolWebapp.controller.schoolYears;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.dto.SchoolYearDto;
import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;
import com.groupeisi.schoolEjb.service.interfaces.ISchoolYearService;

@WebServlet("/school-years/create")
public class CreateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISchoolYearService schoolYearServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("schoolYear", new SchoolYearModel());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/schoolYears/form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SchoolYearDto schoolYearData = new SchoolYearDto(request.getParameterMap());

		schoolYearServiceEJB.create(schoolYearData);

		response.sendRedirect(request.getContextPath() + "/school-years");
	}
}
