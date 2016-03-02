package org.buap.hospitalpuebla.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import lombok.Data;
import org.buap.hospitalpuebla.dao.ICitaDAO;
import org.buap.hospitalpuebla.model.Cita;
import org.buap.hospitalpuebla.service.ICitaService;

@Data
@ManagedBean
@SessionScoped
public class CitaController implements Serializable {

    @EJB
    private ICitaService citaService;

    private Cita cita;
    private String especialidad;
    private List<SelectItem> doctores;
    private List<Cita> citas;

    @PostConstruct
    public void init() {
        cita = new Cita();
        citas = citaService.findAll();

        SelectItemGroup cardeologia = new SelectItemGroup("Cardiologia");
        cardeologia.setSelectItems(new SelectItem[]{new SelectItem("Dr Gonzalez", "Dr. Gonzalez"), new SelectItem("Dr. Castillo", "Dr. Castillo")});

        SelectItemGroup odontologia = new SelectItemGroup("Odontologia");
        odontologia.setSelectItems(new SelectItem[]{new SelectItem("Dr. Mendoza", "Dr. Mendoza"), new SelectItem("Dr. Salzar", "Dr. Salazar")});

        doctores = new ArrayList<SelectItem>();
        doctores.add(cardeologia);
        doctores.add(odontologia);

    }

    public void registrar() {
        try {
            citaService.create(cita);
            cita = new Cita();
            citas = citaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Cita cita) {
        try {
            citaService.remove(cita);
            cita = new Cita();
            citas = citaService.findAll();
        } catch (Exception e) {
        }
    }

    public void leerID(Cita cita) {
        Cita citaTemp;
        try {
            citaTemp = citaService.find(cita);
        } catch (Exception e) {
        }

    }

}
