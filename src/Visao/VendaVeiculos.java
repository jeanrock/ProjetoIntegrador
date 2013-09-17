/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Exception.VeiculoException;
import RN.VendaRN;
import Util.DataUtil;
import Wrapper.VeiculoWrapper;
import com.towel.swing.table.ObjectTableModel;
import java.awt.Component;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Veiculo;
import model.Venda;

/**
 *
 * @author rafael
 */
public class VendaVeiculos extends javax.swing.JDialog {

    public Venda venda;
    public VendaRN vendaRN;
    private ObjectTableModel<VeiculoWrapper> veiculoModel;
    
    
    public VendaVeiculos(java.awt.Frame parent, boolean modal, boolean visible, Component comp) {
        super(parent, modal);
        initComponents();
        inicilizar();
        setLocationRelativeTo(comp);
        setVisible(modal);
    }
    public void inicilizar(){
        txtData.setText(String.valueOf(DataUtil.dateToString(Calendar.getInstance().getTime())));
        vendaRN = new VendaRN();
        btnAdicionarVeiculo.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pListaVeiculos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pDadosCompras = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtValorTotalCompra = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFuncionario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnAdicionarVeiculo = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pListaVeiculos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbVeiculo);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Veiculos da Venda");

        javax.swing.GroupLayout pListaVeiculosLayout = new javax.swing.GroupLayout(pListaVeiculos);
        pListaVeiculos.setLayout(pListaVeiculosLayout);
        pListaVeiculosLayout.setHorizontalGroup(
            pListaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListaVeiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pListaVeiculosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pListaVeiculosLayout.setVerticalGroup(
            pListaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pListaVeiculosLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pDadosCompras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pDadosCompras.setToolTipText("");

        jLabel3.setText("Data");

        txtData.setEnabled(false);

        jLabel4.setText("Valor Total");

        txtValorTotalCompra.setEnabled(false);

        jLabel5.setText("Funcionario");

        txtFuncionario.setEnabled(false);
        txtFuncionario.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Dados Venda");

        javax.swing.GroupLayout pDadosComprasLayout = new javax.swing.GroupLayout(pDadosCompras);
        pDadosCompras.setLayout(pDadosComprasLayout);
        pDadosComprasLayout.setHorizontalGroup(
            pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFuncionario)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDadosComprasLayout.setVerticalGroup(
            pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDadosComprasLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDadosComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtValorTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        btnAdicionarVeiculo.setText("Adicionar Veiculo");
        btnAdicionarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarVeiculoActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pListaVeiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pDadosCompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdicionarVeiculo)
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnGravar)
                        .addGap(61, 61, 61))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(pDadosCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionarVeiculo)
                .addGap(18, 18, 18)
                .addComponent(pListaVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnGravar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarVeiculoActionPerformed
        try {
            BuscarVeiculos buscarVeiculo = new BuscarVeiculos(this, true);
            buscarVeiculo.setVisible(true);            
            vendaRN.veiculosVenda.add(buscarVeiculo.getVeiculoRN().getVeiculoSelecionado());
            inicializaTabelaVeiculo();
        } catch (VeiculoException ex) {
            Logger.getLogger(VendaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAdicionarVeiculoActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja Gravar?") == 0) {
        vendaRN.gravar();
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    public void inicializaTabelaVeiculo() {
        veiculoModel = new ObjectTableModel(VeiculoWrapper.class, "chassi,anoModelo,anoFabricacao,modelo,marca,quilometragem");
        veiculoModel.setData(vendaRN.getVendaWrapperList());
        tbVeiculo.setModel(veiculoModel);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarVeiculo;
    private javax.swing.JButton btnGravar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pDadosCompras;
    private javax.swing.JPanel pListaVeiculos;
    private javax.swing.JTable tbVeiculo;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtFuncionario;
    private javax.swing.JTextField txtValorTotalCompra;
    // End of variables declaration//GEN-END:variables
}