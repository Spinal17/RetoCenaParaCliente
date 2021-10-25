package ConexcionDB;
//Realizará las Consultas a la base de datos

import Cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//Hereda la conexion de mysql
public class SQLDB extends Conexion {

    public List<Cliente> GetClients(String strWhere, String strHaving) {
        List<Cliente> clientes = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "SELECT client.code , sum(account.balance), client.male , client.company, client.encrypt  FROM account\n"
                + "INNER JOIN client  ON account.client_id = client.id " + strWhere + "\n"
                + "group by client.code\n"
                + strHaving + "\n"
                + "order by sum(account.balance) desc";

        try {

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getString(1), rs.getInt(4), rs.getBoolean(5), rs.getBoolean(3), rs.getInt(2));
                clientes.add(cliente);
            }

            return clientes;

        } catch (SQLException ex) {

            //En caso de error devuelve falso
        } finally {
            try {
                con.close();
            } catch (SQLException e) {

            }
        }
        return clientes;
    }

}
