package com.philips.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//// http://localhost:8080/basic-webapp/hello

@WebServlet(urlPatterns = { "/hello", "/welcome" })
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html"); // MIME

		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.println("<hr />");
		out.println("<p>Powered by Java Servlet</p>");

		out.close();
	}

}
