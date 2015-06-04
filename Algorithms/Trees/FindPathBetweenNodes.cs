using Algorithms.Trees.Domain;
using System;
using System.Collections.Generic;

namespace Algorithms.Trees
{
    class FindPathBetweenNodes : IAlgorithm
    {
        private TreeNode<int> root;
        private int first;
        private int second;

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();

            Console.WriteLine("First node:");
            this.first = Int32.Parse(Console.ReadLine());

            Console.WriteLine("Second node:");
            this.second = Int32.Parse(Console.ReadLine());
        }

        public void Execute()
        {
            var result = Algorithm(this.root, this.first, this.second);

            Console.ForegroundColor = IOHelper.ColorResult;
            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(TreeNode<int> node, int first, int second)
        {
            Stack<int> firstPath = new Stack<int>();
            FindNode(firstPath, node, first);

            Stack<int> secondPath = new Stack<int>();
            FindNode(secondPath, node, second);

            //Merge Path
            int lca = 0;
            while (firstPath.Peek() == secondPath.Peek())
            {
                firstPath.Pop();
                lca = secondPath.Pop();
            }

            int[] result = new int[firstPath.Count + secondPath.Count + 1];

            int c = firstPath.Count;
            result[c] = lca;
            while (firstPath.Count > 0)
            {
                result[firstPath.Count - 1] = firstPath.Pop();
            }
            while (secondPath.Count > 0)
            {
                result[++c] = secondPath.Pop();
            }

            return result;
        }

        private static TreeNode<int> FindNode(Stack<int> path, TreeNode<int> node, int data)
        {
            if (node == null)
                return null;

            if (node.Data == data)
            {
                path.Push(node.Data);
                return node;
            }

            var result = FindNode(path, node.Left, data);
            if (result != null)
            {
                path.Push(node.Data);
                return result;
            }

            result = FindNode(path, node.Right, data);
            if (result != null)
            {
                path.Push(node.Data);
                return result;
            }

            return result;
        }
    }
}
