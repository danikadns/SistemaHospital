/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospital;

/**
 *
 * @author Dany
 */
public class FichaTurno {
    
    private int especialidad;
    private int numeroTurno;

    public FichaTurno(int especialidad, int numeroTurno) {
        this.especialidad = especialidad;
        this.numeroTurno = numeroTurno;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
    
    
    
}
