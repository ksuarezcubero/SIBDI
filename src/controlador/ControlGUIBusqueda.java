/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import modelo.Libro;
import modelo.RegistroLibro;
import vista.GUIBusqueda;

/**
 *
 * @author kevin
 */
public class ControlGUIBusqueda implements ActionListener, ItemListener{
    
    private RegistroLibro registro;
    private GUIBusqueda busqueda;
    
    public ControlGUIBusqueda(RegistroLibro registro, GUIBusqueda busqueda){
        this.registro=registro;
        this.busqueda=busqueda;
    }
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(GUIBusqueda.BTNB_BUSCAR)){
            busqueda.mensage("BUSUSU");
        }
    }
    
    public void itemStateChanged(ItemEvent itemEvent){
        if(itemEvent.getStateChange() == itemEvent.SELECTED){
            if(itemEvent.getItem().toString().equalsIgnoreCase("All")){
                busqueda.getPanel().llenarTabla(registro.getFiltro(busqueda.getTxtBusqueda(), busqueda.getCombo().getSelectedIndex()), Libro.getEtiquetas());
            }
            
            if(itemEvent.getItem().toString().equalsIgnoreCase("ID")){
                busqueda.getPanel().llenarTabla(registro.getFiltro(busqueda.getTxtBusqueda(), busqueda.getCombo().getSelectedIndex()), Libro.getEtiquetas());
            }
            
            if(itemEvent.getItem().toString().equalsIgnoreCase("Autor")){
                busqueda.getPanel().llenarTabla(registro.getFiltro(busqueda.getTxtBusqueda(), busqueda.getCombo().getSelectedIndex()), Libro.getEtiquetas());
            }
            if(itemEvent.getItem().toString().equalsIgnoreCase("Categoria")){
                busqueda.getPanel().llenarTabla(registro.getFiltro(busqueda.getTxtBusqueda(), busqueda.getCombo().getSelectedIndex()), Libro.getEtiquetas());
            }
        }
    }
}
