package Tickets;

import Usuarios.Employee;
import Usuarios.Technical;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerTicket {
    //Atributos
    private int ID; //número aleatorio
    public String titulo;
    public String descripcion;
    public Employee employee;
    public Estado estado;
    public Technical tecnicoResponsable;

    public enum Estado {
        Pendiente, EnCurso, Resuelto;
    }

    public static ArrayList<Ticket> allTickets = new ArrayList<>();
    static int IdActual = 1;


    //Interfaces

    public interface manageTickets {
        default void getAllTickets() {
            for (int i = 0; i < allTickets.size(); i++) {
                allTickets.get(i).getData();
            }
        }
/*
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
 */
    }
}
