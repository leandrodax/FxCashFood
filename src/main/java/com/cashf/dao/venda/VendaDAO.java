/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.dao.venda;

import com.cashf.model.cliente.Cliente;
import com.cashf.model.venda.Venda;
import dao.GenericDAOIMP;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author joao
 */
public class VendaDAO extends GenericDAOIMP<Venda> {

    public VendaDAO(Class<Venda> clazz) {
        super(clazz);
    }

    public long totalDeVendasParaCliente(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "select count(cliente.idPessoa) from Venda venda where venda.cliente.idPessoa=:idCliente";
            Query query = session.createQuery(hql);
            query.setParameter("idCliente", cliente.getIdPessoa());
            return (long) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return 0;
        }

    }
    public double avgValorVendaCliente(Cliente cliente) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "select avg(valorTotal) from Venda venda where venda.cliente.idPessoa=:idCliente";
            Query query = session.createQuery(hql);
            query.setParameter("idCliente", cliente.getIdPessoa());
            return (double) query.getSingleResult();
        } catch (Exception e) {
            System.out.println("Erro:" + e);
            return 0;
        }

    }

}
