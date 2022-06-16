import laby.GrapheLabyrinthe;
import laby.Labyrinthe;
import object.Dijkstra;
import object.Graphe;
import object.Valeur;

import java.io.IOException;

public class MainLaby {
    public static void main(String[] args) throws IOException {
        Graphe graphe=new GrapheLabyrinthe(new Labyrinthe("java_etudiant/labySimple/laby2.txt"));
        Valeur valeur= Dijkstra.resoudre(graphe,"(1, 1)");
        System.out.println(valeur.calculerChemin("(17, 12)"));
    }
}
