package Tickets;

import Usuarios.Employee;
import Usuarios.Technical;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerTicket {
    //Atributos
    private int ID; //número aleatorio
    public String  titulo;
    public String descripcion;
    public Employee employee;
    public  Technical tecnicoResponsable;

    public static ArrayList<Ticket> allTickets = new ArrayList<>();
    static int IdActual = 1;


    //Interfaces

    public interface manageTickets{
        default void getAllTickets(){
            for (int i = 0; i < allTickets.size(); i++){
                allTickets.get(i).getData();
            }
        }

        default void searchTicket(){
            try {
                System.out.println("Introduzca el ID del ticket que desea buscar");
                var scanerTicket = new Scanner(System.in);
                int valorScaner = scanerTicket.nextInt();
                if(valorScaner > allTickets.size() || valorScaner == 0){
                    throw new IndexOutOfBoundsException("ID no encontrado");
                }else{
                    for(int i = 0; i < allTickets.size(); i++){
                     if (allTickets.get(i).ID == valorScaner){
                         allTickets.get(i).getData();
                     }
                    }
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
/*
    public interface manageTechnical{
        default void assignTicket(int id){
            try{
                if (id > allTickets.size() || id == 0){
                    throw new ArrayIndexOutOfBoundsException("No se ha encontrado el ID indicado");
                }else {
                    for(int i=0; i < allTickets.size(); i++){
                        if (id == allTickets.get(i).ID){
                            allTickets.get(i).getData();
                            System.out.println("Si desea asignarse el ticket, pulse 1");
                            System.out.println("Si desea buscar otro ticket, pulse 2");
                            var respuestaScaner = new Scanner(System.in);
                            int valorRespuesta = respuestaScaner.nextInt();
                            if (valorRespuesta == 1){

                            } else if (valorRespuesta == 2) {
                                System.out.println("Introduzca el ID del ticket que desea buscar");
                            }
                        }

                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
 */

}
