package org.foobarspam.proyectofinal.repository;

import org.foobarspam.proyectofinal.model.Carrera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by palliser on 27/05/2017.
 */
@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {
}
