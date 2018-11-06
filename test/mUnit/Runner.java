package mUnit;

import mUnit.annotation.Test;

import java.io.Console;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class Runner {
    public static void run(Class ...classes) throws Exception {
        for(final Class clazz : classes){
            final Object instance = clazz.newInstance();

            for(Method method : clazz.getMethods()){
                if(!isTestAnnotated(method)) continue;

                final String methodName = method.getName();

                try {
                    method.invoke(clazz.cast(instance));

                    pass(methodName);
                } catch(Exception e) {
                    fail(methodName);
                    log(e);
                }
            }
        }
    }

    private static boolean isTestAnnotated(AccessibleObject kind){
        try {
            return kind.getAnnotation(Test.class) != null;
        } catch(Exception e) {
            log(e);
        }

        return false;
    }

    private static void fail(String message){
        log(
            ConsoleFormat.combine(ConsoleFormat.TextFormat.BOLD, ConsoleFormat.TextColor.WHITE) +
            message +
            ConsoleFormat.combine(ConsoleFormat.TextFormat.BOLD, ConsoleFormat.TextColor.RED) +
            " failed "
        );
    }

    private static void pass(String message){
        log(
            ConsoleFormat.combine(ConsoleFormat.TextFormat.BOLD, ConsoleFormat.TextColor.WHITE) +
            message +
            ConsoleFormat.combine(ConsoleFormat.TextFormat.BOLD, ConsoleFormat.TextColor.GREEN) +
            " passed "
        );
    }

    private static void log(Exception e){
        log(
            ConsoleFormat.TextColor.RED +
            e.getMessage()
        );
    }

    private static void log(String message){
        System.out.println(message);
    }
}
