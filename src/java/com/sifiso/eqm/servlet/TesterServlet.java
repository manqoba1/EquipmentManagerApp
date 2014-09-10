/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.servlet;

import com.google.gson.Gson;
import com.sfiso.eqm.dto.RequestDTO;
import com.sfiso.eqm.dto.ResponseDTO;

import com.sifiso.eqm.util.DataUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CodeTribe1
 */
@WebServlet(name = "TesterServlet", urlPatterns = {"/eq"})
public class TesterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. name
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        long start = System.currentTimeMillis();
        ResponseDTO resp = new ResponseDTO();
        Gson gson = new Gson();
        RequestDTO dto = getRequest(request);
        if (dto == null) {
            PrintWriter out = response.getWriter();
            resp.setStatusCode(ResponseDTO.UNKNOWN_REQUEST);
            resp.setMessage("Bad request, ignored");
            out.println(gson.toJson(resp));
            out.close();
            return;
        }

        try {
            resp.setStatusCode(ResponseDTO.OK);
            switch (dto.getRequestType()) {
                case RequestDTO.GET_EQUIPMENT:
                    resp = DataUtil.getAllEquipments();
                    resp.setMessage("Equipments Retriveed");
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            LOG.log(Level.OFF, "Am F***d", ex);
            resp.setStatusCode(ResponseDTO.SERVER_ERROR);
            resp.setMessage("database error");
        } finally {
            String json = gson.toJson(resp);
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            //out.println(dto.getRequestType()+"");
            out.println(json);
            out.close();

            long end = System.currentTimeMillis();
            LOG.log(Level.OFF, "TesterServletApp completed, elapsed seconds: {0}", getElapsed(start, end));
        }

    }

    private double getElapsed(long start, long end) {
        BigDecimal d = new BigDecimal(end - start).divide(new BigDecimal(1000));
        return d.doubleValue();
    }

    private RequestDTO getRequest(HttpServletRequest req) {
        Gson gson = new Gson();
        RequestDTO dto = null;
        try {
            dto = gson.fromJson(req.getParameter("JSON"), RequestDTO.class);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "JSON input error", ex);
        }

        return dto;
    }
    private static final Logger LOG = Logger.getLogger(TesterServlet.class.getSimpleName());

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
