/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;
import java.util.*;
/**
 *
 * @author Estudiante
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        double[] precio=new double[5];
        precio[0]=3450;
        precio[1]=4560;
        precio[2]=5600;
        precio[3]=3600;
        precio[4]=2450;
        Habitaciones[] habitaciones1=new Habitaciones[5];
        Habitaciones[] habitaciones2=new Habitaciones[2];
        Habitaciones[] habitaciones3=new Habitaciones[3];
        for(int i=0;i<5;i++){
            habitaciones1[i]=new Habitaciones();
            habitaciones1[i].setNumero(100+(i+1));
            habitaciones1[i].setCapacidad_maxima(i+3);
            habitaciones1[i].setPrecio(precio[i]);
        }
        for(int j=0;j<2;j++){
            habitaciones2[j]=new Habitaciones();
            habitaciones2[j].setNumero(200+(j+1));
            habitaciones2[j].setCapacidad_maxima(j+3);
            habitaciones2[j].setPrecio(precio[j]);
        }
        for(int k=0;k<3;k++){
            habitaciones3[k]=new Habitaciones();
            habitaciones3[k].setNumero(300+(k+1));
            habitaciones3[k].setCapacidad_maxima(k+3);
            habitaciones3[k].setPrecio(precio[k]);
        }
        Hotel hotel=new Hotel(habitaciones1, habitaciones2, habitaciones3);
        hotel.Alquilar_hab();
        hotel.Alquilar_hab();
    }
    
}
