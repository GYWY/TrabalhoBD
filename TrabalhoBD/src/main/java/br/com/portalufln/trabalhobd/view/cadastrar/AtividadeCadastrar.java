package br.com.portalufln.trabalhobd.view.cadastrar;

import br.com.portalufln.trabalhobd.model.dao.AtividadeDAO;
import br.com.portalufln.trabalhobd.model.dao.DisciplinaDAO;
import br.com.portalufln.trabalhobd.model.dao.GenericoDAO;
import br.com.portalufln.trabalhobd.model.dao.TurmaDAO;
import br.com.portalufln.trabalhobd.model.pojo.Atividade;
import br.com.portalufln.trabalhobd.model.pojo.Disciplina;
import br.com.portalufln.trabalhobd.model.pojo.Turma;
import br.com.portalufln.trabalhobd.util.exception.ValorNuloException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AtividadeCadastrar extends javax.swing.JFrame {

    private GenericoDAO atividadeDAO;
    private GenericoDAO disciplinaDAO;
    private GenericoDAO turmaDAO;
    
    public AtividadeCadastrar() {
        atividadeDAO = new AtividadeDAO();
        disciplinaDAO = new DisciplinaDAO();
        turmaDAO = new TurmaDAO();
        initComponents();
        
        btBuscaDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nomeDisciplina = cpDisciplina.getText().toUpperCase();
                preencherTabelaListaDisciplinas(((DisciplinaDAO) disciplinaDAO).buscarNome(nomeDisciplina));
            }
        });
        
        btListarTurmas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel modelTurma = (DefaultTableModel) tableListaTurmas.getModel();
                Integer opDisciplina = tableBuscaDisciplina.getSelectedRow();
                if(opDisciplina == -1) {
                    JOptionPane.showMessageDialog(new JFrame(), "Selecione uma disciplina.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    Disciplina disciplina = (Disciplina) disciplinaDAO.buscarId((Long) tableBuscaDisciplina.getValueAt(opDisciplina, 0));
                    preencherTabelaListaTurmas(disciplina.getListaTurmas());
                }
            }
        });
        
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Integer opTurma = tableListaTurmas.getSelectedRow();
                
                if(opTurma == -1) {
                    JOptionPane.showMessageDialog(new JFrame(), "Selecione um professor.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
                String nome = cpNome.getText().toUpperCase();
                String tipo = cpTipo.getText().toUpperCase();
                String dia = cpDia.getText().toUpperCase();
                String valor = cpValor.getText().toUpperCase();
                Turma turma = (Turma) turmaDAO.buscarId((Long) tableListaTurmas.getValueAt(opTurma, 0));
                Atividade novaAtividade = new Atividade();
                novaAtividade.setNome(nome);
                novaAtividade.setTipo(tipo);
                novaAtividade.setDia(dia);
                novaAtividade.setValor(Double.parseDouble(valor));
                novaAtividade.setTurma(turma);
                turma.addAtividades(novaAtividade);
                
                try{
                    verificar(nome,tipo,dia,valor);
                    atividadeDAO.salvar(novaAtividade);
                    turmaDAO.alterar(turma);
                    JOptionPane.showMessageDialog(new JFrame(), "Atividade cadastrada com sucesso.", "Cadastrado", JOptionPane.DEFAULT_OPTION);
                } catch(ValorNuloException nulo) {
                    JOptionPane.showMessageDialog(new JFrame(), "Campo em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            public void verificar(String nome, String tipo, String dia, String valor) throws ValorNuloException {
                if(nome.equals("") || tipo.equals("")) {
                    if(dia.equals("") || valor.equals("")) {
                        throw new ValorNuloException();
                    }
                }
            }
        });  
        
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
    }
    
    private void preencherTabelaListaDisciplinas(List<Disciplina> listaDisciplinas) {
        DefaultTableModel model = (DefaultTableModel) tableBuscaDisciplina.getModel();
        model.setRowCount(0);
        for(Disciplina disciplina : listaDisciplinas) {
            model.addRow(new Object[]{null,null,null,null});
            model.setValueAt(disciplina.getId(), model.getRowCount() - 1, 0);
            model.setValueAt(disciplina.getNome(), model.getRowCount() - 1, 1);
            model.setValueAt(disciplina.getEmenta(), model.getRowCount() - 1, 2);
            model.setValueAt(disciplina.getCargaHoraria(), model.getRowCount() - 1, 3);
        }
    }
    
    private void preencherTabelaListaTurmas(List<Turma> listaTurmas) {
        DefaultTableModel model = (DefaultTableModel) tableListaTurmas.getModel();
        model.setRowCount(0);
        for(Turma turma : listaTurmas) {
            model.addRow(new Object[]{null,null,null,null});
            model.setValueAt(turma.getId(), model.getRowCount() - 1, 0);
            model.setValueAt(turma.getAno(), model.getRowCount() - 1, 1);
            model.setValueAt(turma.getPeriodo(), model.getRowCount() - 1, 2);
            model.setValueAt(turma.getSala(), model.getRowCount() - 1, 3);
            model.setValueAt(turma.getHorario(), model.getRowCount() - 1, 4);
            model.setValueAt(turma.getVaga(), model.getRowCount() - 1, 5);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cpProfessor4 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        cpDisciplina = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btBuscaDisciplina = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBuscaDisciplina = new javax.swing.JTable();
        btListarTurmas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableListaTurmas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cpNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cpTipo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cpDia = new javax.swing.JTextField();
        cpValor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Sala:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setTitle("Cadastrar Turma");
        jInternalFrame1.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Disciplina:");

        btCadastrar.setText("CADASTRAR");

        btCancelar.setText("CANCELAR");

        btBuscaDisciplina.setText("PROCURAR");

        tableBuscaDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Ementa", "Carga Horária"
            }
        ));
        jScrollPane2.setViewportView(tableBuscaDisciplina);

        btListarTurmas.setText("EXIBIR TURMAS");

        tableListaTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ano", "Período", "Sala", "Horário", "Vagas"
            }
        ));
        jScrollPane3.setViewportView(tableListaTurmas);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ATIVIDADE");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Tipo:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Data:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Valor:");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(btListarTurmas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpDisciplina)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscaDisciplina))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCancelar))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cpDia, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cpTipo)
                            .addComponent(cpValor)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jLabel2)))
                        .addGap(152, 152, 152)))
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cpDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscaDisciplina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btListarTurmas)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cpNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cpTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cpDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cpValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btCadastrar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AtividadeCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtividadeCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtividadeCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtividadeCadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AtividadeCadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscaDisciplina;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btListarTurmas;
    private javax.swing.JTextField cpDia;
    private javax.swing.JTextField cpDisciplina;
    private javax.swing.JTextField cpNome;
    private javax.swing.JTextField cpProfessor4;
    private javax.swing.JTextField cpTipo;
    private javax.swing.JTextField cpValor;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableBuscaDisciplina;
    private javax.swing.JTable tableListaTurmas;
    // End of variables declaration//GEN-END:variables
}
