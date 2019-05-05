import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyReader
{
    public static List<Node> readNodesFromFile(String fileName)
    {
        List<Node> nodes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String[] firstLine = br.readLine().split(" ");
            for(String s : firstLine)
            {
                nodes.add(new Node(s.charAt(0)));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Wrong file format");
            e.printStackTrace();
        }

        return nodes;
    }

    public static List<Route> createRoutesAndConnectTheNodes(String fileName, List<Node> mainNodes)
    {
        List<Route> routes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                if(!line.trim().equals("")){
                    String[] current = line.split(" ");
                    Node n1 = null; Node n2 = null;
                    for(Node n : mainNodes){
                        if(current[0].charAt(0) == n.getName()){
                            n1 = n;
                        }else if(current[1].charAt(0) == n.getName()){
                            n2 = n;
                        }
                    }
                    Route r = new Route(n1, n2);
                    routes.add(r);
                    n1.addRoute(r);
                    n2.addRoute(r);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Wrong file format");
            e.printStackTrace();
        }

        return routes;
    }
}
