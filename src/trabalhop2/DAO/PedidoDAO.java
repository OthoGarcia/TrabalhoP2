/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhop2.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Casa
 */
public class PedidoDAO {
    public Connection conectar(){
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedidos","root","");
            System.out.println("CONECTADO");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void incluir(int idItens, String data, String status, int idCliente, double total, int idPagamento) {
        Connection con = conectar();
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO `pedido`(`idItens`, `data`, `status`, 'idcliente', 'total', idPagamento) VALUES ("
                    + ""+ idItens+",'"+data+"','"+status +"'"+idCliente +","+total+","+idPagamento+")");
            st.execute();
            System.out.println("Inserido");
            con.close();
        } catch(Exception e){
        }
        
    }
}
