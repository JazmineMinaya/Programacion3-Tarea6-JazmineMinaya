package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

import model.Destino;
import utils.ArchivoUtil;

public class RegistroDestinoController {
    @FXML
    private TextField txtNombreDestino;

    @FXML
    private Label lblMensaje;

    @FXML
    private TableView<Destino> tablaDestinos;

    @FXML
    private TableColumn<Destino, String> colNombre;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        cargarDetallesDestino();
    }

    @FXML
    public void guardarDestino() {
        if (txtNombreDestino.getText() == null || txtNombreDestino.getText().trim().isEmpty()) {
            lblMensaje.setText("Destino vacío. Ingrese un destino");
            return;
        }

        Destino destino = crearDestino();
        ArchivoUtil.guardarDestino(destino);

        txtNombreDestino.clear();
        lblMensaje.setText("Destino guardado en el archivo");
    }

    @FXML
    public void cargarDetallesDestino() {
        ObservableList<Destino> lista = FXCollections.observableArrayList(
            ArchivoUtil.leerListaDestinos()
        );

        tablaDestinos.setItems(lista);
    }

    private Destino crearDestino() {
        return new Destino(txtNombreDestino.getText());
    }
}
