/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.service;

import pandora.asistencia.entity.Control;

/**
 *
 * @author Ricardo
 */

public interface ControlService {
    
    public void persistControl(Control control, int nroDocumento);
    
}
