package pe.edu.upeu.apirest.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.apirest.model.Producto;
import pe.edu.upeu.apirest.repository.ProductoRepository;
import pe.edu.upeu.apirest.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{
	@Autowired
    ProductoRepository productoRepository;

    public List<Producto> listar(){
        return productoRepository.findAll();
    }
    public Producto create(Producto producto){
        return productoRepository.save(producto);
    }
    public Optional<Producto> readID(long idproducto){
        return productoRepository.findById(idproducto);        
    }
    public Producto edit(Producto producto){       
        return productoRepository.save(producto);
    }
    public void deleteUser(long idproducto){
        productoRepository.deleteById(idproducto);
    }
}
