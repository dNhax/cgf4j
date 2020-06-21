package de.dnhax.cgf4j.api.generator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FileGenerator {

  private static final Logger LOGGER = LoggerFactory.getLogger(FileGenerator.class);

  protected abstract String getFileRelativePath();

  protected abstract String getFileName();

  protected abstract String getFileExtension();

  protected abstract String getFileContent();

  protected Charset getFileEncoding() {
    return StandardCharsets.UTF_8;
  }

  public void generate(String targetPath) {
    String fullFileName = String.format("%s.%s", getFileName(), getFileExtension());
    Path fullPath = Paths.get(targetPath, getFileRelativePath(), fullFileName);
    try {
      FileUtils.write(fullPath.toFile(), getFileContent(), getFileEncoding());
      LOGGER.info("Writing file {}...", fullPath);
    } catch (IOException e) {
      LOGGER.error("Error writing file {}!", fullPath, e);
    }
  }

}
