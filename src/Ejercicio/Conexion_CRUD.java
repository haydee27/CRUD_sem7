
package Ejercicio;

import java.sql.*;

public class Conexion_CRUD {
    private final String servidor = "jdbc:mysql://localhost:3306/bd_registro_estudiante";
    private final String usuario = "root";
    private final String clave = "";
    private final String driverConector = "com.mysql.jdbc.Driver";
    private static Connection conexion;
    
    public Conexion_CRUD(){
        try{
            
            
           Class.forName(driverConector);
           conexion = DriverManager.getConnection(servidor, usuario, clave);
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Conexion fallida! Error! : " + e.getMessage());
        }
        
    }
    public Connection getConnection(){
        return conexion;
    }
    
    public void GuardarRegistros(String tabla, String camposTabla, String ValoresCampos ){
        Conexion_CRUD Conectar = new Conexion_CRUD();
        Connection cone = Conectar.getConnection();
        try{
            String sqlQueryStmt = " INSERT INTO " + tabla + "(" + camposTabla + ") VALUE (" + ValoresCampos + ");";
            Statement stmt;
            stmt = cone.createStatement();
            stmt.executeUpdate(sqlQueryStmt);
            
            stmt.close();
            cone.close();
            
            System.out.println("Registro guardado correctamente!");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void actualizarEliminarRegistros(String tabla, String ValoresCamposNuevos, String condicion){
        Conexion_CRUD conectar = new Conexion_CRUD();
        Connection cone = conectar.getConnection();
        try{
           Statement stmt;
           String sqlQueryStmt;
           
           if(ValoresCamposNuevos.isEmpty()){
               sqlQueryStmt = " DELETE FROM " + tabla + " WHERE " +  condicion + "; ";
           }else{
               sqlQueryStmt = " UPDATE " + tabla + " SET " + ValoresCamposNuevos + " WHERE " + condicion + ";";
           }
           stmt = cone.createStatement();
           stmt.executeUpdate(sqlQueryStmt);
           stmt.close();
           cone.close();
            
        }catch(SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
    
    public void desplegarRegistros(String tablaBuscar, String camposBuscar, String condicionBuscar) throws SQLException{
        Conexion_CRUD conectar = new Conexion_CRUD();
        Connection cone = conectar.getConnection();
        try{
            Statement stmt;
            String sqlQueryStmt;
            if(condicionBuscar.equals("")){
                sqlQueryStmt =" SELECT " + camposBuscar + " FROM " + tablaBuscar +";";
            }else{
                sqlQueryStmt = " SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);
            
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if(miResultSet.next()) {
                   ResultSetMetaData metaData= miResultSet.getMetaData();
                   int numColumnas = metaData.getColumnCount();
                   System.out.println("<< REGISTROS ALMACENADOS >>");
                   System.out.println("");
                
                    for (int i = 1; i<= numColumnas; i++){
                    
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }
                    System.out.println();
                    do{
                       for (int i = 1; i<=numColumnas; i++){
                           System.out.printf("%-20s\t", miResultSet.getObject(i)); 
                    }
                    System.out.println();
                }while (miResultSet.next());
                System.out.println();
            } else  {
                System.out.println("No se han encontrado registros"); 
            }
            miResultSet.close();
        }finally{
            stmt.close();
            cone.close();
            
        }
        
    }catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
}



