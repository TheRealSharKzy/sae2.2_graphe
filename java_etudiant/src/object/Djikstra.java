package object;

import object.Arc;

import java.util.ArrayList;
import java.util.List;

/**
 * Effectue l'algorithme de Djikstra
 */
public class Djikstra {

    /**
     * Resoud l'algorithme de Dijkstra pour un graphe donné
     * @param g Graphe
     * @param depart point de départ de l'algorithme
     * @return Valeur après l'algorithme
     */
    public static Valeur resoudre(Graphe g, String depart){
        List<String> Q=new ArrayList<>();   //utilisation d'une liste de noeuds à traiter
        Valeur valeur=new Valeur(depart);   //creer un valeur
        for(Noeud sommet:((GrapheListe)g).getEnsNoeuds()){  //ajouter chaque noeud dans valeur
            valeur.setValeur(sommet.getNom(),Double.MAX_VALUE); //un poid d'un noeud initialise infini
            valeur.setParent(sommet.getNom(), null);    //un parent du poeud initialise null
            Q.add(sommet.getNom()); //ajouter le noeud dans Q
        }
        valeur.setValeur(depart,0); //le poid du depart initialise 0;
        while (Q.size()>0){ //tant que Q n'est pas vide
            String u=min(Q,valeur); //un noeud de q telle que son poid est minimale
            Q.remove(u);    //enlever u
            for(Arc arc:g.suivants(u)){ //pour chaque arc de u
                if(Q.contains(arc.getDest())){  //si une destination est dans Q
                    double D=valeur.getValeur(u)+arc.getCout(); //le poid d'un chemin de la destination qui passe u
                    if(D<valeur.getValeur(arc.getDest())){  //si le poid est moins lourd
                        valeur.setValeur(arc.getDest(),D);  //changer le poid
                        valeur.setParent(arc.getDest(),u);  //changer son parent
                    }
                }
            }
            //System.out.println(valeur);
        }
        return valeur;  //retourner le resultat
    }

    /**
     * Prend le minimum d'une liste pour les valeurs
     * @param list liste où prendre le minimum
     * @param valeur valeur courante de l'algorithme
     * @return  minimum
     */
    private static String min(List<String> list, Valeur valeur){
        String res=list.get(0); //le premier élément de la liste
        for(int i=1;i<list.size();i++){ //parcoure tous les restes
            if(valeur.getValeur(list.get(i))<valeur.getValeur(res)){    //si le poid est moins lourd
                res= list.get(i);   //changer le resultat
            }
        }
        return res; //retourner le resultat
    }
}
