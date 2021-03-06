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
public class ItemDAO {
    public Connection conectar(){
        Connection con = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pedido","root","");
            System.out.println("CONECTADO");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public void incluir(int quant, float preco, int idProduto, int idPedido, double subTotal) {
        Connection con = conectar();
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO item(quant, preco, idProduto, idPedido) VALUES ("+ quant+
                    ","+preco+","+idProduto +","+idPedido+")");
            st.execute();
            System.out.println("Inserido");
            con.close();
        } catch(Exception e){
        }
        
    }
    public ResultSet listar( int idPedido){
        Connection con = conectar();
        Statement stmt;
        ResultSet rs= null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT item.idProduto, produto.descricao, item.preco, item.quant FROM item, pedido, produto "
                    + "WHERE item.idProduto = produto.id and item.IdPedido = pedido.id and pedido.id = "+ idPedido);
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
}
