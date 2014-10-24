/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aubrey Malabie
 */
public class EQProperties {

    public static File getARDir() throws Exception {
        getProperties();
        File d = new File(props.getProperty("EquipmentManager"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getTemporaryDir() throws Exception {
        getProperties();
        File d = new File(props.getProperty("tempDir"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getTemporaryZippedDir() throws Exception {
        getProperties();
        File d = new File(props.getProperty("zipped"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    public static File getChartsDir() throws Exception {
        getProperties();
        File d = new File(props.getProperty("charts"));
        if (!d.exists()) {
            d.mkdir();
        }
        return d;
    }

    private static void getProperties() throws Exception {
        //logger.log(Level.INFO, "#### AR Getting Properties ... setting up props map");
        if (props != null) {
            return;
        }
        props = new Properties();
        try {
            File f = null;
            logger.log(Level.INFO, "LOCATING PROPERTIES FILE...");
             f = new File("C:/Users/CodeTribe1/Documents/NetBeansProjects/equipmentproperty.properties");
             logger.log(Level.INFO, "#### Properties file under workspace: {0}", f.getAbsolutePath());
             if (!f.exists()) {
                f = new File("C:/Users/CodeTribe1/Documents/NetBeansProjects/equipmentproperty.properties");
                logger.log(Level.INFO, "#### Properties file if the one under wordspace does'nt exist: {0}", f.getAbsolutePath());
             }
            //File 
            logger.log(Level.INFO, "#### AR Properties filepath: {0}", f.getAbsolutePath());
            if (f.exists()) {
                props.load(new FileInputStream(f));
            } else {
               logger.log(Level.SEVERE, "Properties file ar.properties not found - path: {0}", f.getAbsolutePath()); 
               throw new Exception("Unable to find AftaRobot properties file");
            }

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Properties file ar.properties not found or corrupted", e);
            throw new Exception("Unable to access AftaRobot properties file, got ioexception");
        }

    }
    private static final Logger logger = Logger.getLogger(EQProperties.class.getName());
    private static Properties props;
}
