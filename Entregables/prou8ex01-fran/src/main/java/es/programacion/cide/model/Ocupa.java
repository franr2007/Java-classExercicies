package es.programacion.cide.model;

public class Ocupa {
    //atributos
    private int id;
    private Long nssEmpleado;
    private int codiPlaza;
    private String dataInici;
    private String dataFi;

    //constructor
    public Ocupa(){

    }

    public Ocupa(int id, Long nssEmpleado, int codiPlaza, String dataInici, String dataFi){
        this.id=id;
        this.nssEmpleado=nssEmpleado;
        this.codiPlaza=codiPlaza;
        this.dataInici=dataInici;
        this.dataFi=dataFi;
    }

    //getters y setters
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setNssEmp(Long nssEmpleado){
        this.nssEmpleado=nssEmpleado;
    }
    public Long getNssEmp(){
        return nssEmpleado;
    }

    public void setCodiPlaza(int codiPlaza){
        this.codiPlaza=codiPlaza;
    }
    public int getCodiPlaza(){
        return codiPlaza;
    }

    public void setDataInici(String dataInici){
        this.dataInici=dataInici;
    }
    public String getDataInici(){
        return dataInici;
    }

    public void setDataFi(String dataFi){
        this.dataFi=dataFi;
    }
    public String getDataFi(){
        return dataFi;
    }

    //metodos
}
