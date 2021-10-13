package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.example.telstar_dictionary.TextToSpeech.SpeakTheWord;
import static com.example.telstar_dictionary.DictionaryManagement.*;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;
import java.io.File;


public class DictionaryController implements Initializable
{

    @FXML
    private Label englishLabel;
    @FXML
    private Label explainLabel;
    @FXML
    private Label hisLabelL1;
    @FXML
    private Label hisLabelL2;
    @FXML
    private Label hisLabelL3;
    @FXML
    private Label hisLabelL4;
    @FXML
    private Label hisLabelR1;
    @FXML
    private Label hisLabelR2;
    @FXML
    private Label hisLabelR3;
    @FXML
    private Label hisLabelR4;
    @FXML
    public TextField searchTextField;
    @FXML
    public ImageView engFlagImageView;
    @FXML
    public ImageView usaFlagView;
    @FXML
    public ImageView vieFlagView;
    @FXML
    public ImageView logoImageView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File engFlagFile = new File("src/img/united-kingdom.png");
        Image engFlagImage = new Image(engFlagFile.toURI().toString());
        engFlagImageView.setImage(engFlagImage);

        File logoFile = new File("src/img/dic_icon.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoImageView.setImage(logoImage);

        File usaFlagFile = new File("src/img/united-states.png");
        Image usaFlagImage = new Image(usaFlagFile.toURI().toString());
        usaFlagView.setImage(usaFlagImage);

        File vieFlagFile = new File("src/img/vietnam.png");
        Image vieFlagImage = new Image(vieFlagFile.toURI().toString());
        vieFlagView.setImage(vieFlagImage);
    }


    public void showWord(ActionEvent event) {
        boolean exist = false;
        for (int i = 1; i <= Dictionary.list.size(); i++) {
            if (Dictionary.list.get(i - 1).getWord_target().equals
                    (searchTextField.getText().toLowerCase(Locale.ROOT))) {
                englishLabel.setText(Dictionary.list.get(i - 1).getWord_target());
                explainLabel.setText(Dictionary.list.get(i - 1).getWord_explain());
                Dictionary.his.add(Dictionary.list.get(i-1));
                historyExportToFile();
                exist = true;
            }
        }
        showHistory();
        if (!exist) {
            englishLabel.setText("Từ [" + searchTextField.getText() + "] không tồn tại !");
            explainLabel.setText("");
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

    public void showHistory() {
       hisLabelL1.setText(Dictionary.his.get(Dictionary.his.size()-4).getWord_target());
       hisLabelL2.setText(Dictionary.his.get(Dictionary.his.size()-3).getWord_target());
       hisLabelL3.setText(Dictionary.his.get(Dictionary.his.size()-2).getWord_target());
       hisLabelL4.setText(Dictionary.his.get(Dictionary.his.size()-1).getWord_target());
       hisLabelR1.setText(Dictionary.his.get(Dictionary.his.size()-4).getWord_explain());
       hisLabelR2.setText(Dictionary.his.get(Dictionary.his.size()-3).getWord_explain());
       hisLabelR3.setText(Dictionary.his.get(Dictionary.his.size()-2).getWord_explain());
       hisLabelR4.setText(Dictionary.his.get(Dictionary.his.size()-1).getWord_explain());
    }

    public void speak(ActionEvent event) {
        SpeakTheWord(englishLabel.getText());
    }
}