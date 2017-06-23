/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.dao;

import pandora.asistencia.entity.Parametro;
import pandora.asistencia.service.EntityCrud;

/**
 *
 * @author Ricardo
 */
public class ParametroDao extends EntityCrud<Parametro>{
    
    public ParametroDao(Class<Parametro> obj) {
        super(obj);
    }
    
}
