package es.programacion.cide.model;

public class Empleado {
    // atributos
    private int id;
    private Long nss;
    private String nom;
    private String apellidos;
    private String email;
    private String iban;

    // constructor
    public Empleado() {
    }

    public Empleado(int id, Long nss, String nom, String apellidos, String email, String iban) {
        this.id = id;
        this.nss = nss;
        this.nom = nom;
        this.apellidos = apellidos;
        this.email = email;
        this.iban = iban;
    }

    // getters y setters
    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public Long getNss() {
        return nss;
    }

    public void setNss(Long nss) {
        this.nss = nss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
    // metodos

    @Override
    public String toString() {
        return String.valueOf(nss)+" "+nom+"-"+apellidos;
    }
}
