package com.bakitchi.phoapi.dto;

import com.bakitchi.phoapi.entity.CollegeEdgesEntity;
import com.bakitchi.phoapi.entity.CollegeNodesEntity;

import java.util.List;


public class CollegeNetDTO
{
    List<CollegeNodesEntity> nodes;
    List<CollegeEdgesEntity> edges;

    public List<CollegeNodesEntity> getNodes() {
        return nodes;
    }

    public void setNodes(List<CollegeNodesEntity> nodes) {
        this.nodes = nodes;
    }

    public List<CollegeEdgesEntity> getEdges() {
        return edges;
    }

    public void setEdges(List<CollegeEdgesEntity> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}