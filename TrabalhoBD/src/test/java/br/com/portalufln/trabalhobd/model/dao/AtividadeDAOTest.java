package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Atividade;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AtividadeDAOTest {

    AtividadeDAO atividadeDAO = new AtividadeDAO();
    
    @Test
    public void salvarAtividade() {
        Atividade atividade = new Atividade("P1","PROVA","29/06/2015",10.0);
        atividadeDAO.salvar(atividade);
        assertEquals(true, atividade.equals(atividade));
    }
    
}
