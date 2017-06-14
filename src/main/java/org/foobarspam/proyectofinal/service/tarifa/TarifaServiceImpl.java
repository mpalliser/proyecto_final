package org.foobarspam.proyectofinal.service.tarifa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * Created by palliser on 27/05/2017.
 */
@Service
public class TarifaServiceImpl implements TarifaService {

	@Value("${tarifa.costeMilla}")
	private double costeMilla;

	@Value("${tarifa.costeMinuto}")
	private double costeMinuto;

	@Value("${tarifa.costeMinimo}")
	private double costeMinimo;

	private double distancia;

	private double minutos;

	private double costeTarifa;

	public TarifaServiceImpl() {
	}

	public TarifaServiceImpl(double distancia, double minutos) {

		this.distancia = distancia;
		this.minutos = minutos;
	}

	@Override
	public double getCosteMilla() {
		return costeMilla;
	}

	@Override
	public void setCosteMilla(double COSTEMILLA) {
		this.costeMilla = COSTEMILLA;
	}

	@Override
	public double getCosteMinuto() {
		return costeMinuto;
	}

	@Override
	public void setCosteMinuto(double COSTEMINUTO) {
		this.costeMinuto = COSTEMINUTO;
	}

	@Override
	public double getCosteMinimo() {
		return costeMinimo;
	}

	@Override
	public void setCosteMinimo(double COSTEMINIMO) {
		this.costeMinimo = COSTEMINIMO;
	}

	@Override
	public double getDistancia() {
		return distancia;
	}

	@Override
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public double getMinutos() {
		return minutos;
	}

	@Override
	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	@Override
	public void setCosteTotal(double costeTotal) {
		this.costeTarifa = costeTotal;
	}

	@Override
	public double getCosteDistancia(double distancia){
		return distancia * costeMilla;
	}

	@Override
	public double getCosteTiempo(double minutos){
		return minutos * costeMinuto;
	}

	@Override
	public double getCosteTarifa(){

		costeTarifa = getCosteDistancia(distancia) + getCosteTiempo(minutos);

		if (costeTarifa > costeMinimo){
			costeTarifa = Math.round(costeTarifa * 100);
			costeTarifa = costeTarifa/100;
			return costeTarifa;
		}

		return costeMinimo;
	}
}
