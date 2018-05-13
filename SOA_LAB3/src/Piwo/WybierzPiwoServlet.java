package Piwo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EkspertPiwny;
import model.Piwo;

/**
 * Servlet implementation class WybierzPiwoServlet
 */
@WebServlet("/WybierzPiwo.do")
public class WybierzPiwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WybierzPiwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter out = response.getWriter()){
			String color = request.getParameter("beerType");
			EkspertPiwny ekspert = new EkspertPiwny();
			List<String> marki = ekspert.getMarki(color);
			
			
			request.setAttribute("marki", marki);
			RequestDispatcher view = request.getRequestDispatcher("wynik.jsp");
			view.forward(request, response);
		}
	}

}
