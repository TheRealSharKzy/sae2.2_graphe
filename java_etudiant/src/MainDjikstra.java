import object.Djikstra;
import object.GrapheListe;

import java.io.IOException;

/**
 * Test l'algorithme de Dijkstra
 */
public class MainDjikstra {

    public static void main(String[] args) throws IOException {

        GrapheListe graphe = new GrapheListe("java_etudiant/documente/Graphe_boucle.txt");
        System.out.println(Djikstra.resoudre(graphe,"A"));

        GrapheListe graphe2 = new GrapheListe(10);
        System.out.println(Djikstra.resoudre(graphe,"1"));
    }


}
