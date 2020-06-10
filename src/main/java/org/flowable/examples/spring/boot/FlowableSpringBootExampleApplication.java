/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.examples.spring.boot;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Filip Hrisafov
 */
@SpringBootApplication
public class FlowableSpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableSpringBootExampleApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner init(final RepositoryService repositoryService,
//								  final RuntimeService runtimeService,
//								  final TaskService taskService) {
//
//		return strings -> {
//			System.out.println("Number of process definitions : "
//					+ repositoryService.createProcessDefinitionQuery().count());
//			System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//			runtimeService.startProcessInstanceByKey("oneTaskProcess");
//			System.out.println("Number of tasks after process start: "
//					+ taskService.createTaskQuery().count());
//		};
//	}
}
