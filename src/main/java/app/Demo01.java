package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	// registro de un nuevo Usuario usando valores fijos
	public static void main(String[] args) {
	//llamar a la conexión 
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");

		//crear un manejador de las entidades
		
		EntityManager manager = fabrica.createEntityManager();
		
		//objeto a grabar 
		Usuario u = new Usuario();
		u.setCod_usua(162);
		u.setNom_usua("Cristian");
		u.setApe_usua("Antonio");
		u.setUsr_usua("Crisitan");
		u.setCla_usua("987654321");
		u.setFna_usua("2006/03/20");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		//si queremos registrar, actualizar o eliminar 
		manager.getTransaction().begin();
		manager.persist(u);
		manager.getTransaction().commit();
		manager.close();
		
		System.out.println("Registro ok");
		
		
	}
}
