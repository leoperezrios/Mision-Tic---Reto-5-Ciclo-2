package reto5.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import reto5.model.vo.ComprasPorProyectoVo;
import reto5.util.JDBCUtilities;

public class ComprasPorProyectoDao {
    public List<ComprasPorProyectoVo> listar() throws SQLException {

        List<ComprasPorProyectoVo> result = new ArrayList<ComprasPorProyectoVo>();

        Connection con = JDBCUtilities.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "SELECT ID_Compra, Constructora, Banco_Vinculado FROM Compra c JOIN Proyecto p ON c.ID_Compra = p.ID_Proyecto WHERE Proveedor = 'Homecenter' AND Ciudad = 'Salento'";
        try {
            stm = con.prepareStatement(sql);
            //stm.setDouble(1, limite);
            rs = stm.executeQuery();

            while (rs.next()) {
                ComprasPorProyectoVo vo = new ComprasPorProyectoVo();
                vo.setId(rs.getInt("ID_Compra"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBanco(rs.getString("Banco_Vinculado"));
                result.add(vo);
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
