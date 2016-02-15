package edu.uniandes.ecos.ContadorLOC.vista;

import edu.uniandes.ecos.ContadorLOC.modelo.CargadorArchivos;
import edu.uniandes.ecos.ContadorLOC.modelo.ContadorLineas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * @name VentanaPrincipal
 * @author Juan
 * @version 1.0
 * @date 14/02/2015
 * @description Ventana principal de la aplicación.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    
    /** Componentes de pantalla. */
    private JLabel lblSeleccionar;
    private JButton btnExaminar;
    private JTextArea txaResultado;
    private JFileChooser fcSeleccionador;
    
    /** Instancia para objeto cargador de archivos. */
    private CargadorArchivos cargadorArchivos;
    
    /** Instancia para objeto contador de líneas. */
    private ContadorLineas contadorLineas;
    
    /** Número de líneas de código(LOC) totales del programa. */
    private int numLocTotales;
    
    /** Número de items(métodos) totales del programa. */
    private int numItemsTotales;

    //method
    /**
     * Constructor de la clase.
     */
    public VentanaPrincipal() {
        this.setTitle("Contador de líneas");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        lblSeleccionar = new JLabel("Seleccione directorio");
        lblSeleccionar.setBounds(135, 60, 130, 20);
        lblSeleccionar.setBackground(Color.gray);
        this.add(lblSeleccionar);

        btnExaminar = new JButton("Examinar");
        btnExaminar.addActionListener(this);
        btnExaminar.setBounds(265, 60, 100, 20);
        this.add(btnExaminar);

        txaResultado = new JTextArea();
        txaResultado.setEditable(false);
        txaResultado.setBorder(new TitledBorder("Resultado"));
        txaResultado.setEnabled(false);
        JScrollPane scroll = new JScrollPane(txaResultado);
        scroll.setBounds(40, 120, 410, 300);
        scroll.setEnabled(false);
        this.add(scroll);

        fcSeleccionador = new JFileChooser();
        fcSeleccionador.setDialogTitle("Seleccione directorio");
        fcSeleccionador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    //method
    /**
     * Ejecuta los metodos para el conteo los items y líneas.
     */
    public void ejecutarConteo() {
        cargadorArchivos = new CargadorArchivos();
        txaResultado.setText("");
        numLocTotales = 0;
        numItemsTotales = 0;
        fcSeleccionador.showOpenDialog(this);
        File directorio = fcSeleccionador.getSelectedFile();
        cargadorArchivos.cargarArchivos(directorio);
        contadorLineas = new ContadorLineas();
        List<File> lstClases = cargadorArchivos.getLstArchivos();
        
        for (File clase: lstClases) {
            try {
                contadorLineas.setNumLocArchivo(0);
                contadorLineas.setNumItemsArchivo(0);
                contadorLineas.contarLocsEItems(clase);
                txaResultado.append("Clase: " + clase.getName()
                        + "    Métodos: "
                        + contadorLineas.getNumItemsArchivo()
                        + "    Líneas de la clase: "
                        + contadorLineas.getNumLocArchivo() + "\n");
                numLocTotales += contadorLineas.getNumLocArchivo();
                numItemsTotales += contadorLineas.getNumItemsArchivo();
                txaResultado.setEnabled(true);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println("No hay clases");
            }
        }
        txaResultado.append("\n" + "Tamaño total del programa en líneas: "
                + numLocTotales);
        txaResultado.append("\n" + "Tamaño total del programa en items: "
                + numItemsTotales);   
    }

    //method
    /**
     * Manejador de eventos de la ventana.
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnExaminar) {
            ejecutarConteo();
        }
    }

    //method
    /**
     * @param args
     */
    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }

}
