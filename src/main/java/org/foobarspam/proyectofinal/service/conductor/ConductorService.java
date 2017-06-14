package org.foobarspam.proyectofinal.service.conductor;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.repository.ConductorRepository;

/**
 * Created by palliser on 29/05/2017.
 */
public interface ConductorService {

	Conductor asignarConductor();

	void guardarConductor(Conductor conductor);

	ConductorRepository getConductores();

}
