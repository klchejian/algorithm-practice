//package main.java.ClassicAlgo;
//
//import java.util.Stack;
//
//public class DirectedDepthFirstOrder
//{
//    // visited数组，DFS实现需要用到
//    private boolean[] visited;
//    // 使用栈来保存最后的结果
//    private Stack<Integer> reversePost;
//
//
//    /**
//     * Topological Sorting Constructor
//     */
//    public DirectedDepthFirstOrder(Digraph di, boolean detectCycle)
//    {
//        // 这里的DirectedDepthFirstCycleDetection是一个用于检测有向图中是否存在环路的类
//        DirectedDepthFirstCycleDetection detect = new DirectedDepthFirstCycleDetection(
//                di);
//
//        if (detectCycle && detect.hasCycle())
//            throw new IllegalArgumentException("Has cycle");
//
//        this.visited = new boolean[di.getV()];
//        this.reversePost = new Stack<Integer>();
//
//        for (int i = 0; i < di.getV(); i++)
//        {
//            if (!visited[i])
//            {
//                dfs(di, i);
//            }
//        }
//    }
//
//    private void dfs(Digraph di, int v)
//    {
//        visited[v] = true;
//
//        for (int w : di.adj(v))
//        {
//            if (!visited[w])
//            {
//                dfs(di, w);
//            }
//        }
//
//        // 在即将退出dfs方法的时候，将当前顶点添加到结果集中
//        reversePost.push(v);
//    }
//
//    public Iterable<Integer> getReversePost()
//    {
//        return reversePost;
//    }
//}
