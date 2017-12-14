package cz.cvut.kbss.benchmark.komma.util;

import cz.cvut.kbss.benchmark.BenchmarkException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

public class BenchmarkUtil {

    private static final DatatypeFactory FACTORY = initDatatypeFactory();

    private static DatatypeFactory initDatatypeFactory() {
        try {
            return DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new BenchmarkException("Unable to initialize Komma model.", e);
        }
    }

    public static DatatypeFactory datatypeFactory() {
        return FACTORY;
    }
}
