package cn.ltx.jvm.javaassist;

import javassist.*;

/**
 * Description:使用javaassist生成一个字节码文件
 *
 * @author litianxiang
 * @date   2019-12-10
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        //1.创建class文件
        CtClass ctClass = classPool.makeClass("cn.ltx.entity.User");
        //2.创建成员
        CtField name = CtField.make("private String name;", ctClass);
        CtField age = CtField.make("private Integer age;", ctClass);
        ctClass.addField(name);
        ctClass.addField(age);
        //3.创建构造
        CtConstructor constructor = new CtConstructor(new CtClass[]{classPool.get("java.lang.String"), CtClass.intType}, ctClass);
        constructor.setBody("{this.name = $1;this.age=$2;}");
        ctClass.addConstructor(constructor);
        //4.创建方法
        CtMethod method = CtMethod.make("public String getName() {return name;}",ctClass);
        ctClass.addMethod(method);
        ctClass.writeFile("d:/test");
    }
}
