package org.flowable.examples.spring.boot.engine.servicetask;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class PrintDocumentGenerate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Task 1");
    }
}
