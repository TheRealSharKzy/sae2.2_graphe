import object.Djikstra;
import object.GrapheListe;
import object.Valeur;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DjikstraTest {

    @Test
    public void resoudre() throws IOException {
        GrapheListe graphe=new GrapheListe("./java_etudiant/documente/Graphe_test1.txt");
        Valeur valeur= Djikstra.resoudre(graphe,"A");
        assertEquals(null,valeur.getParent("A"));
        assertEquals(0,valeur.getValeur("A"));
        assertEquals("A",valeur.getParent("B"));
        assertEquals(1,valeur.getValeur("B"));
        assertEquals("A",valeur.getParent("C"));
        assertEquals(2,valeur.getValeur("C"));
    }

    @Test
    public void resoudre2() throws IOException {
        GrapheListe graphe=new GrapheListe("./java_etudiant/documente/Graphe_test2.txt");
        Valeur valeur=Djikstra.resoudre(graphe,"A");
        assertEquals(null,valeur.getParent("A"));
        assertEquals(0,valeur.getValeur("A"));
        assertEquals("A",valeur.getParent("B"));
        assertEquals(1,valeur.getValeur("B"));
        assertEquals("B",valeur.getParent("C"));
        assertEquals(4,valeur.getValeur("C"));
    }
}
