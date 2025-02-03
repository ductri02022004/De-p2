package binarySearchTree;

public class Main {
    public static void main(String[] args) {
        MyBSTree myBSTree = new MyBSTree();
        myBSTree.insert(new Car("A",8));
        myBSTree.insert(new Car("A",4));
        myBSTree.insert(new Car("A",12));
        myBSTree.insert(new Car("A",2));
        myBSTree.insert(new Car("A",6));
        myBSTree.insert(new Car("A",10));
        myBSTree.insert(new Car("A",14));
        myBSTree.insert(new Car("A",1));
        myBSTree.insert(new Car("A",3));
        myBSTree.insert(new Car("A",5));
        myBSTree.insert(new Car("A",7));
        myBSTree.insert(new Car("A",7));
        myBSTree.insert(new Car("A",9));
        myBSTree.insert(new Car("A",11));
        myBSTree.insert(new Car("A",13));
        myBSTree.insert(new Car("A",15));
        myBSTree.insert(new Car("A",15));
        // Xóa
//      myBSTree.deleteByCopying(4);
        // Duyệt
//        myBSTree.deleteByMerging(4);
        myBSTree.rightRotate(8);
        System.out.println("PRE-ORDER");
        myBSTree.preOrder();
        System.out.println();
        System.out.println("POST-ORDER");
        myBSTree.postOrder();
        System.out.println();
        System.out.println("IN-ORDER");
        myBSTree.inOrder();
        System.out.println();
        System.out.println("BREADTH_FIRST");
        myBSTree.breadth_First();
        System.out.println();
//        myBSTree.root.left.info.name = "B";
//        myBSTree.root.left.info.price = 100;
//        myBSTree.breadth_First();
//        System.out.println();
//        Find father
//        System.out.println(myBSTree.findFather(7));
//        myBSTree = new MyBSTree(); // nếu empty Tree
//        System.out.println(myBSTree.findFather(18));

    }
}
