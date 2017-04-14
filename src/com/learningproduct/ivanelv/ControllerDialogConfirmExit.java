package com.learningproduct.ivanelv;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Created by ttat on 05/04/2017.
 */
public class ControllerDialogConfirmExit
{
    @FXML
    Button buttonYes, buttonNo;

    public void onYesClicked(ActionEvent e)
    {
        Platform.exit();
    }

    public void onNoClicked(ActionEvent e)
    {
        Stage stage = (Stage)((Button)e.getSource()).getScene().getWindow();
        stage.close();
    }
}
