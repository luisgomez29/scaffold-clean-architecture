/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package co.com.bancolombia;

import static co.com.bancolombia.TestUtils.deleteStructure;
import static co.com.bancolombia.TestUtils.getTask;
import static co.com.bancolombia.TestUtils.getTestDir;
import static co.com.bancolombia.TestUtils.setupProject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import co.com.bancolombia.exceptions.CleanException;
import co.com.bancolombia.task.GenerateStructureTask;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

/** A simple unit test for the 'co.com.bancolombia.greeting' plugin. */
class PluginCleanTest {
  private static final String TEST_DIR = getTestDir(PluginCleanTest.class);

  @AfterAll
  static void tearDown() {
    deleteStructure(Path.of(TEST_DIR));
  }

  @Test
  void pluginRegistersATask() {
    // Arrange
    String taskGroup = "Clean Architecture";
    String descriptionTask1 = "Scaffolding clean architecture project";
    String descriptionTask2 = "Generate model in domain layer";
    String descriptionTask3 = "Generate use case in domain layer";
    String descriptionTask4 = "Generate entry point in infrastructure layer";
    String descriptionTask5 = "Generate driven adapter in infrastructure layer";
    String descriptionTask6 = "Validate that project references are not violated";
    String descriptionTask7 = "Generate CI pipeline as a code in deployment layer";
    String descriptionTask8 = "Delete gradle module";
    String descriptionTask9 = "Generate subproject by karate framework in deployment layer";
    String descriptionTask10 = "Generate helper in infrastructure layer";
    Project project = ProjectBuilder.builder().build();

    project.getPlugins().apply("co.com.bancolombia.cleanArchitecture");

    // Act
    Task task = project.getTasks().findByName("cleanArchitecture");
    Task task2 = project.getTasks().findByName("generateModel");
    Task task3 = project.getTasks().findByName("generateUseCase");
    Task task4 = project.getTasks().findByName("generateEntryPoint");
    Task task5 = project.getTasks().findByName("generateDrivenAdapter");
    Task task6 = project.getTasks().findByName("validateStructure");
    Task task7 = project.getTasks().findByName("generatePipeline");
    Task task8 = project.getTasks().findByName("deleteModule");
    Task task9 = project.getTasks().findByName("generateAcceptanceTest");
    Task task10 = project.getTasks().findByName("generateHelper");

    // Assert
    assertEquals(taskGroup, task.getGroup());
    assertEquals(descriptionTask1, task.getDescription());

    assertEquals(taskGroup, task2.getGroup());
    assertEquals(descriptionTask2, task2.getDescription());

    assertEquals(taskGroup, task3.getGroup());
    assertEquals(descriptionTask3, task3.getDescription());

    assertEquals(taskGroup, task4.getGroup());
    assertEquals(descriptionTask4, task4.getDescription());

    assertEquals(taskGroup, task5.getGroup());
    assertEquals(descriptionTask5, task5.getDescription());

    assertEquals(taskGroup, task6.getGroup());
    assertEquals(descriptionTask6, task6.getDescription());

    assertEquals(taskGroup, task7.getGroup());
    assertEquals(descriptionTask7, task7.getDescription());

    assertEquals(taskGroup, task8.getGroup());
    assertEquals(descriptionTask8, task8.getDescription());

    assertEquals(taskGroup, task9.getGroup());
    assertEquals(descriptionTask9, task9.getDescription());

    assertEquals(taskGroup, task10.getGroup());
    assertEquals(descriptionTask10, task10.getDescription());
  }

  @Test
  void shouldApply() throws CleanException, IOException {
    deleteStructure(Path.of(TEST_DIR));
    Project project = setupProject(PluginCleanTest.class, GenerateStructureTask.class);
    GenerateStructureTask generateStructureTask = getTask(project, GenerateStructureTask.class);
    generateStructureTask.execute();

    ProjectBuilder.builder()
        .withName("app-service")
        .withProjectDir(new File(TEST_DIR + "/applications/app-service"))
        .withParent(project)
        .build();

    Plugin<?> applied = project.getPlugins().apply("co.com.bancolombia.cleanArchitecture");
    assertNotNull(applied);
  }
}
