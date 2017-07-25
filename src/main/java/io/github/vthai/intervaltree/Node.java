package io.github.vthai.intervaltree;

public class Node {
   private int value;
   private Node left;
   private Node right;
   private int height;

   public Node(int value) {
      this.value = value;
   }

   public Node getLeft() {
      return this.left;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public Node getRight() {
      return this.right;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public int getValue() {
      return this.value;
   }

   public int getHeight() {
      return this.height;
   }

   public void setHeight(int height) {
      this.height = height;
   }
}
