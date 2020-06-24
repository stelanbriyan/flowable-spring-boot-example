package org.flowable.examples.spring.boot.camel;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

import java.util.HashMap;
import java.util.Map;

public class InitialiseVariables implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("input", "Hello");

        Map<String, Object> outputMap = new HashMap<>();
        variables.put("outputMap", outputMap);

        execution.setVariables(variables);

        System.out.println("Input: " + execution.getVariable("input"));
    }

}
