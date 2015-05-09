using System;
using System.Collections;
using System.ComponentModel;

namespace Algorithms
{
    public static class IOHelper
    {
        public static ConsoleColor ColorInput = ConsoleColor.Green;
        public static ConsoleColor ColorResult = ConsoleColor.Yellow;
        public static ConsoleColor ColorError = ConsoleColor.Red;

        public static char[] ReadString()
        {
            Console.ForegroundColor = IOHelper.ColorInput;
            Console.WriteLine("Enter a string:");

            Console.ForegroundColor = ConsoleColor.White;
            return Console.ReadLine().ToCharArray();
        }

        public static TValue[] ReadArray<TValue>()
        {
            Console.ForegroundColor = IOHelper.ColorInput;
            Console.WriteLine("Enter elements:");

            Console.ForegroundColor = ConsoleColor.White;
            string input = Console.ReadLine();
            if(string.IsNullOrEmpty(input))
                return null;

            var itemsStr = input.Split(',');

            var items = new TValue[itemsStr.Length];
            for (int c = 0; c < items.Length; c++)
            {
                items[c] = (TValue)TypeDescriptor
                    .GetConverter(typeof(TValue))
                    .ConvertFromInvariantString(itemsStr[c]);
            }

            return items;
        }

        public static void PrintString(char[] items)
        {
            foreach (var item in items)
                Console.Write(item);
        }

        public static void PrintArray(IEnumerable items)
        {
            int c = 0;
            foreach (var item in items)
            {
                Console.Write(string.Format("{0}{1}",
                    ((c++ == 0) ? "" : ", "),
                    item));
            }
        }
    }
}
