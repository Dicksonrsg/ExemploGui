
package exemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.embed.swing.JFXPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GuiCombo extends JFXPanel {
    
    private JLabel lbEstado, lbCidade;
    private JComboBox cbEstado, cbCidades;
    private JButton btVerificar;
    private String[] estados;
    
    public GuiCombo(){
        estados = addEstados();
        inicializarComponentes();
        definirEventos();    
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        lbEstado = new JLabel("Estados: ");
        lbCidade = new JLabel("Cidades: ");
        cbEstado = new JComboBox(estados);
        cbCidades = new JComboBox();
        cbCidades.setEnabled(false);
        btVerificar = new JButton("Verificar");
        
        lbEstado.setBounds(25, 15, 150, 25);
        lbCidade.setBounds(25, 65, 150, 25);
        cbEstado.setBounds(25, 40, 150, 25);
        cbCidades.setBounds(25, 90, 150, 25);
        btVerificar.setBounds(25, 125, 100, 25);
        add(lbEstado);
        add(lbCidade);
        add(cbEstado);
        add(cbCidades);
        add(btVerificar);
        
        
    }
    
    public void definirEventos(){
        btVerificar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Index: "+ cbEstado.getSelectedIndex() + "\nItem: "+cbEstado.getSelectedItem());
            }
        });
        
        cbEstado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cbCidades.setEnabled(true);
                cbCidades.removeAllItems();
                String estado = String.valueOf(cbEstado.getSelectedItem());
                String[] cidsRN = {"", "Natal", "Parnamirim"};
                if(estado.equals("RN")){
                    for(int i =0; i<cidsRN.length; i++){
                        cbCidades.addItem(cidsRN[i]);
                    }
                }
            }
        });
    }
    
    public String[] addEstados(){
        String[] est = {"", "RN", "CE", "RJ", "GO", "RS"};
        return est;
    }

}
