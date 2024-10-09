package Escuela;

public class Estudiante {

    // Atributos
    private String nombre;
    private int identificacion;
    private double calificacion;

    //Constructores
    public Estudiante() {
    }
    public Estudiante(String nombre, int identificacion, double calificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.calificacion = calificacion;
    }

    //SobreEscribir
    @Override
    public String toString() {
        return  "Nombre: " + this.nombre+       "n"+
                "Identificaacion: "  + this.identificacion+    "n"+
                "Calificacion: "  + this.calificacion+         "n";
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
