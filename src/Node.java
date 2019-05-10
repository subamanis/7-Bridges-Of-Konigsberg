import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node implements Cloneable
{
    private final char name;
    private List<Route> availableRoutes = new ArrayList<>();

    public Node(char name, List<Route> routes)
    {
        this.name = name;
        this.availableRoutes = routes;
    }

    public Node(char name)
    {
        this.name = name;
    }

    public void addRoute(final Route route)
    {
        availableRoutes.add(route);
    }

    public char getName()
    {
        return name;
    }

    public List<Route> getAvailableRoutes()
    {
        return availableRoutes;
    }

    public void setAvailableRoutes(List<Route> availableRoutes)
    {
        this.availableRoutes = availableRoutes;
    }

    public Node crossBetweenNodes(Route route, List<Node> mainNodes)
    {
        this.availableRoutes.remove(route);
        Node otherNode = route.oppositeNode(this);
        for(Node n : mainNodes){
            if(n.getName() == otherNode.getName()){
                otherNode = n;
                break;
            }
        }
        otherNode.availableRoutes.remove(route);
        return otherNode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Node cloneNode;
        cloneNode = (Node) super.clone();
        List<Route> clonedArray = new ArrayList<>();
        for (Route r : this.getAvailableRoutes())
        {
            clonedArray.add((Route)r.clone());
        }
        cloneNode.setAvailableRoutes(clonedArray);

        return cloneNode;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return name == node.name &&
                availableRoutes.equals(node.availableRoutes);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, availableRoutes);
    }

    @Override
    public String toString()
    {
        return Character.toString(name);
    }

    public String nodeInfo()
    {
        return "Node with Name: "+name+"  and "+availableRoutes.size()+" available routes";
    }
}
