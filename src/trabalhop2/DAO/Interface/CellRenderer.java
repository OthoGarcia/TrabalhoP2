/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhop2.DAO.Interface;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Casa
 */
public class CellRenderer extends DefaultTableCellRenderer {  
  
    public CellRenderer() {  
        super();  
    }  
    private int alinhamento = 4;
    public Component getTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) {  
        this.setHorizontalAlignment(alinhamento);  
  
        return super.getTableCellRendererComponent(table, value, isSelected,  
                hasFocus, row, column);  
    }
    
    public int getAlinhamento(){
        return alinhamento;
    }
    
    public void setAlinhamento(int alin){
        this.alinhamento = alin;
    }
}  
