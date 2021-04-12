package com.eden;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/3/30
 * @Version V1.0
 **/
public class test {
    static class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        // 构造方法
        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }
        // 省略了get和set，请自行添加

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 1, "male", "New York"));
        personList.add(new Person("Jack", 7000, 2, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 2, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 2, "female", "New York"));
        personList.add(new Person("Owen", 9500, 2, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 2, "female", "New York"));

        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        list.stream().filter(x -> x > 6).forEach(System.out::println);

        Optional<Integer> first = list.stream().filter(x -> x > 6).findAny();

        List<String> collect = personList.stream().filter((e) -> e.salary > 8000).map(Person::getName).collect(Collectors.toList());


    }


}






