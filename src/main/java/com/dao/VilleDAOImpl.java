package com.dao;

import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO{
    private int i = 0;

    public ArrayList<Ville> findAllVilles() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/TWIC";

        Connection conn = DriverManager.getConnection(url,"TWIC","network");

        String sql = "Select * from ville_france";

        Statement statement = conn.createStatement();

        ResultSet bdd = statement.executeQuery(sql);

        ArrayList<Ville> listVille = new ArrayList<>();

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
        conn.close();

        return listVille;
    }

    public Ville findVilleByName(String name) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = DriverManager.getConnection(url,"TWIC","network");
        String sql = "Select * from ville_france where Nom_commune = "+name;
        Statement statement = conn.createStatement();
        ResultSet bdd = statement.executeQuery(sql);
        ArrayList<Ville> listVille = new ArrayList<>();
        bdd.next();
        Ville ville = new Ville();
        ville.setCodeCommune(bdd.getString(1));
        ville.setNomCommune(bdd.getString(2));
        ville.setCodePostal(bdd.getString(3));
        ville.setLibelleAcheminement(bdd.getString(4));
        ville.setLigne(bdd.getString(5));
        ville.setLatitude(bdd.getString(6));
        ville.setLongitude(bdd.getString(7));
        conn.close();

        return ville;
    }
    public Ville findVilleByCodeCommune(String codeCommune) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/TWIC";
        Connection conn = DriverManager.getConnection(url,"TWIC","network");
        String sql = "Select * from ville_france where Code_commune_INSEE = "+codeCommune;
        Statement statement = conn.createStatement();
        ResultSet bdd = statement.executeQuery(sql);
        ArrayList<Ville> listVille = new ArrayList<>();
        bdd.next();
        Ville ville = new Ville();
        ville.setCodeCommune(bdd.getString(1));
        ville.setNomCommune(bdd.getString(2));
        ville.setCodePostal(bdd.getString(3));
        ville.setLibelleAcheminement(bdd.getString(4));
        ville.setLigne(bdd.getString(5));
        ville.setLatitude(bdd.getString(6));
        ville.setLongitude(bdd.getString(7));
        conn.close();
        return ville;
    }
}
