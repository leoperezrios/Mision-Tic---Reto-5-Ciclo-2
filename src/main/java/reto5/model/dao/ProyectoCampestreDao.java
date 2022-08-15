package reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reto5.model.vo.ProyectoCampestreVo;
import reto5.util.JDBCUtilities;

public class ProyectoCampestreDao {
    public List<ProyectoCampestreVo> listar() throws SQLException {

        List<ProyectoCampestreVo> result = new ArrayList<ProyectoCampestreVo>();
        

        Connection con = JDBCUtilities.getConnection();

        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM Proyecto p WHERE Clasificacion = 'Casa Campestre' AND Ciudad = 'Santa Marta' OR Ciudad = 'Cartagena' OR Ciudad = 'Barranquilla'";

        try {
            stm = con.prepareStatement(sql);
            //stm.setString(1, banco);
            rs = stm.executeQuery();

            while (rs.next()) {
                ProyectoCampestreVo vo = new ProyectoCampestreVo();
                vo.setId(rs.getInt("ID_proyecto"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setHabitaciones(rs.getInt("Numero_Habitaciones"));
                vo.setCiudad(rs.getString("Ciudad"));

                result.add(vo);
                //System.out.println(vo.toString());                
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
