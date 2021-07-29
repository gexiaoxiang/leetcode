package com.eden;

import org.junit.Test;

import java.util.Optional;

/**
 * @Description: TODO
 * @Author gexx
 * @Date 2021/4/9
 * @Version V1.0
 **/


public class test1 {

    @Test
    public void main() {
        User user = new User();
        user = Optional.ofNullable(user).orElse(createUser());
        System.out.println(user);
        User user1=null;
        user1= Optional.ofNullable(user1).orElseGet(() -> createUser());
        System.out.println(user1);
         Optional.ofNullable(user1).map((u) -> u.getName());
        System.out.println(user1);

    }

    public User createUser() {
        User user = new User();
        user.setName("zhangsan");
        System.out.println( "createUser");
        return user;
    }

    class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
