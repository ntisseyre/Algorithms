using Algorithms.Arrays;
using Algorithms.Heaps;
using Algorithms.Sortings;

namespace Algorithms
{
    class Program
    {
        static void Main(string[] args)
        {
            var algorithm = new MergeSort();

            algorithm.ReadInput();
            algorithm.Execute();
        }
    }
}
