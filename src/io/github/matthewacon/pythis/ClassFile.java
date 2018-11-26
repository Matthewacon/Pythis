package io.github.matthewacon.pythis;

import io.github.matthewacon.delphos.api.AbstractSyntaxTree;
import io.github.matthewacon.delphos.api.annotations.conditional.Constants;
import io.github.matthewacon.delphos.api.annotations.conditional.Verifies;
import io.github.matthewacon.delphos.api.annotations.structural.ArrayLength;
import io.github.matthewacon.delphos.api.annotations.structural.SubtypeCase;

public final class ClassFile implements AbstractSyntaxTree {
 @SubtypeCase(
  variable = "tag",
  verifier = "tag()",
  subtypes = {
   ConstantPool.ClassInfo.class,
   ConstantPool.FieldRefInfo.class,
   ConstantPool.MethodRefInfo.class,
   ConstantPool.InterfaceMethodRef.class,
   ConstantPool.StringInfo.class,
   ConstantPool.IntegerInfo.class,
   ConstantPool.FloatInfo.class,
   ConstantPool.DoubleInfo.class,
   ConstantPool.NameAndTypeInfo.class,
   ConstantPool.UTF8Info.class,
   ConstantPool.MethodHandleInfo.class,
   ConstantPool.MethodTypeInfo.class,
   ConstantPool.InvokeDynamicInfo.class
  }
 )
 //cp_info
 public static abstract class ConstantPool implements AbstractSyntaxTree {
  byte tag;
  //CONSTANT_Class_info
  public static class ClassInfo extends ConstantPool {
   short name_index;

   public static byte tag() {
    return 7;
   }
  }
  //CONSTANT_Fieldref_info
  public static class FieldRefInfo extends ConstantPool {
   short class_index;
   short name_and_type_index;

   public static byte tag() {
    return 9;
   }
  }
  //CONSTANT_MethodRef_info
  public static class MethodRefInfo extends FieldRefInfo {
   public static byte tag() {
    return 10;
   }
  }
  //CONSTANT_InterfaceMethodRef_info
  public static class InterfaceMethodRef extends FieldRefInfo {
   public static byte tag() {
    return 11;
   }
  }
  //CONSTANT_String_info
  public static class StringInfo extends ConstantPool {
   short string_index;

   public static byte tag() {
    return 8;
   }
  }
  //CONSTANT_Integer_info
  public static class IntegerInfo extends ConstantPool {
   int bytes;

   public static byte tag() {
    return 3;
   }
  }
  //CONSTANT_Float_info
  public static class FloatInfo extends IntegerInfo {
   public static byte tag() {
    return 4;
   }
  }
  //CONSTANT_Long_info
  public static class LongInfo extends ConstantPool {
   int high_bytes;
   int low_bytes;

   public static byte tag() {
    return 5;
   }
  }
  //CONSTANT_Double_info
  public static class DoubleInfo extends LongInfo {
   public static byte tag() {
    return 6;
   }
  }
  //CONSTANT_NameAndType_info
  public static class NameAndTypeInfo extends ConstantPool {
   short name_index;
   short descriptor_index;

   public static byte tag() {
    return 12;
   }
  }
  //CONSTANT_Utf8_info
  public static class UTF8Info extends ConstantPool {
   short length;
   @ArrayLength("length")
   byte[] bytes;

   public static byte tag() {
    return 1;
   }
  }
  //CONSTANT_MethodHandle_info
  public static class MethodHandleInfo extends ConstantPool {
   byte reference_kind;
   short reference_index;

   public static byte tag() {
    return 15;
   }
  }
  //CONSTANT_MethodType_info
  public static class MethodTypeInfo {
   short descriptor_index;

   public static byte tag() {
    return 16;
   }
  }
  //CONSTANT_InvokeDynamic_info
  public static class InvokeDynamicInfo extends ConstantPool {
   short bootstrap_method_attr_index;
   short name_and_type_index;

   public static byte tag() {
    return 18;
   }
  }
 }
 //attribute_info
 public static class AttributeInfo implements AbstractSyntaxTree {
  short attribute_name_index;
  int attribute_length;
  @ArrayLength("attribute_length")
  byte[] info;
 }
 //field_info
 public static class FieldInfo implements AbstractSyntaxTree {
  short access_flags;
  short name_index;
  short descriptor_index;
  short attributes_count;
  @ArrayLength("attributes_count")
  AttributeInfo[] attributes;
 }
 //method_info
 public static final class MethodInfo extends FieldInfo {}

 @Constants.ConstantInt(0xCAFEBABE)
 int magic;
 short minor_version;
 short major_version;
 short constant_pool_count;
 @ArrayLength(value = "constant_pool_count", offset = -1)
 ConstantPool[] constant_pool;
 short access_flags;
 short this_class;
 short super_class;
 short interfaces_count;
 @ArrayLength("interfaces_count")
 short[] interfaces;
 short fields_count;
 @ArrayLength("fields_count")
 FieldInfo[] fields;
 short methods_count;
 @ArrayLength("methods_count")
 MethodInfo[] methods;
 short attributes_count;
 @ArrayLength("attributes_count")
 AttributeInfo[] attributes;

 //TODO @Verifies should match the parameter count and types
 @Verifies({"minor_version", "major_version"})
 public static String verifyVersion(final long minor_version, final long major_version) {
  return "";
 }
}
