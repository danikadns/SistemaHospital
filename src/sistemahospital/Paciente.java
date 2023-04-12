/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospital;

/**
 *
 * @author Dany
 */
public class Paciente {
    
    private String nombre;
    private String apellido;
    private double peso;
    private int edad;
    private int genero;
    
    
    private FichaTurno turno1; 
    private FichaTurno turno2;
    
    private int especialidad_1;
    private int especialidad_2;

    public Paciente(String nombre, String apellido, double peso, int edad, int genero, FichaTurno turno1, FichaTurno turno2, int especialidad_1, int especialidad_2) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.edad = edad;
        this.genero = genero;
        this.turno1 = turno1;
        this.turno2 = turno2;
        this.especialidad_1 = especialidad_1;
        this.especialidad_2 = especialidad_2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public FichaTurno getTurno1() {
        return turno1;
    }

    public void setTurno1(FichaTurno turno1) {
        this.turno1 = turno1;
    }

    public FichaTurno getTurno2() {
        return turno2;
    }

    public void setTurno2(FichaTurno turno2) {
        this.turno2 = turno2;
    }

    public int getEspecialidad_1() {
        return especialidad_1;
    }

    public void setEspecialidad_1(int especialidad_1) {
        this.especialidad_1 = especialidad_1;
    }

    public int getEspecialidad_2() {
        return especialidad_2;
    }

    public void setEspecialidad_2(int especialidad_2) {
        this.especialidad_2 = especialidad_2;
    }
    
    
    
}
