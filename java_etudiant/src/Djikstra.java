import java.util.ArrayList;
import java.util.List;

public class Djikstra {

    public static Valeur resoudre(Graphe g,String depart){
        List<String> Q=new ArrayList<>();
        Valeur valeur=new Valeur(depart);
        for(Noeud sommet:((GrapheListe)g).getEnsNoeuds()){
            valeur.setValeur(sommet.getNom(),Double.MAX_VALUE);
            valeur.setParent(sommet.getNom(), null);
            Q.add(sommet.getNom());
        }
        valeur.setValeur(depart,0);
        while (Q.size()>0){
            String u=min(Q,valeur);
            Q.remove(u);
            for(String sommet:Q){
                for(Arc arc:g.suivants(u)){
                    if(arc.getDest().equals(sommet)){
                        double D=valeur.getValeur(u)+arc.getCout();
                        if(D<valeur.getValeur(sommet)){
                            valeur.setValeur(sommet,D);
                            valeur.setParent(sommet,u);
                        }
                    }
                }
            }
        }
        return valeur;
    }

    private static String min(List<String> list, Valeur valeur){
        String res=list.get(0);
        for(String noeud:list){
            if(valeur.getValeur(noeud)<valeur.getValeur(res)){
                res=noeud;
            }
        }
        return res;
    }
}
