package com.miproyecto.agendatelefonica.service;

import com.miproyecto.agendatelefonica.model.Contacto;

import java.util.*;

public class Agenda {
    private Set<Contacto> contactos;
    private int maxSize;

    public Agenda() {
        this(10);  // tamaño por defecto
    }

    public Agenda(int maxSize) {
        this.maxSize = maxSize;
        this.contactos = new HashSet<>(maxSize);
    }


    public void agregarContacto(){
        Scanner scanner = new Scanner(System.in);
        Contacto contactoC = new Contacto();

        System.out.println("Ingresa el nombre de tu contacto:");
        contactoC.setNombre(scanner.nextLine());

        System.out.println("Ingresa el apellido de tu contacto:");
        contactoC.setApellido(scanner.nextLine());

        System.out.println("Ingresa el número de teléfono:");
        contactoC.setTelefono(scanner.nextInt());

        // Si están vacios
        if (contactoC.getNombre().isEmpty() || contactoC.getApellido().isEmpty()) {
            System.out.println("⚠️Error: El nombre y apellido no pueden estar vacíos.");
            return;
        }

        // Verificar si ya existe
        if (contactos.contains(contactoC)) {
            System.out.println("❌El contacto ya existe en la agenda.");
            return;
        }

        // Verificacion si hay espacio
        if (contactos.size() >= maxSize) {
            System.out.println("❌La agenda está llena. No se pueden agregar más contactos.");
            return;
        }

        // Agregar contacto nuevo a la lista
        contactos.add(contactoC);
        System.out.println("✅Contacto agregado exitosamente.");
    }

    public void existeContacto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del contacto:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Ingresa el apellido del contacto:");
        String apellido = scanner.nextLine().trim();

        boolean existe = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("✅ El contacto sí existe en la agenda.");
        } else {
            System.out.println("❌ El contacto no se encuentra en la agenda.");
        }
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        List<Contacto> listaOrdenada = new ArrayList<>(contactos);

        // Ordenar por nombre y apellido (ignorando mayúsculas)
        listaOrdenada.sort((c1, c2) -> {
            int comparacionNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
            if (comparacionNombre != 0) {
                return comparacionNombre;
            }
            return c1.getApellido().compareToIgnoreCase(c2.getApellido());
        });

        // Mostrar los contactos
        for (Contacto c : listaOrdenada) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
    }

    public void buscaContacto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del contacto que deseas buscar:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Ingresa el apellido del contacto:");
        String apellido = scanner.nextLine().trim();

        boolean busqueda = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("📱Teléfono de " + nombre + " " + apellido + ": " + c.getTelefono());
                busqueda = true;
                break;
            }
        }
        if (!busqueda) {
            System.out.println("❌Contacto no encontrado.");
        }
    }


}
