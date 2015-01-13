package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter print = response.getWriter();
		try {
			DAO database = new DAO();
			ResultSet result = database.executeSQL("SELECT nom, descripcio, id, telefon FROM ts1.taula");
			print.print("<html><head></head><body>");
			print.print("<table>");
			print.print("<tr>");
			
			
			print.print("<th>ID</th>");
			print.print("<th>NOM</th>");
			print.print("<th>DESCRIPCIO</th>");
			print.print("<th>TELEFON</th>");
			print.print("</tr>");
			while(result.next()){
				print.print("<tr>");
				print.print("<td>");
				print.print(result.getString("id"));
				print.print("</td>");
				print.print("<td>");
				print.print(result.getString("nom"));
				print.print("</td>");
				print.print("<td>");
				print.print(result.getString("descripcio"));
				print.print("</td>");
				print.print("<td>");
				print.print(result.getString("telefon"));
				print.print("</td>");
				print.print("</tr>");
			}
			print.print("<table>");
			print.print("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
