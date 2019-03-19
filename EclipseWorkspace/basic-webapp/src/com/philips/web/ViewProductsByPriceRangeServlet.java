package com.philips.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.philips.dao.ProductDao;

import training.entity.Product;

@WebServlet({ "/ViewProductsByPriceRangeServlet", "/view-products-by-price-range" })
public class ViewProductsByPriceRangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. read any data from the request
		String input = request.getParameter("min_price");
		Double min = Double.parseDouble(input);
		input = request.getParameter("max_price");
		Double max = Double.parseDouble(input);
		
		// 2. talk to the model, and get any data to be passed on to the view
		ProductDao dao = new ProductDao();
		List<Product> list = dao.getProductsByPriceRange(min, max);
		
		// 3. store the model data in a place (scope) which is accessible to view
		request.setAttribute("products", list);
		request.setAttribute("message", "Products betwen $" + min+ " and $" + max);
		
		
		// 4. forward the request/response to the view for presenting the data
		request.getRequestDispatcher("/show-products.jsp").forward(request, response);
	}

}
