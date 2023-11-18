import java.util.ArrayList;

public class AdjacencyGraph<T> implements GraphInterface<T>{
    private int numVertices;
    private T[] labels;
    private ArrayList<Node> adjLists;

    public AdjacencyGraph(int size){
        numVertices=size;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[size];
        labels = temp;
        adjLists = new ArrayList<>();
        for(int i=0; i<size; i++){
            adjLists.add(i, null);
        }
    }

    public boolean isEdge(int source, int target){
        Node currentNode = adjLists.get(source);
        while(currentNode != null){
            if(currentNode.getData() == target)
                return true;
        }
        return false;
    }

    public void addEdge(int source, int target){
        Node newNode = new Node();
        newNode.setData(target);
        
        if(adjLists.get(source) == null)
        {
            adjLists.remove(source);
            adjLists.add(source, newNode);
        }
        else {
            Node currentNode = adjLists.get(source);
            while(currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
    }

    public void removeEdge(int source, int target){
        if(adjLists.get(source).getNext() == null){
            adjLists.remove(source);
            adjLists.add(source, null);
        }
        else {
            Node currentNode = adjLists.get(source);
            while(currentNode.getNext() != null){
                if(currentNode.getData() == target){
                    currentNode.setNext(null);
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
    }

    public T getLabel(int vertex){
        return labels[vertex];
    }

    public void setLabel(int vertex, T newLabel){
        labels[vertex] = newLabel;
    }

    public int getSize(){
        return numVertices;
    }

    public void printGraph(){
        for(int i=0; i< adjLists.size(); i++){
            System.out.print("Vertex " + i + ": ");
            Node currentNode = adjLists.get(i);
            while(currentNode != null){
                System.out.print(currentNode.getData() + " ");
                currentNode = currentNode.getNext();
            }
            System.out.println();
        }
    }

    public int[] neighbors(int vertex){
        int i=0;
        int count=0;
        Node currentNode = adjLists.get(vertex);
        while(currentNode != null){
            count++;
            currentNode = currentNode.getNext();
        }

        int[] answer = new int[count];
        currentNode = adjLists.get(vertex);
        while(currentNode != null){
            answer[i] = currentNode.getData();
            i++;
            currentNode = currentNode.getNext();
        }

        return answer;
    }

    private class Node{
        private int data;
        private Node next;

        private Node(){
            data = -1;
            next = null;
        }

        private Node(int entry){
            data = entry;
            next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }
}
