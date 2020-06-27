package de.dnhax.cgf4j.example.generators

import de.dnhax.cgf4j.api.generator.FileGenerator
import de.dnhax.cgf4j.api.generator.GeneratorTypes

@GeneratorTypes("main")
class ExampleGenerator extends FileGenerator {

  override protected getFileRelativePath() {
    "src/main/java/de/dnhax/cgf4j/example/file"
  }

  override protected getFileName() {
    "ExampleFile"
  }

  override protected getFileExtension() {
    "java"
  }

  override protected getFileContent() '''
    package de.dnhax.cgf4j.example.file;
    
    public class ExampleFile {
      
      public static void main(String[] args) {
        // TODO add code here
        System.out.println("Please add some code!");
      }
    }
  '''

}
