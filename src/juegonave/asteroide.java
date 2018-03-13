/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author 1daw
 */
public class asteroide {
    public Polygon polygon3 = new Polygon();
    private double multiplicador = 2.0;
    double angulo=0;
    int posicionY = 0;
    int posicionX = 0;
    int numero = 3;
    ArrayList<asteroide> listaAsteroide = new ArrayList();
    public asteroide(int SCENE_TAM_X, int SCENE_TAM_Y, double multiplicador){
        polygon3.setId("asteroide");
            polygon3.setFill(Color.web("#00FE00"));
            polygon3.getPoints().addAll(new Double[]{
                49.15 * multiplicador, 20.52 * multiplicador, 
                67.87 * multiplicador, 35.98 * multiplicador, 
                69.5 * multiplicador, 68.26 * multiplicador,  
                58.65* multiplicador, 92.13 * multiplicador, 
                33.42* multiplicador,100.82* multiplicador, 
                16.6* multiplicador, 90.24* multiplicador,
                23.93* multiplicador, 75.31* multiplicador, 
                14.7* multiplicador,62.02* multiplicador, 
                9.28* multiplicador, 42.76* multiplicador,
                16.06* multiplicador, 27.84* multiplicador,
                41.02* multiplicador, 13.46* multiplicador
                }); 
            Random randomx = new Random();
            Random randomy = new Random();
            posicionY = randomy.nextInt(SCENE_TAM_Y);
            posicionX = randomx.nextInt(SCENE_TAM_X);
            polygon3.setLayoutX(posicionX);
            polygon3.setLayoutY(posicionY);
     
    }
    public void rotarAsteroide(){
      polygon3.setRotate(angulo++);
      polygon3.setLayoutX(posicionX++);
      polygon3.setLayoutY(posicionY++);
    }
     /*public boolean chocarNaveAsteroide(asteroide asteroide, Pane root){
        Shape.intersect(asteroide.getPolygon(), cuerpo);  
        Shape shapeColision = Shape.intersect(asteroide.getPolygon(), cuerpo);
        boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                if (colisionVacia == false) {
                    root.getChildren().remove(nave);
                }
                return colisionVacia;
    }*/
    public void salirPantalla(int SCENE_TAM_X, int SCENE_TAM_Y){
        //si la x de la nave es mayor que el tamaño de la escena x
            if (polygon3.getLayoutX() > SCENE_TAM_X){
    //poner la x de la nave en 0
                polygon3.setLayoutX(0);
            }
    //si la x de la nave es menor que 0
            if (polygon3.getLayoutX() < 0){
    //ponerla nave en la posicion de la x de la escena
                polygon3.setLayoutX(SCENE_TAM_X);
            }
    //si la Y de la nave es mayor que el tamaño de la escena Y
            if (polygon3.getLayoutY() > SCENE_TAM_Y){
    //poner la nave en la posicion 0        
                polygon3.setLayoutY(0);
            }
    //si la Y de la nave es menor que 0        
            if (polygon3.getLayoutY() < 0){
    //poner la nave en la posicion Y de la escena        
                polygon3.setLayoutY(SCENE_TAM_Y);
            }
    }
    public Polygon getPolygon() {
        return polygon3;
        
    }
}

