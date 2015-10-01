/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhop2.DAO.Interface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import trabalhop2.DAO.ProdutoDAO;

/**
 *
 * @author Casa
 */
public class ListarProdutos extends javax.swing.JFrame {

    /**
     * Creates new form ListarProdutos
     */
   
          
    public ListarProdutos() {
        initComponents();
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBTN_Deletar = new javax.swing.JButton();
        jBtn_Alterar = new javax.swing.JButton();
        jBTN_Incluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jScrollPane1.setViewportView(jTable1);

        jBTN_Deletar.setText("Deletar");
        jBTN_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_DeletarActionPerformed(evt);
            }
        });

        jBtn_Alterar.setText("Alterar");
        jBtn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AlterarActionPerformed(evt);
            }
        });

        jBTN_Incluir.setText("Incluir");
        jBTN_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTN_IncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jBtn_Alterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBTN_Deletar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBTN_Incluir)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBTN_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtn_Alterar)
                    .addComponent(jBTN_Incluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        preencherTabela();
    
    }//GEN-LAST:event_formWindowOpened

    private void jBTN_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_DeletarActionPerformed
        ProdutoDAO prod = new ProdutoDAO();
        int teste = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        System.out.println(""+teste);
        prod.excluir(teste);
        preencherTabela();
    }//GEN-LAST:event_jBTN_DeletarActionPerformed

    private void jBtn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AlterarActionPerformed
        AlterarProduto aProduto = new AlterarProduto();
       
        aProduto.pegar(Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()),
                jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(),
                Float.parseFloat(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString()),
                Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString()));
        
        //aProduto.pegar(1, "teste", 5, 8);
        aProduto.setVisible(true);
        this.dispose();
      
    }//GEN-LAST:event_jBtn_AlterarActionPerformed

    private void jBTN_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTN_IncluirActionPerformed
        CadastrarProduto cadasProduto = new CadastrarProduto();
        cadasProduto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBTN_IncluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarProdutos().setVisible(true);
            }
        });
    }
    public void preencherTabela(){
        
        DefaultTableModel tableModel =(DefaultTableModel) jTable1.getModel();  
        tableModel.setNumRows(0); 
        try {
            ProdutoDAO prod = new ProdutoDAO();
            ResultSet rs = prod.listar();
            String[] tableColumnsName = {"Codigo", "Descrição", "Preço", "Quantidade"};
            DefaultTableModel aModel = (DefaultTableModel) jTable1.getModel();
            aModel.setColumnIdentifiers(tableColumnsName);
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int colNo = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] objects = new Object[colNo];
                for (int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i + 1);
                }
                aModel.addRow(objects);
            }
            jTable1.setModel(aModel);
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.addRowSelectionInterval(0, 0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTN_Deletar;
    private javax.swing.JButton jBTN_Incluir;
    private javax.swing.JButton jBtn_Alterar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}