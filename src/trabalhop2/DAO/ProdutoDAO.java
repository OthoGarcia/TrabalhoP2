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


public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    
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
    
    public void incluir(String descricao, float preco, int quant) {
        Connection con = conectar();
        try{
            PreparedStatement st = con.prepareStatement("INSERT INTO `produto`(`descricao`, `preco`, `quant`) VALUES ('"+ descricao+
                    "',"+preco+","+quant +")");
            st.execute();
            System.out.println("Inserido");
            con.close();
        } catch(Exception e){
        }
        
    }
    public ResultSet listar(){
        Connection con = conectar();
        Statement stmt;
        ResultSet rs= null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from produto");
            //con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public void excluir(int id){
        Connection con = conectar();
        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM `produto` WHERE id= "+ id);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void alterar(int id,String descricao, float preco, int quant){
        Connection con = conectar();
        Statement stmt;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `produto` SET `descricao`='"+descricao+"',`preco`="+preco+",`quant`="+quant+" WHERE id = "+ id);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tirarEstoque(int id,int quant){
        Connection con = conectar();
        Statement stmt;
        ResultSet rs;
        try {
            int estoque=0;
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from produto where id = "+id);
            if (rs.next()){
                estoque= rs.getInt(4);
            }
            estoque = estoque - quant;
            stmt.executeUpdate("UPDATE `produto` SET `quant`="+estoque+" WHERE id = "+ id);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void acrescentarEstoque(int id,int quant){
        Connection con = conectar();
        Statement stmt;
        ResultSet rs;
        try {
            int estoque=0;
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from produto where id = "+id);
            if (rs.next()){
                estoque= rs.getInt(4);
            }
            estoque = estoque + quant;
            stmt.executeUpdate("UPDATE `produto` SET `quant`="+estoque+" WHERE id = "+ id);
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
