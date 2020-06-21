package de.dnhax.cgf4j.api;

import org.apache.commons.lang3.StringUtils;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dnhax.cgf4j.api.controller.GeneratorController;

public class Generator {

  private static final Logger LOGGER = LoggerFactory.getLogger(Generator.class);

  private String targetPath;

  public Generator(String targetPath) {
    this.targetPath = targetPath;
  }

  public void generate() {
    if (StringUtils.isBlank(targetPath)) {
      LOGGER.error("'targetPath' must not be [null]");
      return;
    }

    Weld weld = new Weld(getClass().getName());
    try (WeldContainer weldContainer = weld.initialize()) {
      GeneratorController generatorController = weldContainer.select(GeneratorController.class).get();
      generatorController.delegate(targetPath);
    }
  }

}
