package Usuarios;

import Tickets.ManagerTicket;
import Tickets.Ticket;

import java.util.Scanner;

import static Tickets.ManagerTicket.allTickets;

public class Technical implements ManagerEmployee.showEmployee, ManagerTicket.manageTickets {
    //Atributos
    public String ID; //DNI
    public String name;
    public String surnames;
    public final String departamento = "Técnico";

    //Constructor
    public Technical(String ID, String name, String surnames){
        this.ID = ID;
        this.name = name;
        this.surnames = surnames;
    }

    //Métodos
    public void assignTicket(int id){
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
                            allTickets.get(i).tecnicoResponsable = this;
                            System.out.println("Ticket asignado correctamente");
                            allTickets.get(i).getData();
                        } else if (valorRespuesta == 2) {
                            System.out.println("Introduzca el ID del ticket que desea buscar");
                            var newScanner = new Scanner(System.in);
                            int nuevaBusqueda = newScanner.nextInt();
                            assignTicket(nuevaBusqueda);
                        }else{
                            System.out.println("Error: algo ha salido mal" );
                        }
                    }

                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }


}
