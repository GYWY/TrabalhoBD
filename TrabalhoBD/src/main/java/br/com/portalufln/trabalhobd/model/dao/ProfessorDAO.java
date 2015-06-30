package br.com.portalufln.trabalhobd.model.dao;

import br.com.portalufln.trabalhobd.model.pojo.Professor;
import br.com.portalufln.trabalhobd.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ProfessorDAO implements GenericoDAO<Professor, Long> {

    @Override
    public void salvar(Professor professor) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.persist(professor);
        tx.commit();
        em.close();
    }

    @Override
    public void alterar(Professor professor) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.merge(professor);
        tx.commit();
        em.close();
    }

    @Override
    public void remover(Professor professor) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        EntityTransaction tx = JPAUtil.getInstancia().getTransaction(em);
        em.remove(professor);
        tx.commit();
        em.close();
    }

    @Override
    public List<Professor> buscarTodos() {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("select a from Professor a", Professor.class);
        List lista = query.getResultList();
        em.close();
        return lista;
    }

    @Override
    public Professor buscarId(Long id) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        return em.find(Professor.class, id);
    }
    
    public List<Professor> buscarNome(String nome) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.nome LIKE :nome", Professor.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
    public List<Professor> buscarCpf(String cpf) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.cpf LIKE :cpf", Professor.class);
        query.setParameter("cpf", cpf);
        return query.getResultList();
    }
    
    public List<Professor> buscarDepartamento(String departamento) {
        EntityManager em = JPAUtil.getInstancia().getEntityManager();
        Query query = em.createQuery("SELECT c FROM Professor c WHERE c.cpf LIKE :departamento", Professor.class);
        query.setParameter("departamento", departamento);
        return query.getResultList();
    }
}
