package de.dnhax.cgf4j.example.generators;

import de.dnhax.cgf4j.api.generator.FileGenerator;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class ExampleGenerator extends FileGenerator {
  @Override
  protected String getFileRelativePath() {
    return "src/main/java/de/dnhax/cgf4j/example/file";
  }
  
  @Override
  protected String getFileName() {
    return "ExampleFile";
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
    _builder.append("public class ExampleFile {");
    _builder.newLine();
    _builder.append("  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("// TODO add code here");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("System.out.println(\"Please add some code!\");");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
