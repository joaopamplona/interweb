
package com.interage.menagedbean;


import com.interage.bean.Tabusu;
import conexao.Conectar;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.*;

@ManagedBean(name = "TabUsuBean")
public class TabUsuBean {
    
    Tabusu tabusu = new Tabusu();
    MenuBarBean menuBean = new MenuBarBean();
    
    public TabUsuBean(){
        Conectar.ConectarBD();
    }

    public Tabusu getTabusu() {
        return tabusu;
    }

    public void setTabusu(Tabusu tabusu) {
        this.tabusu = tabusu;
    }
    
    
    //Método para fazer o Login do Usuário
    public String LogarUsuario(Tabusu tabusu) {
        
        String caminho = "";
        
        try {
            
            Conectar.result = Conectar.stam.executeQuery("select * from TABUSU where ((RGEVENTO <> '3') or (RGEVENTO IS NULL)) "
                    + "and (NOME = '" + tabusu.getNome() + "') order by SISTEMA");
            
            while (Conectar.result.next()) {
                
                //Resultset temporario
                ResultSet rs = null;
                /*
                Select nome do sistema
                */
                Conectar.stam = Conectar.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
                rs = Conectar.stam.executeQuery("SELECT * FROM TABSIS WHERE CODSIS = "+ Conectar.result.getString("SISTEMA") +" ");
                 
                while(rs.next()){
                    
                    ResultSet rs2 = null;
                    
                    Conectar.stam = Conectar.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
                    rs2 = Conectar.stam.executeQuery("SELECT * FROM MENUITEM WHERE CODSIS = "+rs.getString("CODSIS")+" ");
                    
                    while(rs2.next()){
                        
                        String label = rs2.getString("DESCRICAO");
                        
                        DefaultMenuItem item = new DefaultMenuItem(label);
                        menuBean.menubar.addElement(item);
                    }
                    
                }
                
            }    
            
            
   
                /*
                tabusu.setCodigo(Conectar.result.getInt("CODIGO"));          //Pega o codigo do usuário
                tabusu.setNome(Conectar.result.getString("NOME"));        //Pega o nome do usuario     
                tabusu.setSenha(Conectar.result.getString("SENHA"));      //Pega a senha do usuario 

                System.out.println("Código do Usuário: " + tabusu.getCodigo());
                System.out.println("Usuário: " + tabusu.getNome());
                System.out.println("Senha: " + tabusu.getSenha());
                
                System.out.println("Usuário Logado");
                
                */
                //System.out.println("Menu:" + menu);
                FacesContext.getCurrentInstance().addMessage("myform:frmlogin", new FacesMessage("Usuário Logado!"));
                caminho = "/views/paginaprincipal.xhtml?faces-redirect=true";
  
        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error Login \n" + e.getLocalizedMessage());
        }
        
        return caminho;
    }
    
}
