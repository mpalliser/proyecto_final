package org.foobarspam.proyectofinal.model;

import javax.persistence.*;

/**
 * Created by palliser on 27/05/2017.
 */
@Entity
public class Carrera {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "ORIGEN", nullable = false)
	private String origen;

	@Column(name = "DESTINO", nullable = false)
	private String destino;

	@Column(name = "METODO_PAGO")
	private String modoPago;

	@Column(name = "COSTE")
	private double coste;

	@Column(name = "PROPINA")
	private double propina;

	@Column(name = "DISTANCIA")
	private double distancia;

	@Column(name = "TIEMPO")
	private double minutos;

	private String tiempoInicial;

	private String distanciaInicial;

	@ManyToOne
	@JoinColumn(name = "CONDUCTOR_ID")
	private Conductor conductor;

	@Column(name = "VALORACION", nullable = false)
	private double valoracion;

	public Carrera() {
	}

	public Carrera(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getModoPago() {
		return modoPago;
	}

	public void setModoPago(String modoPago) {
		this.modoPago = modoPago;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public double getPropina() {
		return propina;
	}

	public void setPropina(double propina) {
		this.propina = propina;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getMinutos() {
		return minutos;
	}

	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	public String getTiempoInicial() {
		return tiempoInicial;
	}

	public String getDistanciaInicial() {
		return distanciaInicial;
	}

	public void setTiempoInicial(String tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}

	public void setDistanciaInicial(String distanciaInicial) {
		this.distanciaInicial = distanciaInicial;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
}
