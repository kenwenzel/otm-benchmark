package cz.cvut.kbss.benchmark.util;

import java.net.URI;

public class Constants {

    /**
     * Number of items of one kind to use in one round.
     */
    public static final int ITEM_COUNT = 300;

    public static final int MAX_SEVERITY = 10;

    public static final int ATTACHMENT_COUNT = 3;

    public static final int MAX_CHILD_EVENTS = 2;

    public static final int MAX_EVENT_DEPTH = 2;

    public static final String FACTOR_PARAMETER = "f";

    /**
     * Randomly generated string usable as report summary.
     */
    public static final String SUMMARY =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor" +
                    " incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" +
                    " nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum" +
                    " dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +
                    " mollit anim id est laborum.";

    public static final URI[] EVENT_TYPES =
            new URI[]{URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-1"),
                      URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-10"),
                      URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-100"),
                      URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-101"),
                      URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-102"),
                      URI.create("http://onto.fel.cvut.cz/ontologies/eccairs/aviation-3.4.0.2/vl-a-430/v-103")};
}
