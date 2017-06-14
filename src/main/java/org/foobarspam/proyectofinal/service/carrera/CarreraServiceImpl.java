package org.foobarspam.proyectofinal.service.carrera;

import org.foobarspam.proyectofinal.model.Carrera;
import org.foobarspam.proyectofinal.model.Conductor;
import org.foobarspam.proyectofinal.model.Valoracion;
import org.foobarspam.proyectofinal.repository.CarreraRepository;
import org.foobarspam.proyectofinal.service.conductor.ConductorService;
import org.foobarspam.proyectofinal.service.conductor.ConductorServiceImpl;
import org.foobarspam.proyectofinal.service.tarifa.TarifaService;
import org.foobarspam.proyectofinal.service.valoracion.ValoracionService;
import org.foobarspam.proyectofinal.service.valoracion.ValoracionServiceImpl;
import org.foobarspam.proyectofinal.service.tarifa.TarifaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by palliser on 27/05/2017.
 */
@Service
public class CarreraServiceImpl implements CarreraService {

	private ConductorService conductorService;

	private CarreraRepository carreras;

	private ValoracionService valoracionService;

	private Carrera carrera;

	private TarifaService tarifaServiceImpl;

	@Autowired
	public CarreraServiceImpl(ConductorServiceImpl conductorService, ValoracionServiceImpl valoracionService, TarifaServiceImpl tarifaServiceImpl) {

		this.conductorService = conductorService;
		this.valoracionService = valoracionService;
		this.tarifaServiceImpl = tarifaServiceImpl;
	}

	public ValoracionService getValoracionService() {
		return valoracionService;
	}

	public void setValoracionService(ValoracionService valoracionService) {
		this.valoracionService = valoracionService;
	}

	public CarreraRepository getCarreras() {
		return carreras;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	@Autowired
	public void setCarreras(CarreraRepository carreras) {
		this.carreras = carreras;
	}

	public TarifaService getTarifaService() {
		return this.tarifaServiceImpl;
	}

	public Long conductorActualID() {
		return this.carrera.getConductor().getId();
	}
	
	public void setDistancia(double distancia) {
		this.tarifaServiceImpl.setDistancia(distancia);
	}
	
	public void setTiempo(double minutos) {
		this.tarifaServiceImpl.setMinutos(minutos);
	}

	public Conductor getConductor() {
		return this.carrera.getConductor();
	}

	@Override
	public void guardarCarrera() {
		this.carreras.save(this.carrera);
	}

	@Override
	public synchronized void asignarConductor() {

		//TODO: añadir try catch para gestionar si no existen conductores libres
		carrera.setConductor(conductorService.asignarConductor());
		carrera.getConductor().setOcupado(true);
		conductorService.guardarConductor(carrera.getConductor());
	}

	@Override
	public void calcularCoste() {

		getCarrera().setCoste(tarifaServiceImpl.getCosteTarifa());

	}

	public void liberarConductor(){

		getConductor().setOcupado(false);
		conductorService.guardarConductor(this.getConductor());
	}

	public double valoracionMedia() {

		double valoracionMedia = 0.0d;

		for (Valoracion valoracion : valoracionService.getValoraciones().findAllByConductor(this.getConductor())) {
			valoracionMedia += valoracion.getValoracion();
		}

		valoracionMedia = valoracionMedia / valoracionService.getValoraciones().findAllByConductor(this.getConductor()).size();

		valoracionMedia = Math.round(valoracionMedia * 100);
		valoracionMedia = valoracionMedia/100;

		return valoracionMedia ;

	}

	public void transformarDistancia() {

		String distanciaFinal = "";

		for(int i = 0; i< getCarrera().getDistanciaInicial().length(); i++) {
			if(Character.isDigit(getCarrera().getDistanciaInicial().charAt(i))) {
				distanciaFinal += getCarrera().getDistanciaInicial().charAt(i);
			}else if(Character.toString(getCarrera().getDistanciaInicial().charAt(i)).matches("[,]")) {
				distanciaFinal += ".";
			}
		}

		setDistancia(Double.parseDouble(distanciaFinal));
	}

	public void transformarTiempo() {

		String tiempoFinal = "";

		if( !getCarrera().getTiempoInicial().contains("h")){

			for(int i = 0; i< getCarrera().getTiempoInicial().length(); i++) {
				if(Character.isDigit(getCarrera().getTiempoInicial().charAt(i))) {

					tiempoFinal += getCarrera().getTiempoInicial().charAt(i);
				}
			}

			setTiempo(Double.parseDouble(tiempoFinal));

		} else {

			double horas = 0.0d;
			String minutos = "";

			horas =  Double.valueOf(String.valueOf(getCarrera().getTiempoInicial().charAt(0))) * 60 ;

			for(int i = 1; i< getCarrera().getTiempoInicial().length(); i++) {
				if(Character.isDigit(getCarrera().getTiempoInicial().charAt(i))) {

					minutos += getCarrera().getTiempoInicial().charAt(i);
				}
			}

			setTiempo(horas + Double.parseDouble(minutos));

		}


	}

	public void inyectarDistanciaTiempo() {

		getCarrera().setDistancia(tarifaServiceImpl.getDistancia());
		getCarrera().setMinutos(tarifaServiceImpl.getMinutos());
	}

}