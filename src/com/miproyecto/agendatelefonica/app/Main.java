package com.miproyecto.agendatelefonica.app;
import com.miproyecto.agendatelefonica.view.PantallaInicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agenda Telefónica");
        primaryStage.setScene(PantallaInicio.crearPantallaInicio(primaryStage));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}