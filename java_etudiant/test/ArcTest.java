import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcTest {
    @Test
    void constructeur(){
        Arc arc=new Arc(new Noeud("A"),1);
        assertEquals("A",arc.getDest());
        assertEquals(1,arc.getCout());
    }
}