using System;

namespace Algorithms.Arrays
{
    class NextPermutation : IAlgorithm
    {
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var result = Algorithm(this.items);

            Console.ForegroundColor = IOHelper.ColorResult;
            Console.WriteLine("Next permutation:");
            IOHelper.PrintArray(result);
            Console.WriteLine();
        }

        private static int[] Algorithm(int[] items)
        {
            int minIndex = 0;
            int swapIndex = 0;

            for (int c = 0; c < items.Length - 1; c++)
            {
                if (items[c] < items[c + 1])
                {
                    swapIndex = c;
                    minIndex = c + 1;
                }
                else if (items[c] < items[minIndex] && items[minIndex] >= items[swapIndex])
                {
                    minIndex = c;
                }
            }

            var tmp = items[swapIndex];
            items[swapIndex] = items[minIndex];
            items[minIndex] = tmp;


            for (int c = swapIndex + 1, i = items.Length - 1; c < (swapIndex + 1 + items.Length) / 2; c++, i--)
            {
                tmp = items[c];
                items[c] = items[i];
                items[i] = tmp;
            }
            return items;
        }

        private static int[] Algorithm2(int[] items)
        {
            int k = items.Length - 2;
            while (k >= 0 && items[k] >= items[k + 1])
                --k;

            if (k == -1)
                return null;

            //Find the smallest entry after index K tath is bigger than items[k]
            int l = 0;
            for (int i = k + 1; i < items.Length; i++)
            {
                if (items[i] > items[k])
                    l = i;
                else
                    break;
            }

            var tmp = items[k];
            items[k] = items[l];
            items[l] = tmp;

            for (int c = k + 1, i = items.Length-1; c < (k + 1 + items.Length) / 2; c++, i--)
            {
                tmp = items[c];
                items[c] = items[i];
                items[i] = tmp;
            }

            return items;
        }
    }
}
