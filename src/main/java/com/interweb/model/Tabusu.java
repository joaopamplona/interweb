/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.interweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "TABUSU")
@NamedQueries({
    @NamedQuery(name = "Tabusu.findAll", query = "SELECT t FROM Tabusu t")
    , @NamedQuery(name = "Tabusu.findByCodigo", query = "SELECT t FROM Tabusu t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tabusu.findByNome", query = "SELECT t FROM Tabusu t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tabusu.findBySenha", query = "SELECT t FROM Tabusu t WHERE t.senha = :senha")
    , @NamedQuery(name = "Tabusu.findByTipousu", query = "SELECT t FROM Tabusu t WHERE t.tipousu = :tipousu")
    , @NamedQuery(name = "Tabusu.findBySistema", query = "SELECT t FROM Tabusu t WHERE t.sistema = :sistema")
    , @NamedQuery(name = "Tabusu.findByCodven", query = "SELECT t FROM Tabusu t WHERE t.codven = :codven")
    , @NamedQuery(name = "Tabusu.findByVlautoriza", query = "SELECT t FROM Tabusu t WHERE t.vlautoriza = :vlautoriza")
    , @NamedQuery(name = "Tabusu.findByRgcodusu", query = "SELECT t FROM Tabusu t WHERE t.rgcodusu = :rgcodusu")
    , @NamedQuery(name = "Tabusu.findByRgusuario", query = "SELECT t FROM Tabusu t WHERE t.rgusuario = :rgusuario")
    , @NamedQuery(name = "Tabusu.findByRgdata", query = "SELECT t FROM Tabusu t WHERE t.rgdata = :rgdata")
    , @NamedQuery(name = "Tabusu.findByRgevento", query = "SELECT t FROM Tabusu t WHERE t.rgevento = :rgevento")
    , @NamedQuery(name = "Tabusu.findByPercdescav", query = "SELECT t FROM Tabusu t WHERE t.percdescav = :percdescav")
    , @NamedQuery(name = "Tabusu.findByPercdesccc", query = "SELECT t FROM Tabusu t WHERE t.percdesccc = :percdesccc")
    , @NamedQuery(name = "Tabusu.findByPercdescap", query = "SELECT t FROM Tabusu t WHERE t.percdescap = :percdescap")
    , @NamedQuery(name = "Tabusu.findByPercdesccoav", query = "SELECT t FROM Tabusu t WHERE t.percdesccoav = :percdesccoav")
    , @NamedQuery(name = "Tabusu.findByPercdescatav", query = "SELECT t FROM Tabusu t WHERE t.percdescatav = :percdescatav")
    , @NamedQuery(name = "Tabusu.findByPercdesccocc", query = "SELECT t FROM Tabusu t WHERE t.percdesccocc = :percdesccocc")
    , @NamedQuery(name = "Tabusu.findByPercdescatcc", query = "SELECT t FROM Tabusu t WHERE t.percdescatcc = :percdescatcc")
    , @NamedQuery(name = "Tabusu.findByPercdesccoap", query = "SELECT t FROM Tabusu t WHERE t.percdesccoap = :percdesccoap")
    , @NamedQuery(name = "Tabusu.findByPercdescatap", query = "SELECT t FROM Tabusu t WHERE t.percdescatap = :percdescatap")
    , @NamedQuery(name = "Tabusu.findByPercdescjur", query = "SELECT t FROM Tabusu t WHERE t.percdescjur = :percdescjur")
    , @NamedQuery(name = "Tabusu.findByPercdescmul", query = "SELECT t FROM Tabusu t WHERE t.percdescmul = :percdescmul")
    , @NamedQuery(name = "Tabusu.findByPercdesctit", query = "SELECT t FROM Tabusu t WHERE t.percdesctit = :percdesctit")
    , @NamedQuery(name = "Tabusu.findByVisualizardebitos", query = "SELECT t FROM Tabusu t WHERE t.visualizardebitos = :visualizardebitos")
    , @NamedQuery(name = "Tabusu.findByCodconta", query = "SELECT t FROM Tabusu t WHERE t.codconta = :codconta")
    , @NamedQuery(name = "Tabusu.buscaUsuario", query = "SELECT t FROM Tabusu t WHERE ((t.rgevento <> '3') or (t.rgevento <> NULL)) AND (t.nome = :nome) AND (t.senha = :senha) ORDER BY t.sistema ")})

