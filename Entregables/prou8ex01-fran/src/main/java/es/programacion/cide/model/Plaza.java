package es.programacion.cide.model;

public class Plaza {
    //atributos
    private int codi;
    private String nom;
    private int salari;
    private int codiPlaSuper;
    private String informeSuper;
    private String nomPlaza;
    //constructor
    public Plaza(){
    }

    public Plaza(int codi, String nom, int salari, int codiPlaSuper, String informeSuper, String nomPlaza){
        this.codi=codi;
        this.nom=nom;
        this.salari=salari;
        this.codiPlaSuper=codiPlaSuper;
        this.informeSuper=informeSuper;
        this.nomPlaza=nomPlaza;
    }
    //getters y setters
    public void setCodi(int codi){
        this.codi=codi;
    }
    public int getCodi(){
        return codi;
    }

    public void setNom(String nom){
        this.nom=nom;
    }
    public String getNom(){
        return nom;
    }

    public void setSalari(int salari){
        this.salari=salari;
    }
    public int getSalari(){
        return salari;
    }

    public void setCodiPlaSuper(int codiPlaSuper){
        this.codiPlaSuper=codiPlaSuper;
    }
    public int getCodiPlaSuper(){
        return codiPlaSuper;
    }

    public void setInformeSuper(String informeSuper){
        this.informeSuper=informeSuper;
    }
    public String getInformeSuper(){
        return informeSuper;
    }

    public void setNomPlaza(String nomPlaza){
        this.nomPlaza=nomPlaza;
    }
    public String getNomPlaza(){
        return nomPlaza;
    }
    
    //metodos
}
