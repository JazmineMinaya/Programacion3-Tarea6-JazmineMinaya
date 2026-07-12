package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;

import model.Destino;
import utils.ArchivoUtil;

public class ConsultaDestinoController {
    @FXML
    private TableView<Destino> tablaDestinos;

    @FXML
    private TableColumn<Destino, String> colDestino;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {
        colDestino.setCellValueFactory(
            new PropertyValueFactory<>("nombre")
        );

        cargarArchivo();
        lblMensaje.setText("Esperando acción...");
    }

    @FXML
    public void cargarArchivo() {
        ObservableList<Destino> lista = FXCollections.observableArrayList(
            ArchivoUtil.leerListaDestinos()
        );

        tablaDestinos.setItems(lista);

        if (lista.isEmpty()) {
            lblMensaje.setText("No hay destinos registrados en el archivo");
        } else {
            lblMensaje.setText("Destinos cargados exitosamente");
        }
    }
}
