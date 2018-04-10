/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.menu;

import com.cashf.cashfood.MainApp;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class FXMenuFCaixaFXMLController implements Initializable {

    @FXML
    private Pane paneHeader;
    @FXML
    private JFXHamburger jfxHamburguer;
    @FXML
    private JFXButton btnSair;
    @FXML
    private FontAwesomeIconView iconSair;
    @FXML
    private JFXDrawer jfxDrawer;
    @FXML
    private Pane paneCalc;
    @FXML
    private Pane paneProdutos;
    //-------------------
    private static StackPane rootAux;
    private VBox gavetas;
    private HamburgerNextArrowBasicTransition burgerTask2;
    private Pane paneAux;
    private Pane paneAnt;
    private boolean flag = false;
    @FXML
    private StackPane rootStackPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.paneRoot = rootStackPane;
        rootAux = rootStackPane;
        loadDrawer();
        burgerTask2 = new HamburgerNextArrowBasicTransition(jfxHamburguer);
        burgerTask2.setRate(-1);
        jfxHamburguer.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            burgerTask2.setRate(burgerTask2.getRate() * -1);
            burgerTask2.play();
            if (jfxDrawer.isHidden()) {
                if (flag) {
                    paneHeader.getChildren().remove(paneAux);
                }
                jfxDrawer.open();
                jfxDrawer.setMinWidth(180);
            } else {
                jfxDrawer.close();
                jfxDrawer.setMinWidth(0);
            }
        });
        loadPanelGrupo();
        menuButtonsControl();
        // TODO
    }

    @FXML
    private void onSair(ActionEvent event) {
        System.exit(0);
    }

    private void loadPanelGrupo() {
        Pane auxPane;
        try {
            auxPane = FXMLLoader.load(getClass().getResource("/fxml/FCPainelProdutosFXML.fxml"));
            paneProdutos.getChildren().add(auxPane);
        } catch (IOException ex) {
            System.out.println("Erro ao abrir:" + ex);
        }

    }

    private void loadDrawer() {
        try {
            gavetas = FXMLLoader.load(getClass().getResource("/fxml/GavetaMesasFXML.fxml"));
            jfxDrawer.setSidePane(gavetas);
        } catch (IOException ex) {
            System.out.println("Erro:" + ex);
        }
    }

    private void menuButtonsControl() {
        for (Node node : gavetas.getChildren()) {
            if (node.getAccessibleText() != null) {
                if (node.getAccessibleText().equalsIgnoreCase("FPane")) {
                    FlowPane fp = (FlowPane) node;
                    for (Node nodeFp : fp.getChildren()) {
                        nodeFp.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                            switch (nodeFp.getAccessibleText()) {
                                case "M01":
                                    GavetaMesasFXMLController.getIconM1().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa1");

                                    break;
                                case "M02":
                                    GavetaMesasFXMLController.getIconM2().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa2");

                                    break;
                                case "M03":
                                    GavetaMesasFXMLController.getIconM3().setFill(Paint.valueOf("RED"));
                                    System.out.println("Mesa3");

                                    break;
                                case "M04":
                                    GavetaMesasFXMLController.getIconM4().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M05":
                                    GavetaMesasFXMLController.getIconM5().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M06":
                                    GavetaMesasFXMLController.getIconM6().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M07":
                                    GavetaMesasFXMLController.getIconM7().setFill(Paint.valueOf("RED"));
                                    jfxDrawer.close();
                                    break;
                                case "M08":
                                    GavetaMesasFXMLController.getIconM8().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M09":
                                    GavetaMesasFXMLController.getIconM9().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M10":
                                    GavetaMesasFXMLController.getIconM10().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M11":
                                    GavetaMesasFXMLController.getIconM11().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M12":
                                    GavetaMesasFXMLController.getIconM12().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M13":
                                    GavetaMesasFXMLController.getIconM13().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M14":
                                    GavetaMesasFXMLController.getIconM14().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M15":
                                    GavetaMesasFXMLController.getIconM15().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M16":
                                    GavetaMesasFXMLController.getIconM16().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M17":
                                    GavetaMesasFXMLController.getIconM17().setFill(Paint.valueOf("RED"));

                                    break;
                                case "M18":
                                    GavetaMesasFXMLController.getIconM18().setFill(Paint.valueOf("RED"));

                                    break;
                            }
                        });
                    }

                }
            }
        }
    }

}
