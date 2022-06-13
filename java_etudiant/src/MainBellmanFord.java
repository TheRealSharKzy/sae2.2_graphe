import object.BellmanFord;
import object.GrapheListe;

import java.io.IOException;

public class MainBellmanFord {
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("java_etudiant/documente/Graphe_exemple1.txt");
        System.out.println(BellmanFord.resoudre(graphe,"A"));
    }
}
