package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Aluno;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlunoDAOTest {
    
    AlunoDAO alunoDAO = new AlunoDAO();
    
//    @Test
//    public void salvarAluno() {
//        Aluno aluno = new Aluno("Yan","12155458789");
//        alunoDAO.salvar(aluno);
//        assertEquals(true, aluno.equals(aluno));
//    }
    
//    @Test
//    public void alterarAluno() {
//        Aluno aluno = new Aluno("Yan","51871920101");
//        alunoDAO.alterar(aluno);
//        assertEquals(true, aluno.equals(aluno));
//    }
    
    @Test
    public void removerAluno() {
        Aluno aluno = new Aluno("Yan","12155458789");
        alunoDAO.remover(aluno);
        assertEquals(true, aluno.equals(aluno));
    }
}