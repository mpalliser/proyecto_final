package org.foobarspam.proyectofinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by palliser on 27/05/2017.
 */

@Entity
public class Conductor {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "NOMBRE", nullable = false)
	private String nombre;

	@Column(name = "MATRICULA", nullable = false)
	private String matricula;

	@Column(name = "MODELO", nullable = false)
	private String modelo;

	@Column(name = "OCUPADO")
	private boolean ocupado = false;

	@Column(name = "MEDIA_VALORACIONES")
	private double mediaValoraciones;

	@Column(name = "FACE_IMG")
	private String faceImg;

	@Column(name = "CAR_IMG")
	private String carImg;

	@OneToMany
	private List<Carrera> carreras;

	//necesario JPA
	public Conductor() {
	}

	public Conductor(String nombre, String matricula, String modelo,
					 String faceImg, String carImg) {

		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.faceImg = faceImg;
		this.carImg = carImg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public List<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carrera> carreras) {
		this.carreras = carreras;
	}

	public double getMediaValoraciones() {
		return mediaValoraciones;
	}

	public void setMediaValoraciones(double mediaValoraciones) {
		this.mediaValoraciones = mediaValoraciones;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String getCarImg() {
		return carImg;
	}

	public void setCarImg(String carImg) {
		this.carImg = carImg;
	}

}
