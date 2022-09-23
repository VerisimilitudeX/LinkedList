public class Node {
    public Integer data;
    public int nextLocation;
    public int previousLocation;
    public static final int invalidIndexValue = -1;

    public Node() {
        data = null;
        nextLocation = invalidIndexValue;
        previousLocation = invalidIndexValue;
    }
}
