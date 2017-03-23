
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
@Table(name = "TABVEIC")
@NamedQueries({
    @NamedQuery(name = "Tabveic.findAll", query = "SELECT t FROM Tabveic t")
    , @NamedQuery(name = "Tabveic.findByCodveic", query = "SELECT t FROM Tabveic t WHERE t.codveic = :codveic")
    , @NamedQuery(name = "Tabveic.findByMarca", query = "SELECT t FROM Tabveic t WHERE t.marca = :marca")
    , @NamedQuery(name = "Tabveic.findByModelo", query = "SELECT t FROM Tabveic t WHERE t.modelo = :modelo")
    , @NamedQuery(name = "Tabveic.findByAno", query = "SELECT t FROM Tabveic t WHERE t.ano = :ano")
    , @NamedQuery(name = "Tabveic.findByCor", query = "SELECT t FROM Tabveic t WHERE t.cor = :cor")
    , @NamedQuery(name = "Tabveic.findByPlaca", query = "SELECT t FROM Tabveic t WHERE t.placa = :placa")
    , @NamedQuery(name = "Tabveic.findByCidade", query = "SELECT t FROM Tabveic t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "Tabveic.findByEstado", query = "SELECT t FROM Tabveic t WHERE t.estado = :estado")
    , @NamedQuery(name = "Tabveic.findByKilomini", query = "SELECT t FROM Tabveic t WHERE t.kilomini = :kilomini")
    , @NamedQuery(name = "Tabveic.findByKilomfim", query = "SELECT t FROM Tabveic t WHERE t.kilomfim = :kilomfim")
    , @NamedQuery(name = "Tabveic.findByKilocomb", query = "SELECT t FROM Tabveic t WHERE t.kilocomb = :kilocomb")
    , @NamedQuery(name = "Tabveic.findByRgcodusu", query = "SELECT t FROM Tabveic t WHERE t.rgcodusu = :rgcodusu")
    , @NamedQuery(name = "Tabveic.findByRgusuario", query = "SELECT t FROM Tabveic t WHERE t.rgusuario = :rgusuario")
    , @NamedQuery(name = "Tabveic.findByRgdata", query = "SELECT t FROM Tabveic t WHERE t.rgdata = :rgdata")
    , @NamedQuery(name = "Tabveic.findByRgevento", query = "SELECT t FROM Tabveic t WHERE t.rgevento = :rgevento")
    , @NamedQuery(name = "Tabveic.findByPesoveic", query = "SELECT t FROM Tabveic t WHERE t.pesoveic = :pesoveic")
    , @NamedQuery(name = "Tabveic.findByRntc", query = "SELECT t FROM Tabveic t WHERE t.rntc = :rntc")
    , @NamedQuery(name = "Tabveic.findByPropterc", query = "SELECT t FROM Tabveic t WHERE t.propterc = :propterc")
    , @NamedQuery(name = "Tabveic.findByTara", query = "SELECT t FROM Tabveic t WHERE t.tara = :tara")
    , @NamedQuery(name = "Tabveic.findByCapacidadeKg", query = "SELECT t FROM Tabveic t WHERE t.capacidadeKg = :capacidadeKg")
    , @NamedQuery(name = "Tabveic.findByCapacidadeM3", query = "SELECT t FROM Tabveic t WHERE t.capacidadeM3 = :capacidadeM3")
    , @NamedQuery(name = "Tabveic.findByRenavam", query = "SELECT t FROM Tabveic t WHERE t.renavam = :renavam")
    , @NamedQuery(name = "Tabveic.findByTpRodado", query = "SELECT t FROM Tabveic t WHERE t.tpRodado = :tpRodado")
    , @NamedQuery(name = "Tabveic.findByRodado", query = "SELECT t FROM Tabveic t WHERE t.rodado = :rodado")
    , @NamedQuery(name = "Tabveic.findByTpCarroceria", query = "SELECT t FROM Tabveic t WHERE t.tpCarroceria = :tpCarroceria")
    , @NamedQuery(name = "Tabveic.findByCarroceria", query = "SELECT t FROM Tabveic t WHERE t.carroceria = :carroceria")
    , @NamedQuery(name = "Tabveic.findByCodprop", query = "SELECT t FROM Tabveic t WHERE t.codprop = :codprop")
    , @NamedQuery(name = "Tabveic.findByNomeprop", query = "SELECT t FROM Tabveic t WHERE t.nomeprop = :nomeprop")})
public class Tabveic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODVEIC")
    private Short codveic;
    @Size(max = 15)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 15)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 4)
    @Column(name = "ANO")
    private String ano;
    @Size(max = 10)
    @Column(name = "COR")
    private String cor;
    @Size(max = 10)
    @Column(name = "PLACA")
    private String placa;
    @Size(max = 20)
    @Column(name = "CIDADE")
    private String cidade;
    @Size(max = 2)
    @Column(name = "ESTADO")
    private String estado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KILOMINI")
    private Double kilomini;
    @Column(name = "KILOMFIM")
    private Double kilomfim;
    @Column(name = "KILOCOMB")
    private Double kilocomb;
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
    @Column(name = "PESOVEIC")
    private Double pesoveic;
    @Size(max = 20)
    @Column(name = "RNTC")
    private String rntc;
    @Column(name = "PROPTERC")
    private Character propterc;
    @Column(name = "TARA")
    private Integer tara;
    @Column(name = "CAPACIDADE_KG")
    private Integer capacidadeKg;
    @Column(name = "CAPACIDADE_M3")
    private Integer capacidadeM3;
    @Size(max = 11)
    @Column(name = "RENAVAM")
    private String renavam;
    @Size(max = 2)
    @Column(name = "TP_RODADO")
    private String tpRodado;
    @Size(max = 60)
    @Column(name = "RODADO")
    private String rodado;
    @Size(max = 2)
    @Column(name = "TP_CARROCERIA")
    private String tpCarroceria;
    @Size(max = 60)
    @Column(name = "CARROCERIA")
    private String carroceria;
    @Column(name = "CODPROP")
    private Integer codprop;
    @Size(max = 60)
    @Column(name = "NOMEPROP")
    private String nomeprop;

    public Tabveic() {
    }

    public Tabveic(Short codveic) {
        this.codveic = codveic;
    }

    public Short getCodveic() {
        return codveic;
    }

    public void setCodveic(Short codveic) {
        this.codveic = codveic;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getKilomini() {
        return kilomini;
    }

    public void setKilomini(Double kilomini) {
        this.kilomini = kilomini;
    }

    public Double getKilomfim() {
        return kilomfim;
    }

    public void setKilomfim(Double kilomfim) {
        this.kilomfim = kilomfim;
    }

    public Double getKilocomb() {
        return kilocomb;
    }

    public void setKilocomb(Double kilocomb) {
        this.kilocomb = kilocomb;
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

    public Double getPesoveic() {
        return pesoveic;
    }

    public void setPesoveic(Double pesoveic) {
        this.pesoveic = pesoveic;
    }

    public String getRntc() {
        return rntc;
    }

    public void setRntc(String rntc) {
        this.rntc = rntc;
    }

    public Character getPropterc() {
        return propterc;
    }

    public void setPropterc(Character propterc) {
        this.propterc = propterc;
    }

    public Integer getTara() {
        return tara;
    }

    public void setTara(Integer tara) {
        this.tara = tara;
    }

    public Integer getCapacidadeKg() {
        return capacidadeKg;
    }

    public void setCapacidadeKg(Integer capacidadeKg) {
        this.capacidadeKg = capacidadeKg;
    }

    public Integer getCapacidadeM3() {
        return capacidadeM3;
    }

    public void setCapacidadeM3(Integer capacidadeM3) {
        this.capacidadeM3 = capacidadeM3;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getTpRodado() {
        return tpRodado;
    }

    public void setTpRodado(String tpRodado) {
        this.tpRodado = tpRodado;
    }

    public String getRodado() {
        return rodado;
    }

    public void setRodado(String rodado) {
        this.rodado = rodado;
    }

    public String getTpCarroceria() {
        return tpCarroceria;
    }

    public void setTpCarroceria(String tpCarroceria) {
        this.tpCarroceria = tpCarroceria;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public Integer getCodprop() {
        return codprop;
    }

    public void setCodprop(Integer codprop) {
        this.codprop = codprop;
    }

    public String getNomeprop() {
        return nomeprop;
    }

    public void setNomeprop(String nomeprop) {
        this.nomeprop = nomeprop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codveic != null ? codveic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tabveic)) {
            return false;
        }
        Tabveic other = (Tabveic) object;
        if ((this.codveic == null && other.codveic != null) || (this.codveic != null && !this.codveic.equals(other.codveic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.interagese.interweb.model.Tabveic[ codveic=" + codveic + " ]";
    }
    
}
