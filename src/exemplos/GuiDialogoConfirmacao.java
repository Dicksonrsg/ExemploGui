
package exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GuiDialogoConfirmacao extends JPanel{
    
    private JRadioButton rbYesNo, rbYesNoCancel, rbOkCancel;
    private ButtonGroup group;
    private JButton btMostrar;
    
    public GuiDialogoConfirmacao(){
        inicializarComponentes();
        definirEventos();     
    
    }
   
            
    public void inicializarComponentes(){
        setLayout(null);
        
        rbYesNo = new JRadioButton("Sim ou Não");
        rbOkCancel = new JRadioButton("Sim, Não ou Cancelar");
        rbOkCancel = new JRadioButton("Ok ou Cancelar");        
        group = new ButtonGroup();
        btMostrar = new JButton("Mostrar");
        
        group.add(rbYesNo);
        group.add(rbYesNoCancel);
        group.add(rbOkCancel);
        
        rbYesNo.setBounds(55, 100, 200, 25);
        rbYesNoCancel.setBounds(55, 30, 200, 35);
        rbOkCancel.setBounds(55, 60, 200, 25);
        btMostrar.setBounds(55, 90, 100, 20);
        
        add(rbYesNo);
        add(rbYesNoCancel);
        add(rbOkCancel);
        add(btMostrar);
        
        rbYesNo.setSelected(true);
    
    }
    
    public void definirEventos(){
    
        btMostrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int resposta = 0;
                if(rbYesNo.isSelected()){
                    resposta = JOptionPane.showConfirmDialog(null, "Erro ao acessar o arquivo. Tentar novamente?", "Erro do arquivo", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                } 
                else if(rbYesNoCancel.isSelected()){
                    resposta = JOptionPane.showConfirmDialog(null, "Deseja salvar as alterações?", "Salvar arquivo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                }
                else{
                    resposta = JOptionPane.showConfirmDialog(null, "Deseja abrir o arquivo?", "Abrir arquivo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, resposta, "Resposta", 1);
            }
        });
    }
}
