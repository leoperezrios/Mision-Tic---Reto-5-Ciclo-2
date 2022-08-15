package reto5;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import reto5.view.ReportesView;

public class App {

    public static void main(String[] args) {

         ReportesView reportesView = new ReportesView();
         reportesView.setLayout(new FlowLayout());
         reportesView.setSize(700, 600);
         reportesView.setVisible(true);
         reportesView.setResizable(false);
         reportesView.setTitle("Informes - Reto 5");
         reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         reportesView.setLocationRelativeTo(null);
       
    }
}
