package com.cibertec.ricaldi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cli")
	private int id;
	
	@Column(name = "nom_cli")
	@NotEmpty(message = "Campo obligatorio.")
	@Size(min = 2, max = 45)
	private String nombre;
	
	@Column(name = "ape_cli")
	@NotEmpty(message = "Campo obligatorio.")
	@Size(min = 2, max = 45)
	private String apellido;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fec_nac_cli")
	@NotNull(message = "Campo obligatorio.")
	private Date fecNacimiento;
	
	@Column(name = "tlf_cli")
	@Size(min = 9, max = 9, message = "Debe ser un teléfono de 9 dígitos.")
	private String telefono;
	
	@Column(name = "email_cli")
	@NotEmpty(message = "Campo obligatorio.")
	@Email(message = "Deber ser un email con formato válido.")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_ciu")
	@NotNull(message = "Campo obligatorio.")
	private Ciudad ciudad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecNacimiento() {
		return fecNacimiento;
	}

	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecNacimiento="
				+ fecNacimiento + ", telefono=" + telefono + ", email=" + email + ", ciudad=" + ciudad + "]";
	}

}
