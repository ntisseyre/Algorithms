using Algorithms.Core;
using Algorithms.Trees.Domain;
using System;

namespace Algorithms.Trees
{
    class NotKBalancedNode : IAlgorithm
    {
        private int k;
        private TreeNode<int> root;

        public void Execute()
        {
            var node = Algorithm(this.root, this.k);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine(string.Format("Not K balanced: {0}", node.Data));
        }

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();

            Console.WriteLine("Enter the max allowed difference in the number of nodes:");
            this.k = Int32.Parse(Console.ReadLine());
        }

        private TreeNode<int> Algorithm(TreeNode<int> root, int k)
        {
            return PostOrder(root, k).Node;
        }

        private static Result PostOrder(TreeNode<int> node, int maxNodesDiff)
        {
            if (node == null)
                return new Result { Node = null, Count = 0 };

            var leftResult = PostOrder(node.Left, maxNodesDiff);
            if (leftResult.Node != null)
                return leftResult; //Left tree is not k-balanced

            var rightResult = PostOrder(node.Right, maxNodesDiff);
            if (rightResult.Node != null)
                return rightResult; //Right tree is not k-balanced

            int count = leftResult.Count + rightResult.Count + 1;

            //Check the difference between left and right subtrees
            if (Math.Abs(leftResult.Count - rightResult.Count) > maxNodesDiff)
                return new Result { Node = node, Count = count };

            return new Result { Node = null, Count = count };
        }

        struct Result
        {
            public TreeNode<int> Node;
            public int Count;
        };
    }
}
