
package com.interweb.model;

import javax.faces.bean.ManagedBean;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

@ManagedBean(name = "MenuBarBean")
public class MenuBar {
    
    private static MenuModel menubar = new DefaultMenuModel();

    public MenuModel getMenubar() {
        return menubar;
    }

    public void setMenubar(MenuModel menubar) {
        MenuBar.menubar = menubar;   
    }
    
}
