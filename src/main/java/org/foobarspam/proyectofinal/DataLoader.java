package org.foobarspam.proyectofinal;

import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.service.carrera.CarreraService;
import org.foobarspam.proyectofinal.service.carrera.CarreraServiceImpl;
import org.foobarspam.proyectofinal.service.conductor.ConductorService;
import org.foobarspam.proyectofinal.service.conductor.ConductorServiceImpl;
import org.foobarspam.proyectofinal.service.valoracion.ValoracionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by palliser on 27/05/2017.
 * Creamos tres conductores, les añade una valoración de 4 por defecto y los guarda en la db.
 */
@Component
public class DataLoader {

	private CarreraService carreraService;

	private ConductorService conductorService;

	private ValoracionServiceImpl valoracionService;

	@Autowired
	public DataLoader(ConductorServiceImpl conductorService, CarreraServiceImpl carreraService, ValoracionServiceImpl valoracionService) {

		this.conductorService = conductorService;
		this.carreraService = carreraService;
		this.valoracionService = valoracionService;

	}

	@PostConstruct
	public void setUp() {

		// Creamos los conductores
		conductorService.guardarConductor(new Conductor("Mariano", "BE-343561", "Range Rover", "./img/conductores/mariano.png", "./img/coches/coche.png"));
		conductorService.guardarConductor(new Conductor("Victor", "CA-780429", "Audi A6", "./img/conductores/victor.png", "./img/coches/A6.png"));
		conductorService.guardarConductor(new Conductor("David", "AB-240459", "Hummer", "./img/conductores/david.png", "./img/coches/hummer.png"));
		conductorService.guardarConductor(new Conductor("MrMeeseeks", "AA-000000", "Magic Box", "./img/conductores/mrmeeseeks.jpg", "./img/coches/Meeseeks_box.png"));

		// valoracion por defecto 4

		valoracionService.guardarValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(1))));
		valoracionService.guardarValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(2))));
		valoracionService.guardarValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(3))));
		valoracionService.guardarValoracion(new Valoracion(4, conductorService.getConductores().findOne(new Long(4))));

	}
}
