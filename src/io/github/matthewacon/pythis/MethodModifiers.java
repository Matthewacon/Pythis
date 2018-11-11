package io.github.matthewacon.pythis;

import io.github.matthewacon.delphos.api.annotations.type.TypeAlias;

@TypeAlias(aliasType = int.class, aliasTarget = "value")
public enum MethodModifiers implements FlagConstant<Integer> {
 ACC_PUBLIC(FieldModifiers.ACC_PUBLIC),
 ACC_PRIVATE(FieldModifiers.ACC_PRIVATE),
 ACC_PROTECTED(FieldModifiers.ACC_PROTECTED),
 ACC_STATIC(0x0008),
 AcC_FINAL(0x0010),
 ACC_SYNCHRONIZED(0x0020),
 ACC_BRIDGE(0x0040),
 ACC_VARARGS(0x0080),
 ACC_NATIVE(0x0100),
 ACC_ABSTRACT(0x0400),
 ACC_STRICT(0x0800),
 ACC_SYNTHETIC(0x1000);

 public final int value;

 MethodModifiers(final int value) {
  this.value = value;
 }

 MethodModifiers(final FlagConstant<Integer> reference) {
  this.value = reference.getValue();
 }

 @Override
 public Integer getValue() {
  return value;
 }
}
