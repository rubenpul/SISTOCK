/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistock;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ruben
 */
public class RenderTablaEstatus extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table,
		Object value, boolean isSelected, boolean hasFocus, int row,
		int column) {

		JLabel cell = (JLabel) super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);

		if(value instanceof String){
			String valor = (String) value;
			if(column==10){
				if(valor.equals("EJECUTADO")){
					cell.setBackground(Color.GREEN);
					cell.setForeground(Color.WHITE);
				}
				else{
					cell.setBackground(Color.RED);
					cell.setForeground(Color.WHITE);					
				}
			}
                        else{
                            cell.setBackground(Color.WHITE);
		            cell.setForeground(Color.BLACK);
                        }
		}
		
		return cell;
        }            
}
