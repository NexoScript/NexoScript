package com.nexoscript.nexoscript.util;

import com.nexoscript.nexoscript.runner.NexoRunner;
import com.nexoscript.nexoscript.runner.code.Variable;
import com.nexoscript.nexoscript.runner.variable.DoubleVariable;
import com.nexoscript.nexoscript.runner.variable.FloatVariable;
import com.nexoscript.nexoscript.runner.variable.IntegerVariable;
import com.nexoscript.nexoscript.runner.variable.LongVariable;

public class NexoUtil {
    public static boolean proveType(String varName, String... types) {
        for (Variable<?> var : NexoRunner.get().getVariables()) {
            if(var.key().equals(varName)) {
                for (String type : types) {
                    if(var.type().equals(type)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String getVarType(String varName) {
        for (Variable<?> var : NexoRunner.get().getVariables()) {
            if(!var.key().equals(varName)) continue;
            return var.type();
        }
        return "";
    }

    public static void calculation(String type, String operation, String result, String number1, String number2) {
        for (Variable<?> var : NexoRunner.get().getVariables()) {
            if(!var.key().equals(result)) continue;
            for (Variable<?> var1 : NexoRunner.get().getVariables()) {
                if(!var1.key().equals(number1)) continue;
                for (Variable<?> var2 : NexoRunner.get().getVariables()) {
                    if(!var2.key().equals(number2)) continue;
                    switch (type) {
                        case "integer" -> {
                            IntegerVariable resultInt = (IntegerVariable) var;
                            IntegerVariable number1Int = (IntegerVariable) var1;
                            IntegerVariable number2Int = (IntegerVariable) var2;
                            if(operation.equals("<+<")) resultInt.setValue(number1Int.getValue() + number2Int.getValue());
                            if(operation.equals("<-<")) resultInt.setValue(number1Int.getValue() - number2Int.getValue());
                            if(operation.equals("<*<")) resultInt.setValue(number1Int.getValue() * number2Int.getValue());
                            if(operation.equals("</<")) resultInt.setValue(number1Int.getValue() / number2Int.getValue());
                            if(operation.equals("<%<")) resultInt.setValue(number1Int.getValue() % number2Int.getValue());
                        }
                        case "long" -> {
                            LongVariable resultInt = (LongVariable) var;
                            LongVariable number1Int = (LongVariable) var1;
                            LongVariable number2Int = (LongVariable) var2;
                            if(operation.equals("<+<")) resultInt.setValue(number1Int.getValue() + number2Int.getValue());
                            if(operation.equals("<-<")) resultInt.setValue(number1Int.getValue() - number2Int.getValue());
                            if(operation.equals("<*<")) resultInt.setValue(number1Int.getValue() * number2Int.getValue());
                            if(operation.equals("</<")) resultInt.setValue(number1Int.getValue() / number2Int.getValue());
                            if(operation.equals("<%<")) resultInt.setValue(number1Int.getValue() % number2Int.getValue());
                        }
                        case "double" -> {
                            DoubleVariable resultInt = (DoubleVariable) var;
                            DoubleVariable number1Int = (DoubleVariable) var1;
                            DoubleVariable number2Int = (DoubleVariable) var2;
                            if(operation.equals("<+<")) resultInt.setValue(number1Int.getValue() + number2Int.getValue());
                            if(operation.equals("<-<")) resultInt.setValue(number1Int.getValue() - number2Int.getValue());
                            if(operation.equals("<*<")) resultInt.setValue(number1Int.getValue() * number2Int.getValue());
                            if(operation.equals("</<")) resultInt.setValue(number1Int.getValue() / number2Int.getValue());
                            if(operation.equals("<%<")) resultInt.setValue(number1Int.getValue() % number2Int.getValue());
                        }
                        case "float" -> {
                            FloatVariable resultInt = (FloatVariable) var;
                            FloatVariable number1Int = (FloatVariable) var1;
                            FloatVariable number2Int = (FloatVariable) var2;
                            if(operation.equals("<+<")) resultInt.setValue(number1Int.getValue() + number2Int.getValue());
                            if(operation.equals("<-<")) resultInt.setValue(number1Int.getValue() - number2Int.getValue());
                            if(operation.equals("<*<")) resultInt.setValue(number1Int.getValue() * number2Int.getValue());
                            if(operation.equals("</<")) resultInt.setValue(number1Int.getValue() / number2Int.getValue());
                            if(operation.equals("<%<")) resultInt.setValue(number1Int.getValue() % number2Int.getValue());
                        }
                    }
                }
            }
        }
    }
}
