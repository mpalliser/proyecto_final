package org.foobarspam.proyectofinal.service.tarifa;

/**
 * Created by mariano.palliser on 31/05/2017.
 */
public interface TarifaService {
	double getCosteMilla();

	void setCosteMilla(double costeMilla);

	double getCosteMinuto();

	void setCosteMinuto(double costeMinuto);

	double getCosteMinimo();

	void setCosteMinimo(double costeMinimo);

	double getDistancia();

	void setDistancia(double distancia);

	double getMinutos();

	void setMinutos(double minutos);

	void setCosteTotal(double costeTotal);

	double getCosteDistancia(double distancia);

	double getCosteTiempo(double minutos);

	double getCosteTarifa();
}
