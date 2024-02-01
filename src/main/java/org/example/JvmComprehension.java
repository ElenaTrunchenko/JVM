package org.example;
// Загрузка классов main, printAll и стандартных библиотечных классов (Object, Integer) по схеме ClassLoader
public class JvmComprehension { // Классы загружается в Metaspace
    public static void main(String[] args) { // В Stack Memory создался фрейм main
        int i = 1;                      // 1 В Stack Memory в фрейме main создается переменная i и присваивается значение 1
        Object o = new Object();        // 2 В куче создается объект Object. В Stack Memory создается переменная o, которая ссылается на объект Object
        Integer ii = 2;                 // 3 В куче создается объект Integer с значением 2. В Stack Memory создается переменная ii которая имеет ссылку на объект Integer
        printAll(o, i, ii);             // 4 В Stack Memory создался фрейм printAll. Создаются новые ссылки на объекты o, i, ii
        System.out.println("finished"); // 7 В Stack Memory создается фрейм println, которому передается ссылка на созданный в куче объект String со значением "finished"
        // Пириодически выполняется Garbage Collector
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В куче создается объект Integer с значением 700. В Stack Memory в фрейме printAll создается переменная uselessVar которая имеет ссылку на этот объект
        System.out.println(o.toString() + i + ii);  // 6 В Stack Memory создается фрейм println, которому передаются ссылки на объекты и переменные. В Stack Memory создается фрейм toString
    }
}
