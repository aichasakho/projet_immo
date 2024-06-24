package sn.dev.projetimmo.web;

import lombok.Data;
import sn.dev.projetimmo.entities.Immeuble;

import java.util.ArrayList;
import java.util.List;
@Data
public class ImmeubleModel {
    private String motCle;
    private List<Immeuble> immeubles = new ArrayList<>();

}
