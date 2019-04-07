/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilosofosPrueba;

/**
 *
 * @author Victor Echavarria
 */
public class Tenedor {

    private int id; //Identificacion del tenedor
    private boolean libre = true; // ESta Libre o no 

    public Tenedor(int id) {
        this.id = id;
    }
    //Método sincornizado, para que solo ingrese una hebra a la vez
    public synchronized void qTenedor(int i) throws InterruptedException {
        //Mientras no este libre, ha de esperar
        while (!libre) {
            wait();
        }
        System.out.println("Filósofo " + i + " Coge Tenedor" + id);
        libre = false;

    }
    
    //Si esta libre, Suelta tenedor y notifica de que esta libre
    public synchronized void sTenedor(int i){
    libre=true;
        System.out.println("Filósofo "+i+" Suelta el tenedor"+id);
        notify();
    
    }

}
