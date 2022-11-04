
package my.labyrinth.labyrinth;


public class Posicion {
    
    int x;
    int y;
    
    public Posicion(int x, int y){
        this.x=x;
        this.y=y;
    }
    
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void moveRight(){
        x=x+1;
    }
    
    public void moveDown(){
        y=y+1;
    }
    
    public void moveLeft(){
        x=x-1;
    }
    
    public void moveTop(){
        y=y-1;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
}
