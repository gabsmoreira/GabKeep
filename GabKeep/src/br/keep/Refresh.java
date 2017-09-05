package br.keep;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/refresh")
public class Refresh extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws ServletException, IOException {
	
 
 
 
 
}

@Override
protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
throws ServletException, IOException {
	
	GabKeep gabkeep = new GabKeep();
	Notes note = new Notes();
	note.setId(Integer.valueOf(request.getParameter("id")));
	note.setContent(request.getParameter("content"));
	note.setColor(10);
	gabkeep.altera(note);
	
	
//	PrintWriter out = response.getWriter();
//	out.println("<tr><td>" + note.getId() + "</td>");
//	out.println("<tr><td>" + note.getContent() + "</td>");
	response.sendRedirect("notes.jsp");
	gabkeep.close();

}
}