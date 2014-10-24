/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sifiso.eqm.util;

import com.sfiso.eqm.dto.ConsultantorganisationDTO;
import com.sfiso.eqm.dto.EquipmentDTO;
import com.sfiso.eqm.dto.EquipmentmanagerDTO;
import com.sfiso.eqm.dto.EqupmanageDTO;
import com.sfiso.eqm.dto.InventoryDTO;
import com.sfiso.eqm.dto.OrganisationDTO;
import com.sfiso.eqm.dto.ResponseDTO;
import com.sfiso.eqm.dto.UserDTO;
import com.sfiso.eqm.dto.UserinventoryDTO;
import com.sifiso.eqm.data.Consultant;
import com.sifiso.eqm.data.Consultantorganisation;
import com.sifiso.eqm.data.Equipment;
import com.sifiso.eqm.data.Equipmentmanager;
import com.sifiso.eqm.data.Equpmanage;
import com.sifiso.eqm.data.Inventory;
import com.sifiso.eqm.data.Organisation;
import com.sifiso.eqm.data.User;
import com.sifiso.eqm.data.Userinventory;
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
public class DataUtil {

    private static final Logger LOG = Logger.getLogger(DataUtil.class.getSimpleName());
    @PersistenceContext
    private static EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public static ResponseDTO assignDeviceToUser(UserinventoryDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {

            Userinventory ui = new Userinventory();
            ui.setIssuedDate(new Date(dto.getIssuedDate()));
            ui.setReturnedDate(new Date(dto.getReturnedDate()));
            ui.setInventory(getInventory(dto.getInventoryID()));
            ui.setUser(getUser(dto.getUserID()));

            em.persist(ui);
            resp.setMessage("User Assigned");
            resp.setStatusCode(0);
            resp.setUserinventoryDTO(new UserinventoryDTO(ui));

        } catch (ConstraintViolationException e) {
            LOG.log(Level.SEVERE, "Assigning User a Device Failed", e);
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException e) {
            LOG.log(Level.SEVERE, "Assigning User a Device Failed", e);
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Assigning User a Device Failed", e);
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO addEquipment(EquipmentDTO dto) throws DataException {
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

    public static ResponseDTO addInventory(InventoryDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {

            Inventory e = new Inventory();
            e.setInventoryName(dto.getInventoryName());
            e.setInventoryModel(dto.getInventoryModel());
            e.setInventorySerialNo(dto.getInventorySerialNo());
            e.setEquipment(getEquipment(dto.getEquipmentID()));
            e.setInventoryImage(dto.getInventoryImage());

            em.persist(e);
            resp.setMessage("Inventory added");
            resp.setStatusCode(0);
            resp.setInventoryDTO(new InventoryDTO(e));
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO addUser(UserDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {
            User e = new User();
            e.setUserName(dto.getUserName());
            e.setUserSurname(dto.getUserSurname());
            e.setUserEmaill(dto.getUserEmaill());
            e.setUserTel(dto.getUserTel());
            e.setUserStatus(1);
            e.setUserImage(dto.getUserImage());
            e.setOrganisation(getOrganisation(dto.getOrganisationID()));

            em.persist(e);
            resp.setMessage("User added");
            resp.setStatusCode(0);
            resp.setUserDTO(new UserDTO(e));
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO addOrganisation(OrganisationDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {
            Organisation e = new Organisation();
            e.setOrganisationName(dto.getOrganisationName());
            e.setOrganisationAddress(dto.getOrganisationAddress());
            e.setContactname(dto.getContactname());
            e.setLatitude(dto.getLatitude());
            e.setLongitude(dto.getLongitude());

            em.persist(e);
            resp.setMessage("Organisation added");
            resp.setStatusCode(0);
            resp.setOrganisationDTO(new OrganisationDTO(e));
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO addEquipmentManager(EquipmentmanagerDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {
            Equipmentmanager e = new Equipmentmanager();
            e.setEquipmentManagerName(dto.getOrganisationName());
            e.setEquipmentManagerSurname(dto.getEquipmentManagerSurname());
            e.setEquipmentManagerTel(dto.getEquipmentManagerTel());
            e.setEquipmentManagerAddress(dto.getEquipmentManagerAddress());
            e.setEquipmentManagerEmail(dto.getEquipmentManagerEmail());
            e.setManagerImage(dto.getManagerImage());
            e.setPassword(dto.getPassword());
            e.setOrganisation(getOrganisation(dto.getOrganisationID()));

            em.persist(e);
            resp.setMessage("Equipment Manager added");
            resp.setStatusCode(0);
            resp.setEquipmentmanagerDTO(new EquipmentmanagerDTO(e));
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO assignManagerToEquipment(EqupmanageDTO dto) throws DataException {

        ResponseDTO resp = new ResponseDTO();
        try {
            Equpmanage e = new Equpmanage();
            e.setEquipment(getEquipment(dto.getEquipmentID()));
            e.setAssignedDate(new Date(dto.getAssignedDate()));
            e.setEquipmentmanager(getEquipmentmanager(dto.getEquipmentmanagerID()));

            em.persist(e);
            resp.setMessage("Equipment assigned to manager");
            resp.setStatusCode(0);
            resp.setEqupmanageDTO(new EqupmanageDTO(e));
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    private static List<UserinventoryDTO> getUserInventoryDTOs() throws DataException {
        List<UserinventoryDTO> userinventoryDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Userinventory.findAll");
            List<Userinventory> in = q.getResultList();
            for (Userinventory i : in) {
                userinventoryDTOs.add(new UserinventoryDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return userinventoryDTOs;
    }

    private static List<ConsultantorganisationDTO> getConsultantorganisationDTOs() throws DataException {
        List<ConsultantorganisationDTO> consultantorganisationDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Consultantorganisation.findAll");
            List<Consultantorganisation> in = q.getResultList();
            for (Consultantorganisation i : in) {
                consultantorganisationDTOs.add(new ConsultantorganisationDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return consultantorganisationDTOs;
    }

    private static List<UserDTO> getUserDTOs() throws DataException {
        List<UserDTO> userDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("User.findAll");
            List<User> in = q.getResultList();
            for (User i : in) {
                userDTOs.add(new UserDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return userDTOs;
    }

    public static ResponseDTO getInventoryDTOs() throws DataException {
        ResponseDTO resp = new ResponseDTO();
        List<InventoryDTO> inventoryDTOs = getInventory();
        resp.setInventoryDTOs(inventoryDTOs);
        resp.setMessage("Inventory Found");
        return resp;
    }

    //private List<Equipment> getEquipments()
    public static ResponseDTO getUsersByOrganisationID(int organisationID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        try {
            Query q = em.createNamedQuery("User.findUsersByOrganisationID");
            q.setParameter("organisationID", organisationID);
            List<User> in = q.getResultList();
            List<UserDTO> userDTOs = new ArrayList<>();
            List<UserinventoryDTO> userinventoryDTOs = getUserInventoryDTOs();
            UserDTO userDTO;
            for (User u : in) {
                userDTO = new UserDTO(u);
                for (int i = 0; i < userinventoryDTOs.size(); ++i) {
                    if (u.getUserID() == userinventoryDTOs.get(i).getUserID()) {
                        userDTO.getUserinventoryList().add(userinventoryDTOs.get(i));
                    }
                }
                userDTOs.add(userDTO);
            }
            resp.setUserDTOs(userDTOs);

        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    public static ResponseDTO authenticateManager(String email, String password) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        em = EMUtil.getEntityManager();
        try {
            Query q = em.createNamedQuery("Equpmanage.findByPasswordAndEmail");
            q.setParameter("email", email);
            q.setParameter("password", password);
            Equipmentmanager as = (Equipmentmanager) q.getSingleResult();
            List<EqupmanageDTO> equpmanageDTOs = getEqupmanageDTOs();

            EquipmentmanagerDTO edto = new EquipmentmanagerDTO(as);
            edto.setEqupmanageList(new ArrayList<>());
            for (int i = 0; i < equpmanageDTOs.size(); i++) {
                if (edto.getEquipmentManagerID() == equpmanageDTOs.get(i).getEquipmentmanagerID()) {

                    edto.getEqupmanageList().add(equpmanageDTOs.get(i));
                }
            }
           // OrganisationDTO dTO = new OrganisationDTO(as.getOrganisation());

            resp.setEquipmentmanagerDTO(edto);
          //  resp.setOrganisationDTO(dTO);
            resp.setMessage("");
            resp.setStatusCode(ResponseDTO.OK);

            LOG.log(Level.INFO, "### Authentication data found: {0}");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Data error", e);
            throw new DataException(DataException.UNKNOWN_ERROR);
        }

        return resp;
    }

    public static ResponseDTO getEquipmentsByID(int equipmentID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        em = EMUtil.getEntityManager();
        try {
            Query q = em.createNamedQuery("Equipment.findByEquipmentID");
            q.setParameter("equipmentID", equipmentID);
            List<Equipment> eq = q.getResultList();
            List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
            List<InventoryDTO> inventoryDTOs = getInventory();
            EquipmentDTO equipmentDTO;

            for (Equipment e : eq) {
                equipmentDTO = new EquipmentDTO(e);
                equipmentDTO.setInventoryList(new ArrayList<>());
                for (int i = 0; i < inventoryDTOs.size(); ++i) {
                    if (e.getEquipmentID() == inventoryDTOs.get(i).getEquipmentID()) {
                        equipmentDTO.getInventoryList().add(inventoryDTOs.get(i));
                    }
                }
                equipmentDTOs.add(equipmentDTO);
            }
            resp.setEquipmentDTOs(equipmentDTOs);

        } catch (ConstraintViolationException e) {
            LOG.log(Level.SEVERE, "Data error", e);
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException e) {
            LOG.log(Level.SEVERE, "Data error", e);
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Data error", e);
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    private static List<InventoryDTO> getInventory() throws DataException {
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

    private static List<EquipmentDTO> getEquipmentDTOs() throws DataException {
        List<EquipmentDTO> equipmentDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Equipment.findAll");
            List<Equipment> in = q.getResultList();
            for (Equipment i : in) {
                equipmentDTOs.add(new EquipmentDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return equipmentDTOs;
    }

    private static List<EqupmanageDTO> getEqupmanageDTOs() throws DataException {
        List<EqupmanageDTO> equpmanageDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Equpmanage.findAll");
            List<Equpmanage> in = q.getResultList();
            for (Equpmanage i : in) {
                equpmanageDTOs.add(new EqupmanageDTO(i));
            }
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return equpmanageDTOs;
    }

    public static ResponseDTO getInventoryByUserID(int userID) throws DataException {
        ResponseDTO resp = new ResponseDTO();
        List<InventoryDTO> inventoryDTOs = new ArrayList<>();
        try {
            Query q = em.createNamedQuery("Inventory.findInventoryByUserID");
            q.setParameter("userID", userID);
            List<Inventory> in = q.getResultList();
            for (Inventory i : in) {
                inventoryDTOs.add(new InventoryDTO(i));
            }
            resp.setInventoryDTOs(inventoryDTOs);
        } catch (ConstraintViolationException ex) {
            throw new DataException(DataException.DUPLICATE);
        } catch (IllegalStateException ex) {
            throw new DataException(DataException.ILLEGAL_STATE);
        } catch (Exception ex) {
            throw new DataException(DataException.UNKNOWN_ERROR);
        }
        return resp;
    }

    //Entity helper methods
    public static Consultant getConsultant(int consultantID) {

        Consultant c = em.find(Consultant.class, consultantID);
        return c;
    }

    public static Consultantorganisation getConsultantorganisation(int consultantorganisationID) {

        Consultantorganisation c = em.find(Consultantorganisation.class, consultantorganisationID);
        return c;
    }

    public static Equipment getEquipment(int equipmentID) {

        Equipment e = em.find(Equipment.class, equipmentID);
        return e;
    }

    public static Equipmentmanager getEquipmentmanager(int equipmentManagerID) {

        Equipmentmanager c = em.find(Equipmentmanager.class, equipmentManagerID);
        return c;
    }

    public static Inventory getInventory(int inventoryID) {
        Inventory c = em.find(Inventory.class, inventoryID);
        return c;
    }

    public static Organisation getOrganisation(int organisationID) {

        Organisation c = em.find(Organisation.class, organisationID);
        return c;
    }

    public static User getUser(int userID) {

        User c = em.find(User.class, userID);
        return c;
    }

    public static Userinventory getUserinventory(int userInventoryID) {

        Userinventory c = em.find(Userinventory.class, userInventoryID);
        return c;
    }
}
