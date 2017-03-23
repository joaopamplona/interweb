
package com.interweb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "MENUITEM")
@NamedQueries({
    @NamedQuery(name = "Menuitem.findAll", query = "SELECT m FROM Menuitem m")
    , @NamedQuery(name = "Menuitem.findByCodsis", query = "SELECT m FROM Menuitem m WHERE m.codsis = :codsis")
    , @NamedQuery(name = "Menuitem.findByCodigo", query = "SELECT m FROM Menuitem m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Menuitem.findByDescricao", query = "SELECT m FROM Menuitem m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Menuitem.findByCodpermissao", query = "SELECT m FROM Menuitem m WHERE m.codpermissao = :codpermissao")
    , @NamedQuery(name = "Menuitem.findByTipopermissao", query = "SELECT m FROM Menuitem m WHERE m.tipopermissao = :tipopermissao")
    , @NamedQuery(name = "Menuitem.buscaMenuDoSistema", query = "SELECT m FROM Menuitem m WHERE m.codsis = :codsis")})
public class Menuitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODSIS")
    private int codsis;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Size(max = 50)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Size(max = 10)
    @Column(name = "CODPERMISSAO")
    private String codpermissao;
    @Size(max = 10)
    @Column(name = "TIPOPERMISSAO")
    private String tipopermissao;

    public Menuitem() {
    }

    public Menuitem(Integer codigo) {
        this.codigo = codigo;
    }

    public Menuitem(Integer codigo, int codsis) {
        this.codigo = codigo;
        this.codsis = codsis;
    }

    public int getCodsis() {
        return codsis;
    }

    public void setCodsis(int codsis) {
        this.codsis = codsis;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodpermissao() {
        return codpermissao;
    }

    public void setCodpermissao(String codpermissao) {
        this.codpermissao = codpermissao;
    }

    public String getTipopermissao() {
        return tipopermissao;
    }

    public void setTipopermissao(String tipopermissao) {
        this.tipopermissao = tipopermissao;
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
        if (!(object instanceof Menuitem)) {
            return false;
        }
        Menuitem other = (Menuitem) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interagese.interweb.model.Menuitem[ codigo=" + codigo + " ]";
    }
    
}
