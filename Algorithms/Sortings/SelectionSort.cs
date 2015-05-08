using System;

namespace Algorithms.Sortings
{
    class SelectionSort : IAlgorithm
    {
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var result = Algorithm(this.items);

            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(int[] items)
        {
            for (int c = 0; c < items.Length; c++)
            {
                int minIndex = c;
                for (int j = c + 1; j < items.Length; j++)
                {
                    if (items[minIndex] > items[j])
                    {
                        minIndex = j;
                    }
                }

                if (minIndex != c)
                {
                    var tmp = items[c];
                    items[c] = items[minIndex];
                    items[minIndex] = tmp;
                }
            }

            return items;
        }
    }
}
