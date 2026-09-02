package Tickets;

import Usuarios.Employee;
import Usuarios.Technical;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comentarios {
    //Atributos
    public int ID;
    public String date;
    public Employee empleado;
    public Technical technical;
    public String texto;
    public Ticket ticket;

    DateTimeFormatter dtm = DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm");
    static int idComment = 1;
    //Constructor

    public Comentarios(String texto){
        //this.date = dtm.format(LocalDateTime.now());
        this.texto = texto;
    }

    //Métodos:
    public void showCommentData(){
        if (this.empleado == null ){
            System.out.println("ID:"+ this.ID + " " + this.technical.name + " " + this.technical.surnames + " "  + this.date + " " + this.texto);
        } else if (this.technical == null) {
            System.out.println("ID:" + this.ID + " " + this.empleado.name + " " + this.empleado.surnames + " " + this.date + " " + this.texto);
        }

    }

    //Interface:

}
