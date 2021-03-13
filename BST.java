public class BST
{
    Node root;
    public BST()
    {
       root = null;
    }
    public void insert(int key)
    {
        root = insertRecursive(root, key);
    }
    public Node insertRecursive(Node root, int thisKey)
    {
        if (root == null)
        {
            root = new Node(thisKey);
            return root;
        }
        if (thisKey < root.key)
        {
            root.left = insertRecursive(root.left, thisKey);
        }
        else if (thisKey > root.key)
        {
            root.right = insertRecursive(root.right, thisKey);
        }
        return root;
    }
    public void search(int thisKey)
    {
        Node node = searchRecursive(root, thisKey);
        if(node != null)
        {
            System.out.println("The value " + node.key + " was found in the tree");
        }   
        else
        {
            System.out.println("The value " + thisKey + " was not found in the tree");
        }
        
    
    }
    public Node searchRecursive(Node root, int thisKey)
    {
        if(root.key == thisKey)
        {
            return root;
        }
        if(root.left != null && thisKey < root.key)
        {
            return searchRecursive(root.left, thisKey);
        }
        else if(root.right != null && thisKey > root.key)
        {
            return searchRecursive(root.right, thisKey);
        }
        else {
            return null;
        }
    }
    public void delete(int thisKey)
    {
        root = deleteRecursive(root, thisKey);
    }
    public Node deleteRecursive(Node root, int thisKey)
    {
        if(root.key == thisKey)
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }
            else if(root.right == null && root.left != null)
            {
                return root.left;
            }
            else if(root.left == null && root.right != null)
            {
                return root.right;
            }
            return findGreatestLeastValue(root.right, root);
        } 
        if(root.left != null && thisKey < root.key)
        {
            root.left = deleteRecursive(root.left, thisKey);
        }
        else if(root.right != null && thisKey > root.key)
        {
            root.right = deleteRecursive(root.right, thisKey);
        }
        return root;
    }
    public Node findGreatestLeastValue(Node root, Node originalRoot)
    {
        if(root.left != null)
        {
            root = findGreatestLeastValue(root.left, originalRoot);
        }
        root.left = originalRoot.left;
        return root;
    }
    public void printTree()
    {
        printTreeRecursive(root);
    }
    public Node printTreeRecursive(Node root)
    {
        if(root == null)
        {
            return null;
        }
        printTreeRecursive(root.left);
        System.out.println(root.key);
        printTreeRecursive(root.right);
        return null;
    }
   
 }
