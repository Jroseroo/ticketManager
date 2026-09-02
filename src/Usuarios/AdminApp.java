package Usuarios;

import ConexionBD.ConexionBD;
import Tickets.ManagerTicket;
import Tickets.Ticket;

import java.util.ArrayList;

public class AdminApp  {
    //Atributos
    public String ID; //DNI
    public String name;
    public String surnames;
    public final String departamento = "SoporteApp";

    //Constructor
    public AdminApp(String ID, String name, String surnames){
        this.ID = ID;
        this.name = name;
        this.surnames = surnames;
    }

    //Métodos

}
