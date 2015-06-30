package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Professor;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfessorDAOTest {
    
    ProfessorDAO professorDAO = new ProfessorDAO();
    
    @Test
    public void salvarProfessor() {
        Professor professor = new Professor("LEONARDO","23491283284","DCEL");
        professorDAO.salvar(professor);
        assertEquals(true, professor.equals(professor));
    }
    
}
