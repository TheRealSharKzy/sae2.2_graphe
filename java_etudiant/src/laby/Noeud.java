package laby;

import java.util.ArrayList;
import java.util.List;

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

    public void ajouterArc(Noeud dest, double cout){
        adj.add(new Arc(dest,cout));
    }

    public String getNom() {
        return nom;
    }

    public List<Arc> getAdj() {
        return adj;
    }
}
