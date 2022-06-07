import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un noeud d'un graphe
 */
public class Noeud {

    /**
     * Nom du noeud
     */
    String nom;

    /**
     * Liste de tout les arc connectés au noeud
     */
    List<Arc> adj;


    /**
     * Constructeur de noeud prenant en paramétre le nom du noeud
     * @param nom nom du noeud
     */
    public Noeud(String nom) {
        this.nom = nom;
        this.adj = new ArrayList<>();
    }

    /**
     * Regarde si le nom du noeud est égal à un autre
     * @param n nom du noeud à comparer
     * @return booléen correspondant à si le nom est égal celui en paramétre
     */
    public boolean equals(Noeud n) {
        return nom.equals(n.getNom());
    }

    /**
     * Ajouter un arc à la liste de tout les arcs connectés au noeud
     * @param dest Destination du nouvel arc
     * @param cout cout du nouvel arc
     */
    public void ajouterArc(Noeud dest, double cout){
        adj.add(new Arc(dest,cout));
    }

    /**
     * Getter de nom
     * @return nom du noeud
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter de adj
     * @return liste de tout les arcs connectés au noeud
     */
    public List<Arc> getAdj() {
        return adj;
    }
}
