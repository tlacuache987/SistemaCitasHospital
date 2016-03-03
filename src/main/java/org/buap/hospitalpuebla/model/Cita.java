package org.buap.hospitalpuebla.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "CITA")
public class Cita implements Serializable {

    @Id
    @Column(name = "ID_CITA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;
    
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDOPATERNO")
    private String apellidoPaterno;

    @Column(name = "APELLIDOMATERNO")
    private String apellidoMaterno;

    @Column(name = "SEXO")
    private String sexo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_CITA")
    private Date fechaCita;

    @Column(name = "DOCTOR")
    private String doctor;

    @Column(name = "EMAIL")
    private String email;
    
    
    

}
