package com.miproyecto.agendatelefonica.controller;

import com.miproyecto.agendatelefonica.service.Agenda;
import com.miproyecto.agendatelefonica.model.Contacto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class PhoneController {

    private Agenda agenda = new Agenda();

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextArea resultadosArea;

    @FXML
    private void agregarContacto() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        String telefonoStr = telefonoField.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || telefonoStr.isEmpty()) {
            mostrarAlerta("Error", "Por favor completa todos los campos.");
            return;
        }

        int telefono;
        try {
            telefono = Integer.parseInt(telefonoStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El teléfono debe ser un número válido.");
            return;
        }

        Contacto contacto = new Contacto(nombre, apellido, telefono);

        if (agenda.agendaLlena()) {
            mostrarAlerta("Agenda llena", "No hay espacio para más contactos.");
            return;
        }

        if (agenda.getContactos().contains(contacto)) {
            mostrarAlerta("Error", "El contacto ya existe.");
            return;
        }

        agenda.getContactos().add(contacto);
        mostrarAlerta("Éxito", "Contacto agregado correctamente.");
        limpiarCampos();
        listarContactos();
    }

    @FXML
    private void buscarContacto() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingresa nombre y apellido para buscar.");
            return;
        }

        boolean encontrado = false;
        for (Contacto c : agenda.getContactos()) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                resultadosArea.setText("Contacto encontrado:\n" + c.toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            resultadosArea.setText("Contacto no encontrado.");
        }
    }

    @FXML
    private void eliminarContacto() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingresa nombre y apellido para eliminar.");
            return;
        }

        Contacto contacto = new Contacto();
        contacto.setNombre(nombre);
        contacto.setApellido(apellido);

        if (agenda.getContactos().remove(contacto)) {
            mostrarAlerta("Éxito", "Contacto eliminado correctamente.");
            limpiarCampos();
            listarContactos();
        } else {
            mostrarAlerta("Error", "No se encontró el contacto para eliminar.");
        }
    }

    @FXML
    private void modificarTelefono() {
        String nombre = nombreField.getText().trim();
        String apellido = apellidoField.getText().trim();
        String nuevoTelefonoStr = telefonoField.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || nuevoTelefonoStr.isEmpty()) {
            mostrarAlerta("Error", "Por favor ingresa nombre, apellido y nuevo teléfono.");
            return;
        }

        int nuevoTelefono;
        try {
            nuevoTelefono = Integer.parseInt(nuevoTelefonoStr);
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El teléfono debe ser un número válido.");
            return;
        }

        boolean encontrado = false;
        for (Contacto c : agenda.getContactos()) {
            if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                mostrarAlerta("Éxito", "Teléfono modificado correctamente.");
                limpiarCampos();
                listarContactos();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            mostrarAlerta("Error", "No se encontró el contacto para modificar.");
        }
    }

    @FXML
    private void listarContactos() {
        if (agenda.getContactos().isEmpty()) {
            resultadosArea.setText("La agenda está vacía.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        agenda.getContactos().stream()
                .sorted((c1, c2) -> {
                    int cmp = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                    if (cmp != 0) return cmp;
                    return c1.getApellido().compareToIgnoreCase(c2.getApellido());
                })
                .forEach(c -> sb.append(c.toString()).append("\n"));

        resultadosArea.setText(sb.toString());
    }

    @FXML
    private void espaciosLibres() {
        int libres = agenda.getMaxSize() - agenda.getContactos().size();
        mostrarAlerta("Espacios disponibles", "Quedan " + libres + " espacios libres en la agenda.");
    }

    @FXML
    private void agendaLlena() {
        if (agenda.agendaLlena()) {
            mostrarAlerta("Agenda llena", "La agenda está llena.");
        } else {
            mostrarAlerta("Agenda", "La agenda tiene espacio disponible.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        nombreField.clear();
        apellidoField.clear();
        telefonoField.clear();
    }


    @FXML
    private TextField txtNombreBuscar;
    @FXML
    private TextField txtApellidoBuscar;
    @FXML
    private Label lblResultadoBuscar;

    @FXML
    private void existeContacto() {
        String nombre = txtNombreBuscar.getText().trim();
        String apellido = txtApellidoBuscar.getText().trim();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            lblResultadoBuscar.setText("Por favor ingresa nombre y apellido.");
            return;
        }

        Contacto c = new Contacto(nombre, apellido, 0); // Teléfono no importa
        boolean existe = agenda.getContactos().contains(c);

        if (existe) {
            lblResultadoBuscar.setText("✅ El contacto existe.");
        } else {
            lblResultadoBuscar.setText("❌ El contacto no se encuentra.");
        }
    }
}
