package br.keep;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/remove")


public class Remove extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {	
	GabKeep gabkeep = new GabKeep();
	 try {
		gabkeep.remove(Integer.valueOf(request.getParameter("id")));

		response.sendRedirect("notes.jsp");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		 }
	
	
	
@Override
 protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
 throws ServletException, IOException {
	

 }
}
