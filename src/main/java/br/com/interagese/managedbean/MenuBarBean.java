
package br.com.interagese.managedbean;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "MenuBarBean")
public class MenuBarBean {
    
    static MenuModel menubar = new DefaultMenuModel();
    

    public MenuModel getMenubar() {
        return menubar;
    }

    public static void setMenubar(MenuModel menubar) {
        MenuBarBean.menubar = menubar;
        
    }
    
    
    
}
