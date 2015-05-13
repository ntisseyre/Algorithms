using Algorithms.Trees.Domain;
using System;
using System.Collections.Generic;

namespace Algorithms.Trees
{
    class IfRouteExistsInGraph : IAlgorithm
    {
        private GraphNode<int> node;

        public void ReadInput()
        {
            throw new NotImplementedException();
        }

        public void Execute()
        {
            throw new NotImplementedException();
        }

        private static bool Algorithm(GraphNode<int> from, GraphNode<int> to)
        {
            Queue<GraphNode<int>> queue = new Queue<GraphNode<int>>();
            queue.Enqueue(from);

            while (queue.Count != 0)
            {
                var node = queue.Dequeue();

                foreach (var adjacentNode in node.AdjacentNodes)
                {
                    if (adjacentNode.Data == to.Data)
                        return true;

                    if (adjacentNode.State != State.Unvisited)
                        continue;

                    adjacentNode.State = State.Visiting;
                    queue.Enqueue(adjacentNode);
                }

                node.State = State.Visited;
            }

            return false;
        }
    }
}
