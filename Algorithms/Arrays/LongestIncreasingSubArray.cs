using System;

namespace Algorithms.Arrays
{
    class LongestIncreasingSubArray
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
            int maxLength = 0;
            int startIndex = 0;

            int tmpStartIndex = 0;
            int tmpLength = 1;

            for (int c = 1; c < items.Length; c++)
            {
                if (items[c - 1] < items[c])
                {
                    tmpLength++;
                }
                else
                {
                    if (maxLength < tmpLength)
                    {
                        maxLength = tmpLength;
                        startIndex = tmpStartIndex;
                    }

                    tmpLength = 1;
                    tmpStartIndex = c;
                }
            }

            if (maxLength < tmpLength)
            {
                maxLength = tmpLength;
                startIndex = tmpStartIndex;
            }


            return new int[] { startIndex, startIndex + maxLength - 1 };
        }
    }
}
