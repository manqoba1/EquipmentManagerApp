/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

/**
 *
 * @author Ntokozo
 */
public class DataException extends Exception {

    public static final int DUPLICATE = 1;
    public static final int ILLEGAL_STATE = 2;
    public static final int UNKNOWN_ERROR = 3;
    int code;

    public DataException(int code) {
        this.code = code;
    }
}
