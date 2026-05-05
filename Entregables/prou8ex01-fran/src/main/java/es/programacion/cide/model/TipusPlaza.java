package es.programacion.cide.model;

public class TipusPlaza {
    //atributos
    private int id;
    private String nom;
    private String funcion;
    //constructor
    public TipusPlaza(){
    }
    
    public TipusPlaza(int id, String nom, String funcion){
        this.id=id;
        this.nom=nom;
        this.funcion=funcion;
    }
    //getters y setters
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

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
