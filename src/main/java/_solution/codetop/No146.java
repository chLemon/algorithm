package _solution.codetop;

import sun.jvm.hotspot.HelloWorld;

public class No146 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = HelloWorld.class.getClassLoader();
        System.out.println(loader);
        Test2 test2 = new Test2();
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块 
//        loader.loadClass("_solution.codetop.Test2");
        //使用Class.forName()来加载类，默认会执行初始化块 
//                Class.forName("_solution.codetop.Test2"); 
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
//                Class.forName("_solution.codetop.Test2", false, loader); 
    }


}

class Test2 {
    static {
        System.out.println("静态初始化块执行了！");
    }
}