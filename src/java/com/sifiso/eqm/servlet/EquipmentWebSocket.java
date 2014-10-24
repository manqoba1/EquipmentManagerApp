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
import com.sifiso.eqm.util.GZipUtility;
import com.sifiso.eqm.util.InventoryUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.IIOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author CodeTribe1
 */
@ServerEndpoint("/eqws")
public class EquipmentWebSocket {

    @EJB
    InventoryUtil inventoryUtil;
    @EJB
    DataUtil dataUtil;

    private static final Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    public void sendData(ResponseDTO resp, String sessionID) throws IIOException, Exception {
        for (Session session : peers) {
            if (sessionID.equals(session.getId())) {
                session.getBasicRemote().sendBinary(getZippedResponse(resp));
            }
        }
    }

    private ByteBuffer getZippedResponse(ResponseDTO resp) throws Exception {
        File file = GZipUtility.getZipped(gson.toJson(resp));
        byte[] bfile = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bfile);
        fileInputStream.close();

        ByteBuffer byteBuffer = ByteBuffer.wrap(bfile);
        return byteBuffer;
    }

    @OnOpen
    public void onOpen(Session session) {
        peers.add(session);
        try {
            ResponseDTO r = new ResponseDTO();
            r.setSessionID(session.getId());
            r.setMessage("Connection Openned");
            session.getBasicRemote().sendText(gson.toJson(r));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Openning Connection Failed", e);
        }
    }

    @OnClose
    public void onClose(Session session) {
        peers.remove(session);
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        ResponseDTO r = new ResponseDTO();
        try {
            RequestDTO req = gson.fromJson(message, RequestDTO.class);
            switch (req.getRequestType()) {
                case RequestDTO.ADD_EQUIPMENT_MANAGER:
                    r = inventoryUtil.addEquipment(req.getEquipmentDTO());
                    r.setSessionID(session.getId());
                    r.setMessage("Equipment Manager added");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Fail connection", e);
            r.setStatusCode(ResponseDTO.SERVER_ERROR);
            r.setMessage("database error");
        } finally {
            try {
                session.getBasicRemote().sendText(gson.toJson(r));
            } catch (IOException ex) {
                LOG.log(Level.SEVERE, null, ex);
                r.setStatusCode(ResponseDTO.SERVER_ERROR);
                r.setMessage("database error");
            }
        }
        return gson.toJson(r);
    }
    private Gson gson = new Gson();
    private static final Logger LOG = Logger.getLogger(EquipmentWebSocket.class.getSimpleName());

}
