package object;

import object.Arc;

import java.util.List;

public interface Graphe {
    List<String> listeNoeuds();
    List<Arc> suivants(String n);
    String toGraphviz();
    List<Noeud> getEnsNoeuds();
}
