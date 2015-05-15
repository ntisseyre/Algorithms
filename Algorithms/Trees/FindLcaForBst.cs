using Algorithms.Trees.Domain;
using System;

namespace Algorithms.Trees
{
    class FindLcaForBst : IAlgorithm
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
            Console.WriteLine(string.Format("Lowest common ancestor: {0}", result.Data));
        }

        private static TreeNode<int> Algorithm(TreeNode<int> root, int first, int second)
        {
            if (root == null)
                return null;

            while (!(first <= root.Data && root.Data < second))
            {
                if (root.Data <= first)
                    root = root.Right;
                else
                    root = root.Left;
            }

            return root;
        }
    }
}
