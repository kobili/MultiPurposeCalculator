package UI;

import Backend.BinaryConverter;
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

    private int WIDTH = 300;
    private int HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Number Conversion");

        TabPane root = new TabPane();

        GridPane hexGridPane = getHexConverterUI();
        Tab hexTab = new Tab("Hex", hexGridPane);

        GridPane binaryGridPane = getBinaryConverterUI();
        Tab binaryTab = new Tab("Binary", binaryGridPane);

        GridPane decimalGridPane = getDecimalConverterUI();
        Tab decimalTab = new Tab("Decimal", decimalGridPane);

        root.getTabs().add(hexTab);
        root.getTabs().add(binaryTab);
        root.getTabs().add(decimalTab);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane getHexConverterUI() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // set the title
        Text sceneTitle = new Text("Hexadecimal Conversion");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        // create a user input box for the hex number to be converted
        Label hexInputLabel = new Label("0x");
        final TextField hexInput = new TextField();
        grid.add(hexInputLabel, 0, 1);
        grid.add(hexInput, 1, 1);

        // create a submit button
        Button submitButton = new Button("Convert");
        HBox buttonBox = new HBox(submitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 2);

        // create space for binary and decimal conversions
        Label decimalResultLabel = new Label("Decimal: ");
        grid.add(decimalResultLabel, 0, 4, 2, 1);
        final Text decimalResult = new Text();
        grid.add(decimalResult, 1, 5, 2, 1);

        Label binaryResultLabel = new Label("Binary: ");
        grid.add(binaryResultLabel, 0, 6, 2, 1);
        final Text binaryResult = new Text();
        grid.add(binaryResult, 1, 7, 2, 1);

        final HexConverter converter = new HexConverter();

        // set what the submit button does
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String numberString = hexInput.getText();
                int conversion = converter.convertString(numberString);
                decimalResult.setText(Integer.toString(conversion));
                binaryResult.setText("0b" + Integer.toBinaryString(conversion));
            }
        });

//        grid.setGridLinesVisible(true);

        return grid;
    }

    private GridPane getBinaryConverterUI() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // set the title
        Text sceneTitle = new Text("Binary Conversion");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        // create a user input box for the hex number to be converted
        Label hexInputLabel = new Label("0b");
        final TextField hexInput = new TextField();
        grid.add(hexInputLabel, 0, 1);
        grid.add(hexInput, 1, 1);

        // create a submit button
        Button submitButton = new Button("Convert");
        HBox buttonBox = new HBox(submitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 2);

        // create space for binary and decimal conversions
        Label decimalResultLabel = new Label("Decimal: ");
        grid.add(decimalResultLabel, 0, 4, 2, 1);
        final Text decimalResult = new Text();
        grid.add(decimalResult, 1, 5, 2, 1);

        Label hexResultLabel = new Label("Hex: ");
        grid.add(hexResultLabel, 0, 6, 2, 1);
        final Text hexResult = new Text();
        grid.add(hexResult, 1, 7, 2, 1);

        final BinaryConverter converter = new BinaryConverter();

        // set what the submit button does
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String numberString = hexInput.getText();
                int conversion = converter.convertString(numberString);
                decimalResult.setText(Integer.toString(conversion));
                hexResult.setText("0x" + Integer.toHexString(conversion));
            }
        });

//        grid.setGridLinesVisible(true);

        return grid;
    }

    private GridPane getDecimalConverterUI() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // set the title
        Text sceneTitle = new Text("Decimal Conversion");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        // create a user input box for the hex number to be converted
        Label decimalInputLabel = new Label("");
        final TextField decimalInput = new TextField();
        grid.add(decimalInputLabel, 0, 1);
        grid.add(decimalInput, 1, 1);

        // create a submit button
        Button submitButton = new Button("Convert");
        HBox buttonBox = new HBox(submitButton);
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 1, 2);

        // create space for binary and decimal conversions
        Label binaryResultLabel = new Label("Binary: ");
        grid.add(binaryResultLabel, 0, 4, 2, 1);
        final Text binaryResult = new Text();
        grid.add(binaryResult, 1, 5, 2, 1);

        Label hexResultLabel = new Label("Binary: ");
        grid.add(hexResultLabel, 0, 6, 2, 1);
        final Text hexResult = new Text();
        grid.add(hexResult, 1, 7, 2, 1);

        final DecimalConverter converter = new DecimalConverter();

        // set what the submit button does
        submitButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                String numberString = decimalInput.getText();
                int conversion = converter.convertString(numberString);
                hexResult.setText(Integer.toString(conversion));
                binaryResult.setText("0b" + Integer.toBinaryString(conversion));
            }
        });

//        grid.setGridLinesVisible(true);

        return grid;
    }
}
