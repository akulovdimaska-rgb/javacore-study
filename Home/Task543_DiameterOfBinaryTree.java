package Home;

public class Task543_DiameterOfBinaryTree {
//Для бинарного дерева root вернуть длину диаметра дерева.
//Диаметр двоичного дерева — это длина самого длинного пути между любыми двумя узлами дерева.
// Этот путь может проходить или не проходить через root.
//Длина пути между двумя узлами равна количеству рёбер между ними.

    // Создадим метод для вычисления максимального диаметра,
    // в котором вызовем вспомогательный метод для вычисления глубины поддерева - это будет рекурсивный метод.
    // в нём мы будем вычислять глубину поддеревьев - длина самого длинного пути от узла до листа, т.е. будем выбирать
    // самую большую глубину - или левую или правую.

    // Это static nested class, он имеет доступ только к static членам внешнего класса
    // и может создаваться без экземпляра внешнего класса
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        // Пустой конструктор - для создания узла с default значениями.
        // Полезно при десериализации или постепенном построении.
        TreeNode() {
        }

        // Конструктор для листьев (узлы без потомков).
        TreeNode(int val) {
            this.val = val;
        }

        // Конструктор для создания родительских узлов с потомками (удобен для построения дерева "снизу вверх").
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        //input root = {1, 2, 3, 4, 5};
        // Необходимо создать дерево
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3));
        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];                         // Создаем массив-контейнер для хранения результата.
        depth(root, maxDiameter);                               // Запускаем рекурсию, начиная от корневого узла.
        return maxDiameter[0];
    }

    private static int depth(TreeNode node, int[] maxDiameter) {
            // для того, чтобы остановить бесконечную рекурсию - мы вышли за лист
            // соответственно глубина 0, за ним нет узла и нет ребра
        if (node == null) {
            return 0;
        }
        int left = depth(node.left, maxDiameter);                   // уходим в лево и создаем новый вызов depth, а текущее состояние сохраняется в стеке
        int right = depth(node.right, maxDiameter);                 // то же самое происходит с правым поддеревом
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);    // При возврате из рекурсии на каждом узле обновляем maxDiameter
        return Math.max(left, right) + 1;                           // Здесь мы возвращаем максимальную глубину из левого и правого поддерева
    }

}
