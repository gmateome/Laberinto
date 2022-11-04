
package my.labyrinth.labyrinth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    
    String fichero;
    ArrayList<String> tablero= new ArrayList<String>();
    char[][] map;
    int entradaX;
    int entradaY;
    
    public Map(String fichero){
        this.fichero=fichero;
    }
    
    public void setMap(){    
        int fila=0;
        int longitud=0;
        String linea;
        
        try{
        File archivo = new File (fichero);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);
        
        while((linea = br.readLine())!=null) {               
                fila++; 
                longitud=linea.length();
                tablero.add(linea);
        } 
        br.close();         
        System.out.println("Dimensiones del tablero: "+longitud+"x"+fila);
        
        map = new char[fila][longitud];
        fila=0;
        
        for(String cadena: tablero){
            for(int i=0;i<cadena.length();i++){                 
                    if(cadena.charAt(i)=='E'){entradaX=i;entradaY=fila;}
                    map[fila][i]=cadena.charAt(i);
                }                
            fila++;  
        }
          
        }catch(Exception e){
        System.out.println(e);
        } 
    }
    
    public void taparCasilla(int x, int y){
        map[y][x]='#';
    }
    
    public int getEntradaX(){   
        return entradaX;
    }
    
    public int getEntradaY(){   
        return entradaY;
    }
    
    public char getCasilla(int x,int y){
        char casilla;
        casilla = map[y][x];
        return casilla;
    }
}
