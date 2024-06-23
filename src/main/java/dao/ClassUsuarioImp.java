package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import interfaces.Iusuario;
import model.TblUsuariocl2;

public class ClassUsuarioImp implements Iusuario {

	@Override
	public TblUsuariocl2 Autenticar(String usuario, String password) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_DiazLuqueLeyla");
		EntityManager em = emf.createEntityManager();
		TblUsuariocl2 user = null;

		try {
			em.getTransaction().begin();
			user = em
					.createQuery(
							"SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :usuario AND u.passwordcl2 = :password",
							TblUsuariocl2.class)
					.setParameter("usuario", usuario).setParameter("password", password).getSingleResult();
			em.getTransaction().commit();
		} catch (NoResultException e) {
			user = null;
		} finally {
			em.close();
		}

		return user;
	}
}
