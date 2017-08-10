package org.foobarspam.proyectofinal.repository;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by palliser on 27/05/2017.
 */
@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

	@Query(value = "SELECT CARRERA.VALORACION FROM CARRERA " +
			"WHERE CARRERA.CONDUCTOR_ID = ?1", nativeQuery = true)
	List<Double> findAllValoracionesById(Long conductorId);

}
