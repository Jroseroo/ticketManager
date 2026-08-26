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
    public Estado estado;
    public  Technical tecnicoResponsable;

    public ArrayList<String> comentarios = new ArrayList<>();

    //Constructor
    public Ticket(String titulo, String descripcion, Employee employee){
        this.ID = IdActual ++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.employee = employee;
        this.estado = Estado.Pendiente;

        allTickets.add(this);
    }

    //Métodos
    public String getTitle(){
        return titulo;
    }

    public void getData(){
        if(this.tecnicoResponsable == null){
            System.out.println("ID" + this.ID + " " + this.titulo + " " + this.employee.name + " Estado: " +estado + " Sin asignar");
        }else {
            System.out.println("ID" + this.ID + " " + this.titulo + " " + this.employee.name +   " Estado: " + estado + " Responsable: " + this.tecnicoResponsable.name + " " + this.tecnicoResponsable.surnames);
        }

    }

}
