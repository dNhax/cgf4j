package de.dnhax.cgf4j.example.generators

import de.dnhax.cgf4j.api.generator.FileGenerator
import de.dnhax.cgf4j.api.generator.GeneratorTypes

@GeneratorTypes("test")
class ExampleTestGenerator extends FileGenerator {

  override protected getFileRelativePath() {
    "src/test/java/de/dnhax/cgf4j/example/file"
  }

  override protected getFileName() {
    "ExampleFileTest"
  }

  override protected getFileExtension() {
    "java"
  }

  override protected getFileContent() '''
    package de.dnhax.cgf4j.example.file;
    
    import org.junit.Test;
    
    public class ExampleFileTest {
      
      @Test
      public void testExampleFile() {
        ExampleFile.main(null);
      }
    }
  '''

}
