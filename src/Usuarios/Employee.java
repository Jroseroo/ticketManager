package Usuarios;

import Tickets.Ticket;

import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends ManagerEmployee{
    //Atributos
    public int ID; //DNI
    public String name;
    public String surnames;
    public String departamento;

    ArrayList<Ticket> misTickets = new ArrayList<>();
    //static ArrayList<Employee> allEmployee = new ArrayList<>();

    //Constructor
    public Employee(String name, String surnames, String departamento){
        this.ID = IdUserActual ++;
        this.name = name;
        this.surnames = surnames;
        this.departamento = departamento;
        allEmployee.add(this);
    }

    //Métodos
    public void crearTicket(String titulo, String descripcion){
        var nuevoTicket = new Ticket(titulo, descripcion, this);
        misTickets.add(nuevoTicket);
    }

    public void mostrarTicketsUser(){
        for(int i = 0; i < misTickets.size(); i++){
            misTickets.get(i).getData();
        }
    }

    public void getUserData(){
        System.out.println("ID" + this.ID + " " + this.name + " " + this.surnames);
    }


    public void commentTicket(int id){
        try{
            if (id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ID indicado");
            }else{
                for(int i = 0; i < misTickets.size(); i++){
                    if (misTickets.get(i).ID == id){
                        misTickets.get(i).getData();
                        System.out.println("Escriba el comentario deseado:");
                        var comentScanner = new Scanner(System.in);
                        String valorComent = comentScanner.nextLine();

                        misTickets.get(i).comentarios.add(valorComent);
                        System.out.println("Comentario agregado correctamente");
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showComment(int id){
        try{
            if (id == 0){
                throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ticket");
            }else {
                for (int i=0; i < misTickets.size(); i++){
                    if (misTickets.get(i).ID == id){
                        if (misTickets.get(i).comentarios.isEmpty()){
                            System.out.println("Aún no hay comentarios disponibles");
                        }else{
                            for (int x=0; x<misTickets.get(i).comentarios.size(); x++){
                                System.out.println(misTickets.get(i).comentarios.get(x));
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
