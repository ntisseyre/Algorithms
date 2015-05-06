using Algorithms.Core;
using System;
using System.Collections.Generic;
using System.ComponentModel;

namespace Algorithms.Trees.Domain
{
    class TreeNode<TData>
    {
        private const string YES = "yes";
        private const string NULL = "N";

        public TData Data { get; set; }

        public TreeNode<TData> Left { get; set; }

        public TreeNode<TData> Right { get; set; }

        public static void Print(TreeNode<TData> root)
        {
            if (root == null)
                return;

            Console.ForegroundColor = IOHelper.ResultColor;

            Queue<TreeNode<TData>> queue = new Queue<TreeNode<TData>>();
            queue.Enqueue(root);

            int level = 0;
            int expected = 1;
            while (queue.Count != 0)
            {
                var node = queue.Dequeue();

                Console.Write(string.Format(" {0} ", node == null ? "null" : node.Data.ToString()));

                if (node != null)
                {
                    queue.Enqueue(node.Left);
                    queue.Enqueue(node.Right);
                }

                expected--;

                if (expected == 0)
                {
                    Console.WriteLine();
                    level++;
                    expected = 1 << level;
                }
            }
        }

        public static TreeNode<TData> Create()
        {
            TreeNode<TData> root = null;

            Console.ForegroundColor = IOHelper.InputColor;

            string input;
            Queue<TreeNode<TData>> queue = new Queue<TreeNode<TData>>();

            int level = 0;
            while (!(input = Console.ReadLine()).Equals(YES, StringComparison.InvariantCultureIgnoreCase))
            {
                var parentNode = (queue.Count != 0) ? queue.Dequeue() : null;

                int exptected = 1 << level;
                bool isLeft = true;
                foreach (var node in ParseNodes(input))
                {
                    exptected--;

                    if (isLeft)
                    {
                        if (parentNode != null)
                            parentNode.Left = node;
                    }
                    else
                    {
                        if (parentNode != null)
                            parentNode.Right = node;

                        if (exptected != 0)
                            parentNode = queue.Dequeue();
                    }
                    isLeft = !isLeft;


                    if (root == null)
                        root = node;

                    queue.Enqueue(node);
                }

                level++;
            }

            return root;
        }

        private static List<TreeNode<TData>> ParseNodes(string input)
        {
            List<TreeNode<TData>> result = new List<TreeNode<TData>>();

            foreach (var nodeStr in input.Split(' '))
            {
                if (string.IsNullOrEmpty(nodeStr))
                    continue;

                var node = ParseNode(nodeStr);
                result.Add(node);
            }

            return result;
        }

        private static TreeNode<TData> ParseNode(string nodeStr)
        {
            if (nodeStr.Equals(NULL, StringComparison.InvariantCultureIgnoreCase))
                return null;

            return new TreeNode<TData>
            {
                Data = (TData)TypeDescriptor
                        .GetConverter(typeof(TData))
                        .ConvertFromInvariantString(nodeStr)
            };
        }
    }
}
