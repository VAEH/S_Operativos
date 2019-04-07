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
public class Silla {
    //SIllas libres, 4 para que los filosofos no mueran, y solo se param cuando no tengan habmbre
    private int sLibre=4;
//    private int id;
//    public Silla(int id) {
//        this.id = id;
//    }
    
    //Se crea el evento sincronizado para que 2 filosos NO! se siente en la misma silla
    public synchronized void qSilla(int i) throws InterruptedException{//SE lanza exepcion
        while(sLibre==0)//Mientras no este libre, se espera
            wait();
            System.out.println("Filósofo "+i+" Coge una Silla " );
            sLibre--;
        }
        
        public synchronized void sSilla(int i){ //Se notifica que se solto una silla
            sLibre++;
            System.out.println("Filósofo "+i+ " Suelta una Silla ");
            notify();
        }
        
    
}
