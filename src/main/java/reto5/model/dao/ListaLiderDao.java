package reto5.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import reto5.model.vo.*;
import reto5.util.JDBCUtilities;
import java.sql.ResultSet;

public class ListaLiderDao {
    public List<ListaLiderVo> listar() throws SQLException {
        ArrayList<ListaLiderVo> compras = new ArrayList<ListaLiderVo>();

        Connection con = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider ORDER BY Ciudad_Residencia";
        
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                ListaLiderVo vo = new ListaLiderVo();
                vo.setId(rs.getInt("Id_Lider"));
                vo.setNombre(rs.getString("Nombre"));
                vo.setApellido(rs.getString("Primer_Apellido"));
                vo.setCiudad(rs.getString("Ciudad_Residencia"));

                compras.add(vo);
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
        return compras;
    }
}
