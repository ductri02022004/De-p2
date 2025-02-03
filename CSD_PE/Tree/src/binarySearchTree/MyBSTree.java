package binarySearchTree;


import binarySearchTree.queueForBreadth_First.MyQueue;

public class MyBSTree {
    Node root;
    public MyBSTree(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    // INSERT
    public void insert(Car c){
        Node node = new Node(c);
        if(isEmpty()) root = node;
        else {
            // đi tìm node (cha của node cần add)
            Node current = root;
            Node father = null;
            while(current!=null){
                if(current.info.price == c.price){
                    System.out.println("Key '" + c.price + "' exist ");
                    return;
                }
                father = current;

                if(current.info.price > c.price) current = current.left;
                else current = current.right;
            }
            assert father != null;
            if (father.info.price > c.price) father.left = node;
            else father.right = node;
        }
    }
    // VISIT
    private void visit(Node p){
        if(p==null) return;
        System.out.print(p.info+", ");
    }

    // PRE-ORDER
    private void preOrder(Node p){
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    // POST-ORDER
    public void preOrder(){
        preOrder(root);
    }
    private void postOrder(Node p){
        if(p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    public void postOrder(){
        postOrder(root);
    }

    // IN-ORDER
    private void inOrder(Node p){
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    public void inOrder(){
        inOrder(root);
    }

    //  BREATH-FIRST
    private void breadth_First(Node p){
        if(p==null) return;
        // Xây dựng 1 Queue, mà ở đó value nodeQ chính là Node Tree
        MyQueue my = new MyQueue();
        my.EnQueue(p);
        while(!my.isEmpty()){
            Node q = my.Dequeue();
            if(q.left != null) my.EnQueue(q.left);
            if(q.right!= null) my.EnQueue(q.right);
            visit(q);
        }
    }
    public void breadth_First(){
        breadth_First(root);
    }
   // FIND FATHER NODE
   public Node /* int */ findFather(int key){
        /* tìm và trả về node cha của node có key = input key
           nếu không tìm thấy thì trả về null
         */
        Node current = root;
        Node father = null;
        while(current != null){
            if(current.info.price == key) return father /* father.info.price */;
            father = current;
            current = current.info.price < key ? current.right : current.left;
        }
        return null /*-1*/;
   }
   // SEARCHING
   public Node search(int key){
       // tìm và trả về node có price bằng key
       Node father = findFather(key);
//       if(father == null){
////           if( root.info.price == key) return root;
////           else return null;
//           return root.info.price == key ? root : null;
//       }
//       else {
////           if(father.left.info.price == key) return father.left;
////           else return father.right;
//           return father.left.info.price == key ? father.left : father.right;
//       }
       return father == null ? (root.info.price == key ? root : null) :
               (father.left.info.price == key ? father.left : father.right);
   }

   // Delete
   private void deleteByCopyLeft(Node p){
       if(p==null || p.left == null) return;
       // tìm giá trị ngoài cùng của con bên trái
       if(p.left.right == null){ // con bên trái chính là giá trị ngoài cùng bên phải
           p.info = p.left.info;
           p.left = p.left.left;
           return;
       }
       Node current = p.left.right;
       Node father = p.left;
       while (current.right != null){ // đi tìm node ngoài cùng bên phải của con trái
           father = current;
           current = current.right;
       }
       p.info = current.info;
       father.right = null; // xóa node ngoài cùng bên phải của con trái
   }
    private void deleteByCopyRight(Node p){
        if(p==null || p.right == null) return;
        // tìm giá trị ngoài cùng của con bên trái
        if(p.right.left == null){ // con bên phải chính là giá trị ngoài cùng bên trái
            p.info = p.right.info;
            p.right = p.right.right;
            return;
        }
        Node current = p.right.left;
        Node father = p.right;
        while (current.left != null){ // đi tìm node ngoài cùng bên trái của con phải
            father = current;
            current = current.left;
        }
        p.info = current.info;
        father.left = null; // xóa node ngoài cùng bên trái của con phải
    }
    public void deleteByCopying(int key){
       Node p = search(key);
       deleteByCopyLeft(p);
    }
    private void deleteByMergingLeft(Node p){
       if(p==null || p.left == null) return;
       //đi tìm node ngoài cùng bên phải của con trái
        Node father = findFather(p.info.price);// tìm key của cha
        // Nếu father = null -> p chính là root
        Node current = p.left;
        while (current.right != null) current = current.right;
        current.right = p.right;
        if(father==null) root = root.left;
        else {
            // node cần xóa nằm bên phải node cha
            if(father.info.price < p.info.price) father.right = p.left;
            else father.left = p.left;
        }
    }
    private void deleteByMergingRight(Node p){
        if(p==null || p.right == null) return;
        //đi tìm node ngoài cùng bên phải của con trái
        Node father = findFather(p.info.price);// tìm key của cha
        // Nếu father = null -> p chính là root
        Node current = p.right;
        while (current.left != null) current = current.left;
        current.left = p.left;
        if(father==null) root = root.right;
        else {
            // node cần xóa nằm bên phải node cha
            if(father.info.price < p.info.price) father.left = p.right;
            else father.right = p.right;
        }
    }
    public void deleteByMerging(int key){
       Node p = search(key);
       deleteByMergingLeft(p);
    }
////////////////// Balanced Binary Search Tree ///////////////////////////

    // Rotation
    private Node rightRotate(Node p) {
       if(p == null || p.left == null) return p;
       Node current = p.left;
       Node temp = current.right;
       current.right = p;
       p.left = temp;
       return current;
    }
    public void rightRotate(int key){
       Node p = search(key);
       if(p==null || p.left == null) return;
       Node father = findFather(key);
       Node afterRotate = rightRotate(p);
       if(father==null) root = afterRotate;
       else {
           if(father.left.info.price == key) father.left = afterRotate;
           else father.right = afterRotate;
       }
    }
    private Node leftRotate(Node p) {
        if(p == null || p.right == null) return p;
        Node current = p.right;
        Node temp = current.left;
        current.left = p;
        p.right = temp;
        return current;
    }
    public void leftRotate(int key){
        Node p = search(key);
        if(p==null || p.right == null) return;
        Node father = findFather(key);
        Node afterRotate = leftRotate(p);
        if(father==null) root = afterRotate;
        else {
            if(father.right.info.price == key) father.right = afterRotate;
            else father.left = afterRotate;
        }
    }
}

