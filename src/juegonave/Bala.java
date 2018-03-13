/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author 1daw
 */
public class Bala {
private Group bala = new Group();
double balaX = 0.0;
double balaY = 0.0;
double velBala = 1.0;
double potenciaNave = 0.2;
public boolean disparar = false;
Rectangle cuerpoVala = new Rectangle(50, 50, 5, 30);
    public Group getGroup() {
        return bala;    
    }
    public void disparar(double angulo, double x, double y, double velocidadX, double velocidadY, double coseno, double seno){
        cuerpoVala.setId("rectangle1");
        cuerpoVala.setFill(Color.web("#FF0000"));
        bala.getChildren().add(cuerpoVala);
        bala.setVisible(true);
        balaX = velocidadX+velBala*coseno;
        balaY = velocidadY+velBala*seno;
        bala.setLayoutX(x);
        bala.setLayoutY(y);
        bala.setRotate(angulo);
        balaX = x;
        balaY = y;
                
    }
    public void moverBala(double variaY, double variaX)
    {
    bala.setLayoutX(balaX+variaX);
    bala.setLayoutY(balaY+variaY);
    balaX += velBala +variaX;
    balaY += velBala +variaY;
    }
    public Rectangle getRectangle() {
        return cuerpoVala;
        
    }
}
