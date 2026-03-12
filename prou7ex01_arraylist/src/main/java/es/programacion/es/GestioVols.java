package es.programacion.es;

import java.util.ArrayList;

public class GestioVols implements IGestioPassatgers {
    //atributos
    private ArrayList<String> llistaPassatgers;

    //constructor
    public GestioVols(){
        llistaPassatgers= new ArrayList<>();
    }
    //getters y setters

    //metodos
    @Override
    public void registrarPassatger(String nom) {
        llistaPassatgers.add(nom); //añade al array list
    }
    @Override
    public void modificarReserva(int index, String nouNom) {
        llistaPassatgers.set(index, nouNom); //modifica el valor en esa posicion del arrayList
    }
    @Override
    public void cancelarReserva(String nom) {
        llistaPassatgers.remove(nom); //elimina el elemento de la lista
    }
    @Override
    public String obtenirPassatger(int index) {
        return llistaPassatgers.get(index); // obtiene el valor de esa posicion de la lista
    }
    @Override
    public void llistarPassatgers() {
        for(String elemento : llistaPassatgers){ //recorre toda la lista
            System.out.println(elemento); // y lo imprime
        }
    }
}
