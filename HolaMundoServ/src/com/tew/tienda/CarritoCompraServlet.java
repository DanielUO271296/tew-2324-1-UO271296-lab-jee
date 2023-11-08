package com.tew.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet("/CarritoCompraServlet")
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraServlet() {
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
			 out.println("<HEAD><TITLE>Carrito Compra</TITLE></HEAD>");
			 out.println("<BODY>");
			 
			 //http://localhost:8080/HolaMundoServ/CarritoCompraServlet 
			 out.println("<table >");
					out.println("	<tr>");
					out.println("<td >Seleccione el artículo que desea:</td>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>");
					out.println("<select name='producto' size='1'>");
					out.println("<option value='010'>Manzana</option>");
			        out.println("<option value='145'>Pera</option>");
					out.println("<option value='254'>Platano</option>");
					out.println("<option value='355'>Cebolla</option>");
					out.println("<option value='456'>Sandia</option>");
					out.println("<option value='557'>Melón</option>");
					out.println("<option value='658'>Cerezas</option>");
					out.println("<option value='759'>Mango</option>");
					out.println("<option value='860'>Tomate</option>");
					out.println("<option value='961'>Zanahoria</option>");
					out.println("</select>");
		            out.println("</td>");
				    out.println("</tr>");
				    out.println("<tr>");
					out.println("<td >");
					out.println("<input type='submit' value='añadir al carrito...'>");
					out.println("</td>");
					out.println("</tr>");
			out.println("</table>");
			
			
			//Comprobamos si existe el objeto "carrito" en sesión.
			//Si no existe, lo creamos vacío. Será de tipo HashMap
			@SuppressWarnings("unchecked")
			HashMap<String,Integer> carrito =
			 (HashMap<String,Integer>)request.getSession().getAttribute("carrito");
			if ( carrito == null ) {
			 carrito = new HashMap<String, Integer>();
			}

			
			//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
			String producto = request.getParameter("producto");
			if ( producto != null ){
				 Integer cantidad = (Integer) carrito.get(producto);
				 	if ( cantidad == null )
				 		cantidad = new Integer ( 1 );
		            else
				 		cantidad = new Integer ( cantidad.intValue() + 1 );
				    //Y añadimos el producto al carrito
				    carrito.put(producto, cantidad);
			}
			
			//Añadimos el carrito a la sesión
			request.getSession().setAttribute("carrito",carrito);
			
			Set<String> productos = carrito.keySet();
	 		Iterator<String> iter = productos.iterator();
	 		while ( iter.hasNext() ) {
	 			String elemento = (String)iter.next();
	 
	 			//out.println("<br>Del producto <elemento%> , <(Integer)carrito.get(elemento)%> unidades."); 
	 			out.println("<br>Del producto " + elemento + " , " + (Integer) carrito.get(elemento) + " unidades.");
	 		
	 		}
	 		
	 		
	 		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
