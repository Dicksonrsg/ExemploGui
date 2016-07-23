
package exemplos;

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;

public class GuiRadio extends JPanel{
    
    private JLabel lbSexo;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup group;
    private JButton btVerificar;
    
    public GuiRadio(){
        inicializarComponentes();
        definirEventos();        
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        lbSexo = new JLabel("Selecione o sexo: ");
        rbMasculino = new JRadioButton("Masculino");
        rbFeminino = new JRadioButton("Feminino");
        group = new ButtonGroup();
        btVerificar = new JButton("Verificar");
        
        lbSexo.setBounds(55, 10, 105, 30);
        rbMasculino.setBounds(55, 45, 100, 25);
        rbFeminino.setBounds(55, 70, 100, 25);
        btVerificar.setBounds(55, 105, 100, 20);
        
        group.add(rbFeminino);
        group.add(rbMasculino);
        
        rbMasculino.setSelected(true);
        
        add(lbSexo);
        add(rbMasculino);
        add(rbFeminino);
        add(btVerificar);
    }
    
    public void definirEventos(){
        
        btVerificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selecao = "Selecionado: ";
                if(rbMasculino.isSelected()){
                    selecao += "Masculino";
                }else{
                    selecao += "Feminino";
                }
                JOptionPane.showMessageDialog(null, selecao);
            }
        });
    }
    
}
