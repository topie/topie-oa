package com.topie.bpm.cmd;

import com.topie.bpm.graph.ActivitiHistoryGraphBuilder;
import com.topie.bpm.graph.Graph;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindHistoryGraphCmd implements Command<Graph> {
    private static Logger logger = LoggerFactory
            .getLogger(FindHistoryGraphCmd.class);
    private String processInstanceId;

    public FindHistoryGraphCmd(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Graph execute(CommandContext commandContext) {
        return new ActivitiHistoryGraphBuilder(processInstanceId).build();
    }
}
