public interface GraphInterface<T>{

    // To test whether an edge exists
    public boolean isEdge(int source, int target);

    // Add an edge
    public void addEdge(int source, int target);

    // Accessor method to get the label of a vertex of this graph
    public T getLabel(int vertex);

    // Remove an edge
    public void removeEdge(int source, int target);

    // Accessor method to set the label of a vertex of this graph
    public void setLabel(int vertex, T newLabel);

    // Returns size of graph
    public int getSize();

    // prints graph on matrix
    public void printGraph();

    // prints neighbors of vertex n
    public int[] neighbors(int n);
}