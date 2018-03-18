package com.bakitchi.phoapi.dto;


import com.bakitchi.phoapi.entity.TeacherEdgesEntity;
import com.bakitchi.phoapi.entity.TeacherNodesEntity;

import java.util.List;

public class TeacherNetDTO
{
    List<TeacherNodesEntity> nodes;
    List<TeacherEdgesEntity> edges;

    public List<TeacherNodesEntity> getNodes() {
        return nodes;
    }

    public void setNodes(List<TeacherNodesEntity> nodes) {
        this.nodes = nodes;
    }

    public List<TeacherEdgesEntity> getEdges() {
        return edges;
    }

    public void setEdges(List<TeacherEdgesEntity> edges) {
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
