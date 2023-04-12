/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemahospital;

/**
 *
 * @author Dany
 */
public class Pila {
    private Object [] arregloPila;
    private int tamanoPila;
    private int cima;
     
    //constructor
    public Pila(int tamano){
        this.tamanoPila= tamano;
        this.cima = -1;
        arregloPila = new Object[tamano];
    }
    
    //METODO PUSH
    public void push(Object elemento){
        cima++;
        arregloPila[cima]= elemento;
    }
    
    //metodo pop
    public Object pop(){
        Object temporal = arregloPila[cima];
        cima--;
        return temporal;
    }
    //Metodo cual es la cima
    public Object cimaPila(){
        return arregloPila[cima];
    }
    //metodo para saber si la pila esta vacia 
    
    public boolean pilaVacia(){
        return cima==-1;
    }
    
    
    //metodo para saber si la pila esta llena 
    public boolean pilaLlena(){
        return cima == tamanoPila -1;
    }
    
    
    //Metodo para obtener la cantidad de elementos de la pila 
    public int cantidadElementosPila(){
        return cima+1;
    }
    
    //mostrar todos los valors de la fila
    
    public void mostrarElementosPila(){
        for(int i=0; i<cantidadElementosPila(); i++){
            System.out.println(arregloPila[i]);
             System.out.print("  ");
        }
    }
}
