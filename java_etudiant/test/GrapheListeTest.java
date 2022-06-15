import object.GrapheListe;
import object.Noeud;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {
    @Test
    public void constructeur(){
        List<Noeud> list=new ArrayList<>();
        list.add(new Noeud("A"));
        list.add(new Noeud("B"));
        list.add(new Noeud("C"));
        GrapheListe gl=new GrapheListe(list);
        List<String> listNomNoeuds=gl.listeNoeuds();
        Assertions.assertEquals("A",listNomNoeuds.get(0));
        Assertions.assertEquals("B",listNomNoeuds.get(1));
        Assertions.assertEquals("C",listNomNoeuds.get(2));
    }

    @Test
    void constructeur_avec_meme_nom_noeud(){
        List<Noeud> list=new ArrayList<>();
        list.add(new Noeud("A"));
        list.add(new Noeud("B"));
        list.add(new Noeud("B"));
        list.add(new Noeud("C"));
        GrapheListe gl=new GrapheListe(list);
        List<String> listNomNoeuds=gl.listeNoeuds();
        assertEquals(3,listNomNoeuds.size());
        Assertions.assertEquals("A",listNomNoeuds.get(0));
        Assertions.assertEquals("B",listNomNoeuds.get(1));
        Assertions.assertEquals("C",listNomNoeuds.get(2));
    }

    @Test
    void constructeur_avec_meme_noeud(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        Noeud b=new Noeud("B");
        Noeud c=new Noeud("C");
        list.add(a);
        list.add(b);
        list.add(b);
        list.add(c);
        GrapheListe gl=new GrapheListe(list);
        List<String> listNomNoeuds=gl.listeNoeuds();
        assertEquals(3,listNomNoeuds.size());
        Assertions.assertEquals("A",listNomNoeuds.get(0));
        Assertions.assertEquals("B",listNomNoeuds.get(1));
        Assertions.assertEquals("C",listNomNoeuds.get(2));
    }

    @Test
    public void suivant_sans_arc(){
        List<Noeud> list=new ArrayList<>();
        list.add(new Noeud("A"));
        list.add(new Noeud("B"));
        list.add(new Noeud("C"));
        GrapheListe gl=new GrapheListe(list);
        List<String> listNomNoeuds=gl.listeNoeuds();
        for(int i=0;i<listNomNoeuds.size();i++)
            Assertions.assertEquals(new ArrayList<>(),gl.suivants(listNomNoeuds.get(i)));
    }

    @Test
    public void suivant_noeud_inexstant(){
        List<Noeud> list=new ArrayList<>();
        GrapheListe graphe=new GrapheListe(list);
        assertEquals(null,graphe.suivants("A"));
    }

    @Test
    public void suivant_avec_arc(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        Noeud b=new Noeud("B");
        Noeud c=new Noeud("C");
        a.ajouterArc(b,1);
        a.ajouterArc(c,2);
        b.ajouterArc(c,3);
        list.add(a);
        list.add(b);
        list.add(c);
        GrapheListe gl=new GrapheListe(list);
        Assertions.assertEquals(a.getAdj(),gl.suivants("A"));
        Assertions.assertEquals(b.getAdj(),gl.suivants("B"));
        Assertions.assertEquals(c.getAdj(),gl.suivants("C"));
    }

    @Test
    public void ajouterArc(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        Noeud b=new Noeud("B");
        Noeud c=new Noeud("C");
        list.add(a);
        list.add(b);
        list.add(c);
        GrapheListe gl=new GrapheListe(list);
        gl.ajouterArc("A","B",1);
        gl.ajouterArc("A","B",2);
        gl.ajouterArc("B","C",3);
        Assertions.assertEquals(a.getAdj(),gl.suivants("A"));
        Assertions.assertEquals(b.getAdj(),gl.suivants("B"));
        Assertions.assertEquals(c.getAdj(),gl.suivants("C"));
    }

    @Test
    public void ajouterArc_noeud_inexistant(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        Noeud z=new Noeud("Z");
        list.add(a);
        GrapheListe gl=new GrapheListe(list);
        gl.ajouterArc("A","Z",1);
        gl.ajouterArc("Z","A",2);
        Assertions.assertEquals(0,gl.suivants("A").size());
    }

    @Test
    void ajouterArc_a_soi(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        list.add(a);
        GrapheListe gl=new GrapheListe(list);
        gl.ajouterArc("A","A",1);
        Assertions.assertEquals(a.getAdj(),gl.suivants("A"));
    }

    @Test
    void ajouterArc_plusieux_fois_entre_2_noeud(){
        List<Noeud> list=new ArrayList<>();
        Noeud a=new Noeud("A");
        Noeud b=new Noeud("B");
        list.add(a);
        list.add(b);
        GrapheListe gl=new GrapheListe(list);
        gl.ajouterArc("A","B",1);
        gl.ajouterArc("A","B",2);
        Assertions.assertEquals(a.getAdj(),gl.suivants("A"));
    }
}