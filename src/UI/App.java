package UI;

import Backend.BinaryConverter;
import Backend.Converter;
import Backend.DecimalConverter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Backend.HexConverter;

public class App extends Application {

    private int WIDTH = 265;
    private int HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Conversion");

        TabPane root = new TabPane();

        GridPane hexGridPane = getConverterUI("hex");
        Tab hexTab = new Tab("Hex", hexGridPane);

        GridPane binaryGridPane = getConverterUI("binary");
        Tab binaryTab = new Tab("Binary", binaryGridPane);

        GridPane decimalGridPane = getConverterUI("decimal");
        Tab decimalTab = new Tab("Decimal", decimalGridPane);

        root.getTabs().add(hexTab);
        root.getTabs().add(binaryTab);
        root.getTabs().add(decimalTab);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // type is one of: {"decimal", "hex", "binary"}
    private GridPane getConverterUI(String type) {

        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // set the title
        Text sceneTitle = new Text();
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        // create a user input box for the hex number to be converted
        Label inputLabel = new Label();
        final TextField inputField = new TextField();
        grid.add(inputLabel, 0, 1);
        grid.add(inputField, 1, 1);

        // create a submit button
        Button submitButton = new Button("Convert");
        HBox buttonBox = new HBox(submitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 2);

        // create space for binary and decimal conversions
        Label result1Label = new Label();
        grid.add(result1Label, 0, 4, 2, 1);
        final Text result1 = new Text();
        grid.add(result1, 1, 5, 4, 1);

        Label result2Label = new Label();
        grid.add(result2Label, 0, 6, 2, 1);
        final Text result2 = new Text();
        grid.add(result2, 1, 7, 4, 1);

        final Converter converter;

        if (type.equals("decimal")) {
            sceneTitle.setText("Decimal Converter");
            inputLabel.setText("Decimal:");
            result1Label.setText("Binary: ");
            result2Label.setText("Hexadecimal: ");
            converter = new DecimalConverter();
        } else if (type.equals("hex")) {
            sceneTitle.setText("Hexadecimal Converter");
            inputLabel.setText("0x");
            result1Label.setText("Decimal: ");
            result2Label.setText("Binary: ");
            converter = new HexConverter();
        } else {    // binary
            sceneTitle.setText("Binary Converter");
            inputLabel.setText("0b");
            result1Label.setText("Decimal: ");
            result2Label.setText("Hexadecimal: ");
            converter = new BinaryConverter();
        }

        // set what the submit button does
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String numberString = inputField.getText();
                result1.setText(converter.getResult1(numberString));
                result2.setText(converter.getResult2(numberString));
            }
        });

//        grid.setGridLinesVisible(true);

        return grid;
    }


}
