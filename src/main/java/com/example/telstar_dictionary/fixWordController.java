package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.validation.decoration.AbstractValidationDecoration;

import java.util.Locale;
import java.util.Scanner;

import static com.example.telstar_dictionary.DictionaryManagement.*;

public class fixWordController {

    @FXML
    private TextField engTextField;

    @FXML
    private TextField vieTextField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label alertLabel;

    public void fixWord(ActionEvent event) {
        boolean exist = false;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (engTextField.getText().toLowerCase(Locale.ROOT).equals(Dictionary.list.get(i).getWord_target())) {
                Dictionary.list.get(i).setWord_explain(vieTextField.getText());
                dictionaryExportToFile();
                alertLabel.setText("Sửa thành công");
                exist = true;
                break;
            }
        }
        //Nếu không có trong từ điển.
        if (!exist) {
            alertLabel.setText("Từ không có trong từ điển");
        }
    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
}
