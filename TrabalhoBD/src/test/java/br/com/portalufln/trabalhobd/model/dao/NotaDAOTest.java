package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Nota;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NotaDAOTest {
    
    NotaDAO notaDAO = new NotaDAO();
    
    @Test
    public void salvarNota() {
        Nota nota = new Nota(8.5);
        notaDAO.salvar(nota);
        assertEquals(true, nota.equals(nota));
    }
    
}
