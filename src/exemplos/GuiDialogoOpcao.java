
package exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiDialogoOpcao extends JPanel{
    
    private JLabel lbResposta;
    private JButton btAbrir;
    
    public GuiDialogoOpcao(){
    
        inicializarComponentes();
        definirEventos();        
    
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbResposta = new JLabel("");
        btAbrir = new JButton("Abrir");
        
        lbResposta.setBounds(25, 60, 200, 25);
        btAbrir.setBounds(25, 30, 100, 25);
        
        add(lbResposta);
        add(btAbrir);
    }

    private void definirEventos() {
        btAbrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] escolha = {"Masculino", "Feminino"};
                int resposta = JOptionPane.showOptionDialog(null, "Escolha o sexo", "Sexo", 0, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("sexo.gif"), escolha, escolha[0]);
                lbResposta.setText("Sexo escolhido: " + escolha[resposta]);
            }
        });
    }
    
}
