/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

/**
 *
 * @author Ntokozo
 */
public class EMUtil {

    private static final Logger LOG = Logger.getLogger("EMUtil");
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    private static void setEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("EquipmentManagerPU");
            LOG.log(Level.OFF, "Factory has just been created");
        }
        if (em == null) {
            em = emf.createEntityManager();
            LOG.log(Level.INFO, "TesterWebApp EntityManager created OK", emf.toString());
        } else {
            if (!em.isOpen()) {
                em = emf.createEntityManager();
            }
        }
    }
    
    public static EntityManager getEntityManager(){
        setEntityManager();
        em.setFlushMode(FlushModeType.AUTO);
        return em;
    }
}
