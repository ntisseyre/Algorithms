using Algorithms.Arrays;
using Algorithms.Heaps;
using Algorithms.Sortings;
using Algorithms.Trees;

namespace Algorithms
{
    class Program
    {
        static void Main(string[] args)
        {
            var algorithm = new FindPathBetweenNodes();

            algorithm.ReadInput();
            algorithm.Execute();
        }
    }
}
