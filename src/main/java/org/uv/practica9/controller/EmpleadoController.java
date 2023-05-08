/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.practica9.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/")
public class EmpleadoController {
    @Autowired
    private RepositoryEmpleado repositoryEmpleado;

    @GetMapping("/msg")
    public String holamundo() {
        return "Hola Mundo";
    }

    @GetMapping("/empleado")
    public DTOEmpleado obtenerEmpleado() {
        DTOEmpleado emp = new DTOEmpleado();
        emp.setClave(9);
        emp.setNombre("Yahir");
        emp.setDireccion("Av. 1");
        emp.setTelefono("273");
        return emp;
    }

    @GetMapping("/empleado/{id}")
    public DTOEmpleado obtenerEmpleado(@PathVariable("id") long id) {
        DTOEmpleado emp = null;
        if (id == 10) {
            emp = new DTOEmpleado();
            emp.setClave(10);
            emp.setNombre("Jssus");
            emp.setDireccion("Av. 10");
            emp.setTelefono("273");
        }
        return emp;
    }

    @GetMapping("/empleados")
    public List<DTOEmpleado> obtenerTodosLosEmpleado() {
        List<DTOEmpleado> lstEmpleados = new ArrayList<>();
        DTOEmpleado emp1 = new DTOEmpleado();
        emp1.setClave(10);
        emp1.setNombre("Yahir");
        emp1.setDireccion("Av. 1");
        emp1.setTelefono("273");
        lstEmpleados.add(emp1);

        DTOEmpleado emp2 = new DTOEmpleado();
        emp2.setClave(12);
        emp2.setNombre("Luis");
        emp2.setDireccion("Av. 8");
        emp2.setTelefono("272");
        lstEmpleados.add(emp2);

        return lstEmpleados;
    }

    //guardarregistro
    @PostMapping("/crearempleados")
    public DTOEmpleado createEmpleado(@RequestBody DTOEmpleado empleadoDTO) {
        Empleado empleadopojo = new Empleado();
        empleadopojo.setNombre(empleadoDTO.getNombre());
        empleadopojo.setDireccion(empleadoDTO.getDireccion());
        empleadopojo.setTelefono(empleadoDTO.getTelefono());

        Empleado empleadopojoNew = repositoryEmpleado.save(empleadopojo);

        DTOEmpleado empleadoDTONew = new DTOEmpleado();
        empleadoDTONew.setClave(empleadopojoNew.getId());
        empleadoDTONew.setNombre(empleadopojoNew.getNombre());
        empleadoDTONew.setDireccion(empleadopojoNew.getDireccion());
        empleadoDTONew.setTelefono(empleadopojoNew.getTelefono());
        return empleadoDTONew;
    }

    //update
    @PutMapping("/modificarempleados/{id}")
    public DTOEmpleado modificarEmpleado(@PathVariable("id") Long id,
            @RequestBody DTOEmpleado empleado) {

        return empleado;

    }

    //delete
    @DeleteMapping("/borarempleados")
    public void borrarEmpleado(@PathVariable("id") Long id) {
        return ;
    }
}
