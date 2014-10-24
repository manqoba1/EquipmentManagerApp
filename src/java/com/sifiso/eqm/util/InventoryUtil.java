/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

import com.sfiso.eqm.dto.EquipmentDTO;
import com.sfiso.eqm.dto.InventoryDTO;
import com.sfiso.eqm.dto.ResponseDTO;
import com.sfiso.eqm.dto.UserinventoryDTO;
import com.sifiso.eqm.data.Equipment;
import com.sifiso.eqm.data.Inventory;
import com.sifiso.eqm.data.Userinventory;
import static com.sifiso.eqm.util.DataUtil.getOrganisation;
import static com.sifiso.eqm.util.DataUtil.getUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author CodeTribe1
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InventoryUtil {

    private static final Logger LOG = Logger.getLogger(DataUtil.class.getSimpleName());
    @PersistenceContext
    EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public ResponseDTO addEquipment(EquipmentDTO dto) throws DataException {
        ResponseDTO resp = new ResponseDTO();

        Equipment e = new Equipment();
        e.setEquipmentName(dto.getEquipmentName());
        e.setEquipmentImage(dto.getEquipmentImage());
        e.setOrganisation(getOrganisation(dto.getOrganisationID()));
        try {
            em.persist(e);
            resp.setEquipmentDTOs(new ArrayList<EquipmentDTO>());
            resp.getEquipmentDTOs().add(new EquipmentDTO(e));
            resp.setMessage("Equipment added");

        } catch (ConstraintViolationException ex) {
            LOG.log(Level.SEVERE, "Fail to add equipment", ex);
            throw new DataException(DataException.DUPLICATE);

        } catch (IllegalStateException ex) {
            LOG.log(Level.SEVERE, "Fail to add equipment", ex);
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Fail to add equipment", ex);
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO updateAssignDeviceToUser(UserinventoryDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {
            Userinventory ui = DataUtil.getUserinventory(dto.getInventoryID());

            ui.setReturnedDate(new Date(dto.getReturnedDate()));
            ui.setReturn1(dto.getUserStatus());

            em.merge(ui);
            resp.setUserinventoryDTO(new UserinventoryDTO(ui));
            resp.setMessage("User Inventory Updated");
            resp.setStatusCode(0);
        } catch (ConstraintViolationException e) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException e) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception e) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public ResponseDTO getAllEquipments() throws DataException {

        ResponseDTO resp = new ResponseDTO();

        try {
            Query q = em.createNamedQuery("Equipment.findAll");
            List<Equipment> eq = q.getResultList();
            List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
            List<InventoryDTO> inventoryDTOs = getInventory();
            EquipmentDTO equipmentDTO;
            for (Equipment e : eq) {
                equipmentDTO = new EquipmentDTO(e);
                for (int i = 0; i < inventoryDTOs.size(); ++i) {
                    if (e.getEquipmentID() == inventoryDTOs.get(i).getEquipmentID()) {
                        equipmentDTO.getInventoryList().add(inventoryDTOs.get(i));
                    }
                }
                equipmentDTOs.add(equipmentDTO);
            }
            resp.setEquipmentDTOs(equipmentDTOs);

        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    private List<InventoryDTO> getInventory() throws DataException {

        List<InventoryDTO> inventoryDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Inventory.findAll");
            List<Inventory> in = q.getResultList();
            for (Inventory i : in) {
                inventoryDTOs.add(new InventoryDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return inventoryDTOs;
    }

    public ResponseDTO getInventoryDTOs() throws DataException {
        ResponseDTO resp = new ResponseDTO();
        List<InventoryDTO> inventoryDTOs = getInventory();
        resp.setInventoryDTOs(inventoryDTOs);
        resp.setMessage("Inventory Found");
        return resp;
    }

    
}
