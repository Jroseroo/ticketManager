package Usuarios;

import Tickets.Ticket;

import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.RMISocketFactory;
import java.util.ArrayList;

public class Employee extends ManagerEmployee{
    //Atributos
    public int ID; //DNI
    public String name;
    public String surnames;
    public String departamento;

    ArrayList<Ticket> miTickets = new ArrayList<>();
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
        miTickets.add(nuevoTicket);
    }

    public void mostrarTicketsUser(){
        for(int i = 0; i < miTickets.size(); i++){
            miTickets.get(i).getData();
        }
    }

    public void getUserData(){
        System.out.println("ID" + this.ID + " " + this.name + " " + this.surnames);
    }


}
