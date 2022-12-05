package com.controller;

import com.dao.VilleDAOImpl;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ListController {
    @Autowired
    VilleDAOImpl villeDAO;


    @GetMapping(value = "/list")
    public String get(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) throws SQLException {
        ArrayList<Ville> listeVille = villeDAO.findAllVilles();
        model.addAttribute("villes",listeVille);
        model.addAttribute("page", page);
        return "list";
    }

}
