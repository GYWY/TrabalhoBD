package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Turma;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TurmaDAOTest {
    
    TurmaDAO turmaDAO = new TurmaDAO();
    
    @Test
    public void salvarTurma() {
        Turma turma = new Turma(2015,5,"12","07:50",40);
        turmaDAO.salvar(turma);
        assertEquals(true, turma.equals(turma));
    }
    
}
