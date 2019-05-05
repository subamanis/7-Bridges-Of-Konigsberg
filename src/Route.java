import java.util.Objects;

public class Route implements Cloneable
{
    private Node node1;
    private Node node2;

    public Route(Node node1, Node node2)
    {
        this.node1 = node1;
        this.node2 = node2;
    }

    public Node getNode1()
    {
        return node1;
    }

    public Node getNode2()
    {
        return node2;
    }

    public Node oppositeNode(final Node node)
    {
        if(node.getName() == node1.getName()) return node2;
        return node1;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return node1.equals(route.node1) &&
                node2.equals(route.node2);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(node1, node2);
    }

    @Override
    protected Object clone()  throws CloneNotSupportedException
    {
        Route clone;
        clone = (Route) super.clone();
        clone.node1  = new Node(this.node1.getName(), this.node1.getAvailableRoutes());
        clone.node2  = new Node(this.node2.getName(), this.node2.getAvailableRoutes());

        return clone;
    }

    @Override
    public String toString()
    {
        return "From Node "+node1+" to Node "+node2;
    }

}
