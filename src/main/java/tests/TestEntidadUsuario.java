package tests;

import dao.ClassUsuarioImp;
import model.TblUsuariocl2;

public class TestEntidadUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instanciar el DAO
        ClassUsuarioImp usuarioDao = new ClassUsuarioImp();

        // Datos de prueba
        String usuarioExistente = "brunito";
        String passwordCorrecto = "brunis123";

        TblUsuariocl2 usuarioAutenticado = usuarioDao.Autenticar(usuarioExistente, passwordCorrecto);
        if (usuarioAutenticado != null) {
            System.out.println("Autenticación exitosa para usuario");
        } else {
            System.out.println("No se pudo autenticar con las credenciales proporcionadas.");
        }
        
	}

}
