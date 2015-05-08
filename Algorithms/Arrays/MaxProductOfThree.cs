using System;

namespace Algorithms.Arrays
{
    class MaxProductOfThree : IAlgorithm
    {
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();
        }

        public void Execute()
        {
            var result = Algorithm(this.items);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine(string.Format("Max product: {0}", result));
            Console.WriteLine();
        }

        private static int Algorithm(int[] items)
        {
            //max will be max(max1*max2*max3, max1*min1*min2)

            int max1, max2, max3, min1, min2;

            max1 = Math.Max(items[0], items[1]);
            max2 = Math.Min(items[0], items[1]);

            if (items[2] > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = items[2];
            }
            else if (items[2] > max2)
            {
                max3 = max2;
                max2 = items[2];
            }
            else
            {
                max3 = items[2];
            }

            min1 = max3;
            min2 = max2;

            for (int c = 3; c < items.Length; c++)
            {
                if (items[c] > max1)
                {
                    max3 = max2;
                    max2 = max1;
                    max1 = items[c];
                }
                else if (items[c] > max2)
                {
                    max3 = max2;
                    max2 = items[c];
                }
                else if (items[c] > max3)
                {
                    max3 = items[c];
                }

                if (items[c] < min1)
                {
                    min2 = min1;
                    min1 = items[c];
                }
                else if(items[c] < min2)
                {
                    min2 = items[c];
                }
            }

            return Math.Max(max1 * max2 * max3, max1 * min1 * min2);
        }
    }
}
