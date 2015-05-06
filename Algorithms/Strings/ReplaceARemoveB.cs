using System;
using System.Collections.Generic;

namespace Algorithms.Strings
{
    class ReplaceARemoveB : IAlgorithm
    {
        private static Dictionary<char, string> RULES = new Dictionary<char, string>
        {
            {',', "{COMMA}"},
            {'.', "{DOT}"},
            {'?', "{QUESTION MARK}"},
            {'!', "{EXCLAMATION MARK}"}
        };

        private char[] items;

        public void ReadInput()
        {
            this.items = IOHelper.ReadString();
            Console.WriteLine();
        }

        public void Execute()
        {
            //Action
            char[] result = Algorithm(this.items);

            //Print result
            IOHelper.PrintString(result);
            Console.WriteLine();
        }

        private static char[] Algorithm(char[] letters)
        {
            int additionalSize = 0;

            // O(n) - Count the new size
            foreach (char letter in letters)
            {
                if (RULES.ContainsKey(letter))
                    additionalSize += RULES[letter].Length - 1;
            }

            // Allocate new size
            char[] result = new char[letters.Length + additionalSize];

            // O(n) - Copy and replace using backward iteration
            int writeIndex = result.Length - 1;
            for (int c = letters.Length - 1; c >= 0; c--)
            {
                if (RULES.ContainsKey(letters[c]))
                {
                    char[] rule = RULES[letters[c]].ToCharArray();
                    for (int i = rule.Length - 1; i >= 0; i--)
                    {
                        result[writeIndex--] = rule[i];
                    }
                }
                else
                {
                    result[writeIndex--] = letters[c];
                }
            }

            return result;
        }
    }
}
