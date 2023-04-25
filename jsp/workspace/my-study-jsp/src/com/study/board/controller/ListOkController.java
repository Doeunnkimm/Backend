package com.study.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.study.Action;
import com.study.Result;
import com.study.board.dao.BoardDAO;

public class ListOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		
		JSONArray jsonArray = new JSONArray();
		boardDAO.selectAll().stream().map(board -> new JSONObject(board)).forEach(jsonArray::put);
		req.setAttribute("boards", jsonArray.toString()); // 리턴하는 객체를 목록 페이지에서 키값으로 사용 가능
		
		result.setPath("templete/board/list.jsp");
		return result;
	}

}
