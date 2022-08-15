package reto5.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import reto5.controller.ReportesController;
import reto5.model.vo.ComprasPorProyectoVo;
import reto5.model.vo.ListaLiderVo;
import reto5.model.vo.ProyectoCampestreVo;

public class ReportesView extends JFrame implements ActionListener {
    private ReportesController controller;
    private JMenuBar menuBar;
    private JMenuItem inf1, inf2, inf3;
    private JTable table;
    private DefaultTableModel modelo;
    private JLabel lblTitulo, lblConsulta;

    public ReportesView() {
        controller = new ReportesController();
        menu();
        etiquetaUno();
        etiquetaDos();
        tabla();
    }

    public void tabla() {

        table = new JTable(modelo);
        table.setPreferredScrollableViewportSize(new Dimension(500, 400));
        add(table);
        JScrollPane pane = new JScrollPane(table);
        add(pane);
    }

    public void etiquetaUno() {
        lblTitulo = new JLabel("Informe Reto 5");
        lblTitulo.setPreferredSize(new Dimension(500, 30));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo);
    }

    public void etiquetaDos() {
        lblConsulta = new JLabel(" ");
        lblConsulta.setPreferredSize(new Dimension(500, 30));
        lblConsulta.setFont(new Font("Arial", Font.BOLD, 14));
        lblConsulta.setAlignmentX(SwingConstants.RIGHT);
        add(lblConsulta);
    }

    public void menu() {
        
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        inf1 = new JMenuItem("Primer informe");
        inf1.setMaximumSize( new Dimension(120, 40));
        inf1.setHorizontalAlignment(SwingConstants.CENTER);
        inf1.addActionListener(this);
        menuBar.add(inf1);

        inf2 = new JMenuItem("Segundo informe");        
        inf2.setMaximumSize( new Dimension(120, 40));
        inf2.addActionListener(this);
        menuBar.add(inf2);

        inf3 = new JMenuItem("Tercero informe");        
        inf3.setMaximumSize( new Dimension(120, 40));
        inf3.addActionListener(this);
        menuBar.add(inf3);
    }

    public void primerInforme() {
        try {
            List<ListaLiderVo> lideres = controller.listarLider();

            modelo = new DefaultTableModel();

            modelo.addColumn("Id_Lider");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Ciudad");

            for (ListaLiderVo lider : lideres) {
                Object[] f = new Object[4];
                f[0] = lider.getId();
                f[1] = lider.getNombre();
                f[2] = lider.getApellido();
                f[3] = lider.getCiudad();
                modelo.addRow(f);
            }

            table.setModel(modelo);
            modelo.fireTableDataChanged();

            for (int i = 0; i < 4; i++) {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                table.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void segundoInforme() {
        try {
            List<ProyectoCampestreVo> proyectos = controller.listarProyectosCampestres();

            modelo = new DefaultTableModel();

            modelo.addColumn("Id_Proyecto");
            modelo.addColumn("Constructora");
            modelo.addColumn("Numero_Habitaciones");
            modelo.addColumn("Ciudad");

            for (ProyectoCampestreVo proyecto : proyectos) {
                Object[] f = new Object[4];
                f[0] = proyecto.getId();
                f[1] = proyecto.getConstructora();
                f[2] = proyecto.getHabitaciones();
                f[3] = proyecto.getCiudad();
                modelo.addRow(f);
            }

            table.setModel(modelo);
            modelo.fireTableDataChanged();

            for (int i = 0; i < 4; i++) {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                table.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void tercerInforme() {
        try {
            List<ComprasPorProyectoVo> proyectos = controller.listarComprasProyecto();

            modelo = new DefaultTableModel();

            modelo.addColumn("Id_Compra");
            modelo.addColumn("Constructora");
            modelo.addColumn("Banco_Vinculado");

            for (ComprasPorProyectoVo proyecto : proyectos) {
                Object[] f = new Object[3];
                f[0] = proyecto.getId();
                f[1] = proyecto.getConstructora();
                f[2] = proyecto.getBanco();
                modelo.addRow(f);
            }

            table.setModel(modelo);
            modelo.fireTableDataChanged();

            for (int i = 0; i < 3; i++) {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                table.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inf1) {
            primerInforme();
            lblConsulta.setText("Informe de lideres");
            inf1.setBackground(Color.GRAY);
            inf2.setBackground(Color.white);
            inf3.setBackground(Color.white);

        } else if (e.getSource() == inf2) {
            segundoInforme();
            lblConsulta.setText("Informe de proyectos Casa Campestre");
            inf1.setBackground(Color.white);
            inf2.setBackground(Color.GRAY);
            inf3.setBackground(Color.white);
        } else {
            tercerInforme();
            lblConsulta.setText("Informe de compras por proyecto con el proveedor Homecenter");
            inf1.setBackground(Color.white);
            inf2.setBackground(Color.white);
            inf3.setBackground(Color.GRAY);            
        }

    }
}
