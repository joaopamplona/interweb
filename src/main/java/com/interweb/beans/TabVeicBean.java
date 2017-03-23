
package com.interweb.beans;

import com.interweb.conexao.JPAUtil;
import com.interweb.model.Tabveic;
import com.interweb.util.Utilitarios;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@ManagedBean(name = "TabVeicBean")
@ViewScoped
public class TabVeicBean implements java.io.Serializable{
    
    private Tabveic tabveic;
    private Tabveic veiculoSelecionado;
    private List<Tabveic> veiculosSelecionados;
    private String tag_acao;
    
    public Tabveic getTabveic(){
        return tabveic;
    }
    
    public void setTabveic(Tabveic tabveic){
        this.tabveic = tabveic;
    }
    
    public Tabveic getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    public void setVeiculoSelecionado(Tabveic veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }
    
    public List<Tabveic> getVeiculosSelecionados(){
        return veiculosSelecionados;
    }
    
    public void setVeiculosSelecionados(List<Tabveic> veiculosSelecionados){
        this.veiculosSelecionados = veiculosSelecionados;
    }
    
    public List<Tabveic> getVeiculos(){
        Query query = JPAUtil.getEntityManager().createQuery("SELECT t FROM Tabveic t WHERE t.rgevento <> '3'");
        return query.getResultList();
    }
    
    public short BuscaCodMax(){
        TypedQuery<Short> query = JPAUtil.getEntityManager().createQuery("SELECT MAX(t.codveic) + 1 FROM Tabveic t", Short.class);
        Short codmax = query.getSingleResult();
        if(codmax == null){
            codmax = Short.parseShort("1");
        }
        
        return codmax;
    }
    
    public void inserir(){
        this.tag_acao = "1";
        this.tabveic = new Tabveic();
        this.tabveic.setCodveic(BuscaCodMax());
    }
    
    public void alterar(){
        this.tag_acao = "2";
        this.tabveic = this.veiculoSelecionado;
    }

    public void excluir(){
        this.tag_acao = "3";
        this.tabveic = this.veiculoSelecionado;
    }    
    
    public void gravar(){
        try {
            if (tag_acao.equals("1")) {

                this.tabveic.setRgcodusu(1);

                this.tabveic.setRgusuario("INTER");

                this.tabveic.setRgdata(new Date());

                this.tabveic.setRgevento("1");

                JPAUtil.persistir(this.tabveic);

                Utilitarios.CriarMensagem("Veículo inserido com sucesso!", "");
                
                System.out.println("Código= " + tabveic.getCodveic());
                
            } else if (tag_acao.equals("2")) {

                Tabveic veic = this.tabveic;

                veic.setRgcodusu(1);

                veic.setRgusuario("INTER");

                veic.setRgdata(new Date());

                veic.setRgevento("2");

                JPAUtil.persistir(veic);

                Utilitarios.CriarMensagem("Veículo alterado com sucesso!", "");
                
            } else if (tag_acao.equals("3")) {

                Tabveic veic = this.tabveic;

                veic.setRgcodusu(1);

                veic.setRgusuario("INTER");

                veic.setRgdata(new Date());

                veic.setRgevento("3");

                JPAUtil.persistir(veic);
                
                System.out.println("Item excluido");

                Utilitarios.CriarMensagem("Veículo deletado com sucesso!", "");
                
            }
        }catch(Exception e){
            e.printStackTrace();
            Utilitarios.CriarMensagemErro("Erro ao gravar veículo", e.getLocalizedMessage());
        }
        
    }
    
    
}
