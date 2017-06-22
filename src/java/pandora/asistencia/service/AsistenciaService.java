/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.service;

import pandora.asistencia.entity.Asistencia;

/**
 *
 * @author Ricardo
 */
public interface AsistenciaService {
    
    public void persistAsistencia(Asistencia asistencia, int nroDocumento);
    public void updateByMerge(int nroDocumento);
    public Asistencia getIngreso(int nroDocumento);
    public Asistencia getSalida(int nroDocumento);
    public Asistencia validarIngreso(int nroDocumento);
    public Asistencia validarSalida(int nroDocumento);
    
}
