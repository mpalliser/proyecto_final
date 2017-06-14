package org.foobarspam.proyectofinal.service.valoracion;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by palliser on 27/05/2017.
 */
@Service
public class ValoracionServiceImpl implements ValoracionService {

	@Autowired
	private ValoracionRepository valoraciones;

	public ValoracionServiceImpl() {
	}

	public ValoracionRepository getValoraciones() {
		return valoraciones;
	}

	@Autowired
	public void setValoraciones(ValoracionRepository valoraciones) {
		this.valoraciones = valoraciones;
	}

	public void guardarValoracion(Valoracion valoracion) {
		this.valoraciones.save(valoracion);
	}

	public List<Valoracion> findAllByConductor(Conductor conductor) {

		return this.valoraciones.findAllByConductor(conductor);
	}

}
