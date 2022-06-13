import java.io.IOException;

public class TestEfficaciteAlgo {
    
    public static void main(String[] args) throws IOException {
        GrapheListe graphe = new GrapheListe("java_etudiant/documente/Graphe_boucle.txt");

        System.out.println("============================================");
        System.out.println("test belleman ford");
        BellmanFord.resoudre(graphe,"A");
        System.out.println("============================================");
        System.out.println("test djikstra");
        Djikstra.resoudre(graphe,"A");
    }
}
