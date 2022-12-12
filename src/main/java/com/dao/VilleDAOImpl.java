package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO{
    private int i = 0;

    public ArrayList<Ville> findAllVilles() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/TWIC";
        ArrayList<Ville> listVille = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        try {
            conn = DriverManager.getConnection(url, "TWIC", "network");

            String sql = "Select * from ville_france";

            statement = conn.createStatement();

            ResultSet bdd = statement.executeQuery(sql);

            while (bdd.next()) {
                this.i += 1;
                Ville ville = new Ville();
                ville.setCodeCommune(bdd.getString(1));
                ville.setNomCommune(bdd.getString(2));
                ville.setCodePostal(bdd.getString(3));
                ville.setLibelleAcheminement(bdd.getString(4));
                ville.setLigne(bdd.getString(5));
                ville.setLatitude(bdd.getString(6));
                ville.setLongitude(bdd.getString(7));
                listVille.add(ville);
            }
        } finally {
            if(conn != null && statement!=null){
                conn.close();
                statement.close();
            }
        }
        return listVille;
    }

    public Ville findVilleByName(String name) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = null;
        Statement statement = null;
        Ville ville = new Ville();
        try {
            conn = DriverManager.getConnection(url, "TWIC", "network");

            String sql = "Select * from ville_france where Nom_commune = "+name;
            statement = conn.createStatement();
            ResultSet bdd = statement.executeQuery(sql);
            ArrayList<Ville> listVille = new ArrayList<>();
            bdd.next();
            ville.setCodeCommune(bdd.getString(1));
            ville.setNomCommune(bdd.getString(2));
            ville.setCodePostal(bdd.getString(3));
            ville.setLibelleAcheminement(bdd.getString(4));
            ville.setLigne(bdd.getString(5));
            ville.setLatitude(bdd.getString(6));
            ville.setLongitude(bdd.getString(7));
        } finally {
            if(conn != null && statement!=null){
                conn.close();
                statement.close();
            }
        }
        return ville;
    }
    public Ville findVilleByCodeCommune(String codeCommune) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = null;
        Statement statement = null;
        Ville ville = new Ville();
        try {
            conn = DriverManager.getConnection(url, "TWIC", "network");
            String sql = "Select * from ville_france where Code_commune_INSEE = "+codeCommune;
            statement = conn.createStatement();
            ResultSet bdd = statement.executeQuery(sql);
            ArrayList<Ville> listVille = new ArrayList<>();
            bdd.next();
            ville.setCodeCommune(bdd.getString(1));
            ville.setNomCommune(bdd.getString(2));
            ville.setCodePostal(bdd.getString(3));
            ville.setLibelleAcheminement(bdd.getString(4));
            ville.setLigne(bdd.getString(5));
            ville.setLatitude(bdd.getString(6));
            ville.setLongitude(bdd.getString(7));
        } finally {
            if(conn != null && statement!=null){
                conn.close();
                statement.close();
            }
        }
        return ville;
    }

    public void editVille(Ville ville) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(url, "TWIC", "network");
            String sql = "UPDATE ville_france SET Nom_commune = ?, Code_Postal = ?, Libelle_acheminement = ?, Ligne_5 = ?,Latitude = ?, Longitude = ? where Code_commune_INSEE = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,ville.getNomCommune());
            preparedStatement.setString(2,ville.getCodePostal());
            preparedStatement.setString(3,ville.getLibelleAcheminement());
            preparedStatement.setString(4,ville.getLigne());
            preparedStatement.setString(5,ville.getLatitude());
            preparedStatement.setString(6,ville.getLongitude());
            preparedStatement.setString(7,ville.getCodeCommune());
            int bdd = preparedStatement.executeUpdate();
        } finally {
            if(conn != null && preparedStatement!=null){
                conn.close();
                preparedStatement.close();
            }
        }
    }

    public void deleteVille(String codeCommune) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DriverManager.getConnection(url, "TWIC", "network");
            String sql = "DELETE from ville_france where Code_commune_INSEE = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,codeCommune);
            int bdd = preparedStatement.executeUpdate();
        } finally {
            if(conn != null && preparedStatement!=null){
                conn.close();
                preparedStatement.close();
            }
        }
    }
}
