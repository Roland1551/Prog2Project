package com.example.demokitudjahanyadik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Adventure extends Application {

    public static Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        window=stage;
        FXMLLoader helloLoader = new FXMLLoader(Adventure.class.getResource("hello-view.fxml"));

        Scene hello = new Scene(helloLoader.load(), 320, 240);

        window.setTitle("Lost In The Wild!");
        window.setScene(hello);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}