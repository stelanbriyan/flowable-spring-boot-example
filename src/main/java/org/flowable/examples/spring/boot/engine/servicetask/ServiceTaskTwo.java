package org.flowable.examples.spring.boot.engine.servicetask;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class ServiceTaskTwo implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Task 2: PROC ID: " + execution.getProcessInstanceId());
    }

}
