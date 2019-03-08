package app;

import Queue.Priority;
import Excepciones.isEmptyException;
import Excepciones.isFullException;
import Stack.StackSimpleList;
import Stack.Stacks;
import javax.swing.JOptionPane;
import Queue.*;
import java.util.Iterator;
public class Main {

    public static void main(String[] args) throws isEmptyException, isFullException {
        
   
         
        int resp = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el tamaño de la pila #1", null));
     Queue <Integer> queue = new QueueDoubleList <Integer>(resp);
      Priority<Integer> ma = new Priority(4);
       
        int opc;

        do {

            opc = Integer.parseInt(JOptionPane.showInputDialog("1: ENCOLAR"
                    + "\n 2: SACAR PRIMER VALOR"
                    + "\n3: REGRESAR EL VALOR PROXIMO A ELIMINAR"
                    + "\n4: REGRESA EL VALOR ULTIMO A ELIMINAR"
                    + "\n5: IMPRIMIR TODA LA COLA "
                    + "\n 6: VACIAR TODA LA COLA"
                    +"\n ----------------------------"
                    +"\n 7: Verificar si la cola se encuentra llena"
                    +"\n 8: Verificar si la cola se encuentra vacia"

                    + "\n9: Salir", null));
            int aux=0;
            switch (opc) {
                case 1:
                    aux = Integer.parseInt(JOptionPane.showInputDialog("INTRUDUZCA EL ELEMENTO QUE DESEA AGREGAR", null));
                    
                    ma.enqueue(2,4);
       

                    break;
                case 2:
                    ma.dequeue();
                    break;
                case 3:
                    System.out.println(""+ma.front());
         
                    break;
                case 4:
                    System.out.println(""+ma.last()); 
                    break;

                case 5:
                   Iterator <Integer> iterador =  queue.iterator(); 
                   while(iterador.hasNext()){
                       System.out.println(""+iterador.next());}
                  
                case 6:
                    ma.removeAll();
                    break;
                    
               
                case 7:
                  System.out.println(""+  ma.isFull(0));
                    break;
                    
                case 8:
                    System.out.println(""+ ma.isEmpty(0));
                    break; //este
                    
             
                 
                    
                    

            }
        } while (opc != 9 && opc > 0);
    }
    }   

