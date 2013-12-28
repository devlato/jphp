package ru.regenix.jphp.compiler.jvm;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import ru.regenix.jphp.runtime.lang.UncaughtException;
import ru.regenix.jphp.runtime.memory.support.Memory;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExceptionsTest extends JvmCompilerCase {

    @Test
    public void testSimple(){
        Memory memory = includeResource("exceptions/simple.php");
        Assert.assertEquals("success", memory.toString());
    }

    @Test
    public void testTrace(){
        Memory memory = includeResource("exceptions/test_trace.php");
        Assert.assertEquals("success", memory.toString());
    }

    @Test(expected = UncaughtException.class)
    public void testUncaught(){
        includeResource("exceptions/uncaught.php");
    }
}
