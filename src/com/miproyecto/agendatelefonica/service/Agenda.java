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

    public Set<Contacto> getContactos() {
        return contactos;
    }

    public int getMaxSize() {
        return maxSize;
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
        if (agendaLlena()) {
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

    public void eliminarContacto() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del contacto que deseas eliminar:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Ingresa el apellido del contacto:");
        String apellido = scanner.nextLine().trim();

        // Creamos un objeto Contacto solo con nombre y apellido
        Contacto contactoC = new Contacto();
        contactoC.setNombre(nombre);
        contactoC.setApellido(apellido);

        if (contactos.remove(contactoC)) {
            System.out.println("✅ Contacto eliminado exitosamente.");
        } else {
            System.out.println("❌ No se encontró un contacto con ese nombre y apellido.");
        }
    }

    public void modificarTelefono() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el nombre del contacto a modificar:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Ingresa el apellido del contacto:");
        String apellido = scanner.nextLine().trim();

        boolean encontrado = false;

        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {

                System.out.println("Ingresa el nuevo número de teléfono:");
                int nuevoTelefono = scanner.nextInt();

                c.setTelefono(nuevoTelefono);
                System.out.println("✅ Teléfono actualizado exitosamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("❌ Contacto no encontrado.");
        }
    }

    public boolean agendaLlena() {
        boolean llena = contactos.size() >= maxSize;

        if (llena) {
            System.out.println("📕 La agenda está llena. No hay espacio disponible para nuevos contactos.");
        } else {
            System.out.println("📗 La agenda todavía tiene espacio disponible.");
        }
        return llena;

    }

    public void espaciosLibres() {
        int disponibles = maxSize - contactos.size();

        if (disponibles == 0) {
            System.out.println("📕 No hay espacio disponible. La agenda está llena.");
        } else {
            System.out.println("📗 Quedan " + disponibles + " espacio(s) disponible(s) en la agenda.");
        }
    }

    // Nuevo método para agregar contacto desde la UI
    public boolean agregarContactoDesdeUI(Contacto contactoC) {
        if (contactoC.getNombre().isEmpty() || contactoC.getApellido().isEmpty()) return false;
        if (contactos.contains(contactoC)) return false;
        if (agendaLlena()) return false;

        contactos.add(contactoC);
        return true;
    }

    // Nuevo método para buscar contacto
    public Contacto buscarContacto(String nombre, String apellido) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                return c;
            }
        }
        return null;
    }

    // Nuevo método para eliminar contacto desde la UI
    public boolean eliminarContacto(String nombre, String apellido) {
        Contacto c = new Contacto();
        c.setNombre(nombre);
        c.setApellido(apellido);
        return contactos.remove(c);
    }

    // Nuevo método para modificar teléfono desde la UI
    public boolean modificarTelefono(String nombre, String apellido, int nuevoTelefono) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                return true;
            }
        }
        return false;
    }




}
