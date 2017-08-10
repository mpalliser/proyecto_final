package org.foobarspam.proyectofinal.service.carrera;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.repository.CarreraRepository;
import org.foobarspam.proyectofinal.service.tarifa.TarifaService;

public interface CarreraService {

	void asignarConductor();

	void calcularCoste();
	
	void guardarCarrera();

	void liberarConductor();

	Conductor getConductor();

	Carrera getCarrera();

	void setDistancia(double distancia);

	void setTiempo(double tiempo);

	void setCarrera(Carrera carrera);

	CarreraRepository getCarreras();

	TarifaService getTarifaService();

	double valoracionMedia();

	Long conductorActualID();

	void inyectarDistanciaTiempo();

	void transformarDistancia();

	void transformarTiempo();

	}
