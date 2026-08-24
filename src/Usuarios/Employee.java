package Usuarios;

import Tickets.Ticket;

import java.util.ArrayList;

public class Employee{
    //Atributos
    public String ID; //DNI
    public String name;
    public String surnames;
    public String departamento;

    ArrayList<Ticket> miTickets = new ArrayList<>();

    //Constructor
    public Employee(String ID, String name, String surnames, String departamento){
        this.ID = ID;
        this.name = name;
        this.surnames = surnames;
        this.departamento = departamento;
    }

    //Métodos
    public void crearTicket(String titulo, String descripcion){
        var nuevoTicket = new Ticket(titulo, descripcion, this);
        miTickets.add(nuevoTicket);
    }

    public void mostrarTicketsUser(){
        for(int i = 0; i < miTickets.size(); i++){
            System.out.println(miTickets.get(i).getTitle());
        }
    }

}
