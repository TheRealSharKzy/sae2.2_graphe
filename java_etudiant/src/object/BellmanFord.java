package object;

import object.Arc;

import java.util.List;

/**
 * Représente l'algorithme du point fixe de Bellman Ford
 */
public class BellmanFord {

    /**
     * Méthode du chemin le plus court d'un graphe avec la méthode de point fixe
     * @param g Graphe
     * @param depart point de départ de l'algorithme
     * @return valeur du point final de l'algorithme
     */
    public static Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur(depart);  //creer un valeur pour enregistre les poids
        List<Noeud> listeNoeud = ((GrapheListe) g).getEnsNoeuds();  //creer un listre des noeuds
        for (Noeud n : listeNoeud) {    //ajouter les noeuds dans valeur
            v.setValeur(n.getNom(), Double.MAX_VALUE);  //les poids des noeuds initialisent infini
            v.setParent(n.getNom(), null);  //les antécédants des noeuds initialisent null
        }
        v.setValeur(depart, 0); //le poid de antécédant de noeud de depart initialise 0;
        for(int i=0;i<listeNoeud.size();i++){   //reperter pluseure fois
            for (Noeud n:listeNoeud) {  //pour chaque noeud
                for (Arc arc : g.suivants(n.getNom())) {    //pour chaque arc
                    if (v.getValeur(arc.getDest()) > v.getValeur(n.getNom()) + arc.getCout()) { //si le poid de le noeud est superrieus que le poid un chemin
                        v.setValeur(arc.getDest(), v.getValeur(n.getNom()) + arc.getCout());    //changer le chemin
                        v.setParent(arc.getDest(), n.getNom()); //changer le parent
                    }
                }
            }
            //System.out.println(v);
        }
        return v;   //retourner le resultat
    }

}


