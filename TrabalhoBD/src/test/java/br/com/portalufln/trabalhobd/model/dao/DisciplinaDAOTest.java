package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Disciplina;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DisciplinaDAOTest {
    
    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    @Test
    public void salvarDisciplina() {
        Disciplina disciplina = new Disciplina("PROG3","CANSAÇO",60);
        disciplinaDAO.salvar(disciplina);
        assertEquals(true, disciplina.equals(disciplina));
    }
}
