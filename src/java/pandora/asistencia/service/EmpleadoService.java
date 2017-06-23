/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.service;

import java.util.List;
import pandora.asistencia.entity.Empleado;

/**
 *
 * @author Ricardo
 */
public interface EmpleadoService {
    
    public Empleado validar(int nroDocumento, String password);
    public List<Empleado> findByNroDocumento(int nroDocumento);
    
}
