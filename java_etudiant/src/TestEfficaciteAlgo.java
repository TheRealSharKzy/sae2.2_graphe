import java.io.IOException;

public class TestEfficaciteAlgo {
    
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("./java_etudiant/documente/Graphe_boucle.txt");

        System.out.println(BellmanFord.resoudre(graphe,"A"));
        System.out.println(Djikstra.resoudre(graphe,"A"));
    }
}
