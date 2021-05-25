package pe.edu.upeu.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upeu.apirest.model.Producto;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto,Long>{

}
