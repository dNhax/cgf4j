package de.dnhax.cgf4j.api;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dnhax.cgf4j.api.controller.GeneratorController;

public class Generator {

  private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);

  private String targetPath;
  private List<String> generatorTypes;

  public Generator(String targetPath, List<String> generatorTypes) {
    this.targetPath = targetPath;
    this.generatorTypes = generatorTypes;
  }

  public void generate() {
    if (StringUtils.isBlank(targetPath)) {
      LOGGER.error("'targetPath' must not be [null]");
    } else {
      LOGGER.info("Starting generation...");
      Weld weld = new Weld(getClass().getName());
      try (WeldContainer weldContainer = weld.initialize()) {
        GeneratorController generatorController = weldContainer.select(GeneratorController.class).get();
        generatorController.delegate(targetPath, generatorTypes);
      }
      LOGGER.info("Finished generation!");
    }
  }

}
