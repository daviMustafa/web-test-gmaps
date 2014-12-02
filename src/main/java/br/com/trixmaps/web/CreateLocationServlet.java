package br.com.trixmaps.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.trixmaps.dao.LocationDao;
import br.com.trixmaps.dao.LocationDaoImpl;
import br.com.trixmaps.model.Location;

@WebServlet("/createLocation")
public class CreateLocationServlet extends HttpServlet{

	private static final long serialVersionUID = 9170585954865575907L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String name = request.getParameter("name");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String tags = request.getParameter("tags");
		
//		Montando uma location
		Location location = new Location();
		
		location.setName(name);
		location.setLatitude(Double.parseDouble(latitude));
		location.setLongitude(Double.parseDouble(longitude));
		location.setCreated(new Date());
		
//		Inserir no banco
		LocationDao dao = new LocationDaoImpl();

		dao.insert(location);
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
			out.println("<body>");
				out.println("Location "+location.getName()+ " created.");
			out.println("</body>");
		out.println("</html>");
	}
	
}
