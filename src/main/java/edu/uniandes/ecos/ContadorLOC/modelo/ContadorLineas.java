package edu.uniandes.ecos.ContadorLOC.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
* @name ContadorLineas
* @author Juan
* @version 1.0
* @date 14/02/2015
* @description Cuenta las l�neas y m�todos de una clase java.
*/
public class ContadorLineas {
    
    /** N�mero de l�neas del archivo. */
    private int numLocArchivo;
    
    /** N�mero de items(m�todos) del archivo. */
    private int numItemsArchivo;
    
    //method
    /**
     * Cuenta las l�neas totales de un archivo, de acuerdo con
     * est�ndar de medici�n definido.
     *
     * @param file
     * @throws IOException
     */
    public void contarLocsEItems(File file) throws IOException{
        FileReader lectorArchivo = new FileReader(file);
        BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
        String linea;
        
        while ((linea = bufferLectura.readLine()) != null) {
            if (!linea.trim().isEmpty() && !(linea.trim().startsWith("/") || linea.trim().startsWith("*"))) {
                numLocArchivo++;
            }
            
            if ("//method".equals(linea.trim())) {
                numItemsArchivo++;
            }
        }
    }

    /**
     * @return the numLocArchivo
     */
    public int getNumLocArchivo() {
        return numLocArchivo;
    }

    /**
     * @param numLocArchivo the numLocArchivo to set
     */
    public void setNumLocArchivo(int numLocArchivo) {
        this.numLocArchivo = numLocArchivo;
    }

    /**
     * @return the numItemsArchivo
     */
    public int getNumItemsArchivo() {
        return numItemsArchivo;
    }

    /**
     * @param numItemsArchivo the numItemsArchivo to set
     */
    public void setNumItemsArchivo(int numItemsArchivo) {
        this.numItemsArchivo = numItemsArchivo;
    }
}
