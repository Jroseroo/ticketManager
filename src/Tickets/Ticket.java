package Tickets;
import Usuarios.Employee;
import Usuarios.Technical;

import java.util.ArrayList;

public class Ticket extends ManagerTicket {
    //Atributos
    public int ID; //número aleatorio
    private String  titulo;
    private String descripcion;
    private Employee employee;
    public  Technical tecnicoResponsable;

    //Constructor
    public Ticket(String titulo, String descripcion, Employee employee){
        this.ID = IdActual ++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.employee = employee;

        allTickets.add(this);
    }

    //Métodos
    public String getTitle(){
        return titulo;
    }

    public void getData(){
        if(this.tecnicoResponsable == null){
            System.out.println("ID" + this.ID + " " + this.titulo + " " + this.employee.name + " Sin asignar");
        }else {
            System.out.println("ID" + this.ID + " " + this.titulo + " " + this.employee.name + " Responsable: " + this.tecnicoResponsable.name + " " + this.tecnicoResponsable.surnames);
        }

    }

}
