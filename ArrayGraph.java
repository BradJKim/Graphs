public class ArrayGraph<T> implements GraphInterface<T> {
    private boolean[][] edges;
    private T[] labels; // labels[i] contains label for vertex i

    public ArrayGraph(int n){
        edges = new boolean[n][n]; // all init falues false
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[n];
        labels = temp;
    }

    public boolean isEdge(int source, int target){
        return edges[source][target];
    }

    public void addEdge(int source, int target){
        edges[source][target] = true;
    }

    public T getLabel(int vertex){
        return labels[vertex];
    }

    public void removeEdge(int source, int target){
        edges[source][target] = false;
    }

    public void setLabel(int vertex, T newLabel){
        labels[vertex] = newLabel;
    }

    public int getSize(){
        return labels.length;
    }

    public int[] neighbors(int vertex){
        int i;
        int count=0;
        int[] answer;

        for(i=0; i<labels.length; i++){
            if(edges[vertex][i])
                count++;
        }
        answer = new int[count];
        count=0;
        for(i=0; i<labels.length; i++){
            if(edges[vertex][i])
                answer[count++] =i;
        }
        return answer;
    }

    public void printGraph(){
        System.out.println("Printing Graph:");
        int i,j;
        System.out.print("  ");
        for(i=0; i<labels.length; i++){
            System.out.print(labels[i] + " ");
        }
        System.out.println();
        for(i=0; i<edges.length; i++){
            System.out.print(labels[i] + " ");
            for(j=0; j<edges[i].length; j++){
                if(edges[i][j]){
                    System.out.print(1 + " ");
                }
                else{
                    System.out.print(0 + " ");
                }

            }
            System.out.println();
        }
    }

}
