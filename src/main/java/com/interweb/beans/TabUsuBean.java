
package com.interweb.beans;


import com.interweb.model.MenuBar;
import com.interweb.model.Tabusu;
import com.interweb.conexao.JPAUtil;
import com.interweb.model.Menuitem;
import com.interweb.model.Tabsis;
import com.interweb.util.Utilitarios;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import org.primefaces.model.menu.*;


@ManagedBean(name = "TabUsuBean")
public class TabUsuBean {
    
    private Tabusu tabusu;

    @PostConstruct
    public void init(){
        this.tabusu = new Tabusu();
    }
    
    public Tabusu getUsuario() {
        return tabusu;
    }
    
    //Método para fazer o Login do Usuário
    public String LogarUsuario(Tabusu tabusu) {
        
        MenuBar menuBar = new MenuBar();
        
        try {
            //Faz o select e seta os parametros login e senha vindos da view de login
            Query queryUsuario = JPAUtil.getEntityManager().createNamedQuery("Tabusu.buscaUsuario");
            queryUsuario.setParameter("nome", tabusu.getNome());
            queryUsuario.setParameter("senha", tabusu.getSenha());
            
            //Pega a lista de usuarios
            List<Tabusu> resultTabUsu = queryUsuario.getResultList();

            for (Tabusu usuario : resultTabUsu) {
                //Faz o select de sistemas e seta codsis vindo do select de usuarios
                Query queryTabsis = JPAUtil.getEntityManager().createNamedQuery("Tabsis.buscaSistemaDoUsuario");
                queryTabsis.setParameter("codsis", usuario.getSistema());

                //Pega a lista de sistemas
                List<Tabsis> resultTabsis = queryTabsis.getResultList();

                for (Tabsis sistema : resultTabsis) {
                    //Faz o select de menus e seta o parametro codsis vindo do select de sistemas
                    Query queryMenuitem = JPAUtil.getEntityManager().createNamedQuery("Menuitem.buscaMenuDoSistema");
                    queryMenuitem.setParameter("codsis", sistema.getCodsis());

                    //Não precisa repetir
                    List<Menuitem> resultMenuitem = queryMenuitem.getResultList();

                    //Popula o menu com os itens da lista acima
                    for (Menuitem menuitem : resultMenuitem) {
                        String label = menuitem.getDescricao();
                        DefaultSubMenu item = new DefaultSubMenu(label);
                        if(label.equals("Cadastros")){
                            DefaultMenuItem subitem = new DefaultMenuItem("Veículos");
                            subitem.setUrl("cadastro_veiculo.xhtml?faces-redirect=true");
                                    
                            item.setId("SubMenuCadastros");
                            item.addElement(subitem);
                            
                        }
                        
                        
                        menuBar.getMenubar().addElement(item);
                        
                    }
                    
                    
                    FacesContext.getCurrentInstance().addMessage("myform:frmlogin", new FacesMessage("Usuário Logado!"));
                    Utilitarios.RedirecionarPagina("views/pagina_principal.xhtml?faces-redirect=true");
                    return null;
                }

            }
  
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage("myform:frmlogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getLocalizedMessage()));
        }
        
        return null;
    }
    
}