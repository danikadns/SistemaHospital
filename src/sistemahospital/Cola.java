/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospital;

/**
 *
 * @author Dany
 */
public class Cola {
    private Object[] arregloCola;
    private int frente;
    private int fin;
    private int tamanoMax;
    private int numeroElementos;
    
    //Constructor
    public Cola(int tamano){
        this.arregloCola = new Object[tamano];
        this.tamanoMax = tamano;
        this.numeroElementos = 0;
        this.frente = 0;
        this.fin = -1;
        
    }
    
    //Método para insertar elementos a la cola
    public void insertar(Object elemento){
        if(fin == tamanoMax -1){
            fin = -1;
        }
        
        fin++;
        
        arregloCola[fin] = elemento;
        numeroElementos++;
    }
    
    //la funcion retorna y el procedimiento no retorna nada
    //Método para extraer o remover elementos de la cola
    public Object quitar(){
        Object elementoTemporal = arregloCola[frente];
        frente++;
        if(frente == tamanoMax){
            frente =0;
        }
        numeroElementos--;
        return elementoTemporal;
    }
    
    //Metodo para obtener el elemento al frente de la cola
    public Object frenteCola(){
        return arregloCola[frente];
    }
    
    //Metodo para saber el tamaño de la cola
    public int tamanoCola(){
        return numeroElementos;
    }
    
    //Metodo para saber si la cola esta vacia
    public boolean colaVacia(){
        return (numeroElementos == 0);
    }
    
    //Metodo para saber si la cola esta llena
    public boolean colaLlena(){
        return(numeroElementos == tamanoMax);
    }
    
}
