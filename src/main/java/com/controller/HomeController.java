package com.controller;

import com.dao.VilleDAOImpl;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    VilleDAOImpl villeDAO;


    @RequestMapping(value = "/")
    public String get(Model model) throws SQLException {

        ArrayList<Ville> listeVille = villeDAO.findAllVilles();
        model.addAttribute("villes",listeVille);
        return "home";
    }
}
