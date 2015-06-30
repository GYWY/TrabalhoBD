package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Falta;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FaltaDAOTest {
   
    FaltaDAO faltaDAO = new FaltaDAO();
    
    @Test
    public void salvarFalta() {
        Falta falta = new Falta(8);
        faltaDAO.salvar(falta);
        assertEquals(true, falta.equals(falta));
    }
    
}
