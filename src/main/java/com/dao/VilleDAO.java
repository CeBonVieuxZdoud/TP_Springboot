package com.dao;

import com.dto.Ville;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VilleDAO {
    public ArrayList<Ville> findAllVilles() throws SQLException;
    public Ville findVilleByName(String name) throws SQLException;
    public Ville findVilleByCodeCommune(String codeCommune) throws SQLException;
}
