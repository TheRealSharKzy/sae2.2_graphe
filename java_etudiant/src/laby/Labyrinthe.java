package laby;

import object.Graphe;
import object.GrapheListe;
import object.Noeud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';

    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";


    /**
     * les murs du labyrinthe
     */
    public boolean[][] murs;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public int[] deplacerPerso(int i, int j,String action) {
        // case courante
        int[] courante = {i,j};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            // on met a jour personnage
            return suivante;
        }
        return courante;
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return
     */
    public int getLengthY() {
        return murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return
     */
    public int getLength() {
        return murs.length;
    }

    /**
     * return mur en (i,j)
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * Génére un graphe à partir d'un labyrinthe
     * @return Le graphe généré
     */
    public Graphe genererGraphe(){
        List<Noeud> noeuds=new ArrayList<>();
        for(int i=0;i<murs.length;i++){
            for (int j=0;j<murs[i].length;j++){
                if(!murs[i][j]){
                    noeuds.add(new Noeud("("+i+", "+j+")"));
                }
            }
        }
        GrapheListe graphe=new GrapheListe(noeuds);
        for(Noeud noeud:graphe.getEnsNoeuds()){
            int[] position=toPosition(noeud.getNom());
            int x=position[0];
            int y=position[1];
            int[] suivant;
            suivant=getSuivant(x,y,HAUT);
            if(!murs[suivant[0]][suivant[1]]){
                graphe.ajouterArc(noeud.getNom(),"("+suivant[0]+", "+suivant[1]+")",1);
            }
            suivant=getSuivant(x,y,BAS);
            if(!murs[suivant[0]][suivant[1]]){
                graphe.ajouterArc(noeud.getNom(),"("+suivant[0]+", "+suivant[1]+")",1);
            }
            suivant=getSuivant(x,y,DROITE);
            if(!murs[suivant[0]][suivant[1]]){
                graphe.ajouterArc(noeud.getNom(),"("+suivant[0]+", "+suivant[1]+")",1);
            }
            suivant=getSuivant(x,y,GAUCHE);
            if(!murs[suivant[0]][suivant[1]]){
                graphe.ajouterArc(noeud.getNom(),"("+suivant[0]+", "+suivant[1]+")",1);
            }
        }
        return graphe;
    }

    /**
     * Converti le nom du noeud en position
     * @param nom nom du noeud
     * @return Position du noeud
     */
    private int[] toPosition(String nom){
        int[] res=new int[2];
        String positon="";
        for (int i=1;i<nom.length()-1;i++){
            positon+=nom.charAt(i);
        }
        String[] posi=positon.split(", ");
        res[0]=Integer.parseInt(posi[0]);
        res[1]=Integer.parseInt(posi[1]);
        return res;
    }

}
