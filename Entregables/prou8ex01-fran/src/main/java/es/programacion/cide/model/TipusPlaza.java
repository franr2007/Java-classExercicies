package es.programacion.cide.model;

public class TipusPlaza {
    //atributos
    private String nom;
    private String funcion;
    //constructor
    public TipusPlaza(){
    }
    
    public TipusPlaza(String nom, String funcion){
        this.nom=nom;
        this.funcion=funcion;
    }
    //getters y setters
    public void setNom(String nom){
        this.nom=nom;
    }
    public String getNom(){
        return nom;
    }

    public void setFuncion(String funcion){
        this.funcion=funcion;
    }
    public String getFuncion(){
        return funcion;
    }
    //metodos
}
