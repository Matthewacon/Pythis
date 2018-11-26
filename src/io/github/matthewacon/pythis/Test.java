package io.github.matthewacon.pythis;

import io.github.matthewacon.delphos.ParserTree;
import io.github.matthewacon.delphos.api.IParser;

public class Test {
 public static void main(String[] args) {
  final IParser<ClassFile.ConstantPool.ClassInfo> parser = ParserTree.construct(ClassFile.ConstantPool.ClassInfo.class);

 }
}
