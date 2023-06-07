/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1yahir.models;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author yacruz
 */
@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="clave_grupo")
    private int clave_grupo;
    
    @Column(name="nombre_grupo")
    private String nombre_grupo;
    
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private Set<Alumno> alumnos = new HashSet<>();

    public Grupo() {
    }

    public Grupo(GrupoDTO grupo) {
        this.clave_grupo = grupo.getIdDTO();
        this.nombre_grupo = grupo.getNombreDTO();
    }

    public int getClave_grupo() {
        return clave_grupo;
    }

    public void setClave_grupo(int clave_grupo) {
        this.clave_grupo = clave_grupo;
    }

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
        for(Alumno alumno: alumnos){
            alumno.setGrupo(this);
        }
    }
}
