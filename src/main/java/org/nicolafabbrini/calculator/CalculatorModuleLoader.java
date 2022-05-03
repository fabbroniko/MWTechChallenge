package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.exception.InitializationException;
import org.nicolafabbrini.calculator.module.AbstractOperation;
import org.reflections.Reflections;
import java.util.List;

/**
 * Utility class used to automatically load modules usable by the Calculator.
 */
public class CalculatorModuleLoader {

    private static final String MODULE_PACKAGE = "org.nicolafabbrini.calculator.module";

    /**
     * This method scans for sub-types of AbstractOperation in the classpath and returns a list of instances meeting the
     * criteria. This allows the program to very easily pick up new modules (like trigonometric functions) without having
     * to change any code apart from creating the module itself.
     *
     * @return Returns a list of instances of classes extending {@link AbstractOperation}
     */
    public static List<? extends AbstractOperation> getModules() {
        final Reflections reflections = new Reflections(MODULE_PACKAGE);
        return reflections.getSubTypesOf(AbstractOperation.class)
                .stream()
                .map(m -> {
                    try {
                        return m.getConstructor().newInstance();
                    } catch (final Exception e) {
                        throw new InitializationException();
                    }
                })
                .toList();
    }
}
