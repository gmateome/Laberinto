

package my.labyrinth.labyrinth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;


public class Labyrinth {

    public static void main(String[] args) {
        
        Map newMap = new Map("C:\\Users\\gmateome\\Documents\\Formacion Java\\laberinto.txt");
        newMap.setMap();
        Posicion myPosition = new Posicion(newMap.getEntradaX(),newMap.getEntradaY());
        Posicion lastPosition = new Posicion(newMap.getEntradaX(),newMap.getEntradaY());
        System.out.println("Posicion inicial: "+myPosition.getY()+","+myPosition.getX());       
        System.out.println(newMap.getCasilla(myPosition.getX(), myPosition.getY()));
        Stack<Integer> pilaX= new Stack<Integer>();
        Stack<Integer> pilaY= new Stack<Integer>();
        pilaX.push(myPosition.getX());
        pilaY.push(myPosition.getY());
        boolean retroceso=false;
        
        while(newMap.getCasilla(myPosition.getX(), myPosition.getY())!='S'){       
            myPosition.moveRight();
        if(newMap.getCasilla(myPosition.getX(), myPosition.getY())==' ' || newMap.getCasilla(myPosition.getX(), myPosition.getY())=='S' ){
            pilaX.push(myPosition.getX());
            pilaY.push(myPosition.getY());
            if(newMap.getCasilla(myPosition.getX(), myPosition.getY())!='S'){newMap.taparCasilla(myPosition.getX(), myPosition.getY());}
        }else{
            myPosition.moveLeft();
            myPosition.moveDown();
            if(newMap.getCasilla(myPosition.getX(), myPosition.getY())==' ' || newMap.getCasilla(myPosition.getX(), myPosition.getY())=='S'){
                pilaX.push(myPosition.getX());
                pilaY.push(myPosition.getY());
                if(newMap.getCasilla(myPosition.getX(), myPosition.getY())!='S'){newMap.taparCasilla(myPosition.getX(), myPosition.getY());}
            }else{
                myPosition.moveTop();
                myPosition.moveLeft();
                if(newMap.getCasilla(myPosition.getX(), myPosition.getY())==' ' || newMap.getCasilla(myPosition.getX(), myPosition.getY())=='S'){
                    pilaX.push(myPosition.getX());
                    pilaY.push(myPosition.getY());
                    if(newMap.getCasilla(myPosition.getX(), myPosition.getY())!='S'){newMap.taparCasilla(myPosition.getX(), myPosition.getY());}
                }else{
                    myPosition.moveRight();
                    myPosition.moveTop();
                    if(newMap.getCasilla(myPosition.getX(), myPosition.getY())==' ' || newMap.getCasilla(myPosition.getX(), myPosition.getY())=='S'){
                        pilaX.push(myPosition.getX());
                        pilaY.push(myPosition.getY());
                        if(newMap.getCasilla(myPosition.getX(), myPosition.getY())!='S'){newMap.taparCasilla(myPosition.getX(), myPosition.getY());} 
                    }else{
                        myPosition.moveDown();
                        System.out.println("Posicion actual: "+myPosition.getY()+","+myPosition.getX()); 
                        myPosition.setPosition(pilaX.pop(), pilaY.pop());

                        retroceso=true;
                    }
                }
            }
        }
            System.out.println("Posicion actual: "+myPosition.getY()+","+myPosition.getX());  
        }   
        
         
        
        ArrayDeque<String> movimientos = new ArrayDeque<String>();
        while(pilaX.size()>0){
            movimientos.addFirst("Fila "+String.valueOf(pilaY.pop())+" Columna "+String.valueOf(pilaX.pop()));
        }
        for(String move: movimientos){
            System.out.println(move);
        }
        
        System.out.println("Ha llegado a la meta");
        
    }
}
