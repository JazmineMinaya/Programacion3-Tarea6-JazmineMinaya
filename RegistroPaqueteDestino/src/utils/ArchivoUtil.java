package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Destino;
import model.Paquete;

public class ArchivoUtil {
    
    public static void guardarDestino(Destino destino) {
        try {
            FileWriter archivo = new FileWriter("Destinos.txt", true);
            archivo.write(destino.getNombre() + "\n");
            archivo.close();
            System.out.println("Destino guardado en el archivo");

        } catch (Exception e) {
            System.out.println("Error al guardar el destino: " + e.getMessage());
        }
    }

    public static void guardarPaquete(Paquete paquete) {
        try {
            FileWriter archivo = new FileWriter("Paquetes.txt", true);
            archivo.write(paquete.getCodigo() + ";" +
                          paquete.getDestinatario() + ";" +
                          paquete.getPeso() + ";" +
                          paquete.getDestino() + "\n");
            archivo.close();
            System.out.println("Paquete guardado en el archivo");

        } catch (Exception e) {
            System.out.println("Error al guardar el paquete: " + e.getMessage());
        }
    }

    public static ArrayList<Destino> leerListaDestinos() {
        ArrayList<Destino> destinos = new ArrayList<>();

        try {
            FileReader archivo = new FileReader("Destinos.txt");
            BufferedReader lector = new BufferedReader(archivo);

            String linea;

            while((linea = lector.readLine()) != null) {
                Destino destino = new Destino(linea);

                destinos.add(destino);
            }

            lector.close();
            archivo.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        return destinos;
    }

    public static ArrayList<Paquete> leerListaPaquetes() {
        ArrayList<Paquete> paquetes = new ArrayList<>();

        try {
            FileReader archivo = new FileReader("Paquetes.txt");
            BufferedReader lector = new BufferedReader(archivo);

            String linea;

            while((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length == 4) {
                    Paquete paquete = new Paquete(partes[0], partes[1], Double.parseDouble(partes[2]), partes[3]);

                    paquetes.add(paquete);
                }
            }

            lector.close();
            archivo.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }

        return paquetes;
    }
}
