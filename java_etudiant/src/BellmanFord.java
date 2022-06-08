import java.util.List;

public class BellmanFord {

    public static Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        List<Noeud> listeNoeud = ((GrapheListe) g).getEnsNoeuds();
        for (Noeud n : listeNoeud) {
            v.setValeur(n.getNom(), Double.MAX_VALUE);
            v.setParent(n.getNom(), null);
        }
        v.setValeur(depart, 0);
        for (int i = 1; i < listeNoeud.size(); i++) {
            for (Arc s : g.suivants(listeNoeud.get(i).getNom())) {
                if (v.getValeur(s.getDest()) > v.getValeur(listeNoeud.get(i).getNom()) + s.getCout()) {
                    v.setValeur(s.getDest(), v.getValeur(listeNoeud.get(i).getNom()) + s.getCout());
                    v.setParent(s.getDest(), listeNoeud.get(i).getNom());
                }
            }
        }
        return v;
    }

}


