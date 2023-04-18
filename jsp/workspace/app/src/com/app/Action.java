package com.app;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;

public interface Action {
	public Result execute(HttpRequest req, HttpResponse rep) throws IOException, ServletException;
}
