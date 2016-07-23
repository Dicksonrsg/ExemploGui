
package exemplos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GuiGrade extends JPanel{
    
    private JPanel pnPrincipal, pnTable;
    private JButton btRemover, btAdicionar;
    private JScrollPane scrollTable;
    private JTable table;
    private JLabel lbNumero, lbTotal, lbProduto, lbPrecoUnitario, lbQuantidade;
    private JTextField tfNumero, tfTotal, tfProduto, tfPrecoUnitario, tfQuantidade;
    
    DecimalFormat df = new DecimalFormat("#,###.00");
    
    public GuiGrade(){
        inicializarComponentes();
        definirEventos();   
    
    }

    private void inicializarComponentes() {
        setLayout(null);
        
        lbProduto = new JLabel("Produto");
        lbQuantidade = new JLabel("Quantidade");
        lbPrecoUnitario = new JLabel("Preço Unitario");
        lbNumero = new JLabel("Numero Pedido: ");
        lbTotal = new JLabel("Total do Pedido: ");
        tfProduto = new JTextField();
        tfPrecoUnitario = new JTextField();
        tfQuantidade = new JTextField();
        tfNumero = new JTextField();
        tfTotal = new JTextField();
        
        tfTotal.setEnabled(false);
        tfTotal.setHorizontalAlignment(JTextField.RIGHT);
        
        btAdicionar = new JButton("Adicionar");
        btRemover = new JButton("Remover");
        
        lbProduto.setBounds(15, 40, 100, 25);
        lbQuantidade.setBounds(225, 40, 100, 25);
        lbPrecoUnitario.setBounds(310, 40, 100, 25);
        lbNumero.setBounds(15, 10, 120, 25);
        lbTotal.setBounds(278, 360, 100, 25);
        tfProduto.setBounds(15, 65, 200, 25);
        tfQuantidade.setBounds(225, 65, 50, 25);
        tfPrecoUnitario.setBounds(310, 65, 80, 25);
        tfNumero.setBounds(130, 10, 50, 25);
        tfTotal.setBounds(375, 360, 100, 25);
        btAdicionar.setBounds(15, 100, 100, 22);
        btRemover.setBounds(125, 100, 100, 22);
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 500, 400);
        
        pnPrincipal.add(lbNumero);
        pnPrincipal.add(lbPrecoUnitario);
        pnPrincipal.add(lbProduto);
        pnPrincipal.add(lbQuantidade);
        pnPrincipal.add(lbTotal);
        pnPrincipal.add(tfNumero);
        pnPrincipal.add(tfPrecoUnitario);
        pnPrincipal.add(tfProduto);
        pnPrincipal.add(tfQuantidade);
        pnPrincipal.add(tfTotal);
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);

        pnTable = new JPanel(new BorderLayout());
        pnTable.setBorder(new TitledBorder("itens do pedido"));
        
        scrollTable = new JScrollPane();
        
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        
        DefaultTableModel model = new DefaultTableModel(
            new String[] {"Produto", "Qtd", "P.Unit", "Total"}, 0) {
            public boolean isCellEditable(int row, int col){
                if (col == 3 ){
                    return false;
                }
                return true;
            }
            };   
        
        table = new JTable(model);
        
        DefaultTableCellRenderer alinharDireita = new DefaultTableCellRenderer();
        alinharDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(50);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(3).setResizable(false);
        
        table.getColumnModel().getColumn(1).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(2).setCellRenderer(alinharDireita);
        table.getColumnModel().getColumn(3).setCellRenderer(alinharDireita);
        
        table.getTableHeader().setResizingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollTable.setViewportView(table);
        pnTable.add(scrollTable);
        
        pnTable.setBounds(10, 130, 470, 230);
        pnPrincipal.add(pnTable);
        
        add(pnPrincipal);
    }
                

    private void definirEventos() {
        btAdicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfProduto.getText().equals("") || tfQuantidade.getText().equals("") || tfPrecoUnitario.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                    return; 
                }
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.addRow(new Object[]{tfProduto.getText(), tfQuantidade.getText(), tfPrecoUnitario.getText(), "" + df.format(Integer.parseInt(tfQuantidade.getText())* Float.parseFloat(tfPrecoUnitario.getText()))});
                limparCampos();
                calcularTotal();
            }
        });
    }
    
    private void limparCampos() {
        tfProduto.setText("");
        tfQuantidade.setText("1");
        tfPrecoUnitario.setText("");
        tfProduto.requestFocus();
    }

    private void calcularTotal() {
        float total = 0f;
        for(int linha =0; linha <table.getRowCount(); linha++){
            String valor = "" + table.getValueAt(linha, 3);
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
            total += Float.parseFloat(valor);
        }
        tfTotal.setText("" + df.format(total));
    }    
    
}
