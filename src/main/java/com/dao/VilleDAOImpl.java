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

        System.out.println("Connected to H2 in-memory database.");

        String sql = "Select * from ville_france";

        Statement statement = conn.createStatement();

        ResultSet bdd = statement.executeQuery(sql);
        ResultSetMetaData rsmd = bdd.getMetaData();

        ArrayList<Ville> listVille = new ArrayList<>();

        while (bdd.next()) {
            this.i += 1;
            listVille.add(new Ville());
            listVille.get(i - 1).setCodeCommune(bdd.getString(1));
            listVille.get(i - 1).setLigne(bdd.getString(5));
            listVille.get(i - 1).setCodePostal(bdd.getString(3));
            listVille.get(i - 1).setLibelleAcheminement(bdd.getString(4));
            listVille.get(i - 1).setNomCommune(bdd.getString(2));
        }
        conn.close();

        System.out.println("findAlVilles");

        return listVille;
    }
}
