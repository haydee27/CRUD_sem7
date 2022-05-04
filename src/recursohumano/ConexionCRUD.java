
package recursohumano;

import java.sql.*; //Librerias para conexion a la BS
        
public class ConexionCRUD {
   
   private final String servidor =  "jdbc:mysql://127.0.0.1:3306/bd_recursos_humano";
   //Nombre del usuario (root por defecto) de la base de datos
   private final String usuario = "root";
   //Clave del usuario de la base de datos
   private final String clave = "";
   //Libreria de mysql
   private final String driverConector ="com.mysql.sqbo.Driver";
   //Objeto de la clase Connection del paquete java.sql
   private static Connection conexion;

    public ConexionCRUD(){   
        try{
    Class.forName(driverConector); //Levantar el driver
    //Establecer conexion
    conexion=DriverManager.getConnection(servidor, usuario, clave);
    }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida! Error");
    }
     
}
    public Connection getConnection(){
        
        return conexion; //Develve el objeto conexion
    }
    
    public void guardarRegistros(String tabla, String camposTabla, String valoresCampos){
        //Cargar la conexion
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        try{
            
            //Definir la sentencia if
            String sqlQueryStmt = "INSERT INTO" + tabla + " (" + camposTabla + ") VALUES (" + valoresCampos + ");";
            //Establece la comunicacion entre nuestra aplicacion java y la base de datos
            Statement stmt; //Envia sentencia sql a a base de datos
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);//Ejecuta la sentencia if
            
            //Cerrar el statement y la conexion; se cierra en orden inverso de como se han abierto
            stmt.close();
            cone.close();
            System.out.println("Registro guardado correctamente!");
        }catch(SQLException e){
            System.out.println("e.getMessage");
        }
        
    }
    
    public void actualizarEliminarRegistro(String tabla, String valoresCamposNuevos, String condicion){
        //Carga la conexion
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        
        try{
            Statement stmt;
            String sqlQueryStmt;
            //Verificar que valoresCamposNuevos venga vacia y asi seleccionar si es borrar o actualizar registro
            if(valoresCamposNuevos.isEmpty()){
                sqlQueryStmt = "DELETE FROM" + tabla + "WHERE" + condicion + ";";
            }else{
                sqlQueryStmt = "UPDATE" + tabla + "SET" + valoresCamposNuevos + "WHERE" + condicion + ";";
            }
            stmt= cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            stmt.close();
            cone.close();
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguient error: " + ex.getMessage());
        }
            
    }
     
   @SuppressWarnings("empty-statement")
    public void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
        
        //Cargar la conexion
        ConexionCRUD conectar = new ConexionCRUD();
        Connection cone = conectar.getConnection();
        
        try {
           Statement stmt;
           String sqlQueryStmt;
           if(condicionBuscar.equals("")){
               sqlQueryStmt = "SELECT " + camposBuscar + "FROM" + tablaBuscar + ";";  
           }else{
               sqlQueryStmt = "SELECT" + camposBuscar + "FROM" + tablaBuscar + "WHERE" + condicionBuscar;
           }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            
            //Le indicamos que ejcute la consulta de la tabla y le pasamos por argumentos nuestra sentencia
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()) { //Ubica el curso en la primera fila de la tabla de resultado
                   
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas = metaData.getColumnCount(); //Obtiene el numero de columna de la consulta
                    
                    System.out.println("<< REGISTROS ALMACENADOS >>");
                    System.out.println();
                    
                     for(int i = 1; i <= numColumnas; i++){
                        //Muestra los titulos de las columnas y %-20s/c/t indica la separacion entre columnas
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                        }
                       System.out.println();
                        do{
                          for (int j = 1; j<= numColumnas; j++)  {
                           System.out.printf("%-20s\t", miResultSet.getObject(j));
                        } 
                         System.out.println();
                        }while(miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                }
                miResultSet.close(); //Cerrar el ResultSet
            }finally{
                //Cerrar el Statement y la Conexion; se cierra en orden inverso de como se han abierto
                stmt.close();
                cone.close();
            }
        }catch(SQLException ex){
            System.out.println("Ha ocurrido un error!: " + ex.getMessage());
        }
    }
}
