package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassProductoImp;
import model.TblProductocl2;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TblProductocl2 producto = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();
		List<TblProductocl2> listadoProducto = crud.ListadoProducto();

		// invocamos el listado de productos para la vista

		request.setAttribute("listadoProductos", listadoProducto);

		// Redireccionamos

		request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recuperar valores del formulario
		String nombre = request.getParameter("nombre");
		String pVenta = request.getParameter("pv");
		String pCompra = request.getParameter("pc");
		String estado = request.getParameter("estado");
		String descrip = request.getParameter("descrip");

		// Instanciar entidades...
		TblProductocl2 product = new TblProductocl2();
		ClassProductoImp crud = new ClassProductoImp();

		// Asignar valores
		product.setNombrecl2(nombre);
		product.setPrecioventacl2(Double.parseDouble(pVenta));
		product.setPreciocompcl2(Double.parseDouble(pCompra));
		product.setEstadocl2(estado);
		product.setDescripcl2(descrip);

		crud.RegistrarProducto(product);

		List<TblProductocl2> listadoProductos = crud.ListadoProducto();
		request.setAttribute("listadoProductos", listadoProductos);
		request.getRequestDispatcher("/listaProductos.jsp").forward(request, response);

	}

}
