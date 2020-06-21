package de.dnhax.cgf4j.example.generators;

import de.dnhax.cgf4j.api.generator.FileGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ExampleTestGenerator extends FileGenerator {
  @Override
  protected String getFileRelativePath() {
    return "src/test/java/de/dnhax/cgf4j/example/file";
  }
  
  @Override
  protected String getFileName() {
    return "ExampleFileTest";
  }
  
  @Override
  protected String getFileExtension() {
    return "java";
  }
  
  @Override
  protected String getFileContent() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package de.dnhax.cgf4j.example.file;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import org.junit.Test;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ExampleFileTest {");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("@Test");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public void testExampleFile() {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("ExampleFile.main(null);");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
