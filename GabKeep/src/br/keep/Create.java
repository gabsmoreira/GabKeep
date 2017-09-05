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

@WebServlet("/create")
public class Create extends HttpServlet {
 @Override
 protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	 GabKeep gabkeep = new GabKeep();
	 Notes note = new Notes();
	 note.setContent(request.getParameter("textinput"));
	 note.setColor(10);
	 //note.setColor(Integer.valueOf(request.getParameter("color")));
	 try {
		gabkeep.adiciona(note);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	response.sendRedirect("notes.jsp");

	 gabkeep.close();
	 

 }
 @Override
 protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	 
	 
 
 }
}