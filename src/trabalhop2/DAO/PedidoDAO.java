/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhop2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */
public class PedidoDAO {

    int idPedido = 0;

    public Connection conectar() {
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido", "root", "");
            System.out.println("CONECTADO");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void incluir(String data, String status, int idCliente, double total) {
        Connection con = conectar();

        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO pedido(data, status, idcliente, total) VALUES ('" + data + "','" + status + "'," + idCliente + "," + total + ")");

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getIdPedido() {
        Connection con = conectar();
        ResultSet rs;
        Statement stmt;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECt * FROM pedido ORDER BY id DESC LIMIT 1");
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idPedido;
    }

}
