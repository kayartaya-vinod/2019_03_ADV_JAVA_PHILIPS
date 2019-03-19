package com.philips.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view-all-products")
public class ViewAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. read any data from the request
		// 2. talk to the model, and get any data to be passed on to the view
		// 3. store the model data in a place (scope) which is accessible to view
		// 4. forward the request/response to the view for presenting the data
		RequestDispatcher rd = request.getRequestDispatcher("/show-products.jsp");
		rd.forward(request, response);
		
	}

}
