/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FilosofosPrueba;

//El filosofo, solo come y piensa...
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Echavarria
 */
public class Filosofo extends Thread{
    //Lo unico que hace un filosfo es  Comer y Pensar.
    private int id;
    private Tenedor izda, dcha;
    private Silla s;
    //Contiene lo que ha de necesitar el filosofo, id, Tenedores y silla
    
    public Filosofo(int id, Tenedor izda, Tenedor dcha, Silla s){
        this.id=id;
        this.izda=izda;
        this.dcha=dcha;
        this.s=s;
    }
    
    public void run(){
        while(true){
            try { //El man se tiene que sentar para poder comer -_-
                s.qSilla(id);
                //Coge tenedor izquierda, derecha
                izda.qTenedor(id);
                dcha.qTenedor(id);
                //Comer
                //Suelta tenedores
                dcha.sTenedor(id);
                izda.sTenedor(id);
                s.sSilla(id);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    
}
