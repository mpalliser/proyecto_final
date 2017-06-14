package org.foobarspam.proyectofinal.repository;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by palliser on 27/05/2017.
 */
@Repository
public interface ValoracionRepository extends CrudRepository<Valoracion, Long> {

	List<Valoracion> findAllByConductor(Conductor conductor);

}
