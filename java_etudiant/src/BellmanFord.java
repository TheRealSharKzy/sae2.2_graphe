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
        Valeur v = new Valeur(depart);
        List<Noeud> listeNoeud = ((GrapheListe) g).getEnsNoeuds();
        for (Noeud n : listeNoeud) {
            v.setValeur(n.getNom(), Double.MAX_VALUE);
            v.setParent(n.getNom(), null);
        }
        v.setValeur(depart, 0);
        for (Noeud n:listeNoeud) {
            for (Arc arc : g.suivants(n.getNom())) {
                if (v.getValeur(arc.getDest()) > v.getValeur(n.getNom()) + arc.getCout()) {
                    v.setValeur(arc.getDest(), v.getValeur(n.getNom()) + arc.getCout());
                    v.setParent(arc.getDest(), n.getNom());
                }
            }
        }
        return v;
    }

}


