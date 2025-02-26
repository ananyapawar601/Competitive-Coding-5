//Breadth First Search Approach

// Time Complexity :    O(N) — Each node is processed once, making the traversal linear in the number of nodes N
// Space Complexity :   O(W) — The queue holds at most W nodes at a time, where W is the maximum width of the tree (worst case: O(N) for a full binary tree).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :We use a queue to perform a level-order traversal of the binary tree while tracking the maximum value at each level. 
//For every level, we iterate through all its nodes, update the maximum value, and enqueue their children for the next level. 
//Finally, we add the maximum value of each row to the result list and return it.


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // If the tree is empty, return an empty list.
        if (root == null) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>(); // Stores the largest value of each row.
        Queue<TreeNode> q = new LinkedList<>(); // Queue for level-order traversal.
        
        q.add(root); // Start BFS from the root node.

        while (!q.isEmpty()) {
            int level = q.size(); // Number of nodes at the current level.
            int rowMax = Integer.MIN_VALUE; // Initialize max value for the current row.

            // Process all nodes at the current level.
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll(); // Remove the front node from the queue.
                rowMax = Math.max(rowMax, node.val); // Update the max value for the row.

                // Add left and right children to the queue if they exist.
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(rowMax); // Store the largest value found at this level.
        }
        return res; // Return the list of largest values per row.
    }
}


//Depth First Search Approach

// Time Complexity :    O(N) — Each node is visited once, leading to a linear traversal.
// Space Complexity :  O(H) — The recursion stack takes space proportional to the tree height H (worst case O(N) for a skewed tree, O(logN) for a balanced tree).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : We use DFS to traverse the tree, tracking the level of each node to maintain the largest value per level in a list. 
//If a level is encountered for the first time, we add the node’s value; otherwise, we update the maximum value for that level. 
//The recursion explores left and right children while keeping track of the depth. 


class Solution {
    List<Integer> res; // List to store the largest values at each level.
    
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0); // Start DFS traversal from the root at level 0.
        return res;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return; // Base case: if the node is null, return.

        // If it's the first node at this level, add its value to the result list.
        if (level == res.size()) {
            res.add(node.val);
        } else {
            // Update the maximum value at this level.
            res.set(level, Math.max(res.get(level), node.val));
        }

        // Recur for left and right children, increasing the level count.
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
