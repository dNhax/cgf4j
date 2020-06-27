package de.dnhax.cgf4j.maven.plugin;

import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import de.dnhax.cgf4j.api.Generator;

@Mojo(name = "generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public class GeneratorMojo extends AbstractMojo {

  @Parameter(defaultValue = "${project.build.directory}/generated-sources")
  private String targetPath;

  @Parameter
  private List<String> generatorTypes;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    Generator generator = new Generator(targetPath, generatorTypes);
    generator.generate();
  }

}
