package com.interweb.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "util")
public class Utilitarios {
    
    public static void CriarMensagem(String txt1, String txt2){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, txt1, txt2);
        FacesContext.getCurrentInstance().addMessage(txt1, mensagem);
    }
    
    public static void CriarMensagemErro(String txt1, String txt2){
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, txt1, txt2);
        FacesContext.getCurrentInstance().addMessage(txt1, mensagem);
    }
    
    public static void RedirecionarPagina(String pagina){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("views/pagina_principal.xhtml?faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(Utilitarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
