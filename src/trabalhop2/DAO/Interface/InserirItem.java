/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhop2.DAO.Interface;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trabalhop2.DAO.ItemDAO;
import trabalhop2.DAO.ProdutoDAO;
import trabalhop2.Pedido;

/**
 *
 * @author Casa
 */
public class InserirItem extends javax.swing.JFrame {

    /**
     * Creates new form InserirItem
     */
    Integer idPedido;

    public InserirItem() {
        initComponents();
        preencherTabela();
        jTF_Quant.setText("" + 1);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTF_Quant = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButton2.setText("Inserir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jButton2)
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(352, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTF_Quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(52, 52, 52))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(121, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTF_Quant.getText() != "") {

            int quantEstoque = Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString()) - Integer.parseInt(jTF_Quant.getText()) ;
            if (quantEstoque >= 0) {

                //coloca a diferença no estoque
                EfetuarPedido ePedido = new EfetuarPedido();
                //Salva Item
                ItemDAO item = new ItemDAO();
                Float subTotal = Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()) * Integer.parseInt(jTF_Quant.getText());
                item.incluir(Integer.parseInt(jTF_Quant.getText()),
                        Float.parseFloat(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString()),
                        Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()),
                        ePedido.getidPedido(),
                        subTotal);
                ProdutoDAO prod = new ProdutoDAO();
                prod.tirarEstoque(Integer.parseInt(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString()),
                        Integer.parseInt(jTF_Quant.getText()));
                //jLBL_Total.setText(total() + "");

                ePedido.setVisible(true);
                ePedido.setSalvar(false);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Nao tem " + jTF_Quant.getText() + " unidades deste produto em estoque");
                jTF_Quant.setText("1");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Porfavor ensira a quantidade de Itens!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(InserirItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirItem().setVisible(true);
            }
        });
    }

    public void preencherTabela() {

        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        tableModel.setNumRows(0);
        try {
            ProdutoDAO prod = new ProdutoDAO();
            ResultSet rs = prod.listar();
            String[] tableColumnsName = {"Codigo", "Descrição", "Preço", "Estoque"};
            DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
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
            jTable2.setModel(aModel);
        } catch (SQLException ex) {
            Logger.getLogger(ListarProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable2.addRowSelectionInterval(0, 0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_Quant;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}