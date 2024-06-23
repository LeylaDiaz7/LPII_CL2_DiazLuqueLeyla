package interfaces;

import java.util.List;

import model.TblProductocl2;

public interface Iproducto {

	// Declarar métodos para el CRUD de productos
		public void RegistrarProducto(TblProductocl2 producto);

		//public void ActualizarProducto(TblProductocl2 producto);

		// public void EliminarProducto(TblProductocl2 producto);

		//public TblProductocl2 BuscarProducto(TblProductocl2 producto);

		public List<TblProductocl2> ListadoProducto();
		
}
