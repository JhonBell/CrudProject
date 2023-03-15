package model;

public class Hadrosaurios{

    private int id; 
    private String nombre;
    private String familia;
    private String genero;
    private String era;
    private String altura;
    private String peso;
    private String longitud;
    private String dieta;

    public Hadrosaurios(){

    }

    public Hadrosaurios(int id, String nombre, String familia, String genero, String era, 
                      String altura, String peso, String longitud, String dieta){
        this.id = id;
        this.nombre = nombre;
        this.familia = familia;
        this.genero = genero;
        this.era = era;
        this.altura = altura;
        this.peso = peso;
        this.longitud = longitud;
        this.dieta = dieta;                 
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setFamilia(String familia){
        this.familia = familia;
    }

    public String getFamilia(){
        return this.familia;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setEra(String era){
        this.era = era;
    }

    public String getEra(){
        return this.era;
    }

    public void setAltura(String altura){
        this.altura = altura;
    }

    public String getAltura(){
        return this.altura;
    }

    public void setPeso(String peso){
        this.peso = peso;
    }

    public String getPeso(){
        return this.peso;
    }

    public void setLongitud(String longitud){
        this.longitud = longitud;
    }

    public String getLongitud(){
        return this.longitud;
    }

    public void setDieta(String dieta){
        this.dieta = dieta;
    }

    public String getDieta(){
        return this.dieta;
    }



}