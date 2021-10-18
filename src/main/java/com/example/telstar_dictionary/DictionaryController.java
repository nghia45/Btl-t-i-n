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
        showHistory();
        if (!Dictionary.trie.search(searchTextField.getText().toLowerCase(Locale.ROOT))) {
            englishLabel.setText("Từ [" + searchTextField.getText() + "] không tồn tại !");
            explainLabel.setText("");
        } else {
            englishLabel.setText(searchTextField.getText().toLowerCase(Locale.ROOT));
            explainLabel.setText(Dictionary.trie.search2(searchTextField.getText().toLowerCase(Locale.ROOT)));
            Word newWord = new Word();
            newWord.setWord_target(searchTextField.getText().toLowerCase(Locale.ROOT));
            newWord.setWord_explain(Dictionary.trie.search2(searchTextField.getText().toLowerCase(Locale.ROOT)));
            Dictionary.his.add(newWord);
            historyExportToFile();
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
    }

    public void speak(ActionEvent event) {
        SpeakTheWord(englishLabel.getText());
    }
}