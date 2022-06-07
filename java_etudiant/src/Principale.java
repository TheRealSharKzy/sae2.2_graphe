import laby.Noeud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] args) throws IOException {
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
        GrapheListe grapheFich = new GrapheListe("./Graphe_exemple1.txt");


        //System.out.println(graphe);
        System.out.println(grapheFich);
        System.out.println(grapheFich.toGraphviz());
        //System.out.println(graphe.toGraphviz());
    }


}
