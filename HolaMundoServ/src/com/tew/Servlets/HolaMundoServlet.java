package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//se puede entrar desde la web usando esta url http://localhost:8080/HolaMundoServ/HolaMundoCordial
		//la barra del buscador hace peticiones get
			 PrintWriter out = response.getWriter();
			 out.println("<HTML>");
			 out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
			 out.println("<BODY>");
		
		    
			 
			 //Tarea 1.Recogemos el nombre
			 String nombre = (String) request.getParameter("NombreUsuario");
			
			 //Tarea 2.Creamos una lista que almacene los nombres de las personas que han entrado a esta página
			 Vector listado = (Vector)request.getSession().getAttribute("listado");
			 
			 //Tarea 3.Buscar en el contexto un atributo de tipo Integer que se llame contador. En caso de
			 //que no exista, se instanciará con valor 0. 
			 Integer contador= (Integer) getServletContext().getAttribute("contador");
			 
			 //Tarea 2.Comprobamos que no esta vacio
			 if (listado == null){
			  listado = new Vector();
			 }
			 
			 //Tarea 1.Comprobamos que han introducido un nombre y lo imprimimos por pantalla
			 if ( nombre != null ){
				 out.println("<br>Hola "+nombre+"<br>");
				 listado.addElement(nombre);
			 }
			 
			 //tarea 3.Comprobamos que no existe
			 if ( contador == null ){
				 contador = new Integer(1);
			 }
			 
			 out.println("Bienvenido a mi primera página web!");
			 out.println("</BODY></HTML>");
			 
			 //Establecemos el vector como un atributo de la sesion
			 request.getSession().setAttribute("listado",listado);
			 
			 out.println("<br>");
			 out.println("Contigo, hoy me han visitado:<br>");
			 for ( int i = 0 ; i < listado.size() ; i++ ){
			  out.println("<br>"+(String)listado.elementAt(i));
			 }
			 out.println("<a href=\"index.html\">volver</a>");
			 
			 // Establecemos el contador como atributo del context bajo el nombre
			 // contador. En caso de que ya existiera, sobreescribiría la referencia
			 // existente con la nueva.
			 getServletContext().setAttribute("contador",new Integer(contador.intValue()+1));

			
			 //Para hacer la llamada desde el buscador se seguira este modelo
			 //http://<servidor>:[<puerto>]/directorio/.../recurso?param1=valor&param2=...
			 //Asi quedaria:
             //http://localhost:8080/HolaMundoServ/HolaMundoCordial?NombreUsuario=Fulanito
			 
			 // http://localhost:8080/HolaMundoServ
			 out.println("<br><br>" + contador +" visitas");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
