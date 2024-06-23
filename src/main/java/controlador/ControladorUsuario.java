package controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClassUsuarioImp;
import model.TblUsuariocl2;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("user");
        String password = request.getParameter("password");

        ClassUsuarioImp usuarioDao = new ClassUsuarioImp();
        TblUsuariocl2 user = usuarioDao.Autenticar(usuario, password);

        if (user != null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // Autenticación fallida, mostrar mensaje de error
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("/Logeo.jsp").forward(request, response);
        }
    }

}
