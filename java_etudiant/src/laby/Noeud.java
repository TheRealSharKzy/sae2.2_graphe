package laby;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Noeud {

    String nom;
    List<Arc> adj;

    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<>();
    }


    public boolean equals(Noeud n) {
        return nom.equals(n.getNom());
    }

    public  void ajouterArc(Noeud dest, double cout){
        Arc arc = new Arc(dest,cout);
        adj.add(arc);
    }

    public String getNom() {
        return nom;
    }
}
