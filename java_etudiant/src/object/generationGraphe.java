package object;

import java.util.ArrayList;
import java.util.List;

public class generationGraphe {

    public static Graphe generer(int taille){
        List<Noeud> noeuds=new ArrayList<>();
        for(int i=0;i<taille;i++){
            noeuds.add(new Noeud(""+i));
        }
        Graphe res=new GrapheListe(noeuds);
        List<Noeud> noeudsIsole=new ArrayList<>(noeuds);
        List<Noeud> noeudsChemin=new ArrayList<>();
        Noeud noeud=noeudsIsole.get((int)(Math.random()*noeudsIsole.size()));
        noeudsIsole.remove(noeud);
        noeudsChemin.add(noeud);
        for(int i=0;i<taille-1;i++){
            noeud=noeudsIsole.get((int)(Math.random()* noeudsIsole.size()));
            noeudsIsole.remove(noeud);
            ((GrapheListe)res).ajouterArc(noeudsChemin.get(noeudsChemin.size()-1).getNom(),noeud.getNom(),(int)(Math.random()*100));
            noeudsChemin.add(noeud);
        }
        ((GrapheListe)res).ajouterArc(noeud.getNom(),noeudsChemin.get(0).getNom(),(int)(Math.random()*100));
        for(int i=0;i<=((int)(Math.random()* noeudsChemin.size()));i++){
            noeud=noeudsChemin.get((int)(noeudsChemin.size()*Math.random()));
            for(int j=0;j<((int)(Math.random()* noeudsChemin.size()));j++){
                Noeud noeudDest=noeudsChemin.get(((int)(noeudsChemin.size()*Math.random())));
                if(noeudDest==noeud){
                    j--;
                }else {
                    boolean contient=false;
                    for(Arc arc:noeud.getAdj()){
                        if(arc.getDest().equals(noeudDest.getNom())){
                            contient=true;
                            break;
                        }
                    }
                    if(!contient){
                        ((GrapheListe)res).ajouterArc(noeud.getNom(),noeudDest.getNom(),(int)(Math.random()*100));
                    }
                }
            }
        }
        return res;
    }

}
