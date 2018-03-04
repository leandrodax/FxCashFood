/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.fichatecnica;

import com.cashf.model.fichatecnica.FichaTecnica;
import com.cashf.model.produto.Produto;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author joao
 */
public class TabListaFichaTecnicaFXMLController implements Initializable {

    @FXML
    private TableView<FichaTecnica> tbvProdutos;
    @FXML
    private TableColumn<FichaTecnica, Produto> tbcDescricao;
    @FXML
    private TableColumn<FichaTecnica, LocalDate> tbcData;
    @FXML
    private TableColumn<FichaTecnica, BigDecimal> tbcCusto;
    @FXML
    private JFXTextField txtConsultar;
    @FXML
    private JFXButton btnPesquisar;
    @FXML
    private JFXRadioButton rdbDesc;
    @FXML
    private JFXRadioButton rdbData;
    @FXML
    private JFXRadioButton rdbTodos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setUpRadioButtons();
        setUpTableView();
        loadTbv();
    }

    @FXML
    private void onSelecionarProduto(MouseEvent event) {
    }

    @FXML
    private void onPesquisar(ActionEvent event) {
    }

    private void setUpTableView() {
        tbcDescricao.setCellValueFactory(new PropertyValueFactory<>("produtoPrincipal"));
        tbcData.setCellValueFactory(new PropertyValueFactory<>("dataProducao"));
        tbcCusto.setCellValueFactory(new PropertyValueFactory<>("custoTotal"));
        tbvProdutos.getColumns().setAll(tbcDescricao, tbcData, tbcCusto);
    }

    private void loadTbv() {
        tbvProdutos.setItems(FichaTecnicaController.getInstance().getLista());
    }

    private void setUpRadioButtons() {

        rdbDesc.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbData.setSelected(false);
                rdbTodos.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(1);//todos
            }
        });
        rdbData.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbDesc.setSelected(false);
                rdbTodos.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(2);//todos
            }
        });

        rdbTodos.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                rdbData.setSelected(false);
                rdbDesc.setSelected(false);
                FichaTecnicaController.getInstance().setTipoConsulta(0);//todos
            }
        });
    }

}
