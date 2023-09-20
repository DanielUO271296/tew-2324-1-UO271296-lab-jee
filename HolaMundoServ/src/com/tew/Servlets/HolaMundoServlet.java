package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet("/HolaMundoServlet")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		     String nombre = (String) request.getParameter("NombreUsuario");
			 response.setCharacterEncoding("UTF-8");
			 response.setContentType("text/html");
			 
			 //se puede entrar desde la web usando esta url http://localhost:8080/HolaMundoServ/HolaMundoCordial
			 //la barra del buscador hace peticiones get
			 PrintWriter out = response.getWriter();
			 out.println("<HTML>");
			 out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
			 out.println("<BODY>");
			 
			 //Comprobamos que han introducido un nombre y lo imprimimos por pantalla
			 if ( nombre != null ){
				 out.println("<br>Hola "+nombre+"<br>");
				 }
			 out.println("Bienvenido a mi primera p�gina web!");
			 out.println("</BODY></HTML>");
			 //Para hacer la llamada desde el buscador se seguira este modelo
			 //http://<servidor>:[<puerto>]/directorio/.../recurso?param1=valor&param2=...
			 //Asi quedaria:
             //http://localhost:8080/HolaMundoServ/HolaMundoCordial?NombreUsuario=Fulanito
			 
			 // http://localhost:8080/HolaMundoServ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
