# cgf4j

Code generator framework for Java for easy and quick declaration and usage of code generators.

## How to declare generators

Example generators can be found inside the module `cgf4j-example-generators`. The use of Xtend is optional but recommended because the templating engine is very powerful. See the [Xtend documentation](https://www.eclipse.org/xtend/documentation/203_xtend_expressions.html#templates) for more information.

1. Add `cgf4j-api` and `org.eclipse.xtext.xbase.lib` to your dependencies
2. Include the `xtend-maven-plugin` inside your build
3. Declare classes extending `FileGenerator` from `cgf4j-api`
4. Override the necessary methods to define the relative path, file name, file extension, file content and optionally file encoding of the generated file

## How to use generators

Example generators can be found inside the module `cgf4j-example-usage`.

1. Add the `cgf4j-maven-plugin` to your build and include the dependency to your generator module
2. Configure the `targetPath` and optionally the `generatorTypes` to use
3. Use the `build-helper-maven-plugin` to include the generated files