public class Tabusu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 8)
    @Column(name = "NOME")
    private String nome;
    @Size(max = 6)
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "TIPOUSU")
    private Character tipousu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SISTEMA")
    private int sistema;
    @Column(name = "CODVEN")
    private Integer codven;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLAUTORIZA")
    private Double vlautoriza;
    @Column(name = "RGCODUSU")
    private Integer rgcodusu;
    @Size(max = 8)
    @Column(name = "RGUSUARIO")
    private String rgusuario;
    @Column(name = "RGDATA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rgdata;
    @Size(max = 1)
    @Column(name = "RGEVENTO")
    private String rgevento;
    @Lob
    @Column(name = "TEMPLATE_1")
    private byte[] template1;
    @Lob
    @Column(name = "TEMPLATE_2")
    private byte[] template2;
    @Lob
    @Column(name = "TEMPLATE_3")
    private byte[] template3;
    @Lob
    @Column(name = "TEMPLATE_4")
    private byte[] template4;
    @Lob
    @Column(name = "TEMPLATE_5")
    private byte[] template5;
    @Column(name = "PERCDESCAV")
    private Double percdescav;
    @Column(name = "PERCDESCCC")
    private Double percdesccc;
    @Column(name = "PERCDESCAP")
    private Double percdescap;
    @Column(name = "PERCDESCCOAV")
    private Double percdesccoav;
    @Column(name = "PERCDESCATAV")
    private Double percdescatav;
    @Column(name = "PERCDESCCOCC")
    private Double percdesccocc;
    @Column(name = "PERCDESCATCC")
    private Double percdescatcc;
    @Column(name = "PERCDESCCOAP")
    private Double percdesccoap;
    @Column(name = "PERCDESCATAP")
    private Double percdescatap;
    @Column(name = "PERCDESCJUR")
    private Double percdescjur;
    @Column(name = "PERCDESCMUL")
    private Double percdescmul;
    @Column(name = "PERCDESCTIT")
    private Double percdesctit;
    @Column(name = "VISUALIZARDEBITOS")
    private Character visualizardebitos;
    @Column(name = "CODCONTA")
    private Integer codconta;

    public Tabusu() {
    }

    public Tabusu(Integer codigo) {
        this.codigo = codigo;
    }

    public Tabusu(Integer codigo, int sistema) {
        this.codigo = codigo;
        this.sistema = sistema;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Character getTipousu() {
        return tipousu;
    }

    public void setTipousu(Character tipousu) {
        this.tipousu = tipousu;
    }

    public int getSistema() {
        return sistema;
    }

    public void setSistema(int sistema) {
        this.sistema = sistema;
    }

    public Integer getCodven() {
        return codven;
    }

    public void setCodven(Integer codven) {
        this.codven = codven;
    }

    public Double getVlautoriza() {
        return vlautoriza;
    }

    public void setVlautoriza(Double vlautoriza) {
        this.vlautoriza = vlautoriza;
    }

    public Integer getRgcodusu() {
        return rgcodusu;
    }

    public void setRgcodusu(Integer rgcodusu) {
        this.rgcodusu = rgcodusu;
    }

    public String getRgusuario() {
        return rgusuario;
    }

    public void setRgusuario(String rgusuario) {
        this.rgusuario = rgusuario;
    }

    public Date getRgdata() {
        return rgdata;
    }

    public void setRgdata(Date rgdata) {
        this.rgdata = rgdata;
    }

    public String getRgevento() {
        return rgevento;
    }

    public void setRgevento(String rgevento) {
        this.rgevento = rgevento;
    }

    public byte[] getTemplate1() {
        return template1;
    }

    public void setTemplate1(byte[] template1) {
        this.template1 = template1;
    }

    public byte[] getTemplate2() {
        return template2;
    }

    public void setTemplate2(byte[] template2) {
        this.template2 = template2;
    }

    public byte[] getTemplate3() {
        return template3;
    }

    public void setTemplate3(byte[] template3) {
        this.template3 = template3;
    }

    public byte[] getTemplate4() {
        return template4;
    }

    public void setTemplate4(byte[] template4) {
        this.template4 = template4;
    }

    public byte[] getTemplate5() {
        return template5;
    }

    public void setTemplate5(byte[] template5) {
        this.template5 = template5;
    }

    public Double getPercdescav() {
        return percdescav;
    }

    public void setPercdescav(Double percdescav) {
        this.percdescav = percdescav;
    }

    public Double getPercdesccc() {
        return percdesccc;
    }

    public void setPercdesccc(Double percdesccc) {
        this.percdesccc = percdesccc;
    }

    public Double getPercdescap() {
        return percdescap;
    }

    public void setPercdescap(Double percdescap) {
        this.percdescap = percdescap;
    }

    public Double getPercdesccoav() {
        return percdesccoav;
    }

    public void setPercdesccoav(Double percdesccoav) {
        this.percdesccoav = percdesccoav;
    }

    public Double getPercdescatav() {
        return percdescatav;
    }

    public void setPercdescatav(Double percdescatav) {
        this.percdescatav = percdescatav;
    }

    public Double getPercdesccocc() {
        return percdesccocc;
    }

    public void setPercdesccocc(Double percdesccocc) {
        this.percdesccocc = percdesccocc;
    }

    public Double getPercdescatcc() {
        return percdescatcc;
    }

    public void setPercdescatcc(Double percdescatcc) {
        this.percdescatcc = percdescatcc;
    }

    public Double getPercdesccoap() {
        return percdesccoap;
    }

    public void setPercdesccoap(Double percdesccoap) {
        this.percdesccoap = percdesccoap;
    }

    public Double getPercdescatap() {
        return percdescatap;
    }

    public void setPercdescatap(Double percdescatap) {
        this.percdescatap = percdescatap;
    }

    public Double getPercdescjur() {
        return percdescjur;
    }

    public void setPercdescjur(Double percdescjur) {
        this.percdescjur = percdescjur;
    }

    public Double getPercdescmul() {
        return percdescmul;
    }

    public void setPercdescmul(Double percdescmul) {
        this.percdescmul = percdescmul;
    }

    public Double getPercdesctit() {
        return percdesctit;
    }

    public void setPercdesctit(Double percdesctit) {
        this.percdesctit = percdesctit;
    }

    public Character getVisualizardebitos() {
        return visualizardebitos;
    }

    public void setVisualizardebitos(Character visualizardebitos) {
        this.visualizardebitos = visualizardebitos;
    }

    public Integer getCodconta() {
        return codconta;
    }

    public void setCodconta(Integer codconta) {
        this.codconta = codconta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabusu)) {
            return false;
        }
        Tabusu other = (Tabusu) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interagese.interweb.model.Tabusu[ codigo=" + codigo + " ]";
    }
    
}
