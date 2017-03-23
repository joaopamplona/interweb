
package com.interweb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TABSIS")
@NamedQueries({
    @NamedQuery(name = "Tabsis.findAll", query = "SELECT t FROM Tabsis t")
    , @NamedQuery(name = "Tabsis.findByCodsis", query = "SELECT t FROM Tabsis t WHERE t.codsis = :codsis")
    , @NamedQuery(name = "Tabsis.findByNomsis", query = "SELECT t FROM Tabsis t WHERE t.nomsis = :nomsis")
    , @NamedQuery(name = "Tabsis.findByPasta", query = "SELECT t FROM Tabsis t WHERE t.pasta = :pasta")
    , @NamedQuery(name = "Tabsis.findByRgcodusu", query = "SELECT t FROM Tabsis t WHERE t.rgcodusu = :rgcodusu")
    , @NamedQuery(name = "Tabsis.findByRgusuario", query = "SELECT t FROM Tabsis t WHERE t.rgusuario = :rgusuario")
    , @NamedQuery(name = "Tabsis.findByRgdata", query = "SELECT t FROM Tabsis t WHERE t.rgdata = :rgdata")
    , @NamedQuery(name = "Tabsis.findByRgevento", query = "SELECT t FROM Tabsis t WHERE t.rgevento = :rgevento")
    , @NamedQuery(name = "Tabsis.buscaSistemaDoUsuario", query = "SELECT t FROM Tabsis t WHERE t.codsis = :codsis")})
public class Tabsis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODSIS")
    private Integer codsis;
    @Size(max = 30)
    @Column(name = "NOMSIS")
    private String nomsis;
    @Size(max = 20)
    @Column(name = "PASTA")
    private String pasta;
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

    public Tabsis() {
    }

    public Tabsis(Integer codsis) {
        this.codsis = codsis;
    }

    public Integer getCodsis() {
        return codsis;
    }

    public void setCodsis(Integer codsis) {
        this.codsis = codsis;
    }

    public String getNomsis() {
        return nomsis;
    }

    public void setNomsis(String nomsis) {
        this.nomsis = nomsis;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codsis != null ? codsis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabsis)) {
            return false;
        }
        Tabsis other = (Tabsis) object;
        if ((this.codsis == null && other.codsis != null) || (this.codsis != null && !this.codsis.equals(other.codsis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interagese.interweb.model.Tabsis[ codsis=" + codsis + " ]";
    }
    
}
