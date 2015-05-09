using System;

namespace Algorithms.Arrays
{
    class RemoveDuplicatesInSorted : IAlgorithm
    {
        private int[] items;

        public void Execute()
        {
            //Action
            int newSize = Algorithm(this.items);

            //Print result
            Console.ForegroundColor = IOHelper.ColorResult;

            Console.WriteLine(string.Format("new size: {0}", newSize));
            IOHelper.PrintArray(this.items);

            Console.WriteLine();
        }

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
            Console.WriteLine();
        }

        private static int Algorithm(int[] items)
        {
            int writeIndex = 0;

            for (int c = 1; c < items.Length; c++)
            {
                if (items[c] != items[writeIndex])
                    items[++writeIndex] = items[c];
            }

            return writeIndex + 1;
        }
    }
}
