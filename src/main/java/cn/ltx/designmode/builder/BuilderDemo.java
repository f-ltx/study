package cn.ltx.designmode.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        PersonDirector director = new PersonDirector(new AmericanBuilder());
        Person person = director.createPerson();
        System.out.println(person);
        PersonDirector director1 = new PersonDirector(new JapanBuilder());
        Person person1 = director1.createPerson();
        System.out.println(person1);
    }
}

class PersonDirector {
    private PersonBuilder builder;

    public PersonDirector(PersonBuilder builder) {
        this.builder = builder;
    }

    public Person createPerson() {
        this.builder.builderHead();
        this.builder.builderBody();
        this.builder.builderFoot();
        return this.builder.buildPerson();
    }
}

class JapanBuilder implements PersonBuilder {
    private Person person;

    public JapanBuilder() {
        person = new Person();
    }

    @Override
    public void builderHead() {
        person.setHead("小日本 - 小胡子");
    }

    @Override
    public void builderBody() {
        person.setBody("日本人 - 个子矮");
    }

    @Override
    public void builderFoot() {
        person.setFoot("腿短");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}

class AmericanBuilder implements PersonBuilder {
    private Person person;

    public AmericanBuilder() {
        person = new Person();
    }

    @Override
    public void builderHead() {
        person.setHead("老外 - 黄头发，蓝眼睛，大鼻子");
    }

    @Override
    public void builderBody() {
        person.setBody("老外 - 个子高");
    }

    @Override
    public void builderFoot() {
        person.setFoot("腿长");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}

interface PersonBuilder {
    void builderHead();

    void builderBody();

    void builderFoot();

    Person buildPerson();
}

class Person {
    String head;
    String body;
    String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "head='" + head + '\'' +
                ", body='" + body + '\'' +
                ", foot='" + foot + '\'' +
                '}';
    }
}