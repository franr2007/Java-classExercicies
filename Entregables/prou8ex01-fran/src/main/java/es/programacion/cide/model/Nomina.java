package es.programacion.cide.model;

public class Nomina {
    //atributos
    private int id;
    private String iban_pagament;
    private String importe;
    private int nssEmpleado;
    private int codiPlaza;
    //constructor
    public Nomina(){
    }

    public Nomina(int id, String iban_pagament, String importe, int nssEmpleado, int codiPlaza){
        this.id=id;
        this.iban_pagament=iban_pagament;
        this.importe=importe;
        this.nssEmpleado=nssEmpleado;
        this.codiPlaza=codiPlaza;
    }

    //getters y setters
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public void setIbanPag(String iban_pagament){
        this.iban_pagament=iban_pagament;
    }
    public String getIbanPag(){
        return iban_pagament;
    }

    public void setImporte(String importe){
        this.importe=importe;
    }
    public String getImporte(){
        return importe;
    }

    public void setNssEmleado(int nssEmpleado){
        this.nssEmpleado=nssEmpleado;
    }
    public int getNssEmpleado(){
        return nssEmpleado;
    }

    public void setCodiPlaza(int codiPlaza){
        this.codiPlaza=codiPlaza;
    }
    public int getCodiPlaza(){
        return codiPlaza;
    }
    //metodos
}
