package rh;

import java.util.Collection;

import static rh.AgentLoader.CONST_PATH;

public class Searcher {

    static {
        System.load(CONST_PATH);
    }

    public native static <T> Collection<T> findAll(Class<T> klass);

    public native static void printLn(String test);
}
