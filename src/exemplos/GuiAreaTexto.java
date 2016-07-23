
package exemplos;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuiAreaTexto extends JPanel{
    
    private JTextField tfCampo;
    private JButton btLimpar;
    private JTextArea taTexto;
    private JScrollPane scrollPane;
    
    private static String novalinha = "\n";
    
    public GuiAreaTexto(){
        inicializarComponentes();
        definirEventos();    
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        tfCampo = new JTextField();
        btLimpar = new JButton("Limpar");
        taTexto = new JTextArea(5,20);
        taTexto.setEditable(false);
        scrollPane = new JScrollPane(taTexto);
        
        tfCampo.setBounds(25, 15, 150, 25);
        scrollPane.setBounds(25, 45, 300, 120);
        btLimpar.setBounds(25, 170, 90, 90);
        
        add(tfCampo);
        add(scrollPane);
        add(btLimpar);

}

    public void definirEventos(){
        
        tfCampo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.selectAll();
                taTexto.append(tfCampo.getText() + novalinha);
                taTexto.setCaretPosition(taTexto.getDocument().getLength());
                tfCampo.setText("");
            }
        });
        
        btLimpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfCampo.setText("");
                taTexto.setText("");
                tfCampo.requestFocus();
            }
        });
    }
}


