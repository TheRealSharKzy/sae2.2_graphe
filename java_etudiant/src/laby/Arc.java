package laby;


/**
 * Classe représentant un arc d'un graphe
 */
public class Arc {

    /**
     * Destination de l'arc, représenté avec le nom du noeud
     */
    private String dest;

    /**
     * Cout de l'arc
     */
    private double cout;

    /**
     * Constructeur d'un arc prenant une destination et un cout
     *
     * @param dest destination de l'arc
     * @param cout cout de l'arc
     */
    public Arc(Noeud dest,double cout){
        this.dest=dest.getNom();
        this.cout=cout;
        if(this.cout<0)
            this.cout=0;
    }

    /**
     * Permet de représenter un noeud dans la console
     *
     * @return Représentation du noeud
     */
    @Override
    public String toString() {
        return dest+"("+cout+")";
    }

    /**
     * Getter de destination
     * @return destination de l'arc
     */
    public String getDest() {
        return dest;
    }

    /**
     * Getter de cout
     * @return cout de l'arc
     */
    public double getCout() {
        return cout;
    }
}
