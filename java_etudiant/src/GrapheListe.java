import laby.Arc;
import laby.Noeud;

import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe(List<Noeud> l){
        ensNoeuds =l;
        ensNom = new ArrayList<>();
        for (Noeud n : ensNoeuds){
            ensNom.add(n.getNom());
        }
    }

    public List<String> listeNoeuds() {
        return ensNom;
    }


    public List<Arc> suivants(String n) {
        List<Arc> suiv = new ArrayList<>();

        for (Noeud noeud : ensNoeuds){
            if (noeud.getNom().equals(n)){
                suiv = noeud.getAdj();
            }
        }

        return suiv;
    }
}
