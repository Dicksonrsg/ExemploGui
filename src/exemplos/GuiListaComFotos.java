
package exemplos;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GuiListaComFotos extends JPanel{
    
    private JList lsFotos;
    private DefaultListModel dlm;
    private ImageIcon imagem;
    private JScrollPane sp;
    private JLabel lbImagem;
    
    
    public GuiListaComFotos(){
        inicializarComponentes();
        definirEventos();    
    }
   
    public void inicializarComponentes(){
        setLayout(null);
        
        dlm = new DefaultListModel();
        for(int i = 1;i<= 3;i++){
            dlm.addElement("Foto" + i);
        }
        
        lsFotos = new JList(dlm);
        sp = new JScrollPane(lsFotos);
        imagem = new ImageIcon();
        lbImagem = new JLabel("imagem");
        
        sp.setBounds(50, 40, 70, 150); 
        lbImagem.setBounds(150, 30, 0, 0);
        
        add(sp);
        add(lbImagem);
    }
    
    public void definirEventos(){
        lsFotos.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                imagem =  new ImageIcon("Imagens/" + lsFotos.getSelectedValue()+ ".gif");
                lbImagem.setIcon(imagem);
                lbImagem.setSize(imagem.getIconWidth(), imagem.getIconHeight());
            }
        });
    }
}
