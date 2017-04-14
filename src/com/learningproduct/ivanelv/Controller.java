package com.learningproduct.ivanelv;

import com.sun.javafx.application.PlatformImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

public class Controller
{
    @FXML
    StackPane mainStackPane;

    @FXML
    FlowPane notificationBar;

    @FXML
    Label notificationBarLabel;

    @FXML
    ImageView controlButtonIconify, controlButtonClose;

    @FXML
    Button buttonInfo;

    public void copyHexColorToClipboard(ActionEvent e)
    {
        Button button = (Button) e.getSource();
        if (button.getText().contains("#"))
        {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(button.getText().replaceAll("#", "")), null);
        }

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1)));
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2)));
        timeline.play();
        notificationBarLabel.setText(button.getText() + " just copied to clipboard!");
        notificationBar.setVisible(true);

        timeline.setOnFinished(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                notificationBar.setVisible(false);
            }
        });
    }

    public void onIconify(MouseEvent e)
    {
        Main.stage.setIconified(true);
    }

    public void onClose(MouseEvent e) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("DialogConfirmExit.fxml"));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();

        stage.focusedProperty().addListener(new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
            {
                stage.close();
            }
        });
    }

    public void onInfo(MouseEvent e)
    {

    }
}
