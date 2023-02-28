package com.schoolWebapp.controller.registrations;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupeisi.schoolEjb.data.entities.RegistrationModel;
import com.groupeisi.schoolEjb.service.interfaces.IRegistrationService;


@WebServlet("/registrations")
public class ListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private IRegistrationService registrationServiceEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<RegistrationModel> registrations = registrationServiceEJB.list();
		request.setAttribute("registrations", registrations);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pages/registrations/list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
