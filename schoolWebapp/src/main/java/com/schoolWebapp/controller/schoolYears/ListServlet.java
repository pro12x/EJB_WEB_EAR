package com.schoolWebapp.controller.schoolYears;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.entities.SchoolYearModel;
import com.groupeisi.schoolEjb.service.interfaces.ISchoolYearService;


@WebServlet("/school-years")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ISchoolYearService schoolYearServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SchoolYearModel> schoolYears = schoolYearServiceEJB.list();
		request.setAttribute("schoolYears", schoolYears);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/schoolYears/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
