/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.IActualizableCiclista;

/**
 *
 * @author William Duarte
 */
public class ServiciosCiclista {
    
    private Ciclista ciclista;
    private ArrayList <Ciclista> ciclistas;
    private ArrayList<IActualizableCiclista> actualizable;

    
    public ServiciosCiclista() {
        ciclistas = new ArrayList<>();
        actualizable = new ArrayList<>();
    }
    
    public void addVista(IActualizableCiclista gui){
        actualizable.add(gui);
    }

    public void cambio(){
        for(IActualizableCiclista gui :actualizable){
            gui.cambio();
        }
    }
    
    public ArrayList darCiclistas()
    {
        return ciclistas;
    }
    
   
    
    //retorna true si el ciclista existe en el arreglo - false si no
    public boolean buscarPorNumero(int pNumero)
    {
        boolean encontro = false;
        if(ciclistas.isEmpty())
        {
            return encontro;
        }
        else
        {
            for (int i = 0; i < ciclistas.size() && !encontro; i++) {
                Ciclista buscar = ciclistas.get(i);
                if(buscar.getNumero() == pNumero)
                {
                    encontro = true;
                }
            }
            return encontro;
        }
    }
    
    //retorna el ciclista existe en el Array - Null si no
    public Ciclista buscarPorCiclista(int pNumero)
    {
        boolean encontro = false;
        Ciclista buscado = null;
        if(ciclistas.isEmpty())
        {
            return buscado;
        }
        else
        {
            for (int i = 0; i < ciclistas.size() && !encontro; i++) {
                Ciclista buscar = ciclistas.get(i);
                if(buscar.getNumero() == pNumero)
                {
                    encontro = true;
                    buscado = buscar;
                }
            }
            return buscado;
        }
    }

    //Adiciona al Array el ciclista que viene por parametro si no existe el numero en el arreglo
    // true = adiciona
    public boolean addCiclistaArray(Ciclista p)
    {        
        boolean buscar = buscarPorNumero(p.getNumero());
        boolean adicionar = false;
        if(!buscar)
        {
            ciclistas.add(p);
            adicionar = true;            
            cambio();   
        }
        return adicionar;
    }
    

    //Elimina del Array el ciclista que viene por parametro si existe el numero en el arreglo
    // true = eliminó
    public boolean deleteCiclistaArray(int pNumero)
    {
        boolean eliminado = false;
        boolean buscar = buscarPorNumero(pNumero);
        
        if(buscar)
        {
            Ciclista buscado = buscarPorCiclista(pNumero);
            ciclistas.remove(buscado);
            eliminado = true;
            cambio();
        }
        return eliminado;
    }
    
    //Busca un ciclista según el numero entrado por parámetro
    //Si lo encuetra retorna el ciclista
    public Ciclista consultarCiclista(int numero)
    {
        Ciclista p = buscarPorCiclista(numero);
        return p;
    }
    
    
    //Actualiza el ciclista con base en el número recibido por parámetro
    // true = actualizó
    public void actualizarCiclista(int numAct, Ciclista p)
    {
        Ciclista x = buscarPorCiclista(numAct);
        x.setNombre(p.getNombre());
        x.setNumero(p.getNumero());
        x.setEquipo(p.getEquipo());
        cambio();        
    }
    
    
    
    

}
