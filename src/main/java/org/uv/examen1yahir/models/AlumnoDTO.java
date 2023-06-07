/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1yahir.models;

/**
 *
 * @author yacruz
 */
public class AlumnoDTO {
    private int clave_Alumno;
    private String nombre_alumno;
    private String direccion_alumno;
    private String telefono_alumno;
    private Grupo grupo;

    public int getClave_Alumno() {
        return clave_Alumno;
    }

    public void setClave_Alumno(int clave_Alumno) {
        this.clave_Alumno = clave_Alumno;
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
