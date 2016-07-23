
package exemplos;

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;

public class GuiLista extends JPanel {
    
    private JButton btCalcular;
    private JLabel lbValor;
    private JTextField tfValor, tfValorDesconto;
    private JList liDesconto;
    private JScrollPane spLista;
    
    public GuiLista(){
        inicializarComponentes();
        definirEventos();    
    }
    
    public void inicializarComponentes(){
        setLayout(null);
        
        String[] liDescontos = {"10%", "20%", "30%", "40%", "50%"};
        btCalcular = new JButton("Calcular");
        lbValor = new JLabel("Valor");
        tfValor = new JTextField(5);
        tfValorDesconto = new JTextField(5);
        liDesconto = new JList(liDescontos);
        spLista = new JScrollPane(liDesconto);
        
        btCalcular.setBounds(35, 120, 90, 25);
        lbValor.setBounds(35, 05, 100, 25);
        tfValor.setBounds(35, 30, 100, 25);
        tfValorDesconto.setBounds(35, 150, 100, 25);
        spLista.setBounds(35, 60, 100, 55);
        
        add(btCalcular);
        add(lbValor);
        add(tfValor);
        add(tfValorDesconto);
        add(spLista);
    }
    
    public void definirEventos(){
        
        btCalcular.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfValor.getText().equals("")){
                    tfValor.requestFocus();
                    return;
                }
                try{
                    float valor = Float.parseFloat(tfValor.getText());
                    float desconto = 0;
                    switch(liDesconto.getSelectedIndex()){

                        case 0:
                            desconto = 0.9f;
                            break;
                        case 1:
                            desconto = 0.8f;
                            break;
                        case 2:
                            desconto = 0.7f;
                            break;
                        case 3:
                            desconto = 0.6f;
                            break;
                        case 4:
                            desconto = 0.5f;
                            break;
                    }
                    valor = valor * desconto;
                    tfValorDesconto.setText(String.valueOf(valor));
                }catch(NumberFormatException error){
                    JOptionPane.showMessageDialog(null, "Forneça apenas numeros");
                    error.toString();
                    tfValor.requestFocus();
                }
            }
        });
    
    }
}
