package io.github.vthai.intervaltree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AVL {
   private Node root;

   private int getHeight(Node node) {
      if (node != null) {
         return node.getHeight();
      }
      return 0;
   }

   public void insert(int insertValue) {
      if (this.root == null) {
         this.root = new Node(insertValue);
      } else {
         _insert(insertValue, this.root);
      }
   }

   private Node _insert(int insertValue, Node currentNode) {
      if (currentNode == null) {
         currentNode = new Node(insertValue);
      } else if (insertValue < currentNode.getValue()) {
         currentNode.setLeft(_insert(insertValue, currentNode.getLeft()));
      } else {
         currentNode.setRight(_insert(insertValue, currentNode.getRight()));
      }
      currentNode.setHeight(Math.max(getHeight(currentNode.getLeft()), getHeight(currentNode.getRight())) + 1);
      return currentNode;
   }

   public List<Node> inOrder() {
      List<Node> inOrderResult = new ArrayList<>();
      Stack<Node> stack = new Stack<>();
      Node currentNode = this.root;
      while ((!stack.isEmpty()) || (currentNode != null)) {
         if (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.getLeft();
         } else {
            currentNode = (Node) stack.pop();
            inOrderResult.add(currentNode);
            currentNode = currentNode.getRight();
         }
      }
      return inOrderResult;
   }

   public List<Node> preOrder() {
      List<Node> inOrderResult = new ArrayList<>();
      Node currentNode = this.root;
      if (currentNode == null) {
         return inOrderResult;
      }
      Stack<Node> stack = new Stack<>();
      stack.push(currentNode);
      while (!stack.isEmpty()) {
         currentNode = (Node) stack.pop();
         inOrderResult.add(currentNode);
         if (currentNode.getRight() != null) {
            stack.push(currentNode.getRight());
         }
         if (currentNode.getLeft() != null) {
            stack.push(currentNode.getLeft());
         }
      }
      return inOrderResult;
   }
}
