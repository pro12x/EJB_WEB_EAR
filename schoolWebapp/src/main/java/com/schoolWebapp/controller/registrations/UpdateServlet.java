package com.schoolWebapp.controller.registrations;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.dto.RegistrationDto;
import com.groupeisi.schoolEjb.data.entities.RegistrationModel;
import com.groupeisi.schoolEjb.service.interfaces.ICourseService;
import com.groupeisi.schoolEjb.service.interfaces.IRegistrationService;
import com.groupeisi.schoolEjb.service.interfaces.ISchoolYearService;
import com.groupeisi.schoolEjb.service.interfaces.IStudentService;

@WebServlet("/registrations/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IRegistrationService registrationServiceEJB;

	@EJB
	private IStudentService studentServiceEJB;

	@EJB
	private ICourseService courseServiceEJB;

	@EJB
	private ISchoolYearService schoolYearServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationModel registration = registrationServiceEJB.get(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("registration", registration);
		request.setAttribute("students",studentServiceEJB.list());
		request.setAttribute("courses",courseServiceEJB.list());
		request.setAttribute("schoolYears",schoolYearServiceEJB.list());

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/registrations/form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationDto registrationData = new RegistrationDto(request.getParameterMap());

		registrationServiceEJB.update(Integer.parseInt(request.getParameter("id")), registrationData);

		response.sendRedirect(request.getContextPath() + "/registrations");
	}

}
