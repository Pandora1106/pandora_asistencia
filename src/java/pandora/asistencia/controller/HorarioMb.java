/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import pandora.asistencia.dao.HorarioDao;
import pandora.asistencia.entity.Horario;

/**
 *
 * @author Ricardo
 */

@ManagedBean
@RequestScoped

public class HorarioMb implements Serializable {

    private int nroDocumento;
    private Horario horario;
    private HorarioDao dao;
    private List<Horario> listaHorario;

    public HorarioMb() {
        horario = new Horario();
        listaHorario = new ArrayList();
        dao = new HorarioDao(Horario.class);
    }

    public void grabar() {
        horario.setPeriodo(new SimpleDateFormat("MM-yyyy").format(Calendar.getInstance().getTime()));
        dao.persistHorario(horario, nroDocumento);
    }

    public void eliminar() {
        dao.remove(horario);
    }

    public void actualizar() throws SQLException {
        HorarioDao.updateJDBC(nroDocumento);
    }

    //uncompleted
    public String validarIngreso(int idUsuario) {
        Horario horario = dao.validarIngreso(idUsuario);
        System.out.println(horario);
        if (horario != null) {
            return "ingresoRegistrado?faces-redirect=true";
        } else {
            return "marcarIngreso?faces-redirect=true";
        }
    }

    //uncompleted
    public String validarSalida(int idUsuario) {
        Horario asistencia = dao.validarIngreso(idUsuario);
        System.out.println(asistencia);
        if (asistencia != null) {
            return "salidaRegistrado?faces-redirect=true";
        } else {
            return "marcarSalida?faces-redirect=true";
        }
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario asistencia) {
        this.horario = asistencia;
    }

    public List<Horario> getListaHorario() {
        return listaHorario;
    }

    public void setListaHorario(List<Horario> listaHorario) {
        this.listaHorario = listaHorario;
    }

    //useless by now
    public Date getRealTime() throws UnknownHostException, IOException {        
        try {
            String TIME_SERVER = "time.nist.gov";
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
            TimeInfo timeInfo = timeClient.getTime(inetAddress);
            long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
            Date time = new Date(returnTime);
            return time;
        } catch (Exception e) {
            
        }
        return null;
    }
    
}