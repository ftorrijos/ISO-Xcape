///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package modelo;
//
//import dBManager.DBManager;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
// */
//public class Incidencia {
//
//
//
//    public Incidencia() {
//
//    }
//    /**
//     *
//     * @throws SQLException
//     */
//    public static Connection c = DBManager.getConnection();
//    
//    public static void listarIncidencias() throws SQLException {
//
//        try {
//            Statement stmt3 = c.createStatement();
//            String sql3 = "SELECT * FROM incidencias;";		
//            ResultSet rs = stmt3.executeQuery(sql3);
//            System.out.println("Lista de Incidencias: ");
//
//            while (rs.next()) {
//                int incidencia_id = rs.getInt("incidencia_id");
//		int usuario_id = rs.getInt("usuario_id");
//		int grupo_id = rs.getInt("grupo_id");
//                String mensaje = rs.getString("mensaje");
//                Incidencia incidencia = new Incidencia(incidencia_id, usuario_id, grupo_id, mensaje);
//                System.out.println(incidencia);
//            }
//            rs.close();
//            stmt3.close();
//
//        } catch (SQLException e) {
//        }
//
//    }
//
//   
//   
//    
//    
// 
//}
