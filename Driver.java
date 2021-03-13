public class Driver
{
   public static void main()
   {
       BST bst = new BST();
       for(int i = 0; i < 100; i++)
       {
           bst.insert((int) (Math.random()*100));
       }
       bst.printTree();
       bst.delete(bst.root.key);
       System.out.println();
       System.out.println();
       System.out.println();
       bst.printTree();
      
       bst.search((int) (Math.random()*100));
       bst.search((int) (Math.random()*100));
       bst.search((int) (Math.random()*100));
       bst.search((int) (Math.random()*100));
       
   }
}
