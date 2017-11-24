/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idProduto;
    private String codigoReferencia;
    private String descriao;
    private int qtdeEmbalagem;
    private String ncm;
    private BigDecimal preco_custo;
    private BigDecimal preco_venda;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Grupo grupo;
    @ManyToOne
    @JoinColumn(nullable = false)
    private AliquotasProduto aliquotasProduto;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadeMedida unidadeMedida;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoProduto tipo;

    private boolean status;

    public Produto() {
    }

    public Produto(long id, String codigoReferencia, String descriao, int qtdeEmbalagem, String ncm, BigDecimal preco_custo, BigDecimal preco_venda, Grupo grupo, AliquotasProduto aliquotasProduto, UnidadeMedida unidadeMedida, TipoProduto tipo, boolean status) {
        this.idProduto = id;
        this.codigoReferencia = codigoReferencia;
        this.descriao = descriao;
        this.qtdeEmbalagem = qtdeEmbalagem;
        this.ncm = ncm;
        this.preco_custo = preco_custo;
        this.preco_venda = preco_venda;
        this.grupo = grupo;
        this.aliquotasProduto = aliquotasProduto;
        this.unidadeMedida = unidadeMedida;
        this.tipo = tipo;
        this.status = status;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public String getDescriao() {
        return descriao;
    }

    public void setDescriao(String descriao) {
        this.descriao = descriao;
    }

    public int getQtdeEmbalagem() {
        return qtdeEmbalagem;
    }

    public void setQtdeEmbalagem(int qtdeEmbalagem) {
        this.qtdeEmbalagem = qtdeEmbalagem;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public BigDecimal getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(BigDecimal preco_custo) {
        this.preco_custo = preco_custo;
    }

    public BigDecimal getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(BigDecimal preco_venda) {
        this.preco_venda = preco_venda;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public AliquotasProduto getAliquotasProduto() {
        return aliquotasProduto;
    }

    public void setAliquotasProduto(AliquotasProduto aliquotasProduto) {
        this.aliquotasProduto = aliquotasProduto;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.idProduto ^ (this.idProduto >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        if (!Objects.equals(this.codigoReferencia, other.codigoReferencia)) {
            return false;
        }
        if (!Objects.equals(this.descriao, other.descriao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.descriao;
    }

}