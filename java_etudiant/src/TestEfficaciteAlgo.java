import object.BellmanFord;
import object.Djikstra;
import object.Graphe;
import object.GrapheListe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestEfficaciteAlgo {


    public void temps(Graphe graphe, double avgTimeBellman, double avgTimeDijkstra){
        double startTimeBellman = System.currentTimeMillis();
        BellmanFord.resoudre(graphe,"1");
        double elapsedTimeBellman = (System.currentTimeMillis() - startTimeBellman);
        avgTimeBellman+=elapsedTimeBellman;

        double startTimeDijkstra = System.currentTimeMillis();
        Djikstra.resoudre(graphe,"1");
        double elapsedTimeDijkstra =  (System.currentTimeMillis() - startTimeDijkstra);
        avgTimeDijkstra+=elapsedTimeDijkstra;
    }
    
    public void calculTempsAlgoFich(File dir) throws IOException {
        List<File> files=new ArrayList<>(List.of(dir.listFiles()));
        double avgTimeBellman = 0;
        double avgTimeDijkstra = 0;
        double compteur = 0;

        for(File file : files){
            Graphe graphe=new GrapheListe("./java_etudiant/documente/5.2/"+file.getName());
            temps(graphe,avgTimeBellman,avgTimeDijkstra);
            compteur++;
        }
        System.out.println("Average time for Bellman Ford algorithm : " + (avgTimeBellman / compteur));
        System.out.println("Average time for Dijkstra algorithm : " + (avgTimeDijkstra / compteur));
    }

    public void calculTempsAlgoFich(List<Graphe> graphes) throws IOException {
        double avgTimeBellman = 0;
        double avgTimeDijkstra = 0;
        double compteur = 0;

        for(Graphe g : graphes){
            temps(g,avgTimeBellman,avgTimeDijkstra);
            compteur++;
        }
        System.out.println("Average time for Bellman Ford algorithm : " + (avgTimeBellman / compteur));
        System.out.println("Average time for Dijkstra algorithm : " + (avgTimeDijkstra / compteur));
    }
}
