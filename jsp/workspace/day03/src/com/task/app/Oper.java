package com.task.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Oper extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		boolean isError = false;
		String expression = request.getParameter("expression");
		String opers = "+-*/";
		char oper = ' ';
		Calc calc = null;
		String[] numbers = null;
		int result = 0;
		PrintWriter out = response.getWriter();

		for (int i = 0; i < expression.length(); i++) {
			for (int j = 0; j < opers.length(); j++) {
				if (expression.charAt(i) == opers.charAt(j)) {
					oper = opers.charAt(j);
				}
			}
		}

		numbers = expression.split("\\" + oper);
		calc = new Calc(numbers[0], numbers[1]);

		switch (oper) {
		case '+':
			result = calc.add();
			break;
		case '-':
			result = calc.sub();
			break;
		case '*':
			result = calc.mul();
			break;
		case '/':
			try {
				result = calc.div();
			} catch (Exception e) {
				isError = true;
				out.print("<h1>0으로 나눌 수 없습니다.</h1>");
				out.print("<a href='/day03/calc'>다시 계산하기</a>");
				out.close();
			}
			break;

		}
		if (!isError) {
			out.print("<h1>결과: " + result + "</h1>");
			out.print("<a href='/day03/calc'>다시 계산하기</a>");
			out.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
