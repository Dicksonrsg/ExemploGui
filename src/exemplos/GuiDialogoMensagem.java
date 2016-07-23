
package exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiDialogoMensagem extends JPanel{
    
    private JComboBox cbCaixas;
    
    public GuiDialogoMensagem(){
        inicializarComponentes();
        definirEventos();   
        
    }
    
    public void inicializarComponentes(){
        
        String[] cbCaixaItens = {"Pergunta", "Informação", "Alerta", "Erro"};
        cbCaixas = new JComboBox(cbCaixaItens);
        
        cbCaixas.setBounds(25, 40, 150, 25);
        
        add(cbCaixas);
    }
    
    public void definirEventos(){
    
        cbCaixas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch(cbCaixas.getSelectedIndex()){
                    case 0:
                        JOptionPane.showMessageDialog(null, "Estou aprendendo Java?", "Pergunta", JOptionPane.QUESTION_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Gravação OK", "Informação", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Cuidado!", "Alerta", JOptionPane.WARNING_MESSAGE);
                        break; 
                    case 3:
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;                        
                }
            }
        });
        
    }
}
