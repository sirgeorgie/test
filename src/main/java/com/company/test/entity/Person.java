package com.company.test.entity;

public class Person implements Comparable{
    public Person(int Age, String firstname, String lastname, Gender gender){
        this.age = Age;
        this.firstName = firstname;
        this.lastName = lastname;
        this.gender = gender;
    }

    public Person() {

    }

    private int age;
    private String firstName;
    private String lastName;
    private Gender gender;

    public int getAge() {
        return age;
    }

    public void setAge(int Age) {
        age = Age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {return gender;}

    public String toString()
    {
        return this.firstName + " " + this.lastName +
                " Gender: " + this.gender + " Age: "+ this.age;
    }

    @Override
    public int compareTo(Object o) {
        Person e = (Person) o;
        return getFirstName().compareTo(e.getFirstName());
    }

    @Override
    public boolean equals(Object obj) {
        return ((Person) obj).getFirstName()
                .equals(getFirstName());
    }

    public enum Gender {
        MALE,
        FEMALE,
        LGBTQ
    }
}
