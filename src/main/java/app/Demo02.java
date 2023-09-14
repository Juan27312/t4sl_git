package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	// actualiza los datos de un Usuario
	public static void main(String[] args) {
	//llamar a la conexión 
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");

		//crear un manejador de las entidades
		
		EntityManager manager = fabrica.createEntityManager();
		
		//objeto a modificar 
		Usuario u = new Usuario();
		u.setCod_usua(3);
		u.setNom_usua("Zoila");
		u.setApe_usua("Toro");
		u.setUsr_usua("ztoro@mail.com");
		u.setCla_usua("23422");
		u.setFna_usua("1990/08/13");
		u.setIdtipo(1);
		u.setEst_usua(1);
		
		//si queremos registrar, actualizar o eliminar 
		try {
			manager.getTransaction().begin();
			manager.merge(u);
			manager.getTransaction().commit();
			System.out.println("Actualizacion Ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error:" + e.getCause().getMessage());
		}
		
		manager.close();
		
	}
}
