package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;

import model.Destino;
import model.Paquete;
import utils.ArchivoUtil;
import utils.Navegacion;

public class RegistroPaqueteController {
    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDestinatario;

    @FXML
    private TextField txtPeso;

    @FXML
    private ComboBox<Destino> cmbDestino;

    @FXML
    private Label lblMensaje;

    @FXML
    private ProgressBar progressBar;

    @FXML
    public void abrirRegistroPaquete(){

    }

    @FXML
    public void abrirRegistroDestino(){
        RegistroDestinoController controller = Navegacion.abrirVentana(
            "/view/registro_destino.fxml", 
            "Registro de Destinos"
        );
    }

    @FXML
    public void abrirConsultaPaquete(){
        ConsultaPaqueteController controller = Navegacion.abrirVentana(
            "/view/consulta_paquete.fxml", 
            "Consulta de Paquetes"
        );
    }

    @FXML
    public void abrirConsultaDestino(){
        ConsultaDestinoController controller = Navegacion.abrirVentana(
            "/view/consulta_destino.fxml", 
            "Consulta de Destinos"
        );
    }

    @FXML
    public void salir() {
        Platform.exit();
    }

    @FXML
    public void guardarConHilo() {
        Paquete paquete = crearPaquete();

        lblMensaje.setText("Guardando en segundo plano");
        progressBar.setProgress(0);

        Thread hilo = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(300);
                    int progreso = i;

                    Platform.runLater(() -> {
                        progressBar.setProgress(progreso / 10.0);
                        lblMensaje.setText("Guardando... " + (progreso * 10) + "%");
                    });
                }
                ArchivoUtil.guardarPaquete(paquete);
                Platform.runLater(() -> {
                    lblMensaje.setText("Paquete guardado en el archivo con hilo");
                });
            } catch (Exception e) {
                System.out.println("Error al guardar el paquete: " + e.getMessage());
            } finally {
                progressBar.setProgress(0);
                lblMensaje.setText("Paquete guardado en el archivo");
            }
        });

        hilo.start();
    }

    @FXML
    public void demostrarHilo() {
        lblMensaje.setText("Iniciando demostración...");
        progressBar.setProgress(0);

        Thread hilo = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Hilo interrumpido");
                    }

                    int valor = i;

                    System.out.println("Thread ejecutando paso: " + valor);

                    Platform.runLater(() -> {
                        progressBar.setProgress(valor / 10.0);
                        lblMensaje.setText("Thread trabajando en segundo plano. Platform.runLater actualizando la GUI: " + (valor * 10) + "%");
                    });
                }
            } catch (Exception e) {
                System.out.println("Error al crear el hilo: " + e.getMessage());
            } finally {
                progressBar.setProgress(0);
                lblMensaje.setText("Demostración finalizada");
            }
        });

        hilo.start();
    }

    @FXML
    public void cargarDestino() {
        ObservableList<Destino> lista = FXCollections.observableArrayList(
            ArchivoUtil.leerListaDestinos()
        );

        cmbDestino.setItems(lista);
    }

    @FXML
    public void guardarPaquete() {
        if (txtCodigo.getText().trim().isEmpty() || txtDestinatario.getText().trim().isEmpty() ||
            txtPeso.getText().trim().isEmpty()) {
                lblMensaje.setText("Campo vacío. Favor todos los campos");
                return;
            }

        if (cmbDestino.getValue() == null) {
            lblMensaje.setText("Seleccione un destino");
            return;
        }
        
        Paquete paquete = crearPaquete();
        ArchivoUtil.guardarPaquete(paquete);

        txtCodigo.clear();
        txtDestinatario.clear();
        txtPeso.clear();
        cmbDestino.setValue(null);

        lblMensaje.setText("Paquete guardado en el archivo");
    }

    private Paquete crearPaquete() {
        Destino destino = cmbDestino.getValue();

        String destinoSeleccionado = destino.toString();

        return new Paquete(
            txtCodigo.getText(),
            txtDestinatario.getText(),
            Double.parseDouble(txtPeso.getText()),
            destinoSeleccionado);
    }
}
