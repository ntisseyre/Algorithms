using Algorithms.Trees.Domain;
using System;
using System.Collections.Generic;

namespace Algorithms.Trees
{
    class FindPathToNode : IAlgorithm
    {
        private TreeNode<int> root;
        private int findMe;

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();

            Console.WriteLine("Find path to node:");
            this.findMe = Int32.Parse(Console.ReadLine());
        }

        public void Execute()
        {
            Stack<int> path = new Stack<int>();

            var result = Algorithm(path, this.root, this.findMe);

            Console.ForegroundColor = IOHelper.ColorResult;

            while (path.Count > 0)
            {
                var node = path.Pop();
                Console.Write(string.Format("{0} -> ", node));
            }

            Console.Write(string.Format("{0}", result.Data));
            Console.WriteLine();
        }

        private static TreeNode<int> Algorithm(Stack<int> path, TreeNode<int> node, int findMe)
        {
            if (node == null)
                return null;

            if (node.Data == findMe)
                return node;

            var result = Algorithm(path, node.Left, findMe);
            if (result != null)
            {
                path.Push(node.Data);
                return result;
            }

            result = Algorithm(path, node.Right, findMe);
            if (result != null)
            {
                path.Push(node.Data);
                return result;
            }

            return result;
        }
    }
}
