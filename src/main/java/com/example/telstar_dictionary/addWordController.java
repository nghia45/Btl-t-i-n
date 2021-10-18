package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import static com.example.telstar_dictionary.DictionaryManagement.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.Stack;

public class addWordController {

    @FXML
    private TextField engTextField;

    @FXML
    private TextArea vieTextArea;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label alertLabel;

    public void addWord(ActionEvent event) {
        boolean exist = false;
        Word newWord = new Word();
        if (!engTextField.getText().isBlank() && !vieTextArea.getText().isBlank()) {
            if (Dictionary.trie.search(engTextField.getText().toLowerCase(Locale.ROOT))) {
                alertLabel.setText("Thêm từ đã có");
            } else {
                newWord.setWord_target(engTextField.getText());
                newWord.setWord_explain(vieTextArea.getText());
                alertLabel.setText("Thêm từ thành công");
                Dictionary.list.add(newWord);
                Dictionary.trie.insert(newWord.getWord_target(), newWord.getWord_explain());
                dictionaryExportToFile();
            }
        }
    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }


}
