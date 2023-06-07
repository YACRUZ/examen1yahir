/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1yahir.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.ManyToOne;
/**
 *
 * @author yacruz
 */
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clave_alumno")
    private int clave_alumno;
    
    @Column(name="nombre_alumno")
    private String nombre_alumno;
    
    @Column(name="direccion_alumno")
    private String direccion_alumno;
    
    @Column(name="telefono_alumno")
    private String telefono_alumno;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Grupo grupo;

    public Alumno(AlumnoDTO alumno) {
        this.clave_alumno = alumno.getClave_Alumno();
        this.nombre_alumno = alumno.getNombre_alumno();
        this.telefono_alumno = alumno.getTelefono_alumno();
        this.direccion_alumno = alumno.getDireccion_alumno();
    }
    
    public Alumno() {
    }

    public int getClave_alumno() {
        return clave_alumno;
    }

    public void setClave_alumno(int clave_alumno) {
        this.clave_alumno = clave_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getDireccion_alumno() {
        return direccion_alumno;
    }

    public void setDireccion_alumno(String direccion_alumno) {
        this.direccion_alumno = direccion_alumno;
    }

    public String getTelefono_alumno() {
        return telefono_alumno;
    }

    public void setTelefono_alumno(String telefono_alumno) {
        this.telefono_alumno = telefono_alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
