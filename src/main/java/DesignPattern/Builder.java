package DesignPattern;

public class Builder
{
    public static void main(String[] args)
    {
        Person person = new Person.PersonBuilder().basic("a", "@google.com").sensitive("male", 123).build();
    }
}

class Person {
    String name;
    String gender;
    int ssn;
    String email;

    private Person(){}

    public static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basic(String name, String email){
            person.name = name;
            person.email = email;
            return this;
        }

        public PersonBuilder sensitive(String gender, int ssn){
            person.email = gender;
            person.ssn = ssn;
            return this;
        }

        public Person build(){
            return person;
        }
    }
}