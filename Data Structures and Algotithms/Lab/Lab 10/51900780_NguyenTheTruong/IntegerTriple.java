public class IntegerTriple {

    private Integer weight;
    private Integer source;
    private Integer dest;

    public IntegerTriple(Integer s, Integer d, Integer w) {
        weight = w;
        source = s;
        dest = d;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getSource() {
        return source;
    }

    public Integer getDest() {
        return dest;
    }

    @Override 
    public String toString() {
        return " " + source + "\t" + dest + "\t" + weight;
    }
}