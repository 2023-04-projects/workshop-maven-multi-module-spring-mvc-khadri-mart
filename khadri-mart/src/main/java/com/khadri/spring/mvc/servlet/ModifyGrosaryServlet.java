package com.khadri.spring.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.spring.mvc.dao.GrosaryDao;
import com.khadri.spring.mvc.form.GrosaryForm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyGrosaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GrosaryDao dao;
	PrintWriter pw;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new GrosaryDao(context);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into ModifyGrosaryServlet doPost(-,-)");
		String grosaryName = req.getParameter("grosaryName");
		String grosaryQty = req.getParameter("grosaryQty");
		String grosaryPrice = req.getParameter("grosaryPrice");
		if (grosaryQty != null && !grosaryQty.isEmpty()) {
			try {
				Integer.parseInt(grosaryQty);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid price format.");
			}
		} else {
			System.out.println("productprice parameter is missing or empty.");
		}
		if (grosaryPrice != null && !grosaryPrice.isEmpty()) {
			try {
				Double.parseDouble(grosaryPrice);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("Invalid price format.");
			}
		} else {
			System.out.println("productprice parameter is missing or empty.");
		}
		GrosaryForm grosaryForm = new GrosaryForm(grosaryName, Integer.parseInt(grosaryQty), Double.parseDouble(grosaryPrice));

		int result = dao.updateGrosary(grosaryForm);
		PrintWriter pw = resp.getWriter();
		if (result > 0) {
			pw.println(result + " Grosary updated successfully");
		} else {
			pw.println("####### Something went wrong #######");
		}
	}
}
