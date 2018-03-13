/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegonave;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author 1daw
 */
public class Nave {
    private Group nave = new Group();
    private Group pantalla = new Group();
    public double angulo = 0;
    juegoNave juuegoNave;
    private double variaX = 0.0;
    private double variaY = 0.0;
    public boolean rotIzq = false;
    public boolean rotDer = false;
    public boolean rotAcel = false;
    double velocidadX = 0.0;
    double velocidadY = 0.0;
    double potenciaNave = 0.2;
    double velocidadGiro = 5;
    public final int SCENE_TAM_X = 1000;
    public final int SCENE_TAM_Y = 800;
    private Polygon polygon = new Polygon();
    private Polygon polygon1 = new Polygon();
    private Polygon polygon2 = new Polygon();
    private Polygon polygon3 = new Polygon();
    Rectangle cuerpoCañon = new Rectangle(5, 0, 10, 30);
    Stage primaryStage; 
    Rectangle cuerpo = new Rectangle(0.5, 0, 20, 80);
    public Nave(){
    nave.getChildren().add(cuerpo);    
    nave.getChildren().add(cuerpoCañon);
    nave.getChildren().add(polygon);
    polygon.getPoints().addAll(new Double[]{
        10.0, 0.0,
        0.0, 60.0,
        20.0, 60.0 });
    //Creacion primera helice
    nave.getChildren().add(polygon1);
    polygon1.getPoints().addAll(new Double[]{
        5.0, 80.0,
        0.0, 60.0,
        10.0, 60.0 });
        //Creacion segunda helice
    nave.getChildren().add(polygon2);
    polygon2.getPoints().addAll(new Double[]{
        15.0, 80.0,
        10.0, 60.0,
        20.0, 60.0 });
    nave.getChildren().add(polygon3);
    polygon3.getPoints().addAll(new Double[]{
        10.0, 20.0,
        0.0, 60.0,
        20.0, 60.0 });
    this.nave = nave;
    }
    public Group getGroup() {
        return nave;    
    }
    public double creacioncoseno() {
    //CalculoSeno
    variaX=Math.sin(Math.toRadians(angulo));
        return variaX;
    }
    public double CreacionSeno() {
    //CalculoCoseno
    variaY=Math.cos(Math.toRadians(angulo))*-1;    
        return variaY;
    }
    public void aceleracion(){
    if (rotAcel){
    //si aceleramos la velocidad sera igual a la velocidad mas la potencia de la nave * el seno o coseno correspondiente
                velocidadX=velocidadX+potenciaNave*variaX;
                System.out.println("la velocidad de la nave X"+velocidadX);
                velocidadY=velocidadY+potenciaNave*variaY;
                System.out.println("la velocidad de la nave Y"+velocidadY);
            }    
    }
    public void frenarNave(){
        velocidadX= 0;
        velocidadY= 0;
    }
    public double rotacionNave(){
        //Usado para la rotacion de la nave
            if (rotIzq){
    //si la rotacion izquierda es true  el angulo le reduces velociad de giro
                angulo -=velocidadGiro;   
            } 
            else if(rotDer){
    //si la rotacion izquierda es true  el angulo le sumas velociad de giro
                angulo +=velocidadGiro;    
            }
    //si el angulo es mayor que  360 poner el angulo en 0
            if (angulo>360){
                angulo=0;
            }
    //si el angulo es inferior a 0 poner el angulo en 360
            else if (angulo<0){
                angulo=360;
            }
            
            nave.setRotate(angulo);
            //System.out.println("angulo es igual a:" + angulo);
            return angulo;
    }
    public void salirPantalla(){
        //si la x de la nave es mayor que el tamaño de la escena x
            if (nave.getLayoutX() > SCENE_TAM_X){
    //poner la x de la nave en 0
                nave.setLayoutX(0);
            }
    //si la x de la nave es menor que 0
            if (nave.getLayoutX() < 0){
    //ponerla nave en la posicion de la x de la escena
                nave.setLayoutX(SCENE_TAM_X);
            }
    //si la Y de la nave es mayor que el tamaño de la escena Y
            if (nave.getLayoutY() > SCENE_TAM_Y){
    //poner la nave en la posicion 0        
                nave.setLayoutY(0);
            }
    //si la Y de la nave es menor que 0        
            if (nave.getLayoutY() < 0){
    //poner la nave en la posicion Y de la escena        
                nave.setLayoutY(SCENE_TAM_Y);
            }
    }
    public boolean chocarNaveAsteroide(asteroide asteroide, Pane root){
        Shape.intersect(asteroide.getPolygon(), cuerpo);  
        Shape shapeColision = Shape.intersect(asteroide.getPolygon(), cuerpo);
        boolean colisionVacia = shapeColision.getBoundsInLocal().isEmpty();
                if (colisionVacia == false) {
                   root.getChildren().remove(nave);
                }
                return colisionVacia;
    }
	
    public Polygon getPolygon() {
        return polygon;
        
    }
    public Polygon getPolygon1() {
        return polygon1;
        
    }
    public Polygon getPolygon2() {
        return polygon1;
        
    }
    public Polygon getPolygon3() {
        return polygon2;
        
    }
    public Rectangle getPolygon4() {
        return cuerpo;
        
    }
    public Rectangle getPolygon5() {
        return cuerpoCañon;
        
    }
}