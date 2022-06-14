import object.Graphe;
import object.GrapheListe;
import object.Noeud;
import object.generationGraphe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] args) throws IOException {
        Graphe graphe= new GrapheListe(10);
        System.out.println(((GrapheListe)graphe).toGraphviz());
    }


}
