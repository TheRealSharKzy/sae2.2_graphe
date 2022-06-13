import java.util.List;

public class BellmanFord {

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


