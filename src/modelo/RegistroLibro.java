/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class RegistroLibro {

    private ArrayList<Libro> listaLibros;

    public RegistroLibro() {
        listaLibros = new ArrayList<Libro>();
    }

    public String addBook(Libro libro) {
        if (libro != null) {
            if (verificarID(libro.getiD())) { 
                listaLibros.add(libro);
                return "El libro se registró correctamente";
            } else {
                return "El libro ya se encuentra registrado!";
            }
        } else {
            return "El objeto es null!";
        }
    }

    public boolean verificarID(String iD) {
        if (!iD.equalsIgnoreCase("")) {
            if (listaLibros.size() != 0) {
                for (Libro libroE : listaLibros) {
                    if (libroE.getiD().equalsIgnoreCase(iD)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
    
    public Libro buscarLibro(String ID){
        Libro libro = null;
        if(!ID.equalsIgnoreCase("")){
            for(Libro libroE : listaLibros){
                if(libroE.getiD().equalsIgnoreCase(ID)){
                    return libroE;
                }
            }
        }
        return null;
    }
    
    public String eliminarLibro(String ID){
        Libro libroE=buscarLibro(ID);
        if(libroE!=null){
            listaLibros.remove(libroE);
            return "El libro fue eliminado";
        }
        return "El libro no se encuentra registrado";
    }
    
    public String consultarLibros(){
        String salida="";
        for(Libro libros : listaLibros){
            salida+=libros+"\n";
        }
        return salida;
    }
    
    public String[][] getMatriz(){
        
        String [][] matrizLibros=new String [listaLibros.size()][Libro.getTamanno()];
        for(int i=0; i<matrizLibros.length;i++){
            for(int j=0;j<matrizLibros[i].length;j++){
                matrizLibros[i][j]=listaLibros.get(i).datos(j);
            }
        }
        return matrizLibros;
    }

    public String [][] getFiltro(String busqueda, int filtro){
        
        ArrayList<Libro> arrayAux=new ArrayList<Libro>();
        if(filtro==0){
            arrayAux=listaLibros;
        }else if(filtro==1){
            for(Libro libro:listaLibros){
                if(libro.getiD().equalsIgnoreCase(busqueda)){
                    arrayAux.add(libro);
                }
            }
        }else if(filtro==2){
            for(Libro libro:listaLibros){
                if(libro.getAutor().equalsIgnoreCase(busqueda)){
                    arrayAux.add(libro);
                }
            }
        }else if(filtro==3){
            for(Libro libro:listaLibros){
                if(libro.getCategoria().equalsIgnoreCase(busqueda)){
                    arrayAux.add(libro);
                }
            }
        }
        
        String [][] matrizFiltro=new String[arrayAux.size()][Libro.getTamanno()];
        for(int i=0; i<matrizFiltro.length;i++){
            for(int j=0;j<matrizFiltro[i].length;j++){
                matrizFiltro[i][j]=arrayAux.get(i).datos(j);
            }
        }
        return matrizFiltro;
    }
}
