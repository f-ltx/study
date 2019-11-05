package cn.ltx.designmode.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        Class<User> clazz1 = User.class;
        User user1 = clazz1.newInstance();
        System.out.println(user1);
        Class clazz2 = user1.getClass();
        User user2 = (User) clazz2.newInstance();
        System.out.println(user2);
        Class clazz = Class.forName("cn.ltx.designmode.reflect.User");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor constructor1 = clazz.getConstructor();
        Constructor constructor2 = clazz.getConstructor(String.class, String.class, Integer.class);
        System.out.println(constructor1);
        System.out.println(constructor2);
        Constructor declaredConstructor1 = clazz.getDeclaredConstructor();
        Constructor declaredConstructor2 = clazz.getDeclaredConstructor(String.class, String.class, Integer.class);
        System.out.println(declaredConstructor1);
        System.out.println(declaredConstructor2);
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();

        // Field sex1 = clazz.getField("sex");报错
        Field name = clazz.getField("name");
        Field sex2 = clazz.getDeclaredField("sex");
        Field age = clazz.getDeclaredField("age");
        for (Field field : fields) {
            System.out.println(field);
        }
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println(name);
        System.out.println(sex2);
        System.out.println(age);
        Object o = clazz.getConstructor().newInstance();
        user1 = (User) o;
        sex2.setAccessible(true);
        sex2.set(user1, "男");
        System.out.println(user1.getSex());

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        //Method protectedMethod = clazz.getMethod("protectedMethod");报错
        Method protectedMethod = clazz.getDeclaredMethod("protectedMethod");
        protectedMethod.invoke(user1);
    }

}

class User {
    public String name;
    private String sex;
    private Integer age;

    public User() {
    }

    public User(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    protected void protectedMethod() {
        System.out.println("protected method");
    }

    private String privateMethod() {
        String x = "private method";
        System.out.println(x);
        return x;
    }
}