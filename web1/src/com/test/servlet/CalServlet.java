package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest req, HttpServletResponse resq) throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		int result = 0;
		String resultStr = "";
		try {
			int num1 = Integer.parseInt(req.getParameter("num1"));
			int num2 = Integer.parseInt(req.getParameter("num2"));
			String op = req.getParameter("op");

			if (op.equals("+")) {
				result = num1 + num2;
			} else if (op.equals("-")) {
				result = num1 - num2;
			} else if (op.equals("/")) {
				result = num1 / num2;
			} else if (op.equals("*")) {
				result = num1 * num2;
			}
			resultStr = "결과값" + result;
		} catch (NumberFormatException e) {
			resultStr = "너임마";

		}
		doProcess(resq, "결과값 = " + result);
	}

	public void dePost(HttpServletRequest req, HttpServletResponse reqs) throws IOException {

	}

	public void doProcess(HttpServletResponse resq, String writeStr) throws IOException {
		resq.setContentType("text/html; charset = UTF-8");
		PrintWriter out = resq.getWriter();
		out.print(writeStr);

	}
}