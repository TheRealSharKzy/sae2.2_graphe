import object.BellmanFord;
import object.Djikstra;
import object.Graphe;
import object.GrapheListe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Test l'efficacité des deux algorithmes
 */
public class TestEfficaciteAlgo {

    /**
     * Temps moyens de l'algorithme Bellman Ford
     */
    public static double avgTimeBellman = 0;

    /**
     * Temps moyens de l'algorithme Dijkstra
     */
    public static double avgTimeDijkstra = 0;

    /**
     * Calcul le temps des deux algorithmes sur un graphe
     * @param graphe graphe sur lequel tester les deux algorithmes
     */
    public void temps(Graphe graphe){
        double startTimeBellman = System.currentTimeMillis();
        BellmanFord.resoudre(graphe,"1");
        double elapsedTimeBellman = (System.currentTimeMillis() - startTimeBellman);
        avgTimeBellman+=elapsedTimeBellman;

        double startTimeDijkstra = System.currentTimeMillis();
        Djikstra.resoudre(graphe,"1");
        double elapsedTimeDijkstra =  (System.currentTimeMillis() - startTimeDijkstra);
        avgTimeDijkstra+=elapsedTimeDijkstra;
    }

    /**
     * Calcul le temps moyens pour les deux algorithmes à partir d'un dossier
     * @param dir dossier dans lequel il y a les fichiers avec les graphes
     */
    public void calculTempsAlgoFich(File dir) throws IOException {
        List<File> files=new ArrayList<>(List.of(dir.listFiles()));
        avgTimeBellman = 0;
        avgTimeDijkstra = 0;
        double compteur = 0;

        for(File file : files){
            Graphe graphe=new GrapheListe("./java_etudiant/documente/5.2/"+file.getName());
            temps(graphe);
            compteur++;
        }
        System.out.println("Average time for Bellman Ford algorithm : " + (avgTimeBellman / compteur));
        System.out.println("Average time for Dijkstra algorithm : " + (avgTimeDijkstra / compteur));
        System.out.println("Ratio de perf bellman ford :" + (avgTimeBellman / compteur) / (avgTimeDijkstra / compteur) );
    }

    /**
     * Calcul le temps moyens pour les deux algorithmes à partir d'une liste de graphe
     * @param graphes liste de graphe
     */
    public void calculTempsAlgoGraphes(List<Graphe> graphes) throws IOException {
        avgTimeBellman = 0;
        avgTimeDijkstra = 0;
        double compteur = 0;

        for(Graphe g : graphes){
            temps(g);
            compteur++;
        }
        System.out.println("Average time for Bellman Ford algorithm : " + (avgTimeBellman / compteur));
        System.out.println("Average time for Dijkstra algorithm : " + (avgTimeDijkstra / compteur));
        System.out.println("Ratio de perf dijkstra :" + (avgTimeBellman / compteur) / (avgTimeDijkstra / compteur) );
    }

    public static void main(String[] args) throws IOException {
        TestEfficaciteAlgo test=new TestEfficaciteAlgo();
        List<Graphe> graphes=new ArrayList<>();
        for(int i=0;i<10;i++){
            graphes.add(new GrapheListe(100));
        }
        test.calculTempsAlgoGraphes(graphes);
    }

}
