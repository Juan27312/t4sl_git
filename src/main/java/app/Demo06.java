package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;


public class Demo06 {

	// actualiza los datos de un Usuario
	public static void main(String[] args) {
	//llamar a la conexión 
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager manager = fabrica.createEntityManager();
		
		
		//select * from tb xxxxxx 
		String sql = "select p from Productos p";
		List<Productos> lsProductos = manager.createQuery(sql, Productos.class).getResultList();
		
		//	recorre el listado y lo muestra
		
		for(Productos p : lsProductos) {
			
			System.out.println("Codigo.....................:" + p.getId_prod());
			System.out.println("Descuento.................." + p.getDes_prod());
			System.out.println("Stock......................" + p.getStk_prod());
			System.out.println("Precio....................:" + p.getPre_prod());
			System.out.println("Categoria..............:" + p.getIdcategoria());
			System.out.println("Estado....................:" + p.getEst_prod());
			System.out.println("_Id Proveedor..........:" + p.getIdproveedor());
			System.out.println("---------------------------------");
			
		}
		
	
		manager.close();
	
	}
}
