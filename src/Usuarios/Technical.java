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
                            stateChangeEncurso(allTickets.get(i));
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

    //Esta función solo se utiliza para actualizar el estado cuando se asigna el ticket
    private void stateChangeEncurso(Ticket ticket){
        ticket.estado = ManagerTicket.Estado.EnCurso;
    }

    public void updateTicketState(int id, ManagerTicket.Estado estado){
        try {
            if (id > allTickets.size() || id == 0){
                throw new ArrayIndexOutOfBoundsException("El ID introducido no es valido");
            }else{
                for(int i=0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        allTickets.get(i).estado =  estado;
                        allTickets.get(i).tecnicoResponsable = this;
                        System.out.println("El estado del ticket se ha actualizado correctamente");
                        allTickets.get(i).getData();
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void commentTicket(int id){
        try{
            if (id > allTickets.size() || id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ID indicado");
            }else{
                for (int i = 0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        allTickets.get(i).getData();
                        System.out.println("Escriba el comentario deseado:");
                        var commentScanner = new Scanner(System.in);
                        String varloComentario = commentScanner.nextLine();
                        allTickets.get(i).comentarios.add(varloComentario);
                        System.out.println("Comentario agregador correctamente");

                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showComment(int id){
        try {
            if (id > allTickets.size() ||id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ticket indicado");
            }else{
                for (int i=0; i < allTickets.size(); i++){
                    if (id == allTickets.get(i).ID){
                        if (allTickets.get(i).comentarios.isEmpty()){
                            System.out.println("Aún no hay comentarios disponibles");
                        }else{
                            for (int x=0; x < allTickets.get(i).comentarios.size(); x++){
                                System.out.println(allTickets.get(i).comentarios.get(x));
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
