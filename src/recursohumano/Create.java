
package recursohumano;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
   Create () throws SQLException {
       Scanner leer = new Scanner(System.in);
       Persona person = new Persona(); //Objeto person de la clase Persona
       System.out.println("<< CREAR REGISTRO >>");
       
       System.out.println("Nombre: ");
       person.setNomPersona(leer.nextLine());
       
       System.out.println("Correo Electronico: ");
       person.setEmailPersona(leer.nextLine());
       
       System.out.println("Telefono: ");
       person.setTelPersona(leer.nextLine());
       
       String tabla= "tb_contacto";
       String camposTabla = "nom_contacto, email_contacto, tel_contacto";
       String valoresCampos = "'" + person.getNomPersona() + "','" + person.getEmailPersona() + "','"+ person.getTelPersona() + "'";
       
       //Instancia u objeto de la clase conexionCrud
       ConexionCRUD utilerias = new ConexionCRUD();
       //Se envian los parametros necesarios para guardar el registro al metodo guardarRegistros
       utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
       
       MenuPrincipal.desplegarMenu(); //Llama al metodo del menu principal
   } 
}
