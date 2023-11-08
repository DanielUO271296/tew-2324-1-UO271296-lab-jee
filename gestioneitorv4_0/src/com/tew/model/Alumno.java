package com.tew.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name = "alumno")
public class Alumno implements Serializable {
	private Long id;
	private String nombre;
	private String apellidos;
	private String iduser;
	private String email;

	
	public Alumno() {
	 }
	 public Alumno(Long id, String nombre, String apellidos, String iduser, String email) {
	 this.id = id; this.nombre = nombre; this.apellidos = apellidos;
	 this.iduser = iduser; this.email = email;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@XmlElement
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
