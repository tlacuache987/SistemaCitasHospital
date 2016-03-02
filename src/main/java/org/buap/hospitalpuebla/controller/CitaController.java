package org.buap.hospitalpuebla.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    private ICitaService citaEJB;
    
    private Cita cita;

    private String especialidad;
    private List<SelectItem> doctores;
    private List<Cita> citas;

    @PostConstruct
    public void init() {
        cita = new Cita();
        citas = citaEJB.findAll();

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
            citaEJB.create(cita);
            cita = new Cita();
            citas = citaEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Cita cita) {
        try {
            citaEJB.remove(cita);
            cita = new Cita();
            citas = citaEJB.findAll();
        } catch (Exception e) {

        }
    }

    public void leerID(Cita cita) {
        Cita citaTemp;
        try {
            citaTemp = citaEJB.find(cita);
        } catch (Exception ex) {

        }

    }

    /*public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public ICitaDAO getCitaEJB() {
        return (ICitaDAO) citaEJB;
    }

    public void setCitaEJB(ICitaDAO citaEJB) {
        this.citaEJB = (ICitaService) citaEJB;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<SelectItem> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<SelectItem> doctores) {
        this.doctores = doctores;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }*/

}
