
package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiBotao extends JPanel {
    
    private JButton btMensagem, btTeimoso;
    
    public GuiBotao(){
        inicializarComponentes();
        definirEventos();    
    }
    
    private void inicializarComponentes(){
        setLayout(null);
        btMensagem = new JButton("Mensagem");
        btTeimoso = new JButton("Teimoso");
        
        btMensagem.setToolTipText("Clique aqui");
        btMensagem.setMnemonic(KeyEvent.VK_M);
        
        btMensagem.setBounds(50, 20, 140, 38);
        btTeimoso.setBounds(50, 70, 100, 25);
        
        add(btMensagem);
        add(btTeimoso);
    }
    
    private void definirEventos(){
        btMensagem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Mensagem");
            }
        });
        
        btTeimoso.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão Teimoso");
            }
        });
        
        btTeimoso.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                btTeimoso.setBounds(50, 120, 100, 25);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btTeimoso.setBounds(50, 70, 100, 25);
            }
        });
    }    
    
}
