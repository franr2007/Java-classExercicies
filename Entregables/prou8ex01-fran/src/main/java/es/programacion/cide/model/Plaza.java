package es.programacion.cide.model;

public class Plaza {
    //atributos
    private int codi;
    private String nom;
    private Double salari;
    private Integer codiPlaSuper;
    private String informeSuper;
    private String tipoPlaza;
    //constructor
    public Plaza(){
    }

    public Plaza(int codi, String nom, Double salari, Integer codiPlaSuper, String informeSuper, String tipoPlaza){
        this.codi=codi;
        this.nom=nom;
        this.salari=salari;
        this.codiPlaSuper=codiPlaSuper;
        this.informeSuper=informeSuper;
        this.tipoPlaza=tipoPlaza;
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

    public void setSalari(Double salari){
        this.salari=salari;
    }
    public Double getSalari(){
        return salari;
    }

    public void setCodiPlaSuper(Integer codiPlaSuper){
        this.codiPlaSuper=codiPlaSuper;
    }
    public Integer getCodiPlaSuper(){
        return codiPlaSuper;
    }

    public void setInformeSuper(String informeSuper){
        this.informeSuper=informeSuper;
    }
    public String getInformeSuper(){
        return informeSuper;
    }

    public void setipoPlaza(String tipoPlaza){
        this.tipoPlaza=tipoPlaza;
    }
    public String getipoPlaza(){
        return tipoPlaza;
    }
    
    //metodos
    @Override
    public String toString() {
        return String.valueOf(codi)+" "+nom +"-"+tipoPlaza;
    }
}
