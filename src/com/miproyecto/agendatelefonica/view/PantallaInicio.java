package com.miproyecto.agendatelefonica.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaInicio {
    public static Scene crearPantallaInicio(Stage stage) {
        Button btnContactos = new Button("📇 Contactos");
        btnContactos.setStyle("-fx-font-size: 24px; -fx-padding: 20px;");

        btnContactos.setOnAction(e -> {
            stage.setScene(FormularioContacto.crearFormulario(stage));
        });

        VBox layout = new VBox(20, btnContactos);
        layout.setStyle("-fx-alignment: center; -fx-padding: 50px;");
        return new Scene(layout, 400, 600);
    }
}
