package laby;

import object.Arc;
import object.Graphe;
import object.Noeud;

import java.util.List;

public class GrapheLabyrinthe implements Graphe{
    Graphe graphe;

    public GrapheLabyrinthe(Labyrinthe labyrinthe){
        graphe= labyrinthe.genererGraphe();
    }

    @Override
    public List<String> listeNoeuds() { return graphe.listeNoeuds(); }

    @Override
    public List<Arc> suivants(String n) {
        return graphe.suivants(n);
    }

    @Override
    public void ajouterArc(String noeud1, String noeud2, double cout) {
        graphe.ajouterArc(noeud1,noeud2,cout);
    }

    @Override
    public String toGraphviz() {
        return graphe.toGraphviz();
    }

    @Override
    public List<Noeud> getEnsNoeuds() {
        return graphe.getEnsNoeuds();
    }
}
