using Algorithms.Arrays;
using Algorithms.Sortings;

namespace Algorithms
{
    class Program
    {
        static void Main(string[] args)
        {
            var algorithm = new MaxProductOfSubArray();

            algorithm.ReadInput();
            algorithm.Execute();
        }
    }
}
