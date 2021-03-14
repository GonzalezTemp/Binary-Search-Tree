
package mysearchtree;

public class MySearchTree <N> {
    
    static class Node
    {
        int value;
        Node Left;
        Node Right;
        
        public Node(int val)
        {
            value = val;
            Left = null;
            Right = null;
        }
    }
    
    Node root = null;
    int height = 0;
    
    void add(int val)
    {
        root = add(root, val);
    }
    
    Node add(Node current, int val)
    {
        if(current == null)
        {
            current = new Node(val);
            return current;
        }
        
        if(current.value > val)
        {
            current.Left = add(current.Left, val);
        }
        
        if(current.value < val)
        {
            current.Right = add(current.Right, val);
        }
        return current;
    }
    
    boolean find(int val)
    {
        return find(root, val);
    }
    
    boolean find(Node current, int val)
    {
        
        if(current == null)
        {
            return false;
        }
        
        if(current.value == val)
        {
            return true;
        }
        
        if(current.value < val)
        {
            return find(current.Right, val);
        }
        
        if(current.value > val)
        {
            return find(current.Left, val);
        }
        
        return false;
    }
    
    int leafCount()
    {
        return leafCount(root);
    }
    
    int leafCount(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        int lleaves = leafCount(current.Left);
        int rleaves = leafCount(current.Right);
        
        if(current.Left == null && current.Right == null)
        {
            return (lleaves + rleaves + 1);
        }
        
        return (lleaves + rleaves);
    }
    
    int parentCount()
    {
        return parentCount(root);
    }
    
    int parentCount(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        int lparent = parentCount(current.Left);
        int rparent = parentCount(current.Right);
        
        if(current.Right != null || current.Left != null)
        {
            return (lparent + rparent + 1);
        }
        
        return (lparent + rparent);
    }
    
    int height()
    {
        height = height(root);
        return height;
    }
    
    int height(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        int lheight = height(current.Left);
        int rheight = height(current.Right);
        
        if(lheight > rheight)
        {
            return (lheight + 1);
        }
        else
        {
            return (rheight + 1);
        }
    }
    
    boolean isPerfect()
    {
        return isPerfect(root, height, 1);
    }
    
    boolean isPerfect(Node current, int max, int floor)
    {
        if(current == null)
        {
            return false;
        }
        if(current.Left == null && current.Right == null)
        {
            if(max == floor)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        if(current.Left == null || current.Right == null)
        {
            return false;
        }
        
        return isPerfect(current.Left, max, floor + 1) && isPerfect(current.Right, max, floor + 1);
    }
    
    void ancestors(int val)
    {
        ancestors(root, val);
    }
    
    boolean ancestors(Node current, int val)
    {
        if(current != null)
        {
            if(current.value == val)
            {
                return true;
            }
            else
            {
                boolean lancestor = ancestors(current.Left, val);
                boolean rancestor = ancestors(current.Right, val);
                if(lancestor)
                {
                    System.out.println(current.value);
                    return true;
                }
                if(rancestor)
                {
                    System.out.println(current.value);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    void inOrderPrint()
    {
        inOrderPrint(root);
    }
    
    void inOrderPrint(Node current)
    {
        if(current != null)
        {
            inOrderPrint(current.Left);
            System.out.println(current.value);
            inOrderPrint(current.Right);
        }
    }
    
    void preOrderPrint()
    {
        preOrderPrint(root);
    }
    
    void preOrderPrint(Node current)
    {
        if(current != null)
        {
            inOrderPrint(current.Left);
            inOrderPrint(current.Right);
            System.out.println(current.value);
        }
    }
    
    public static void main(String[] args) {
        MySearchTree<Node> Tree = new MySearchTree<Node>();
    
        Tree.add(10);
        Tree.add(5);
        Tree.add(15);
        Tree.add(12);
        Tree.add(17);
        Tree.add(3);
        Tree.add(7);
        Tree.add(20);
        Tree.add(9);
        Tree.add(16);
        Tree.add(6);
        Tree.add(4);
        Tree.add(1);
        Tree.add(13);
        Tree.add(11);
        
        System.out.println("--------");
        System.out.println("The ancestors of 6");
        Tree.ancestors(6);
        System.out.println("--------");
        System.out.println("The number of parents");
        System.out.println(Tree.parentCount());
        System.out.println("--------");
        System.out.println("The numbe of leaves");
        System.out.println(Tree.leafCount());
        System.out.println("--------");
        System.out.println("Find 16");
        System.out.println(Tree.find(21));
        System.out.println("--------");
        System.out.println("Find 15");
        System.out.println(Tree.find(15));
        System.out.println("--------");
        System.out.println("The height of the tree");
        System.out.println(Tree.height());
        System.out.println("--------");
        System.out.println("Is this tree perfect");
        System.out.println(Tree.isPerfect());
        System.out.println("--------");
        System.out.println("Inorder Print");
        Tree.inOrderPrint();
        System.out.println("--------");
        System.out.println("Preorder Print");
        Tree.preOrderPrint();
        System.out.println("--------");
    }
    
}
