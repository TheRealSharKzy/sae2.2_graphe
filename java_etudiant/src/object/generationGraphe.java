package object;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de générer des graphes aléatoires
 */
public class generationGraphe {

    /**
     * Génére un graphe aléatoirement avec un nombre de noeuds donné
     * @param taille Nombre de noeuds du graphe
     * @return le graphe généré
     */
    public static Graphe generer(int taille){
        List<Noeud> noeuds = new ArrayList<>();
        for (int i = 0; i < taille; i++) {
            noeuds.add(new Noeud("" + i));
        }
        Graphe res = new GrapheListe(noeuds);
        List<Noeud> noeudsChemein = new ArrayList<>();
        List<Noeud> noeudsIsole = new ArrayList<>(noeuds);
        while (noeudsIsole.size() > 0) {
            int nbNoeudTrait = 1 + (int) (Math.random() * noeudsIsole.size());
            List<Noeud> trait = new ArrayList<>();
            for (int i = 0; i < nbNoeudTrait; i++) {
                Noeud noeud=noeudsIsole.get((int) (Math.random() * noeudsIsole.size()));
                trait.add(noeud);
                noeudsIsole.remove(noeud);
            }
            for (int i = 0; i < trait.size() - 1; i++) {
                ((GrapheListe) res).ajouterArc(trait.get(i).getNom(), trait.get(i + 1).getNom(), (int) (Math.random() * 100));
            }
            if (noeudsChemein.size() == 0) {
                if(trait.size()>1){
                    ((GrapheListe) res).ajouterArc(trait.get(trait.size() - 1).getNom(), trait.get(0).getNom(), (int) (Math.random() * 100));
                }
            } else {
                Noeud noeud1 = noeudsChemein.get((int) (Math.random() * noeudsChemein.size()));
                Noeud noeud2 = noeudsChemein.get((int) (Math.random() * noeudsChemein.size()));
                ((GrapheListe) res).ajouterArc(noeud1.getNom(), trait.get(0).getNom(), (int) (Math.random() * 100));
                ((GrapheListe) res).ajouterArc(trait.get(trait.size() - 1).getNom(), noeud2.getNom(), (int) (Math.random() * 100));
            }
            noeudsChemein.addAll(trait);
        }
        return res;
    }

}
