import laby.GrapheLabyrinthe;
import laby.Labyrinthe;
import object.Djikstra;
import object.Graphe;
import object.GrapheListe;
import object.Valeur;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class MainLaby {
    public static void main(String[] args) throws IOException {
        Graphe graphe=new GrapheLabyrinthe(new Labyrinthe("java_etudiant/labySimple/laby2.txt"));
        Valeur valeur=Djikstra.resoudre(graphe,"(1, 1)");
        System.out.println(valeur.calculerChemin("(17, 12)"));
    }
}
