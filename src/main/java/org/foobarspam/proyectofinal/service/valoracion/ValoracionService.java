package org.foobarspam.proyectofinal.service.valoracion;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.ValoracionRepository;

import java.util.List;

/**
 * Created by palliser on 29/05/2017.
 */
public interface ValoracionService {

	ValoracionRepository getValoraciones();

	List<Valoracion> findAllByConductor(Conductor conductor);

	void guardarValoracion(Valoracion valoracion);

}
