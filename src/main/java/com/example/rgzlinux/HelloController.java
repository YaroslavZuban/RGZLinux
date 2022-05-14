package com.example.rgzlinux;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class HelloController {


    public TextField textMB;
    public TextField textOutfile;

    private File file;
    private File file1;
    private FileWork fileWork = new FileWork();

    @FXML
    private TextArea startTestFile;

    @FXML
    private TextField linfSave;

    @FXML
    private TextField linkFind;

    @FXML
    private TextArea endText;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    void homeFindFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открыть файл");
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));

        file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            linkFind.setText(String.valueOf(file));

            try {
                fileWork.readFile(file,startTestFile);

                textMB.setText("Размер входного файла: " + (double) file.length() + " Б");
            } catch (IOException e) {
                textMB.setText("Размер входного файла: " + 0 + " Б");
                e.printStackTrace();
            }

        }
    }


    @FXML
    public void translateTextAction(ActionEvent actionEvent) {
        DataCompression dataCompression = new DataCompression();
        startTestFile.setEditable(false);
        endText.setText(dataCompression.Compression(startTestFile.getText()));
        error();
    }


    @FXML
    public void setTextVisible(ActionEvent actionEvent) {
        startTestFile.setText("");
        startTestFile.setEditable(true);
        textMB.setText("Размер входного файла: " + 0 + " Б");
        textOutfile.setText("Размер нового файла: " + 0 + " Б");
        linkFind.setText("");
        linfSave.setText("");
        endText.setText("");

    }

    private void error() {
        if (startTestFile.getText().length() < endText.getText().length()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner((Stage) anchorPane.getScene().getWindow().getScene().getWindow());
            alert.setTitle("Ошибка");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Не эффективное сжатие!");

            alert.showAndWait();

        }
    }

    public void saveFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Сохранить файл");
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));

        file1 = fileChooser.showSaveDialog(stage);

        try {
            File file2 = new File(String.valueOf(file1));
            fileWork.writingFile(file2, endText.getText());
            textOutfile.setText("Размер нового файла: " + file2.length() + " Б");
            linfSave.setText(String.valueOf(file2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
