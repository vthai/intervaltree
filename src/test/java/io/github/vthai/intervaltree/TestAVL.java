package io.github.vthai.intervaltree;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestAVL {
   @Test
   public void testInsert() {
      AVL avl = new AVL();
      avl.insert(7);
      avl.insert(80);
      avl.insert(9);
      avl.insert(71);
      avl.insert(15);

      List<Node> inOrderNodes = avl.inOrder();
      int previousNumber = -1;
      for (Node node : inOrderNodes) {
         Assert.assertTrue(node.getValue() > previousNumber);

         previousNumber = node.getValue();
         System.out.print("(" + node.getValue() + "," + node.getHeight() + "),");
      }
      System.out.println();
   }

   @Test
   public void testInsertPrintPreOrder() {
      AVL avl = new AVL();
      avl.insert(100);
      avl.insert(20);
      avl.insert(200);
      avl.insert(10);
      avl.insert(30);
      avl.insert(150);
      avl.insert(220);

      List<Node> inOrderNodes = avl.preOrder();
      int[] expectedOrder = { 100, 20, 10, 30, 200, 150, 220 };
      int size = inOrderNodes.size();
      for (int i = 0; i < size; i++) {
         Node node = (Node) inOrderNodes.get(i);
         Assert.assertEquals(expectedOrder[i], node.getValue());

         System.out.print("(" + node.getValue() + "," + node.getHeight() + "),");
      }
      System.out.println();
   }

   @Test
   public void testInsertPreSort() {
      AVL avl = new AVL();
      avl.insert(100);
      avl.insert(102);
      avl.insert(105);
      avl.insert(108);
      avl.insert(200);

      List<Node> inOrderNodes = avl.inOrder();
      int previousNumber = -1;
      for (Node node : inOrderNodes) {
         Assert.assertTrue(node.getValue() > previousNumber);

         previousNumber = node.getValue();
         System.out.print("(" + node.getValue() + "," + node.getHeight() + "),");
      }
      System.out.println();
   }

   @Test
   public void testInsertPreSortReverse() {
      AVL avl = new AVL();
      avl.insert(500);
      avl.insert(302);
      avl.insert(205);
      avl.insert(108);
      avl.insert(20);

      List<Node> inOrderNodes = avl.inOrder();
      int previousNumber = -1;
      for (Node node : inOrderNodes) {
         Assert.assertTrue(node.getValue() > previousNumber);

         previousNumber = node.getValue();
         System.out.print("(" + node.getValue() + "," + node.getHeight() + "),");
      }
      System.out.println();
   }
}
