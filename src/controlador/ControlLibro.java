/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Libro;
import modelo.RegistroLibro;
import vista.GUIReporte;
import vista.GUILibro;
import vista.PanelBotones;
import vista.PanelDataLibro;

/**
 *
 * @author aaron
 */
public class ControlLibro implements ActionListener {
    
    private PanelDataLibro panelData;
    private RegistroLibro registro;
    private PanelBotones panelBotones;
    private GUILibro guiLibro;

    public ControlLibro(PanelDataLibro panelDataLibro, PanelBotones panelBotones, RegistroLibro registro, GUILibro guiLibro) {
        
        this.panelData = panelDataLibro;
        this.registro = registro;
        this.panelBotones=panelBotones;
        this.guiLibro=guiLibro;

    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equals(PanelBotones.BTN_AGREGAR)) {
            if(panelData.getTxtID().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar el ID del Libro!");
            }else if(panelData.getTxtAutor().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar el Autor de Libro!");
            }else if(panelData.getTxtEdicion().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar la edición del Libro !");
            }else if(panelData.getTxtEditorial().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar la editorial del Libro!");
            }else if(panelData.getTxtTitulo().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar el titulo del Libro!");
            }else if(panelData.getTxtCategoria().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar la Categoría de Libro!");
            }else{
                GUILibro.mensaje(registro.addBook(new Libro(panelData.getTxtTitulo(), panelData.getTxtAutor(), panelData.getTxtID(), panelData.getTxtEdicion(), panelData.getTxtEditorial(), panelData.getTxtCategoria())));
                panelData.limpiarCampos();
            }
        }//FIN AGREGAR
        
        if (evento.getActionCommand().equals(PanelDataLibro.BTN_BUSCAR)) {
            if(panelData.getTxtID().equalsIgnoreCase("")){
                GUILibro.mensaje("Debe agregar el ID del Libro!");
            }else{
                Libro libro = registro.buscarLibro(panelData.getTxtID());
                if(libro!=null){
                    panelData.setTxtAutor(libro.getAutor());
                    panelData.setTxtCategoria(libro.getCategoria());
                    panelData.setTxtEdicion(libro.getEdicion());
                    panelData.setTxtEditorial(libro.getEditorial());
                    panelData.setTxtID(libro.getiD());
                    panelData.setTxtTitulo(libro.getTitulo());
                    panelBotones.enabledBotones(true);
               }else{
                    GUILibro.mensaje("El libro no se encuentra registrado");
                }
            }
        }//FIN BUSCAR
        
        if (evento.getActionCommand().equals(PanelBotones.BTN_MODIFICAR)) {
            
        }//FIN MODIFICAR
        
        if (evento.getActionCommand().equals(PanelBotones.BTN_ELIMINAR)) {
            GUILibro.mensaje(registro.eliminarLibro(panelData.getTxtID()));
            panelData.limpiarCampos();
            panelBotones.enabledBotones(false);
        }//FIN ELIMINAR
        
        if (evento.getActionCommand().equals(PanelBotones.BTN_CONSULTAR)) {
            GUIReporte guiReporte=new GUIReporte();
            guiReporte.getPanelTabla().llenarTabla(registro.getMatriz(), Libro.getEtiquetas());
            guiReporte.show();
            
        }//FIN CONSULTAR
        
        if (evento.getActionCommand().equals(PanelBotones.BTN_SALIR)) {
            guiLibro.dispose();
        }//FIN SALIR
    }

}
