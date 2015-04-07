/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.RegistroLibro;
import vista.GUIBusqueda;
import vista.GUILibro;
import vista.GUISIBDI;

/**
 *
 * @author kevin
 */
public class ControlSIBDI implements ActionListener{

    private RegistroLibro registroLibro;
    
    public ControlSIBDI() {
        this.registroLibro=new RegistroLibro();
    }
    
    
    
    public void actionPerformed(ActionEvent evento){
        if(evento.getActionCommand().equalsIgnoreCase(GUISIBDI.MENU_LIBRO)){
            GUILibro guiLibro=new GUILibro(registroLibro);
            guiLibro.show();
        }
        
        if(evento.getActionCommand().equalsIgnoreCase(GUISIBDI.MENU_BUSQUEDA)){
            GUIBusqueda guiFiltro=new GUIBusqueda(registroLibro);
            guiFiltro.show();
        }
    }
}
