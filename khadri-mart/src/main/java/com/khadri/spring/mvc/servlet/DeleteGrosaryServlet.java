package com.khadri.spring.mvc.servlet;

import java.io.IOException;

import com.khadri.spring.mvc.dao.GrosaryDao;
import com.khadri.spring.mvc.form.GrosaryForm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteGrosaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GrosaryDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new GrosaryDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String grosaryName = req.getParameter("grosaryName");
		String grosaryQty = req.getParameter("grosaryQty");
		String grosaryPrice = req.getParameter("grosaryPrice");


		System.out.println("Received 'name' parameter: " + grosaryName);
		GrosaryForm grosaryForm = new GrosaryForm(grosaryName, Integer.parseInt(grosaryQty), Double.parseDouble(grosaryPrice));
		

		if (grosaryName != null && !grosaryName.isEmpty()) {
			int result = dao.deleteGrosary(grosaryName);

			if (result >0) {
				resp.getWriter().println("Grocery item deleted successfully.");
			} else {
				resp.getWriter().println("Failed to delete grocery item.");
			}
		} else {
			resp.getWriter().println("No grocery items withthis name.");
		}
	}
}
