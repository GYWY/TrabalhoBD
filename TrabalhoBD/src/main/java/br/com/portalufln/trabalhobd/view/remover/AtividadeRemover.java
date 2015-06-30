package br.com.portalufln.trabalhobd.view.remover;

import br.com.portalufln.trabalhobd.view.alterar.*;
import br.com.portalufln.trabalhobd.model.dao.AtividadeDAO;
import br.com.portalufln.trabalhobd.model.dao.GenericoDAO;
import br.com.portalufln.trabalhobd.model.pojo.Atividade;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AtividadeRemover extends javax.swing.JFrame {

    private GenericoDAO atividadeDAO;
    
    public AtividadeRemover() {
        atividadeDAO = new AtividadeDAO();
        initComponents();
        
        btListarAtividades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Atividade> listaAtividades = atividadeDAO.buscarTodos();
                preencherTabelaListaAtividades(listaAtividades);
            }
        });
        
        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel modelAtividade = (DefaultTableModel) tableListaAtividades.getModel();
                Integer opAtividade = tableListaAtividades.getSelectedRow();
                if(opAtividade == -1){
                    JOptionPane.showMessageDialog(new JFrame(), "Selecione uma atividade.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
 
                Atividade atividade = (Atividade) atividadeDAO.buscarId((Long) tableListaAtividades.getValueAt(opAtividade, 0));
                atividadeDAO.remover(atividade);
                JOptionPane.showMessageDialog(new JFrame(), "Atividade removida com sucesso.", "Removido", JOptionPane.DEFAULT_OPTION);
            }
        });
        
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
        
    }
        
    private void preencherTabelaListaAtividades(List<Atividade> listaAtividades) {
        DefaultTableModel model = (DefaultTableModel) tableListaAtividades.getModel();
        model.setRowCount(0);
        for(Atividade atividade : listaAtividades) {
            model.addRow(new Object[]{null,null,null,null,null,null});
            model.setValueAt(atividade.getId(), model.getRowCount() - 1, 0);
            model.setValueAt(atividade.getTurma().getId(), model.getRowCount() - 1, 1);
            model.setValueAt(atividade.getNome(), model.getRowCount() - 1, 2);
            model.setValueAt(atividade.getTipo(), model.getRowCount() - 1, 3);
            model.setValueAt(atividade.getDia(), model.getRowCount() - 1, 4);
            model.setValueAt(atividade.getValor(), model.getRowCount() - 1, 5);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        btCancelar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableListaAtividades = new javax.swing.JTable();
        btListarAtividades = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        btCancelar.setText("CANCELAR");

        btRemover.setText("REMOVER");

        tableListaAtividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", " Turma", "Nome", "Tipo", "Data", "Valor"
            }
        ));
        jScrollPane3.setViewportView(tableListaAtividades);

        btListarAtividades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btListarAtividades.setText("LISTAR ATIVIDADES");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btListarAtividades)
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btListarAtividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btRemover))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtividadeRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtividadeRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtividadeRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtividadeRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtividadeRemover().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btListarAtividades;
    private javax.swing.JButton btRemover;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableListaAtividades;
    // End of variables declaration//GEN-END:variables
}
