package object;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un graphe implementant la classe Graphe
 */
public class GrapheListe implements Graphe {

    /**
     * Liste des noms de tout les noeuds du graphe
     */
    private List<String> ensNom;

    /**
     * Liste de tout les noeuds du graphe
     */
    private List<Noeud> ensNoeuds;

    /**
     * Constructeur prenant en paramétre une liste de noeud
     * @param l liste de noeuds
     */
    public GrapheListe(List<Noeud> l){
        ensNoeuds =l;
        ensNom = new ArrayList<>();
        for (int i=0;i<ensNoeuds.size();i++){
            Noeud courant=ensNoeuds.get(i);
            if (!ensNom.contains(courant.getNom())) {
                ensNom.add(courant.getNom());
            } else {
                ensNoeuds.remove(i);
                i--;
            }
        }
    }

    public GrapheListe(String nom) throws IOException {
        FileReader read = new FileReader(nom);
        BufferedReader reader = new BufferedReader(read);
        List<String> seen = new ArrayList<>();
        ensNoeuds = new ArrayList<>();
        ensNom = new ArrayList<>();


        String line  = reader.readLine();
        while (line!=null){
            String[] tabLine = line.split("\t");
            for (int i=0;i<tabLine.length-1;i++){
                if (!seen.contains(tabLine[i])){
                    ensNoeuds.add(new Noeud(tabLine[i]));
                    ensNom.add(tabLine[i]);
                    seen.add(tabLine[i]);
                }
            }
            ajouterArc(tabLine[0],tabLine[1],Integer.parseInt(tabLine[2]));
            line= reader.readLine();
        }

    }

    public GrapheListe(int taille){
        Graphe graphe=generationGraphe.generer(taille);
        ensNoeuds=((GrapheListe)graphe).ensNoeuds;
        ensNom=((GrapheListe)graphe).ensNom;
    }

    /**
     * Getter de ensNom
     * @return liste des noms des noeuds du graphe
     */
    public List<String> listeNoeuds() {
        return ensNom;
    }

    /**
     * Cherche tout les arcs connectés à un noeud
     * @param n noeud qu'il faut chercher
     * @return liste de tout les arcs connectés au noeud
     */
    public List<Arc> suivants(String n) {
        List<Arc> suiv ;

        int index = findIndex(n);
        suiv = ensNoeuds.get(index).getAdj();

        return suiv;
    }

    /**
     * Trouve l'index d'un noeud dans la liste des noeuds
     * @param s nom du noeud
     * @return index du noeud
     */
    public int findIndex(String s){
        int index = 0;

        for (int i=0;i<ensNoeuds.size();i++){
            if (ensNom.get(i).equals(s)){
                index = i;
            }
        }
        return index;
    }

    /**
     * Ajoute un arc à un des noeuds du graphe
     * @param depart noeud de départ de l'arc
     * @param dest destination de l'arc
     * @param cout cout de l'arc
     */
    public void ajouterArc(String depart, String dest, double cout){
        int indexDep = findIndex(depart);
        int indexFin = findIndex(dest);

        ensNoeuds.get(indexDep).ajouterArc(ensNoeuds.get(indexFin),cout);

    }

    /**
     * Permet de représenter le graphe dans la console
     * @return chaine représentant le graphe
     */
    public String toString() {
        String res=new String();
        for (String i:ensNom) {
            res+=i+" ->";
            for(Arc j:suivants(i)){
                res+=" "+j;
            }
            res+="\n";
        }
        return res;
    }

    /**
     * Permet de pouvoir afficher le graphe avec graphviz
     * @return chaine de caractère pour graphviz
     */
    public String toGraphviz(){
        String res=new String("digraph G {\n");
        for(String i:ensNom){
            for(Arc j:suivants(i)){
                res+=i+" -> "+j.getDest()+" [label = "+(int)j.getCout()+"]\n";
            }
        }
        return res+"}";
    }

    public List<Noeud> getEnsNoeuds() {
        return ensNoeuds;
    }
}
