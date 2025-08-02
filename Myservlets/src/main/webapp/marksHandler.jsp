<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    int marks = Integer.parseInt(request.getParameter("marks"));

    request.setAttribute("studentName", name);
    request.setAttribute("studentMarks", marks);

    if (marks >= 40) {
        RequestDispatcher rd = request.getRequestDispatcher("pass.jsp");
        rd.forward(request, response);
    } else {
        RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
        rd.forward(request, response);
    }
%>
    