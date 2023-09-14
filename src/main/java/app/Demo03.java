package app;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	// actualiza los datos de un Usuario
	public static void main(String[] args) {
	//llamar a la conexión 
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");

		//crear un manejador de las entidades
		
		EntityManager manager = fabrica.createEntityManager();
		
		//objeto a modificar 
		Usuario u = new Usuario();
		
		
		//si queremos registrar, actualizar o eliminar 
		try {
			
			u=  manager.find(Usuario.class, 1);
			
			if (u== null) {
				System.out.println("Usuario no existe");
		} else {
			System.out.println(u);
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error:" + e.getCause().getMessage());
		}
		
		manager.close();
	
	}
}
