/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firebirdconnect;
import java.sql.*;
/**
 *
 * @author vales
 */
public class FireBirdConnect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String databaseURL="jdbc:firebirdsql:localhost/3050:c:/fdb2018/MIBASEUNAPUNO.FDB";
        String usuariodb="sysdba";
        String passworddb="masterkey";
        String driverName="org.firebirdsql.jdbc.FBDriver";
        Connection conexion;
        Statement consulta;
        ResultSet resultado;
        try{
           Class.forName(driverName);
           conexion=DriverManager.getConnection(databaseURL,usuariodb,passworddb);
           consulta=conexion.createStatement();
           String consultaSQL="select*from emp";
           resultado=consulta.executeQuery(consultaSQL);
           
           while(resultado.next()){
               String ename=resultado.getString("ename");
               String job=resultado.getString("job");
               String sal=resultado.getString("sal");
               System.out.println(ename+" ES "+job+" Y GANA "+sal);
           }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
