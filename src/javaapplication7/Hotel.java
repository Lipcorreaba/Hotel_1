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
public class Hotel {
    private int r=0;
    Scanner leer=new Scanner(System.in);
    private Pisos[] pisos;
    private HashMap<Integer,Alquiler> alquiler;

    public Hotel(Habitaciones[] habitaciones1, Habitaciones[] habitaciones2 ,Habitaciones[] habitaciones3) {
        this.pisos = new Pisos[3];
        this.alquiler = new HashMap<Integer,Alquiler>();
        for(int y=0;y<pisos.length;y++){
            pisos[y]=new Pisos();
            pisos[y].setNumero(y+1);
        }
        pisos[0].setHabitaciones(habitaciones1);
        pisos[1].setHabitaciones(habitaciones2);
        pisos[2].setHabitaciones(habitaciones3);
    }

    public Pisos[] getPisos() {
        return pisos;
    }
    
    public void Alquilar_hab(){
        Alquiler al=new Alquiler();
        
        System.out.println("Ingrese dia, mes y año");
        int dia=leer.nextInt();
        int mes=leer.nextInt();
        int anio=leer.nextInt();
        Fecha fecha=new Fecha(dia,mes,anio);
        al.setFecha(fecha);
        System.out.println("Seleccione una habitacion (numero de habitacion)");
        int hab;
        for(int i=0;i<3;i++){
            for(int j=0;j<pisos[i].getHabitaciones().length;j++){
                if(this.alquiler.containsKey(pisos[i].getHabitaciones()[j].getNumero())==false){
                System.out.println(pisos[i].getHabitaciones()[j].getNumero() + " ... " + pisos[i].getHabitaciones()[j].getPrecio() + " Cap: " + pisos[i].getHabitaciones()[j].getCapacidad_maxima());
                }
            } 
        }
        hab=leer.nextInt();
        System.out.println("Para cuantas personas: ");
        int n=leer.nextInt();
        for(int h=0;h<3;h++){
            for(int f=0;f<pisos[h].getHabitaciones().length;f++){
                if(pisos[h].getHabitaciones()[f].getNumero()==hab){
                    al.setHabitacion(pisos[h].getHabitaciones()[f]);
                    al.setPrecio(pisos[h].getHabitaciones()[f].getPrecio());
                    if(n<=pisos[h].getHabitaciones()[f].getCapacidad_maxima()){
                        System.out.println("Persona responsable de la habitacion: ");
                        System.out.println("Nombre: ");
                        String nombre=leer.nextLine();
                        System.out.println("Apellido: ");
                        String apellido=leer.nextLine();
                        System.out.println("Cedula: ");
                        int cc=leer.nextInt();
                        System.out.println("Telefono: ");
                        int tel=leer.nextInt();
                        Personas p=new Personas(nombre, apellido, cc, tel);
                        al.setResponsable(p);
                        ArrayList<Personas> pe= new ArrayList<Personas>();
                        for(int g=0;g<n-1;g++){      
                            System.out.print("Nombre: ");
                            nombre=leer.nextLine();
                            System.out.print("Apellido: ");
                            apellido=leer.nextLine();
                            System.out.print("Cedula: ");
                            cc=leer.nextInt();
                            System.out.print("Telefono: ");
                            tel=leer.nextInt();
                            p=new Personas(nombre, apellido, cc, tel);
                            pe.add(p);
                        }   
                        al.setPersonas(pe);
                    }
                }
            }     
        }
        this.alquiler.put(r, al);
        r++;
    }
    public void Listarpersonas(){
        Scanner leer=new Scanner(System.in);
        System.out.println("Ingrese el numero de habitacion");
        int num=leer.nextInt();
        System.out.println("Responsable: "+ alquiler.get(num).getResponsable());
        for(int n=0;n<alquiler.get(num).getPersonas().size();n++){
            System.out.println(alquiler.get(num).getPersonas().get(n));
        }
    }
}
