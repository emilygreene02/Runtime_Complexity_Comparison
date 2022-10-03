//package bst;
//import java.util.Objects;
//import org.w3c.dom.Node;

public class Node{
	
    private final int key;
    private Node parent;
    private Node left;
    private Node right;
    
    Node(int k)
    {
        this.key=k;
    }
    
    public void setParent(Node p)
    {
        this.parent=p;
    }
    
    public void setLeft(Node l)
    {
        this.left=l;
    }
    
    public void setRight(Node r)
    {
        this.right=r;
    }
    
    public int getKey()
    {
        return key;
    }
    
    public Node getParent()
    {
        return parent;
    }
    
    public Node getLeft()
    {
        return left;
    }
    
    public Node getRight()
    {
        return right;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder("(");
        sb.append(getKey());
        if(getParent()==null)
        {
            sb.append(",");
        }
        else {
            sb.append(",");
            sb.append(parent.getKey());
        }
        if(getLeft()==null)
        {
            sb.append(",");
        }
        else {
            sb.append(",");
            sb.append(left.getKey());
        }
        if(getRight()==null)
        {
            sb.append(",");
        }
        else {
            sb.append(",");
            sb.append(right.getKey());
        }
        sb.append(")");
        return sb.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        return key == other.key;
    }
}



