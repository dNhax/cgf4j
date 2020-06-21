package de.dnhax.cgf4j.api.controller;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import de.dnhax.cgf4j.api.generator.FileGenerator;

public class GeneratorController {

  @Inject
  @Any
  private Instance<FileGenerator> generators;

  public void delegate(String targetPath) {
    for (FileGenerator generator : generators) {
      generator.generate(targetPath);
    }
  }

}
