package de.dnhax.cgf4j.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dnhax.cgf4j.api.generator.FileGenerator;
import de.dnhax.cgf4j.api.generator.GeneratorTypes;

public class GeneratorController {

  private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorController.class);

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
    if (CollectionUtils.isEmpty(generatorTypes)) {
      LOGGER.info("No 'generatorTypes' specified, using all available generators.");
      return stream.collect(Collectors.toList());
    } else {
      LOGGER.info("Using generators with types {}.", generatorTypes);
      return stream.filter(generator -> matchesGeneratorType(generator, generatorTypes)).collect(Collectors.toList());
    }
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
