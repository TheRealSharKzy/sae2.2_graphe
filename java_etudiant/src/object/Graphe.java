package object;

import object.Arc;

import java.util.List;

public interface Graphe {
    List<String> listeNoeuds();
    List<Arc> suivants(String n);
    void ajouterArc(String noeud1,String noeud2,double cout);
    String toGraphviz();
    List<Noeud> getEnsNoeuds();
}
