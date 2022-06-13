import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Noeud a = new Noeud("A");
        Noeud b = new Noeud("B");
        Noeud c = new Noeud("C");
        Noeud d = new Noeud("D");
        Noeud e = new Noeud("E");

        a.ajouterArc(b,12);
        a.ajouterArc(d,87);
        c.ajouterArc(a,19);
        d.ajouterArc(c,10);
        d.ajouterArc(b,23);
        b.ajouterArc(e,11);
        e.ajouterArc(d,43);

        List<Noeud> l = new ArrayList<>();
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);

        GrapheListe graphe = new GrapheListe(l);
        Valeur v = BellmanFord.resoudre(graphe,"A");
        System.out.println(graphe);
        System.out.println(v);
        System.out.println(v.calculerChemin("E"));
    }
}
