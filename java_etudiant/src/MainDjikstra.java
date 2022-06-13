import object.Djikstra;
import object.GrapheListe;

import java.io.IOException;

public class MainDjikstra {

    public static void main(String[] args) throws IOException {

        GrapheListe graphe = new GrapheListe("java_etudiant/documente/Graphe_exemple1.txt");
        System.out.println(Djikstra.resoudre(graphe,"A"));

    }


}
