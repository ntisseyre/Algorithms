using Algorithms.Trees.Domain;
using System;

namespace Algorithms.Trees
{
    class IsBalanced : IAlgorithm
    {
        private static int NotBalanced = -2;

        private TreeNode<int> root;

        public void Execute()
        {
            bool isBalanced = Algorithm(this.root);

            Console.ForegroundColor = IOHelper.ColorResult;
            Console.WriteLine(string.Format("Is balanced: {0}", isBalanced));
        }

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();
        }

        private bool Algorithm(TreeNode<int> root)
        {
            return PostOrder(root) != NotBalanced;
        }

        private static int PostOrder(TreeNode<int> node)
        {
            if (node == null)
                return -1;

            var leftHeight = PostOrder(node.Left);
            if (leftHeight == NotBalanced)
                return NotBalanced; //Left tree is not balanced

            var rightHeight = PostOrder(node.Right);
            if (rightHeight == NotBalanced)
                return NotBalanced; //Right tree is not balanced

            //Check the difference between left and right subtrees
            if (Math.Abs(leftHeight - rightHeight) > 1)
                return NotBalanced;

            return Math.Max(leftHeight, rightHeight) + 1;
        }
    }
}
