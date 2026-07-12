package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Label;

import model.Paquete;
import utils.ArchivoUtil;

public class ConsultaPaqueteController {
    @FXML
    private TableView<Paquete> tablaPaquetes;

    @FXML
    private TableColumn<Paquete, String> colCodigo;

    @FXML
    private TableColumn<Paquete, String> colDestinatario;

    @FXML
    private TableColumn<Paquete, Double> colPeso;

    @FXML
    private TableColumn<Paquete, String> colDestino;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {
        colCodigo.setCellValueFactory(
            new PropertyValueFactory<>("codigo")
        );
        colDestinatario.setCellValueFactory(
            new PropertyValueFactory<>("destinatario")
        );
        colPeso.setCellValueFactory(
            new PropertyValueFactory<>("peso")
        );
        colDestino.setCellValueFactory(
            new PropertyValueFactory<>("destino")
        );

        cargarArchivo();
        lblMensaje.setText("Esperando acción...");
    }

    @FXML
    public void cargarArchivo() {
        ObservableList<Paquete> lista = FXCollections.observableArrayList(
            ArchivoUtil.leerListaPaquetes()
        );

        tablaPaquetes.setItems(lista);

        if (lista.isEmpty()) {
            lblMensaje.setText("No hay paquetes registrados en el archivo");
        } else {
            lblMensaje.setText("Paquetes cargados exitosamente");
        }
    }
}
