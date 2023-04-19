package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.app.member.dao.MemberDAO;

public class CheckIdOkController implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse rep) throws IOException, ServletException {
		MemberDAO memberDAO = new MemberDAO();
		String memberIdentification = memberDAO.selectIdentification(req.getParameter("memberIdentification"));
		boolean check = memberIdentification == null;
		
		return null;
	}
}
