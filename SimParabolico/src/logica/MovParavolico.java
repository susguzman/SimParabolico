/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Jesus
 */
public class MovParavolico {    
    private double angulo;      //radianes
    private double vel, velX, velY, vel_viento; 
    private double gravedad;
    private boolean avanceX = true;
    private double tiempo = 0, posx = 0, posy =0;
    
    public MovParavolico(double angulo, double vel, double vel_viento){
        this(angulo, vel, vel_viento, -9.8);
    }
    
    public MovParavolico(double angulo, double vel, double vel_viento, double gravedad){
        this.angulo = angulo;
        this.vel = vel;
        this.vel_viento = vel_viento;
        this.gravedad = gravedad;
        calVelocidades();
    }
    
    private void calVelocidades(){
        velX = vel * Math.cos(angulo);
        velY = vel * Math.sin(angulo);
    }
    
    public void setTiempo(double tiempo){
        this.tiempo = tiempo;
    }
    
    public double getPosX(){
        if(avanceX){
            posx = (velX + vel_viento) * tiempo;
            return posx;
        }else{
            return posx;
        }        
    }
    
    public double getPosY(){
        posy = (velY * tiempo) + (gravedad * Math.pow(tiempo, 2)) / 2;
        if(posy >= 0){
            return posy;
        }else{
            avanceX = false;
            return 0;            
        }
    }
}
