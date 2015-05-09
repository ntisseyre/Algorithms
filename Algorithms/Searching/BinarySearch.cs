using System;

namespace Algorithms.Searching
{
    class BinarySearch : IAlgorithm
    {
        private int searchMe;
        private int[] items;

        public void Execute()
        {
            var result = Algorithm(this.items, this.searchMe);

            Console.ForegroundColor = IOHelper.ColorResult;
            Console.WriteLine(string.Format("Index: {0}", result));
        }

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>();

            Console.WriteLine("Enter an element to searhch:");
            this.searchMe = Int32.Parse(Console.ReadLine());
        }

        private static int Algorithm(int[] items, int searchMe)
        {
            int result = -1;
            int startIndex = 0;
            int endIndex = items.Length - 1;

            while (startIndex <= endIndex)
            {
                //instead of (start + end)/2 used this equitation to avoid overflow in variable
                int middleIndex = startIndex + ((endIndex - startIndex) >> 1);

                if (items[middleIndex] > searchMe)
                {
                    endIndex = middleIndex - 1;
                }
                else if (items[middleIndex] < searchMe)
                {
                    startIndex = middleIndex + 1;
                }
                else
                {
                    result = middleIndex; //if we need to find any occurancy -> return
                    endIndex = middleIndex - 1; //if we need to find the first occurancy -> keep searching left
                }
            }

            return result;
        }
    }
}
