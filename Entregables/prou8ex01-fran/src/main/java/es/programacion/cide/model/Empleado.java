package es.programacion.cide.model;

public class Empleado {
    //atributos
    private int nss;
    private String nom;
    private String apellidos;
    private String email;
    private String iban;

    //constructor
    public Empleado() {
    }

    public Empleado(int nss, String nom, String apellidos, String email, String iban) {
    this.nss = nss;
    this.nom = nom;
    this.apellidos = apellidos;
    this.email = email;
    this.iban = iban;
    }

    //getters y setters
    public int getNss(){
        return nss;
    }
    public void setNss(int nss){
        this.nss=nss;
    }

    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom=nom;
    }

    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getIban(){
        return iban;
    }
    public void setIban(String iban){
        this.iban=iban;
    }
    //metodos
}
