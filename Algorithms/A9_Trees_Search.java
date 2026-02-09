package Algorithms;

public class A9_Trees_Search {
    // Такая процедура называется Рекурсивный обход в глубину
    public static void main(String[] args) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));
        System.out.println("Сумма для корня дерева: " + root.sum());
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;


        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {
                summ += left.sum();
            }
            if (right != null) {
                summ += right.sum();
            }
            return summ;
        }
    }

}
