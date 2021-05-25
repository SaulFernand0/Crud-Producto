package pe.edu.upeu.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.apirest.service.ProductoService;
import pe.edu.upeu.apirest.model.Producto;

@RestController
public class ProductoController {
	
	   @Autowired
	    ProductoService productoService;
	   
	   @GetMapping("/")
	    public String hola(){
	        return "Bienvenido";
	    }
	   
	   @GetMapping("/listar")
	    public ResponseEntity<List<Producto>> readAll(){
	    	List<Producto> productos = new ArrayList<Producto>();
	        try {
	        	productos = productoService.listar();
	        	if(productos.isEmpty())
	        		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        	return new ResponseEntity<>(productos,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}
	    }
	   
	   @PostMapping("/create")
	    public ResponseEntity<Producto> createUser(@Valid @RequestBody Producto producto){
	    	try {
	    		Producto prod = productoService.create(producto);
				return new ResponseEntity<>(prod, HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}        
	    }
	   
	   @GetMapping("/usuarios/{id}")
	    public ResponseEntity<Producto> getUser(@PathVariable long id){
	        Optional<Producto> optional = productoService.readID(id);
	        if(optional.isPresent()) {
	        	return new ResponseEntity<>(optional.get(), HttpStatus.OK);
	        }else {
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }    	
	    }
	   
	   @PutMapping("/usuarios/{id}")
	    public ResponseEntity<Producto> updateUser(@PathVariable("id") long id, @RequestBody Producto producto){
	    	Optional<Producto> optional = productoService.readID(id);
	    	if(optional.isPresent()) {
	    		Producto prod = optional.get();
	    		prod.setNombre(producto.getNombre());
	    		prod.setPrecio(producto.getPrecio());
	    		prod.setStock(producto.getStock());
	    		return new ResponseEntity<>(productoService.create(prod),HttpStatus.OK);
	    	}else {
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);    		 
	    	}    	
	    }
	   
	   @DeleteMapping("/usuario/eliminar/{id}")
	    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(value = "id") long id){
	    	try {
				productoService.deleteUser(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
			}        
	    }
}
