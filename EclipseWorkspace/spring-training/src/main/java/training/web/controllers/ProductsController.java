package training.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import training.dao.DaoException;
import training.dao.ProductDao;

@Controller // this is a special type of component, qualifies for ComponentScan
public class ProductsController {
	
	@Autowired
	@Qualifier("htDao")
	private ProductDao dao;

	// A controller has one or more request handlers.
	// A HandlerMapping bean maintains a map of all such handlers.

	@RequestMapping(path = "/view-all-products", method = RequestMethod.GET)
	public ModelAndView getAllProductsHandler() throws DaoException {
		return new ModelAndView(
				"/show-products.jsp", "products", dao.getAllProducts());
	}
	

	@RequestMapping(path = "/view-products-by-price-range", method = RequestMethod.GET)
	public ModelAndView getProductsByPriceRangeHandler(
			@RequestParam("min_price") Double min, 
			@RequestParam("max_price") Double max) throws DaoException {
		return new ModelAndView(
				"/show-products.jsp", "products", dao.getProductsByPriceRange(min, max));
	}

}





