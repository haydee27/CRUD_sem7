
package Ejercicio;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
    
    Create() throws SQLException{
        Scanner l = new Scanner(System.in);
        Estudiante est = new Estudiante();
        System.out.println("<< CREAR REGISTRO >>");
        
        
        System.out.println(" Carnet: ");
        est.setCarnet_estudiante(l.next());
        
        System.out.println("Nombre: ");
        est.setNomEstudiante(l.next());
        
        System.out.println("Apellido: ");
        est.setApeEstudiante(l.nextLine());
        
        System.out.println("Edad Estudiante: ");
        est.setEdad_estudiante(l.nextInt());
        
        String tabla = "bd_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante ";
        String ValoresCampos = "'" + est.getCarnet_estudiante() + "','" + est.getNomEstudiante() + "','" + est.getApeEstudiante() + "','" + est.getEdad_estudiante() + "'";
        
        Conexion_CRUD utilerias = new Conexion_CRUD();
        
        utilerias.GuardarRegistros(tabla, camposTabla, ValoresCampos);
        
        MenuPrincipal.desplegarMenu();
    }
}
