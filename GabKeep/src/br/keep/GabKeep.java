package br.keep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GabKeep {
private Connection connection;
public GabKeep() {
 try {
	Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 try {
	connection = DriverManager.getConnection(
	"jdbc:mysql://localhost/GabKeep", "root", "mengo1998_");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}



public List<Notes> getLista() {
	
List<Notes> notes = new ArrayList<Notes>();
PreparedStatement stmt = null;
try {
	stmt = connection.
	 prepareStatement("SELECT * FROM Notes");
} catch (SQLException e) {	
	// TODO Auto-generated catch block
	e.printStackTrace();
}
ResultSet rs = null;
try {
	rs = stmt.executeQuery();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
catch (NullPointerException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	notes = null;
}

	try {
		while (rs.next()) {
			Notes note = new Notes();
			note.setId(rs.getInt("id"));
			note.setContent(rs.getString("content"));
			note.setColor(rs.getInt("color"));
			notes.add(note);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}

	public void close() {
			
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	public void adiciona(Notes note) throws SQLException {
		String sql = "INSERT INTO Notes" +
		"(content,color) values(?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,note.getContent());
		stmt.setInt(2,note.getColor());
		stmt.execute();
		stmt.close();
		}
	
	public void altera(Notes note) {
		String sql = "UPDATE Notes SET " +
		 "content=?, color=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, note.getContent());
			stmt.setInt(2, note.getColor());
			stmt.setInt(3, note.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public void remove(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection
			 .prepareStatement("DELETE FROM Notes WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}