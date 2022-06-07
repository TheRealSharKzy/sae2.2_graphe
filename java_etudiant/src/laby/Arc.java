package laby;

public class Arc {

    private String dest;
    private double cout;

    public Arc(Noeud dest,double cout){
        this.dest=dest.getNom();
        this.cout=cout;
        if(this.cout<0)
            this.cout=0;
    }

    @Override
    public String toString() {
        return dest+"("+cout+")";
    }

    public String getDest() {
        return dest;
    }

    public double getCout() {
        return cout;
    }
}
