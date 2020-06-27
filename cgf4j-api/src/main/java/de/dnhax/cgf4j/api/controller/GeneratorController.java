package de.dnhax.cgf4j.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;

import de.dnhax.cgf4j.api.generator.FileGenerator;
import de.dnhax.cgf4j.api.generator.GeneratorTypes;

public class GeneratorController {

  @Inject
  @Any
  private Instance<FileGenerator> generators;

  public void delegate(String targetPath, List<String> generatorTypes) {
    List<FileGenerator> filteredGenerators = getMatchingGenerators(generatorTypes);
    for (FileGenerator generator : filteredGenerators) {
      generator.generate(targetPath);
    }
  }

  private List<FileGenerator> getMatchingGenerators(List<String> generatorTypes) {
    Stream<FileGenerator> stream = getStream();
    return CollectionUtils.isEmpty(generatorTypes) ? stream.collect(Collectors.toList())
        : stream.filter(generator -> matchesGeneratorType(generator, generatorTypes)).collect(Collectors.toList());
  }

  private Stream<FileGenerator> getStream() {
    return StreamSupport.stream(generators.spliterator(), false);
  }

  private boolean matchesGeneratorType(FileGenerator generator, List<String> generatorTypes) {
    GeneratorTypes generatorType = generator.getClass().getAnnotation(GeneratorTypes.class);
    if (generatorType != null) {
      return CollectionUtils.containsAny(generatorTypes, generatorType.value());
    }
    return false;
  }

}
