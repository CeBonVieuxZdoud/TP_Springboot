package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO{
    String url = "jdbc:mysql://localhost:3306/TWIC";
    String user = "TWIC";
    String password = "network";

    public ArrayList<Ville> findAllVilles() throws SQLException {
        ArrayList<Ville> listVille = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, user,password);) {
            String sql = "Select * from ville_france";
            try(Statement statement = conn.createStatement()){
                ResultSet bdd = statement.executeQuery(sql);
                while (bdd.next()) {
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
            }catch(SQLException exception) {
                throw new SQLException();
            }
        }catch(SQLException exception) {
            throw new SQLException();
        }
        return listVille;
    }

    public Ville findVilleByName(String name) throws SQLException{
        Ville ville = new Ville();
        try(Connection conn = DriverManager.getConnection(url, user,password);) {
            String sql = "Select * from ville_france where Nom_commune = "+name;
           try(Statement statement = conn.createStatement()) {
               ResultSet bdd = statement.executeQuery(sql);
               bdd.next();
               ville.setCodeCommune(bdd.getString(1));
               ville.setNomCommune(bdd.getString(2));
               ville.setCodePostal(bdd.getString(3));
               ville.setLibelleAcheminement(bdd.getString(4));
               ville.setLigne(bdd.getString(5));
               ville.setLatitude(bdd.getString(6));
               ville.setLongitude(bdd.getString(7));
           }catch(SQLException exception) {
               throw new SQLException();
           }
        }catch(SQLException exception) {
            throw new SQLException();
        }
        return ville;
    }
    public Ville findVilleByCodeCommune(String codeCommune) throws SQLException{
        Ville ville = new Ville();
        try(Connection conn = DriverManager.getConnection(url, user,password);) {
            String sql = "Select * from ville_france where Code_commune_INSEE = "+codeCommune;
            try(Statement statement = conn.createStatement()){
                ResultSet bdd = statement.executeQuery(sql);
                bdd.next();
                ville.setCodeCommune(bdd.getString(1));
                ville.setNomCommune(bdd.getString(2));
                ville.setCodePostal(bdd.getString(3));
                ville.setLibelleAcheminement(bdd.getString(4));
                ville.setLigne(bdd.getString(5));
                ville.setLatitude(bdd.getString(6));
                ville.setLongitude(bdd.getString(7));
            }catch(SQLException exception) {
                throw new SQLException();
            }
        }catch(SQLException exception) {
            throw new SQLException();
        }
        return ville;
    }

    public void editVille(Ville ville) throws SQLException{
        try(Connection conn = DriverManager.getConnection(url, user,password);) {
            String sql = "UPDATE ville_france SET Nom_commune = ?, Code_Postal = ?, Libelle_acheminement = ?, Ligne_5 = ?,Latitude = ?, Longitude = ? where Code_commune_INSEE = ?";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1,ville.getNomCommune());
                preparedStatement.setString(2,ville.getCodePostal());
                preparedStatement.setString(3,ville.getLibelleAcheminement());
                preparedStatement.setString(4,ville.getLigne());
                preparedStatement.setString(5,ville.getLatitude());
                preparedStatement.setString(6,ville.getLongitude());
                preparedStatement.setString(7,ville.getCodeCommune());
                preparedStatement.executeUpdate();
            }catch(SQLException exception) {
                throw new SQLException();
            }
        }catch(SQLException exception) {
            throw new SQLException();
        }

    }

    public void deleteVille(String codeCommune) throws SQLException{
        try(Connection conn = DriverManager.getConnection(url, user,password)) {
            String sql = "DELETE from ville_france where Code_commune_INSEE = ?";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql);){
                preparedStatement.setString(1,codeCommune);
                preparedStatement.executeUpdate();
            }catch(SQLException exception) {
                throw new SQLException();
            }
        }catch(SQLException exception) {
            throw new SQLException();
        }
    }
}
