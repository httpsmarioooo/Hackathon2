package com.miproyecto.agendatelefonica.app;

import com.miproyecto.agendatelefonica.service.Agenda;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Agenda1: añadirContacto(Contacto c), existeContacto(Contacto c), listarContacto(), buscarContacto(String nombre)
        //Agenda2: eliminarContacto(Contacto c), modificarTelefono(String nombre, String apellido, String nuevoTelefono), agendaLlena(), espacioLibres()
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;

        System.out.println("BIENVENIDO A TU AGENDA TELEFÓNICA 📒");

        do{
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir nuevo contacto");
            System.out.println("2. ¿Existe este contacto?");
            System.out.println("3. Buscar un contacto");
            System.out.println("4. Eliminar un contacto");
            System.out.println("5. Modificar teléfono de contacto");
            System.out.println("6. Mostrar lista de contactos");
            System.out.println("7. ¿La agenda esta llena?");
            System.out.println("8. Espacios disponibles en la agenda");
            System.out.println("9. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    agenda.agregarContacto();
                    break;
                case 2:
                    agenda.existeContacto();
                    break;
                case 3:
                    agenda.buscaContacto();
                    break;
                case 4:
                    agenda.eliminarContacto();
                    break;
                case 5:
                    agenda.modificarTelefono();
                    break;
                case 6:
                    agenda.listarContactos();
                    break;
                case 7:
                    agenda.agendaLlena();
                    break;
                case 8:
                    agenda.espaciosLibres();
                    break;
                case 9:
                    System.out.println( "!Hasta luego! 😊");
                    break;
                default:
                    System.out.println("❌ Opción invalida. Intenta nuevamente.");
            }
        }while(opcion != 9);
        scanner.close();
    }
}