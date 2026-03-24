package es.programacion.cide;

//Francisco Javier Rodriguez

public class Torrada implements Menjar,Graella{//Superclase Torrada
    //atributos
    protected String festivitat;
    protected String any;
    //constructor
    public Torrada(String festivitat, String any){
        this.festivitat=festivitat;
        this.any=any;
    }
    //getters y setters
    public void setFestivitat(String festivitat){
        this.festivitat=festivitat;
    }

    public String getFestivitat(){
        return festivitat;
    }

    public void setAny(String any){
        this.any=any;
    }

    public String getAny(){
        return any;
    }
    
    //metodos
    @Override
    public boolean estaFet() {
        return false;
    }

    @Override
    public void posarCarnAGraella() {}

    @Override
    public void llevarCarnDeGraella() {}

    @Override
    public void assaborir() {}

    @Override
    public boolean crema() {
        return false;
    }
}
