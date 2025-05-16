package com.miproyecto.agendatelefonica.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FormularioContacto {
    public static Scene crearFormulario(Stage stage) {
        TextField nombreField = new TextField();
        TextField apellidoField = new TextField();
        TextField telefonoField = new TextField();

        Button guardar = new Button("Guardar");
        Button volver = new Button("Volver");

        guardar.setOnAction(e -> {
            // Aquí puedes guardar usando tu clase Agenda
            System.out.println("Guardado: " + nombreField.getText());
        });

        volver.setOnAction(e -> {
            stage.setScene(PantallaInicio.crearPantallaInicio(stage));
        });

        VBox layout = new VBox(10,
                new Label("Nombre:"), nombreField,
                new Label("Apellido:"), apellidoField,
                new Label("Teléfono:"), telefonoField,
                guardar, volver
        );
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-alignment: center;");
        return new Scene(layout, 400, 600);
    }
}
