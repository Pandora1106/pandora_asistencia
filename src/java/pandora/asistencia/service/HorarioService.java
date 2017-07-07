/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.service;

import pandora.asistencia.entity.Horario;

/**
 *
 * @author Ricardo
 */
public interface HorarioService {
    
    public void persistHorario(Horario horario, int nroDocumento);
    public void updateByMerge(int nroDocumento);
    public Horario getIngreso(int nroDocumento);
    public Horario getSalida(int nroDocumento);
    public Horario validarIngreso(int nroDocumento);
    public Horario validarSalida(int nroDocumento);
    
}
