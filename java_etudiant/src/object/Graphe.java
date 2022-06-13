package object;

import object.Arc;

import java.util.List;

public interface Graphe {
    public List<String> listeNoeuds();
    public List<Arc> suivants(String n);
}
