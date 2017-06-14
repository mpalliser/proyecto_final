package org.foobarspam.proyectofinal.service.conductor;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by palliser on 28/05/2017.
 */
@Service
public class ConductorServiceImpl implements ConductorService {

	ConductorRepository conductores;

	public ConductorServiceImpl() {
	}

	public ConductorRepository getConductores() {
		return conductores;
	}

	@Autowired
	public void setConductores(ConductorRepository conductores) {
		this.conductores = conductores;
	}

	@Override
	public Conductor asignarConductor() {

		List<Conductor> conductoresLibres = conductores.findAllByOcupado(false);

		int conductorAleatorio = ThreadLocalRandom.current().nextInt(conductoresLibres.size());

		return conductoresLibres.get(conductorAleatorio);
	}

	@Override
	public void guardarConductor(Conductor conductor){
		conductores.save(conductor);
	}

}
