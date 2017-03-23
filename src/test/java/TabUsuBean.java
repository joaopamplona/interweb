



import com.interweb.model.MenuBar;
import com.interweb.model.Tabusu;
import com.interweb.conexao.JPAUtil;
import com.interweb.model.Menuitem;
import com.interweb.model.Tabsis;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import org.primefaces.model.menu.*;

@ManagedBean(name = "TabUsuBean")
public class TabUsuBean {
    
    Tabusu tabusu = new Tabusu();
    MenuBar menuBar = new MenuBar();
    
    public static void main(String[] args) {
        Tabusu t = new Tabusu();
        t.setNome("INTER");
        t.setSenha("123");
        TabUsuBean b = new TabUsuBean();
        b.LogarUsuario(t);
    }
    
    
    //Método para fazer o Login do Usuário
    public String LogarUsuario(Tabusu tabusu) {
        
        String caminho = "";
        
        try {
            
            Query queryUsuario = JPAUtil.getEntityManager().createNamedQuery("Tabusu.buscaUsuario");
            
            queryUsuario.setParameter("nome", tabusu.getNome());
            
            queryUsuario.setParameter("senha", tabusu.getSenha());
            
            Tabusu resultTabUsu = (Tabusu) queryUsuario.getSingleResult();
            
            Query queryTabsis = JPAUtil.getEntityManager().createNamedQuery("Tabsis.buscaSistemaDoUsuario");
            
            queryTabsis.setParameter("codsis", resultTabUsu.getSistema());
            
            List<Tabsis> resultTabsis = queryTabsis.getResultList();
            
            for (Tabsis sistema : resultTabsis) {
                
                Query queryMenuitem = JPAUtil.getEntityManager().createNamedQuery("Menuitem.buscaMenuDoSistema");
                
                queryMenuitem.setParameter("codsis", sistema.getCodsis());
                
                List<Menuitem> resultMenuitem = queryMenuitem.getResultList();
                
                for (Menuitem menuitem : resultMenuitem) {
                    DefaultMenuItem item = new DefaultMenuItem(menuitem.getDescricao());
                    menuBar.getMenubar().addElement(item);
                }
                
                return caminho = "/views/paginaprincipal.xhtml?faces-redirect=true";
            }
            
            FacesContext.getCurrentInstance().addMessage("myform:frmlogin", new FacesMessage("Usuário Logado!"));
    
  
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error Login \n" + e.getLocalizedMessage());
        }
        
        FacesContext.getCurrentInstance().addMessage("myform:frmlogin", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválido!", "Tente novamente."));
        return null;
    }
    
}
