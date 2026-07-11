package model;

public class Paquete {
    private String codigo;
    private String destinatario;
    private double peso;
    private String destino;

    public Paquete(String codigo, String destinatario, double peso, String destino) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public double getPeso() {
        return peso;
    }
    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return codigo + ";" + destinatario + ";" + peso + ";" + destino;
    }
}
