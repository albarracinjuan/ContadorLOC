package edu.uniandes.ecos.ContadorLOC.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @name CargadorArchivos
 * @author Juan
 * @version 1.0
 * @date 14/02/2015
 * @description Carga en memoria los datos del archivo seleccionado.
 */
public class CargadorArchivos {

    /** Lista de archivos en el directorio. */
    private List lstArchivos;

    //method
    /**
     * Contructor de la clase
     */
    public CargadorArchivos() {
        this.lstArchivos = new ArrayList();
    }

    //method
    /**
     * Carga los archivos del directorio con extensión .java
     *
     * @param directorio
     */
    public void cargarArchivos(File directorio) {
        File[] lstDirectorios = directorio.listFiles();
    
        if (lstDirectorios != null) {
            for (File archivo : lstDirectorios) {
                if (archivo.isDirectory()) { //Se evalúa si es directorio o archivo.
                    cargarArchivos(archivo);
                } else {
                    if (archivo.getName().trim().endsWith(".java")) { //Sólo se cargan clases.
                        lstArchivos.add(archivo);
                    }
                }
            }
        }
    }

    /**
     * @return the lstArchivos
     */
    public List getLstArchivos() {
        return lstArchivos;
    }

    /**
     * @param lstArchivos the lstArchivos to set
     */
    public void setLstArchivos(List lstArchivos) {
        this.lstArchivos = lstArchivos;
    }

}
