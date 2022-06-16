import object.BellmanFord;
import object.GrapheListe;
import object.Noeud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test l'algorithme de Bellman Ford
 */
public class MainBellmanFord {
    public static void main(String[] args) throws IOException {
        GrapheListe grapheEx1 = new GrapheListe("java_etudiant/documente/Graphe_boucle.txt");

        List<Noeud> l = new ArrayList<>();

        l.add(new Noeud("A"));
        l.add(new Noeud("B"));
        l.add(new Noeud("C"));
        l.add(new Noeud("D"));
        l.add(new Noeud("E"));

        GrapheListe graphe  = new GrapheListe(l);
        graphe.ajouterArc("A","B",1);
        graphe.ajouterArc("A","C",5);
        graphe.ajouterArc("B","C",3);
        graphe.ajouterArc("D","C",1);
        graphe.ajouterArc("B","D",1);
        graphe.ajouterArc("C","E",3);
        graphe.ajouterArc("D","E",5);
        //System.out.println(BellmanFord.resoudre(graphe,"A"));
        System.out.println(BellmanFord.resoudre(grapheEx1,"A"));
    }
}
