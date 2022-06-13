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
        File dir=new File("./java_etudiant/documente/5.2");
        List<File> files=new ArrayList<>(List.of(dir.listFiles()));
        for(File file:files){
            Graphe graphe=new GrapheListe("./java_etudiant/documente/5.2/"+file.getName());

        }
    }
}
