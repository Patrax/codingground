public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
     }
     
    class node implements Comparable<node> {
        int weight, index;
    
        public node(int weight, int index){
            this.weight = weight;
            this.index = index;
        }
    
        public int compareTo(node e){
            return weight - e.weight;
        }
    }
    
    public static int dijkstra(int[][] adjMatrix, int start, int end){
        int n = adjMatrix.length;
        PriorityQueue<node> pq = new PriorityQueue<node>();
        
        //Initialize visited to false
        boolean visited[] = new boolean[n];
        for(int i=0; i<n; i++)
            visited[i] = false;
            
        //Add the start node to the queue
        pq.add( new node(0,start) );
        
        //Keep going until all nodes are visited or queue is empty
        while( !visited[end] && !pq.isEmpty() ){
            
            //Get node with lowest total weight
            node curNode = pq.poll();
            
            //Skip node is already visited
            if( visited[curNode.index] )
                continue;
            
            //Mark node as visited
            visited[curNode.index] = true;
            
            //If current node is end node then we are done
            if( curNode.index == end )
                return curNode.weight;
            
            //Iterate through neighbors of current node
            for(int i=0; i<n; i++){
                //Iterate through each unvisited neighbor
                if( adjMatrix[curNode.index][i] > 0 && !visited[i] ){
                    //Set add edge weight to current weight
                    int newWeight = curNode.weight + adjMatrix[curNode.index][i];
                    pq.add( new node(newWeight,i) );
                }
            }
        }
        return -1;
    }
    
}
