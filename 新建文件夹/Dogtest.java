public class Dogtest {
    
    static class Dog { 
// 一个程序中只能有一个public 所以写成了static
//如果不加 static，Dog 将是一个非静态内部类。
// 非静态内部类必须依附于外部类的实例，无法直接被外部独立使用。

        public int weightInPounds;  // non-static
        public static String name = "puppy";  //static String注意大写 puppy要双引号 

        public Dog(int w) {
            weightInPounds = w;
        }

        public void MakeNoise() {
            if (weightInPounds < 10) {
                System.out.println("yipyip");  
            } else {
                System.out.println("arooo");
            }
        }
        
        public static Dog MaxDog1(Dog d1, Dog d2) {
            if (d1.weightInPounds > d2.weightInPounds) return d1;
            else return d2;
        }

        public Dog MaxDog2(Dog d1) {
            if (weightInPounds > d1.weightInPounds) return this; // this!!!
            else return d1;
        }
    }
    
    public static void main (String[] args) {
        Dog A = new Dog(5);
        Dog B = new Dog(15);

        Dog larger1 = Dog.MaxDog1(A, B);
        Dog larger2 = A.MaxDog2(B);

        larger1.MakeNoise();
        larger2.MakeNoise();

        System.out.println(Dog.name); // static 所以是
    }
}

/*
 Dog.MaxDog1 是静态方法，但它依赖于实例字段
虽然 MaxDog1 是静态方法，但它使用了实例对象 d1 和 d2 的非静态字段 weightInPounds，
这是允许的。但你需要明确理解：静态方法不能直接访问非静态字段（如 weightInPounds），但可以通过实例对象访问。
当前代码没问题，但需要注意：
静态方法的职责是与对象实例无关的操作。
这种写法没有问题，但如果你想让它更符合语义，可以使用实例方法替代。
 */