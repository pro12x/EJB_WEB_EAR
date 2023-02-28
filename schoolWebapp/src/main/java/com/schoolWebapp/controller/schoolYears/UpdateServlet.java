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

@WebServlet("/school-years/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ISchoolYearService schoolYearServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SchoolYearModel schoolYear = schoolYearServiceEJB.get(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("schoolYear", schoolYear);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/schoolYears/form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SchoolYearDto schoolYearData = new SchoolYearDto(request.getParameterMap());

		schoolYearServiceEJB.update(Integer.parseInt(request.getParameter("id")), schoolYearData);

		response.sendRedirect(request.getContextPath() + "/school-years");
	}
}
