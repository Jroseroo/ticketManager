package Tickets;
import Usuarios.Employee;

import java.util.ArrayList;

public class Ticket {
    //Atributos
    private String ID; //número aleatorio
    public String  titulo;
    public String descripcion;
    public Employee employee;

    public ArrayList<Ticket> allTickets = new ArrayList<>();

    //Constructor
    public Ticket(String titulo, String descripcion, Employee employee){
        this.ID =
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.employee = employee;

        allTickets.add(this);
    }

    //Métodos
    public String getTitle(){
        return titulo;
    }

}
