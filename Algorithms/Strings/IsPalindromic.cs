using System;

namespace Algorithms.Strings
{
    class IsPalindromic : IAlgorithm
    {
        private char[] items;

        public void Execute()
        {
            bool result = Algorithm(this.items);

            Console.ForegroundColor = IOHelper.ResultColor;
            Console.WriteLine(result);
        }

        public void ReadInput()
        {
            this.items = IOHelper.ReadString();
            Console.WriteLine();
        }

        private static bool Algorithm(char[] letters)
        {
            // O(n) - traverse a string from beginning and end
            int begin = 0;
            int end = letters.Length - 1;

            while (begin < end)
            {
                while (begin < end && !Char.IsLetterOrDigit(letters[begin]))
                    begin++;

                while (begin < end && !Char.IsLetterOrDigit(letters[end]))
                    end--;

                if (letters[begin++] != letters[end--])
                    return false;
            }

            return true;
        }
    }
}
