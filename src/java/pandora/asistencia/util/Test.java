/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandora.asistencia.util;
//import java.net.UnknownHostException;
//import java.text.SimpleDateFormat;

import java.sql.SQLException;
import pandora.asistencia.dao.ControlDao;
import pandora.asistencia.entity.Control;
import pandora.asistencia.entity.Horario;

//import java.util.Calendar;
//import java.util.Date;
//import org.apache.commons.net.ntp.NTPUDPClient;
//import org.apache.commons.net.ntp.TimeInfo;

/**
 *
 * @author Ricardo
 */
public class Test {

    public static void main(String[] args) throws SQLException {
//        String TIME_SERVER = "time.nist.gov";
//        NTPUDPClient timeClient = new NTPUDPClient();
//        InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
//        TimeInfo timeInfo = timeClient.getTime(inetAddress);
//        long returnTime = timeInfo.getMessage().getTransmitTimeStamp().getTime();
//        Date time = new Date(returnTime);
//        System.out.println(time);        
//        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
//        Connection dbConnection = null;
//        try {
//            dbConnection = Conn.getConnection();
//            
//        } catch (Exception e) {
//        }

        ControlDao dao = new ControlDao(Control.class);
        Horario horario = dao.getHorarioJDBC(71857741);               
        System.out.println(horario);

    }
}
