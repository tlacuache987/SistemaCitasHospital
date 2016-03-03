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
import org.apache.log4j.Logger;

@Data
@ManagedBean
@SessionScoped
public class CitaController implements Serializable {

    private static final Logger LOG = Logger.getLogger(CitaController.class);

    // TODO 3 Inyectar cita service
    @EJB
    private ICitaService citaService;

    private Cita cita;
    private String especialidad;
    private List<SelectItem> doctores;
    private List<Cita> citas;

    @PostConstruct
    public void init() {
        org.apache.log4j.BasicConfigurator.configure();

        LOG.info("::::: Iniciando aplicacion");

        this.cita = new Cita();

        // TODO 4 obtener todas las citas
        this.citas = citaService.findAll();

        final SelectItemGroup cardeologia = new SelectItemGroup("Cardiologia");
        cardeologia.setSelectItems(new SelectItem[]{new SelectItem("Dr Gonzalez", "Dr. Gonzalez"), new SelectItem("Dr. Castillo", "Dr. Castillo")});

        final SelectItemGroup odontologia = new SelectItemGroup("Odontologia");
        odontologia.setSelectItems(new SelectItem[]{new SelectItem("Dr. Mendoza", "Dr. Mendoza"), new SelectItem("Dr. Salzar", "Dr. Salazar")});

        this.doctores = new ArrayList<>();
        this.doctores.add(cardeologia);
        this.doctores.add(odontologia);

    }

    public void registrar() {
        try {
            LOG.info(":::: Registrando cita ");

            // TODO 5 crear una nueva cita
            this.citaService.create(cita);

            LOG.info(":::: Cita registrada exitosamente: " + cita);

            this.cita = new Cita();

            // TODO 6 obtener todas las citas
            this.citas = citaService.findAll();

        } catch (Exception e) {
            LOG.error(":::: Fallo al registrar");
            LOG.error(e.getStackTrace());
        }
    }

    public void eliminar(Cita cita) {
        try {
            LOG.info(":::: Eliminando cita");

            // TODO 7 remover la cita seleccionada
            this.citaService.remove(cita);

            LOG.info("cita eliminada exitosamente: " + cita);

            this.cita = new Cita();

            // TODO 8 obtener todas las citas
            this.citas = citaService.findAll();

        } catch (Exception e) {
            LOG.error("Fallo al eliminar");
            LOG.error(e.getStackTrace());
        }
    }

    public void leerID(Cita cita) {
        try {
            LOG.info(":::: Buscando cita");

            //Cita citaTemp;
            
            // TODO 9 buscar cita
            this.cita = citaService.find(cita);
            if (this.cita != null) {
                LOG.info("Se encontro cita: " + this.cita);

                //this.cita = citaTemp;
            }
        } catch (Exception e) {
            LOG.error(":::: Fallo al buscar cita");
            LOG.error(e.getStackTrace());
        }
    }

    public void modificar() {
        try {
            LOG.info("::: Modificado cita");
            
            // TODO 10 editar cita
            citaService.edit(cita);
            
            LOG.info("::: Modificada exitosamente");
            
            // TODO 11 obtener todas las citas
            citas = citaService.findAll();

        } catch (Exception e) {
            LOG.error(":::: Fallo al modificar :::");
            LOG.error(e.getStackTrace());
        }
    }

}
