package com.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ville implements Serializable {


    private String codeCommune;

    private String nomCommune;

    private String codePostal;

    private String libelleAcheminement;

    private String ligne;
    //private Coordonnee coordonnee;

}
