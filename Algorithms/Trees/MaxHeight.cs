using Algorithms.Core;
using Algorithms.Trees.Domain;
using System;

namespace Algorithms.Trees
{
    class MaxHeight : IAlgorithm
    {
        private TreeNode<int> root;

        public void Execute()
        {
            int maxHeight = Algorithm(this.root);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine(string.Format("Max height: {0}", maxHeight));
        }

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();
        }

        private static int Algorithm(TreeNode<int> root)
        {
            return PostOrder(root, 0);
        }

        private static int PostOrder(TreeNode<int> node, int height)
        {
            if (node == null)
                return height - 1;

            var leftHeight = PostOrder(node.Left, height + 1);
            var rightHeight = PostOrder(node.Right, height + 1);

            return Math.Max(leftHeight, rightHeight);
        }
    }
}
