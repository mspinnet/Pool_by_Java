package edu.school21.reflection.app;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.lang.ClassNotFoundException;

public class Program {

    public static void analyzeClass(Object o)
    {
        Class clazz = o.getClass();
        Class[] parametrTypes;
        int n = 0;
        System.out.println("fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            System.out.print("\t");
            System.out.println(fields[i].getType().getSimpleName() + " " + fields[i].getName());
        }
        System.out.println("methods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            parametrTypes = methods[i].getParameterTypes();
            if (parametrTypes.length > 0)
            {
                System.out.print("\t");
                System.out.print(methods[i].getReturnType().getSimpleName() + " " + methods[i].getName());
                System.out.print("(");
                for (int j = 0; j < parametrTypes.length - 1; j++)
                {
                    System.out.print(parametrTypes[j].getSimpleName() + ", ");
                    n = j;
                }
                System.out.println(parametrTypes[n].getSimpleName() + ")");
            }
        }
    }

    public static void createObj(Object o, Scanner in)
    {
        String str;
        Class<?> clazz = o.getClass();
        int num;
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++)
        {
            System.out.println(fields[i].getName() + ":");
            if (fields[i].getType().getSimpleName().equals("String"))
            {
                str = in.nextLine();
                fields[i].setAccessible(true);
                try {
                    fields[i].set(o, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (fields[i].getType().getSimpleName().equals("int"))
            {
                num = in.nextInt();
                fields[i].setAccessible(true);
                try {
                    fields[i].set(o, num);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void changeObj(Object o, Scanner in)
    {
        int num;
        Class<?> clazz = o.getClass();
        Field field;
        String str;
        try
        {
            str = in.next();
            field = clazz.getDeclaredField(str);
            if (field.getType().getSimpleName().equals("String"))
            {
                System.out.println("Enter String value:");
                str = in.next();
                field.setAccessible(true);
                try {
                    field.set(o, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.getType().getSimpleName().equals("int"))
            {
                System.out.println("Enter int value:");
                num = in.nextInt();
                field.setAccessible(true);
                try {
                    field.set(o, num);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (NoSuchFieldException e)
        {
            e.getMessage();
        }
    }

    public static void callMethod(Object o, Scanner in) throws IllegalAccessException, InvocationTargetException
    {
        Class<?> clazz = o.getClass();
        String str = in.next();
        String tmp = "";
        int n = 0;
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++)
        {
            if (methods[i].getParameterTypes().length > 0)
            {
                tmp = methods[i].getName() + "(";
                for (int j = 0; j < methods[i].getParameterTypes().length - 1; j++)
                {
                    tmp += methods[i].getParameterTypes()[j].getSimpleName() + ", ";
                    n = j;
                }
                tmp += methods[i].getParameterTypes()[n].getSimpleName() + ")";
            }
            if (tmp.equals(str))
            {
                Object[] arr = new Object[methods[i].getParameterTypes().length];
                for (int c = 0; c < methods[i].getParameterTypes().length; c++)
                {
                    if (methods[i].getParameterTypes()[c].getSimpleName().equals("String"))
                    {
                        System.out.println("Enter String value:");
                        arr[c] = in.next();
                    }
                    if (methods[i].getParameterTypes()[c].getSimpleName().equals("int"))
                    {
                        System.out.println("Enter int value:");
                        arr[c] = in.nextInt();
                    }
                }
                System.out.println("Method returned:");
                System.out.println(methods[i].invoke(o, arr));
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        System.out.println("Classes:");
        try {
            ScanResult scanResult = new ClassGraph()
                    .whitelistPackages("edu.school21.reflection.classes")
                    .scan();
            for (ClassInfo classInfo : scanResult.getAllClasses()) {
                System.out.println(" - " + classInfo.getSimpleName());
            }
        }
        catch (ClassNotFoundExceptionMy e)
        {
            System.out.println("Exception");
        }
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (!str.equals("User") && !str.equals("Car"))
            throw new ClassNotFoundExceptionMy();
        Class clazz = Class.forName("edu.school21.reflection.classes." + str + "." + str);
        System.out.println("---------------------");
        analyzeClass(clazz.newInstance());
        System.out.println("---------------------");
        System.out.println("Let’s create an object.");
        Object OBJ = clazz.newInstance();
        createObj(OBJ, in);
        System.out.println("Object created: " + OBJ.toString());
        System.out.println("---------------------");
        System.out.println("Enter name of the field for changing:");
        changeObj(OBJ, in);
        System.out.println("Object updated: " + OBJ.toString());
        System.out.println("---------------------");
        System.out.println("Enter name of the method for call:");
        callMethod(OBJ, in);
        in.close();
    }

}
