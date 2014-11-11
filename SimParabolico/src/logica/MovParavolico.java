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
    private double tiempo = 0, tChoque = 0;
    
    public MovParavolico(double angulo, double vel, double vel_viento){
        this(angulo, vel, vel_viento, -9.8);
    }
    
    public MovParavolico(double angulo, double vel, double vel_viento, double gravedad){
        this.angulo = angulo;
        this.vel = vel;
        this.vel_viento = vel_viento;
        this.gravedad = gravedad;
        calVelocidades();
        calTChocque();
    }
    
    private void calVelocidades(){
        velX = vel * Math.cos(angulo);
        velY = vel * Math.sin(angulo);
    }
    
    private void calTChocque(){
        tChoque = (-2 * velY) / gravedad;
    }
    
    public void setTiempo(double tiempo){
        this.tiempo = tiempo;
    }
    
    public double getPosX(){
        if(tiempo <= tChoque){
            return (velX + vel_viento) * tiempo;
        }else{
            return (velX + vel_viento) * tChoque;
        }       
    }
    
    public double getPosY(){
        if(tiempo <= tChoque){
            return (velY * tiempo) + (gravedad * Math.pow(tiempo, 2)) / 2;
        }else{
            return 0;
        }
    }
}
