package Tickets;
import ConexionBD.ConexionBD;
import Usuarios.Employee;
import Usuarios.Technical;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ticket extends ManagerTicket {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    //Atributos
    public int ID; //número aleatorio
    public String  titulo;
    public String descripcion;
    public Employee employee;
    public Estado estado;
    public String dateTime;
    public  Technical tecnicoResponsable;

    public ArrayList<Comentarios> comentarios = new ArrayList<>();
    ConexionBD conexionBD = new ConexionBD();

    //Constructor
    public Ticket(String titulo, String descripcion){
        //this.ID = IdActual ++;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.employee = employee;
        this.estado = Estado.Pendiente;
        this.dateTime = dtf.format(LocalDateTime.now());

        //allTickets.add(this);
    }

    //Métodos
    public String getTitle(){
        return titulo;
    }

    public void getData(){
        if(this.tecnicoResponsable == null){
            System.out.println(this.titulo + " " + this.employee.name + " Sin asignar" + " Fecha: " + dateTime +  " Estado: " +estado);
        }else {
            System.out.println(this.titulo + " " + this.employee.name + " Fecha: " + dateTime +  " Estado: " + estado +   " Responsable: " + this.tecnicoResponsable.name + " " + this.tecnicoResponsable.surnames);
        }

    }

}
