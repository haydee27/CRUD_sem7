
package Ejercicio;


import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    
    Delete() throws SQLException{
        Scanner l = new Scanner(System.in);
        Conexion_CRUD utilerias = new Conexion_CRUD();
        System.out.println("<< ELIMINAR REGISTROS >>");
        
        System.out.println("Ingresar el id del registro: ");
        String idestudianteEliminar = l.nextLine();
        
        String tabla = "bd_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idestudianteEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Presionar <<Y>> para confirmar: ");
        String confirmarBorrar = l.next();
        
        if("Y".equals(confirmarBorrar)){
            
            String ValoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistros(tabla, ValoresCamposNuevos, condicion);
            System.out.println("Registro borrado sastifactoriamente!");
            
            
        }
        MenuPrincipal.desplegarMenu();
    }
    
}

