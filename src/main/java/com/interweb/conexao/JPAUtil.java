
package com.interweb.conexao;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    public static EntityManager getEntityManager() {
        if(em == null){
           
           emf = Persistence.createEntityManagerFactory("FIREBIRD", PropsFirebird());
           em = emf.createEntityManager();
        }
        
        return em;
    }
    
    public static Map PropsFirebird(){
        Map props = new HashMap();
        
        props.put("javax.persistence.jdbc.driver", "org.firebirdsql.jdbc.FBDriver");
        props.put("javax.persistence.jdbc.url", "jdbc:firebirdsql:localhost/3050:C:/InterageSE/Dados/INTEGRADO.GDB");
        props.put("javax.persistence.jdbc.user", "SYSDBA");
        props.put("javax.persistence.jdbc.password", "masterkey");
        props.put("eclipselink.logging.level.sql", "FINE");
        props.put("eclipselink.logging.parameters", "true");
   
        return props;
    }
    
    public static void persistir(Object objeto){
        
        EntityTransaction transacao = em.getTransaction();
        
        transacao.begin();
        
        em.persist(objeto);
        
        transacao.commit();
    }
    
}
