package com.khadri.spring.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.khadri.spring.mvc.dao.GrosaryDao;
import com.khadri.spring.mvc.form.GrosaryForm;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddGrosaryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private GrosaryDao dao;

	@Override
	public void init() {
		ServletContext context = getServletContext();
		dao = new GrosaryDao(context);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("Entered into AddGrosaryServlet doPost(-,-)");
		String grosaryName = req.getParameter("grosaryName");
		String grosaryQty = req.getParameter("grosaryQty");
		String grosaryPrice = req.getParameter("grosaryPrice");

		GrosaryForm grosaryForm = new GrosaryForm(grosaryName, Integer.parseInt(grosaryQty), Double.parseDouble(grosaryPrice));

		int result = dao.insertGrosary(grosaryForm);

		PrintWriter pw = resp.getWriter();

		if (result == 1) {
			pw.println(result + " Inserted Successfully!!!!!");
		} else {
			pw.println("@@@@@Something went wrong@@@@@");
		}

	}

}
