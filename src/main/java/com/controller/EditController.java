package com.controller;

import com.dao.VilleDAOImpl;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class EditController {

    @Autowired
    VilleDAOImpl villeDAO;


    @GetMapping("/edit")
    public String home(
            @RequestParam(value = "codeCommune") String codeCommune,
            Model model)
            throws IOException, SQLException {
        Ville currentVille = villeDAO.findVilleByCodeCommune(codeCommune);
        model.addAttribute("currentVille", currentVille);
        return "edit";
    }
}
