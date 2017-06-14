package org.foobarspam.proyectofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by palliser on 27/05/2017.
 */
@Entity
public class Valoracion {

	@Id
	@GeneratedValue
	@Column(name = "VALORACION_ID", nullable = false)
	private Long id;

	@Column(name = "VALORACION", nullable = false)
	private double valoracion;

	@ManyToOne
	@JoinColumn(name = "CONDUCTOR_ID", nullable = false)
	private Conductor conductor;

	//necesario JPA
	public Valoracion() {
	}

	public Valoracion(double valoracion, Conductor conductor) {

		this.valoracion = valoracion;
		this.conductor = conductor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

}

