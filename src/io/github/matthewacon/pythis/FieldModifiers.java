package io.github.matthewacon.pythis;

import io.github.matthewacon.delphos.api.annotations.type.TypeAlias;

@TypeAlias(aliasType = int.class, aliasTarget = "value")
public enum FieldModifiers implements FlagConstant<Integer> {
 ACC_PUBLIC(0x0001),
 ACC_PRIVATE(0x0002),
 ACC_PROTECTED(0x0004),
 ACC_STATIC(0x0008),
 ACC_FINAL(0x0010),
 ACC_VOLATILE(0x0040),
 ACC_TRANSIENT(0x0080),
 ACC_SYNTHETIC(0x1000),
 ACC_ENUM(0x4000);

 public final int value;

 FieldModifiers(final int value) {
  this.value = value;
 }

 @Override
 public Integer getValue() {
  return value;
 }
}
