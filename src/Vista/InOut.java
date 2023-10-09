/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;

public class InOut {
    
    public int solicitar(String m){
       int d= Integer.parseInt(JOptionPane.showInputDialog(m));
       return d;
    }
    
         
       public String solicitarN(String m){
      return JOptionPane.showInputDialog(m);
    }
    
    public void mostrar(String m){
        JOptionPane.showMessageDialog(null, m);
    }
    
    
}
