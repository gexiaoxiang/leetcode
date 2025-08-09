package com.eden;

public class Test3 {
    public Test3(){}
    public void f(){
    System.out.println(6666);
}
    public static class Thread3 extends Thread {
        public void run() {

            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Someone interrupted me.");
//                    try {
//                        Threa d.sleep(1000);
//                    } catch (InterruptedException e) {
//                        System.out.println("Someone interrupted me1111." +Thread.currentThread().isInterrupted());
//                    }
                } else {

                    System.out.println("Thread is Going...");
                }

            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Class<Test3> randomClass = Test3.class;
        ClassLoader classLoader = randomClass.getClassLoader();
        ClassLoader parent = classLoader.getParent();


    }

}
