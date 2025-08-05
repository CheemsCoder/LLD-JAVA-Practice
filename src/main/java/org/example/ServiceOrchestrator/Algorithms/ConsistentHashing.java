package org.example.ServiceOrchestrator.Algorithms;

import org.example.ServiceOrchestrator.Model.Node;
import org.example.ServiceOrchestrator.Model.Request;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConsistentHashing implements Router{
    private final Map<Node, List<Long>> nodePositions;
    private final ConcurrentHashMap<Long, Node> nodeMappings;
    private final Function<String, Long> hashFunction;
    private final int pointMultiplier;


    public ConsistentHashing(
            final Function<String, Long> hashFunction, final int pointMultiplier) {
        if (pointMultiplier == 0) {
            throw new IllegalArgumentException();
        }
        this.nodePositions = new ConcurrentHashMap<>();
        this.nodeMappings = new ConcurrentHashMap<>();
        this.hashFunction = hashFunction;
        this.pointMultiplier = pointMultiplier;
    }

    @Override
    public void addNode(final Node node) {
        nodePositions.put(node, new ArrayList<>());
        for(int i=0;i<pointMultiplier;i++) {
            for(int j=0;j<node.getWeight();j++) {
                final var point = hashFunction.apply((i*pointMultiplier)+j+node.getId());
                nodePositions.get(node).add(point);
                nodeMappings.put(point, node);
            }
        }
    }

    @Override
    public void removeNode(final Node node) {
        for(Long point : nodePositions.get(node)) {
            nodeMappings.remove(point);
        }
        nodePositions.remove(node);
    }

    @Override
    public Node getAssignedNode(final Request request) {
        final var key = hashFunction.apply(request.getId());
        final var entry = nodeMappings.get(key);
        return entry;
    }
}
