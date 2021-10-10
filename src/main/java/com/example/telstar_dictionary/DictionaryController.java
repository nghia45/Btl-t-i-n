package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.example.telstar_dictionary.TextToSpeech.SpeakTheWord;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ResourceBundle;
import java.net.URL;


public class DictionaryController implements Initializable
{

    @FXML
    private Label englishLabel;

    @FXML
    private Label explainLabel;

    @FXML
    public TextField searchTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }


    public void showWord(ActionEvent event) {
        boolean exist = false;
        for (int i = 1; i <= Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i - 1).getWord_target().equals(searchTextField.getText())) {
                englishLabel.setText(Dictionary.list.get(i - 1).getWord_target());
                explainLabel.setText(Dictionary.list.get(i - 1).getWord_explain());
                exist = true;
            }
        }
        if (!exist) {
            englishLabel.setText("Từ [" + searchTextField.getText() + "] không tồn tại !");
        }
    }

    public void addWordForm(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("addword.fxml"));
            Stage addWordStage = new Stage();
            addWordStage.initStyle(StageStyle.UNDECORATED);
            addWordStage.setScene(new Scene(root, 600, 400));
            addWordStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void fixWordForm(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("fixword.fxml"));
            Stage addWordStage = new Stage();
            addWordStage.initStyle(StageStyle.UNDECORATED);
            addWordStage.setScene(new Scene(root, 600, 400));
            addWordStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void deleteWordForm(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("deleteword.fxml"));
            Stage addWordStage = new Stage();
            addWordStage.initStyle(StageStyle.UNDECORATED);
            addWordStage.setScene(new Scene(root, 600, 400));
            addWordStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void speak(ActionEvent event) {
        SpeakTheWord(englishLabel.getText());
    }
}