using Algorithms.Trees.Domain;
using System;
using System.Collections.Generic;

namespace Algorithms.Trees
{
    class IsBst : IAlgorithm
    {
        private TreeNode<int> root;

        public void ReadInput()
        {
            this.root = TreeNode<int>.Create();
        }

        public void Execute()
        {
            var result = Algorithm(this.root);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine(string.Format("Is BST? {0}", result));
        }

        private static bool Algorithm(TreeNode<int> root)
        {
            var queue = new Queue<TreeContext<int>>();
            queue.Enqueue(new TreeContext<int>
            {
                Node = root,
                Min = int.MinValue,
                Max = int.MaxValue
            });

            while (queue.Count != 0)
            {
                var context = queue.Dequeue();

                if (context.Node.Data > context.Max || context.Node.Data < context.Min)
                    return false;

                if (context.Node.Left != null)
                {
                    queue.Enqueue(new TreeContext<int>
                    {
                        Node = context.Node.Left,
                        Min = context.Min,
                        Max = context.Node.Data
                    });
                }

                if (context.Node.Right != null)
                {
                    queue.Enqueue(new TreeContext<int>
                    {
                        Node = context.Node.Right,
                        Min = context.Node.Data,
                        Max = context.Max
                    });
                }
            }

            return true;
        }

        class TreeContext<TValue>
        {
            public TreeNode<TValue> Node { get; set; }

            public TValue Min { get; set; }

            public TValue Max { get; set; }
        }
    }
}
