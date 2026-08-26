package Usuarios;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ManagerEmployee {
    //Atributos
    public int ID; //DNI
    public String name;
    public String surnames;
    public String departamento;

    public static ArrayList<Employee> allEmployee = new ArrayList<>();
    static int IdUserActual = 1;

    //Métodos


    //Interfaces

    public interface showEmployee{
        default void getAllEmployee(){
            for (int i = 0; i < allEmployee.size(); i++){
                System.out.println("ID" + allEmployee.get(i).ID + " " + allEmployee.get(i).name);
            }
        }

        default void searchEmployee(int id){
            try {
                if (id > allEmployee.size() || id == 0){
                    throw new ArrayIndexOutOfBoundsException("No se ha encontrado el ID");
                }else {
                    for (int i= 0; i < allEmployee.size(); i++){
                        if (allEmployee.get(i).ID == id){
                            allEmployee.get(i).getUserData();
                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        default void searchEmployee(String name){
            try {
                boolean found = false;
                for (int i = 0; i < allEmployee.size(); i++){
                    if (allEmployee.get(i).name.toUpperCase().equals(name.toUpperCase())){
                        found = true;
                        allEmployee.get(i).getUserData();
                    }
                }if (found == false){
                    throw new IllegalArgumentException("No se ha podido encontrar el nombre indicado");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        default void showUserTicket(int id){
            try {
                if (id > allEmployee.size() || id == 0){
                    throw new ArrayIndexOutOfBoundsException("No se ha podido encontrar el ID indicado");
                }else{
                    for (int i=0; i<allEmployee.size(); i++){
                        if (id == allEmployee.get(i).ID ){
                            if (allEmployee.get(i).misTickets.isEmpty()){
                                System.out.println("Este usuario no tiene tickets disponibles");
                            }else{
                                allEmployee.get(i).mostrarTicketsUser();
                            }

                        }
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
