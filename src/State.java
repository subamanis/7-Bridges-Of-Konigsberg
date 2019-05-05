/*
* This is the class that saves the current state of the useful objects(nodes, routes and the currentNode)
* so that we can return to this state if a route leads to a dead-end, like we never traversed that route
* We are using a stack to save and load the states
 */
import java.util.ArrayList;
import java.util.List;

public class State
{
    private Node currentNode;
    private List<Node> nodes = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public State(Node currentNode, List<Node> mainNodes, List<Route> mainRoutes)
    {
        try {
            this.currentNode = (Node) currentNode.clone();

            for (Node n : mainNodes) {
                if (n != null)
                    this.nodes.add((Node) n.clone());
            }

            for (Route r : mainRoutes) {
                if (r != null)
                    this.routes.add((Route) r.clone());
            }
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Route> getRoutes() {
        return routes;
    }

}
