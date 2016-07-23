
package exemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiMenuPrincipal extends JFrame{
    
    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao, miCaixaOpcao, miGrade;
    private JMenuItem miRadio, miLista, miListaComFotos, miCombo, miTextField, miMask, miAbas, miDialogoMensagem, miDialogoConfirmacao, miDialogoOpcao;
    
    
    
    public GuiMenuPrincipal(){
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes(){
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        
        
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnExemplos = new JMenu("Exemplos");
        miSair = new JMenuItem("SAIR");
        miBotao = new JMenuItem("Botão");
        miCaixaOpcao = new JMenuItem("Caixa de Opção");
        miRadio = new JMenuItem("Botâo de Radio");
        miLista =  new JMenuItem("Lista");
        miListaComFotos = new JMenuItem("Lista com Fotos");
        miCombo  = new JMenuItem("Combo");
        miTextField = new JMenuItem("Area de Texto");
        miMask = new JMenuItem("Mascara");
        miAbas = new JMenuItem("Abas");
        miDialogoMensagem = new JMenuItem("Mensagem Dialogo");
        miDialogoConfirmacao =  new JMenuItem("Dialogo confirmacao");
        miDialogoOpcao = new JMenuItem("Dialogo Opcao");
        miGrade = new JMenuItem("Grade");
        
        mnArquivo.setMnemonic('A');
        mnExemplos.setMnemonic('E');
        
        
        mnArquivo.add(miSair);
        mnExemplos.add(miBotao);
        mnExemplos.add(miCaixaOpcao);
        mnExemplos.add(miRadio);
        mnExemplos.add(miLista);
        mnExemplos.add(miListaComFotos);
        mnExemplos.add(miCombo);
        mnExemplos.add(miTextField);
        mnExemplos.add(miMask);
        mnExemplos.add(miAbas);
        mnExemplos.add(miDialogoMensagem);
        mnExemplos.add(miDialogoConfirmacao);
        mnExemplos.add(miDialogoOpcao);
        mnExemplos.add(miGrade);
        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);
        setJMenuBar(mnBarra);
    }
    
    private void definirEventos(){
        miSair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        miBotao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiBotao botao = new GuiBotao();
                contentPane.removeAll();
                contentPane.add(botao);
                contentPane.validate();
            }
        });
        miCaixaOpcao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCaixaOpcao opcao = new GuiCaixaOpcao();
                contentPane.removeAll();
                contentPane.add(opcao);
                contentPane.validate();
            }
        });
        
        miRadio.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiRadio radio = new GuiRadio();
                contentPane.removeAll();
                contentPane.add(radio);
                contentPane.validate();
            }
        });
        
        miLista.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLista lista = new GuiLista();
                contentPane.removeAll();
                contentPane.add(lista);
                contentPane.validate();                
            }
        });
        
        miListaComFotos.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiListaComFotos foto = new GuiListaComFotos();
                contentPane.removeAll();
                contentPane.add(foto);
                contentPane.validate();
            }
        });
        
        miCombo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCombo combo = new GuiCombo();
                contentPane.removeAll();
                contentPane.add(combo);
                contentPane.validate();
            }
        });
        
        miTextField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiAreaTexto areaDeTexto = new GuiAreaTexto();
                contentPane.removeAll();
                contentPane.add(areaDeTexto);
                contentPane.validate();
            }
        });
        miDialogoMensagem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoMensagem dm = new GuiDialogoMensagem();
                contentPane.removeAll();
                contentPane.add(dm);
                contentPane.validate();
            }
        });
        miDialogoConfirmacao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoConfirmacao confirmacao = new GuiDialogoConfirmacao();
                contentPane.removeAll();
                contentPane.add(confirmacao);
                contentPane.validate();
            }
        });
        
        miDialogoOpcao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiDialogoOpcao dopcao = new GuiDialogoOpcao();
                contentPane.removeAll();
                contentPane.add(dopcao);
                contentPane.validate();
            }
        });
        miGrade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GuiGrade grade = new GuiGrade();
                contentPane.removeAll();
                contentPane.add(grade);
                contentPane.validate();
            }
        });
    }
    
    public static void run(){
        GuiMenuPrincipal frame = new GuiMenuPrincipal();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tela.width - frame.getSize().width) / 2;
        int y = (tela.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}
