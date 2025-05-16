package com.miproyecto.agendatelefonica.service;

import com.miproyecto.agendatelefonica.model.Contacto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Agenda2 {


    public boolean eliminarContacto(Contacto c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado correctamente.");
            return true;
        } else {
            System.out.println("Contacto no encontrado.");
            return false;
        }
    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public boolean agendaLlena() {
        return contactos.size() >= capacidadMaxima;
    }

    public int espaciosLibres() {
        return capacidadMaxima - contactos.size();
    }
}
