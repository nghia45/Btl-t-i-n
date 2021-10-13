package com.example.telstar_dictionary;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.Scanner;

import static com.example.telstar_dictionary.DictionaryManagement.*;

public class deleteWordController {

    @FXML
    private TextField targetTextField;

    @FXML
    private Button cancelBtn;

    @FXML
    private Label alertLabel;

    public void deleteWord() {
        boolean exist = false;
        for (int i = 0; i < Dictionary.list.size(); i++) {
            if (targetTextField.getText().toLowerCase(Locale.ROOT).equals(Dictionary.list.get(i).getWord_target())) {
                Dictionary.list.remove(i);
                dictionaryExportToFile();
                alertLabel.setText("Xóa thành công");
                exist = true;
                break;
            }
        }
        //Nếu từ không có trong từ điển
        if (!exist) {
            alertLabel.setText("Từ này không có để xoá!");
        }
    }

    public void cancel(ActionEvent event) {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }


}
