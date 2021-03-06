/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Exception.VeiculoException;
import RN.VeiculoRN;
import Wrapper.DefaultWrapper;
import Wrapper.VeiculoWrapper;
import com.towel.swing.table.ObjectTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Jean
 */
public class BuscarVeiculos extends javax.swing.JDialog {
    private static final long serialVersionUID = 1L;    
        
    private VeiculoRN veiculoRN;

    public VeiculoRN getVeiculoRN() {
        return veiculoRN;
    }

    public void setVeiculoRN(VeiculoRN veiculoRN) {
        this.veiculoRN = veiculoRN;
    }
    
    private ObjectTableModel<VeiculoWrapper> veiculosModel;
    
    public BuscarVeiculos(javax.swing.JFrame parent, boolean modal) throws VeiculoException{
        super(parent,modal);
        initComponents();
        setLocationRelativeTo(null);
        veiculoRN = new VeiculoRN();
        inicializaTableModelVeiculo();      
    }   
    
    public BuscarVeiculos(javax.swing.JDialog parent, boolean modal) throws VeiculoException{
        super(parent,modal);
        initComponents();
        veiculoRN = new VeiculoRN();
        inicializaTableModelVeiculo();      
    }
    private void inicializaTableModelVeiculo(){
        try {
            veiculosModel = new ObjectTableModel(VeiculoWrapper.class, 
                    "chassi,anoModelo,anoFabricacao,modelo,combustivel,marca,quilometragem");
            veiculosModel.setData(veiculoRN.getVeiculoWrapperList());        
            tbVeiculos.setModel(veiculosModel);
        } catch (VeiculoException ex) {
            Logger.getLogger("ERRO FATAL").log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void selectVeiculosFromTable(JTable table){
        int selectedRow = table.getSelectedRow();
        if(selectedRow>-1){
            ObjectTableModel tableModel = (ObjectTableModel) table.getModel();
            DefaultWrapper wrapper = (DefaultWrapper) tableModel.getValue(selectedRow);
            setVeiculoSelecionado(wrapper.getId());            
        }
    }
    
    private void setVeiculoSelecionado(Integer codigoVeiculo) {
        veiculoRN.setVeiculoById(codigoVeiculo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca de Veiculos");
        setResizable(false);

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbVeiculos);
        tbVeiculos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                selectVeiculosFromTable(tbVeiculos);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Veiculos Cadastrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSelecionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbVeiculos;
    // End of variables declaration//GEN-END:variables
}
