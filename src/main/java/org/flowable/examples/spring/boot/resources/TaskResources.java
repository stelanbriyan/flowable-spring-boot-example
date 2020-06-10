package org.flowable.examples.spring.boot.resources;

import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.examples.spring.boot.service.MyService;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskResources {

    private Logger log = LoggerFactory.getLogger(TaskResources.class);

    @Autowired
    private MyService myService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("tasks")
    public Map<String, String> getTasks() {
        Map<String, String> tasksMap = new HashMap<>();
        List<Task> tasks = taskService.createTaskQuery().list();
        for (Task task : tasks) {
            tasksMap.put(task.getId(), task.getName());
        }
        return tasksMap;
    }

    @GetMapping("tasks/{processInstaceId}")
    public Map<String, String> getTasksByProcessInstanceId(@PathVariable("processInstaceId") String processInstaceId) {
        Map<String, String> tasksMap = new HashMap<>();

        List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstaceId).list();
        for (Task task : tasks) {
            tasksMap.put(task.getId(), task.getName());
        }

        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(processInstaceId)
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();
        for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }

        return tasksMap;
    }

    @GetMapping("startServiceTask")
    public void startServiceTask() {
        Map<String, Object> values = new HashMap<>();
        values.put("name", null);

        ProcessInstance serviceTaskProcess = runtimeService.startProcessInstanceByKey("serviceTaskProcess", values);

        log.info("process instance: {}", serviceTaskProcess.getProcessInstanceId());
    }
}
