package pe.edu.upeu.apirest.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.apirest.model.Producto;

public interface ProductoService {
	public List<Producto> listar();
	public Producto create(Producto producto);
	public Optional<Producto> readID(long idproducto);
	public Producto edit(Producto producto);
	public void deleteUser(long idproducto);
}
