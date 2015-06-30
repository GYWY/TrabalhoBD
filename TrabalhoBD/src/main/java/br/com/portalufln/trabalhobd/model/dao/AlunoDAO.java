package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Aluno;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AlunoDAO implements GenericoDAO<Aluno, Long>{

    @Override
    public void salvar(Aluno aluno) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(aluno);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Aluno aluno) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.merge(aluno);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Aluno aluno) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(aluno);
        tx.commit();
        em.close();
    }

    @Override
    public List<Aluno> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Aluno a", Aluno.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Aluno buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Aluno.class, id);
    }
        
    public List<Aluno> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Aluno c WHERE c.nome LIKE :nome", Aluno.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
    public List<Aluno> buscarCpf(String cpf) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Aluno c WHERE c.cpf LIKE :cpf", Aluno.class);
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }
}
