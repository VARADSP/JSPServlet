package day3.assignment8;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * Class ClassDetail which is used to print details of given class such as its methods,constructors,fields
 * @author: Varad Parlikar Created Date: 2019/06/20
 */
public class ClassDetail {
	 /**
     * method printDetails prints details of class such as methods,fields,constructors
     * return type : void
     */
    public void printDetails(String nameOfClass, String typeOfInfo) {

        Class cl = null;
        try {
            cl = Class.forName(nameOfClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        switch (typeOfInfo) {
        case "ALL":printAll(cl);break;
        case "M":  printMethods(cl);break;
        case "C":  printConstructors(cl);break;
        case "F":  printFields(cl);break;
        }
    }
    /**
     * method printAll prints class details such as constructors,methods,fields return type : void
     */
    public void printAll(Class cl) {

        System.out.println("\nName Of Class " + cl.getName() + "\n");
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0)
            System.out.print(modifiers + " ");
        System.out.print("class " + cl.getName());
        if (supercl != null && supercl != Object.class)
            System.out.print(" extends " + supercl.getName());
        System.out.print("\n{\n");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }
    /**
     * method printMethods prints methods of classes
     * return type : void
     */
    public void printMethods(Class cl) {

        System.out.println("\nMethods Of Class " + cl.getName() + "\n");
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("   ");
            // print modifiers, return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes(); // print parameter types
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    /**
     * method printConstructors prints constructors of classes
     * return type :void
     */
    public void printConstructors(Class cl) {

        System.out.println("\nConstructors Of Class " + cl.getName() + "\n");
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");
            Class[] paramTypes = c.getParameterTypes(); // print parameter types
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    /**
     * method printFields prints fields of classes return type : void
     */
    public void printFields(Class cl) {

        System.out.println("\nFields Of Class " + cl.getName() + "\n");
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}