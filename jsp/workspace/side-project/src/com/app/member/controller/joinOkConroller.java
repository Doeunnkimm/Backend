package com.app.member.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Action;
import com.app.Result;
import com.mybatis.dao.MemberDAO;
import com.mybatis.vo.MemberVO;

public class joinOkConroller implements Action{
	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberName(name);
		memberVO.setMemberAge(age);
		
		memberDAO.insert(memberVO);
		result.setRedirect(true);
		result.setPath("login.member");
		
		return result;
	}
}
