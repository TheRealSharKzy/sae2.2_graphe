package object;

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
        Valeur v = new Valeur(depart);  //cree une valeur pour enregistre les poids
        List<Noeud> listeNoeud = ((GrapheListe) g).getEnsNoeuds();  //cree une liste des noeuds
        for (Noeud n : listeNoeud) {    //ajouter les noeuds dans valeur
            v.setValeur(n.getNom(), Double.MAX_VALUE);  //les poids des noeuds initialisent infini
            v.setParent(n.getNom(), null);  //les antécédants des noeuds initialisent null
        }
        v.setValeur(depart, 0); //le poid de antécédant de noeud de depart initialise 0;
        boolean changement = true;
        while (changement){   //reperter pluseure fois
            changement = false;
            for (Noeud n:listeNoeud) {  //pour chaque noeud
                for (Arc arc : g.suivants(n.getNom())) {    //pour chaque arc
                    if (v.getValeur(arc.getDest()) > v.getValeur(n.getNom()) + arc.getCout()) { //si le poid du noeud est superieur au poid du chemin
                        changement = true;
                        v.setValeur(arc.getDest(), v.getValeur(n.getNom()) + arc.getCout());    //changer le chemin
                        v.setParent(arc.getDest(), n.getNom()); //changer le parent
                    }
                }
            }
            //System.out.println(v);
        }
        return v;   //retourner le resultat
    }

    /*
    fonction resoudre(graphe:Graphe,depart:String):L(X)
        debut
        pour chaque noeud dans graphe faire:
            L(noeud)=infini
            parent(noeud)=null
        fpour
        L(depart)=0
        pour i de 1 à graphe.nbNoeud faire
            pour chaque arc(u,v) dans graphe faire
                si L(v)>L(u)+arc(u,v).cout alor
                    L(v)=L(u)+arc(u,v).cout
                    parent(v)=u
                fsi
            fpour
        fpour
        retourner L(x)
        fin
     */

}


