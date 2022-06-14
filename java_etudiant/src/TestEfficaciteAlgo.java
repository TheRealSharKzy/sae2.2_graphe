import object.BellmanFord;
import object.Djikstra;
import object.Graphe;
import object.GrapheListe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestEfficaciteAlgo {
    
    public static void main(String[] args) throws IOException {
        File dir=new File("./java_etudiant/documente/5.2.1");
        List<File> files=new ArrayList<>(List.of(dir.listFiles()));
        double avgTimeBellman = 0;
        double avgTimeDijkstra = 0;
        double compteur = 0;

        for(File file : files){
            Graphe graphe=new GrapheListe("./java_etudiant/documente/5.2/"+file.getName());

            double startTimeBellman = System.currentTimeMillis();
            BellmanFord.resoudre(graphe,"1");
            double elapsedTimeBellman = (System.currentTimeMillis() - startTimeBellman);
            avgTimeBellman+=elapsedTimeBellman;

            double startTimeDijkstra = System.currentTimeMillis();
            Djikstra.resoudre(graphe,"1");
            double elapsedTimeDijkstra =  (System.currentTimeMillis() - startTimeDijkstra);
            avgTimeDijkstra+=elapsedTimeDijkstra;

            compteur++;
        }
        System.out.println("Average time for Bellman Ford algorithm : " + (avgTimeBellman / compteur));
        System.out.println("Average time for Dijkstra algorithm : " + (avgTimeDijkstra / compteur));
    }
}
