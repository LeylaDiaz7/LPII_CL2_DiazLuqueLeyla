package tests;

import java.util.List;

import dao.ClassProductoImp;
import model.TblProductocl2;

public class TestEntidadProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Instanciar
		ClassProductoImp crudProd = new ClassProductoImp();

		TblProductocl2 prodPrueba = new TblProductocl2();

		// 1. CREAR PRODUCTO
		/*
		prodPrueba.setNombrecl2("PAPEL");
		prodPrueba.setPrecioventacl2(20);
		prodPrueba.setPreciocompcl2(30);
		prodPrueba.setEstadocl2("Activo");
		prodPrueba.setDescripcl2("Papelito suave");
		
		crudProd.RegistrarProducto(prodPrueba);
		*/
		
		// 2.- LISTAR PRODUCTOS

		// invocamos al método listado de productos
		
		List<TblProductocl2> listadoProductos = crudProd.ListadoProducto();

		// aplicamos un bucle for..
		for (TblProductocl2 listar : listadoProductos) {

			// Imprimimos los datos por pantalla
			System.out.println("ID: " + listar.getIdproductocl2() + "\nNombre: " + listar.getNombrecl2() + "\nPrecio venta: "
					+ listar.getPrecioventacl2() + "\nPrecio compra: " + listar.getPreciocompcl2() + "\nEstado: "
					+ listar.getEstadocl2() + "\nDescripción: " + listar.getDescripcl2()
					+ "\n***************************");
		}

	}

}
