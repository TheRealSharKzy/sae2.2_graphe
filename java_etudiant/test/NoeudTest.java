import object.Noeud;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NoeudTest {

    @Test
    void constructeur(){
        Noeud noeud=new Noeud("A");
        assertEquals("A",noeud.getNom());
        assertEquals(new ArrayList<>(),noeud.getAdj());
    }

    @Test
    void testEquals() {
        Noeud a1=new Noeud("A");
        Noeud a2=new Noeud("A");
        assertTrue(a1.equals(a2));
    }

    @Test
    void ajouterArc() {
        Noeud a=new Noeud("A");
        Noeud b=new Noeud("B");
        a.ajouterArc(b,1);
        assertEquals(1,a.getAdj().size());
        Noeud c=new Noeud("C");
        a.ajouterArc(c,2);
        assertEquals(2,a.getAdj().size());
    }
}