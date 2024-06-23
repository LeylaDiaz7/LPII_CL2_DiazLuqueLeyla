package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Iproducto;
import model.TblProductocl2;

public class ClassProductoImp implements Iproducto {

	@Override
	public void RegistrarProducto(TblProductocl2 producto) {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_DiazLuqueLeyla");

		// Gestionar entidades
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion
		em.getTransaction().begin();

		// Registramos
		em.persist(producto);

		// Emitir mensaje por consola
		System.out.println("Producto fue registrado en la BD");

		// Confirmar
		em.getTransaction().commit();

		// Cerrar
		em.close();
	}

	@Override
	public List<TblProductocl2> ListadoProducto() {
		// Establecer la conexión con la unidad de persistencia
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_DiazLuqueLeyla");

		// Gestionar entidades
		EntityManager em = emf.createEntityManager();

		// Iniciamos la transaccion
		em.getTransaction().begin();

		/*
		 * Recuperamos el listado de productos de la base de datos aplicacmos consultas
		 * JPQL, el método createquery(): sirve para hacer consultas dinámicas.
		 */
		List<TblProductocl2> listado = em.createQuery("SELECT p FROM TblProductocl2 p", TblProductocl2.class)
				.getResultList();

		// Confirmamos
		em.getTransaction().commit();

		// Cerramos
		em.close();

		// Retornar lista de Productos
		return listado;
	}

}
