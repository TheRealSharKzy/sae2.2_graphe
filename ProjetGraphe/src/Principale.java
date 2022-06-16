import object.Graphe;
import object.GrapheListe;
import object.Noeud;
import object.generationGraphe;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Principale {

    public static void main(String[] args) throws IOException {
        Graphe graphe= new GrapheListe(10);
        File file=new File("java_etudiant/documente/GrapheGénération.puml");
        PrintWriter writer=new PrintWriter(file);
        writer.println("@startuml");
        writer.println(((GrapheListe)graphe).toGraphviz());
        writer.println("@enduml");
        writer.close();
    }


}
