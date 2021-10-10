package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.example.telstar_dictionary.DictionaryManagement.*;

import java.util.ResourceBundle;
import java.net.URL;
import java.util.Stack;

public class addWordController {

    @FXML
    private TextField engTextField;

    @FXML
    private TextField vieTextField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label alertLabel;

    public void addWord(ActionEvent event) {
        boolean exist = false;
        Word newWord = new Word();
        if (!engTextField.getText().isBlank() && !vieTextField.getText().isBlank()) {
            for (int i = 0; i < Dictionary.list.size(); i++) {
                if (engTextField.getText().equals(Dictionary.list.get(i).getWord_target())) {
                    exist = true;
                    break;
                }
            }

            newWord.setWord_target(engTextField.getText());
            newWord.setWord_explain(vieTextField.getText());
            alertLabel.setText("Thêm từ đã có");
            Dictionary.list.add(newWord);
            dictionaryExportToFile();
        }

    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }


}
