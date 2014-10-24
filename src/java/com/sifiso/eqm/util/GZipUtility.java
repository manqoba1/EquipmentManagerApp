/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

/**
 *
 * @author aubreymalabie
 */
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GZipUtility {

    private static final Logger logger = Logger.getLogger(GZipUtility.class.getName());

    public static String sendZippedFile(HttpServletRequest request, HttpServletResponse response,
            String data) throws Exception {
        ZipOutputStream out = null;
        String encodings = request.getHeader("Accept-Encoding");
        response.setHeader("Content-Encoding", "gzip, deflate");
        response.setContentType("application/zip");
        String gzipFileName = null;

        logger.log(Level.INFO, "### About to zip data length: {0}", data.length());
        try {

            File dir = EQProperties.getTemporaryZippedDir();

            Random rand = new Random(System.currentTimeMillis());
            gzipFileName = dir.getPath() + "/medwatch" + System.currentTimeMillis()
                    + rand.nextInt(99999999) + ".data.gz";

            out = new ZipOutputStream(new FileOutputStream(gzipFileName));
            File xmlFile = FileUtility.getFile(data);
            FileInputStream in = null;
            in = new FileInputStream(xmlFile);
            ZipEntry ze = new ZipEntry(xmlFile.getName());
            out.putNextEntry(ze);
            int c = -1;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            out.closeEntry();
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ZipOutputStream zipout = null;
            try {
                zipout = new ZipOutputStream(response.getOutputStream());
                zipout = out;
            } catch (IOException ex) {
                Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.finish();
                    out.close();
                    //zipout.finish();
                    //zipout.close();
                } catch (IOException ex) {
                    Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return gzipFileName;
    }

    public static File getZipped(String data) {
        String gzipFileName = null;
        File zip = null;
        try {
            File dir = EQProperties.getTemporaryDir();
            logger.log(Level.INFO, "###Zip directory: {0}", dir.getAbsolutePath());
            if (!dir.exists()) {
                dir.mkdir();
            }
            Random rand = new Random(System.currentTimeMillis());
            gzipFileName = "ar" + System.currentTimeMillis()
                    + "_" + rand.nextInt(99999999) + ".data.gz";
            zip = new File(dir, gzipFileName);
            logger.log(Level.INFO, "### new zip file to be filled: {0}", zip.getAbsolutePath());
            ZipOutputStream out = null;
            try {
                try {
                    out = new ZipOutputStream(new FileOutputStream(zip));
                } catch (IOException ex) {
                    Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE,
                            "Cannot create ZipOutputStream ", ex);
                }
            } catch (Exception ex) {
                Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE,
                        "Cannot create ZipOutputStream, unknown exception", ex);
            }
            // Create the input file to be compressed
            File file = FileUtility.getFile(data);
            FileInputStream in = null;
            try {
                in = new FileInputStream(file);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, "Where the fuck is the file?", ex);
            }
            ZipEntry ze = new ZipEntry(file.getName());
            try {
                out.putNextEntry(ze);
                int c = -1;
                while ((c = in.read()) != -1) {
                    out.write(c);
                }

                out.closeEntry();
                in.close();
            } catch (IOException e) {
                Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, "ZipEntry shit bugging out!", e);
            }

            out.close();
        } catch (Exception e) {
            Logger.getLogger(GZipUtility.class.getName()).log(Level.SEVERE, "Zipper failed, horse bolted!", e);
        }

        //logger.log(Level.INFO, "#### File has been zipped: {0}", zip.getAbsolutePath());
        //logger.log(Level.INFO, "#### Data length: {0} zipped file length: {1}", new Object[]{data.length(), zip.length()});
        return zip;

    }
    private static final int BUFFER = 1024;

    public static void unzip(File zippedFile) {
        File dir = zippedFile.getParentFile();
        try {
            BufferedOutputStream dest = null;
            FileInputStream fis = new FileInputStream(zippedFile);
            ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                int count;
                byte data[] = new byte[BUFFER];
                // write the files to the disk
                File imgFile = new File(dir, entry.getName());
                FileOutputStream fos = new FileOutputStream(imgFile);
                dest = new BufferedOutputStream(fos, BUFFER);
                while ((count = zis.read(data, 0, BUFFER)) != -1) {
                    dest.write(data, 0, count);
                }
                dest.flush();
                dest.close();
                logger.log(Level.INFO, "\n### File de-compressed: {0}", imgFile.getAbsolutePath());
            }
            zis.close();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unable to de-compress zipped file", e);
        }

    }
}
