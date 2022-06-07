import laby.Arc;
import laby.Noeud;

import java.util.ArrayList;
import java.util.List;

public class GrapheListe implements Graphe{

    private List<String> ensNom;
    private List<Noeud> ensNoeuds;

    public GrapheListe(List<Noeud> l){
        ensNoeuds =l;
        ensNom = new ArrayList<>();
        for (Noeud n : ensNoeuds){
            ensNom.add(n.getNom());
        }
    }

    public List<String> listeNoeuds() {
        return ensNom;
    }


    public List<Arc> suivants(String n) {
        List<Arc> suiv ;

        int index = findIndex(n);
        suiv = ensNoeuds.get(index).getAdj();

        return suiv;
    }

    public int findIndex(String s){
        int index = 0;

        for (int i=0;i<ensNoeuds.size();i++){
            if (ensNom.get(i).equals(s)){
                index = i;
            }
        }
        return index;
    }

    public void ajouterArc(String depart, String dest, double cout){
        int indexDep = findIndex(depart);
        int indexFin = findIndex(dest);

        ensNoeuds.get(indexDep).ajouterArc(ensNoeuds.get(indexFin),cout);

    }

    @Override
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

    public String toGraphviz(){
        String res=new String("digraph G {\n");
        for(String i:ensNom){
            for(Arc j:suivants(i)){
                res+=i+" -> "+j.getDest()+" [label = "+(int)j.getCout()+"]\n";
            }
        }
        return res+"}";
    }
}
