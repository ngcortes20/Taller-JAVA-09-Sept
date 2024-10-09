package Escuela;

import java.util.HashSet;
import java.util.Set;

public class Escuela {

    private Set<Estudiante> estudiantes; //para que no hayan duplicados

    //Constructor
    public Escuela() {
        this.estudiantes = new HashSet<>();
    }

    //Metodo agregar estudiante
    public boolean agregarEstudiante(Estudiante estudiante){
        for (Estudiante e : estudiantes) {
            if (e.getIdentificacion() == estudiante.getIdentificacion()) {
                System.out.println("Error: Este numero de identificacion ya esta registrado");
                return false;
            }
        }
        estudiantes.add(estudiante);
        System.out.println("Registro Exitoso");
        return true;
    }

    //Metodo buscar y devolver un estudiante por su numero de idenficacion
    public Estudiante buscarEstudiante(int identificacion){
        for (Estudiante e : estudiantes) {
            if (e.getIdentificacion() == identificacion) {
                return e; //Lleva al estudiante si lo encuentra
            }
        }
        return null; // Si no lo encuentra, null
    }

    //Metodo actualizar los datos de un estudiante existente
    public boolean actualizarEstudiante(int identificacion, String nuevoNombre, double nuevaCalificacion) {
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
            estudiante.setCalificacion(nuevaCalificacion);
            // estudiante.setIdentificacion();
            System.out.println("Datos del actualizados correctamente");
            return true;
        } else {
            System.out.println("Estudiante no encontrado");
            return false;
        }
    }

    // Metodo eliminar un estudiante de la lista por su número de identificación.
    public boolean eliminarEstudiante(int identificacion){
        Estudiante estudiante = buscarEstudiante(identificacion);
        if (estudiante != null) {
            estudiantes.remove(estudiante);
            System.out.println("Estudiante eliminado correctamente");
            return true;
        } else {
            System.out.println("Estudiante no encontrado");
            return false;
        }
    }

}
