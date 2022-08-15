package reto5.controller;

import java.sql.SQLException;
import java.util.List;

import reto5.model.dao.*;
import reto5.model.vo.*;

public class ReportesController {
    private ProyectoCampestreDao proyectoCampestreDao;
    private ComprasPorProyectoDao comprasporproyectoDao;
    private ListaLiderDao listaliderDao;

    public ReportesController() {
        proyectoCampestreDao = new ProyectoCampestreDao();
        comprasporproyectoDao = new ComprasPorProyectoDao();
        listaliderDao = new ListaLiderDao();

    }

    public List<ProyectoCampestreVo> listarProyectosCampestres() throws SQLException {
        return proyectoCampestreDao.listar();
    }

    public List<ComprasPorProyectoVo> listarComprasProyecto() throws SQLException {
        return comprasporproyectoDao.listar();
    }

    public List<ListaLiderVo> listarLider() throws SQLException {
        return listaliderDao.listar();
    }
}
