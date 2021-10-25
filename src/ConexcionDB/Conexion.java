package ConexcionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static Utils.Constant.STR_BASE;
import static Utils.Constant.STR_USER;
import static Utils.Constant.STR_PASSWORD;

public class Conexion {

    //Nombre de la base de datos
    private final String base = STR_BASE;

    //Usuario de la base de datos
    private final String user = STR_USER;

    private final String contraseña = STR_PASSWORD;
    //Donde nos vamos a conectar
    private final String url = "jdbc:mysql://localhost:" + 3306 + "/" + base+"?useSSL=false";
    private Connection con = null;

    //Clase para la conexión a Mysql
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, contraseña);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return con;
    }
}
