package io.github.matthewacon.pythis;

import io.github.matthewacon.delphos.api.annotations.type.TypeAlias;

@TypeAlias(aliasType = int.class, aliasTarget = "value")
public enum AccessFlags implements FlagConstant<Integer> {
 ACC_PUBLIC(0x0001),
 ACC_FINAL(0x0010),
 ACC_SUPER(0x0020),
 ACC_INTERFACE(0x0200),
 ACC_ABSTRACT(0x0400),
 ACC_SYNTHETIC(0x1000),
 ACC_ANNOTATION(0x2000),
 ACC_ENUM(0x4000);

 public final int value;

 AccessFlags(final int value) {
  this.value = value;
 }

 @Override
 public Integer getValue() {
  return value;
 }
}
