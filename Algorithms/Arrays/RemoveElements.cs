using Algorithms.Core;
using System;

namespace Algorithms.Arrays
{
    class RemoveElements : IAlgorithm
    {
        private int removeMe;
        private int[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadArray<int>(); 
            
            Console.ForegroundColor = IOHelper.InputColor;
            Console.WriteLine("Enter an element to remove from an array:");

            Console.ForegroundColor = ConsoleColor.Red;
            this.removeMe = Int32.Parse(Console.ReadLine());

            Console.WriteLine();
        }

        public void Execute()
        {
            //Action
            int newSize = Algorithm(this.removeMe, this.items);

            //Print result
            Console.ForegroundColor = IOHelper.ResultColor;

            Console.WriteLine(string.Format("new size: {0}", newSize));
            IOHelper.PrintArray(this.items);

            Console.WriteLine();
        }

        private static int Algorithm(int removeMe, int[] items)
        {
            int writeIndex = 0;

            for (int readIndex = 0; readIndex < items.Length; readIndex++)
            {
                if (items[readIndex] != removeMe)
                {
                    items[writeIndex++] = items[readIndex];
                }
            }

            return writeIndex;
        }
    }
}
