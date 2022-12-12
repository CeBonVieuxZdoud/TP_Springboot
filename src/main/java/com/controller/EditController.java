package com.controller;

import com.dao.VilleDAOImpl;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@Controller
public class EditController {

    @Autowired
    VilleDAOImpl villeDAO;


    @GetMapping("/edit")
    public String home(
            @RequestParam(value = "codeCommune") String codeCommune,
            Model model)
            throws SQLException {
        Ville currentVille = villeDAO.findVilleByCodeCommune(codeCommune);
        model.addAttribute("currentVille", currentVille);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("currentVille") Ville ville) throws SQLException {
        villeDAO.editVille(ville);
        return "edit";
    }

    @DeleteMapping("/edit")
    public void delete(@RequestParam(value = "codeCommune") String codeCommune) throws SQLException {
        villeDAO.deleteVille(codeCommune);
    }
}
