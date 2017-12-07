package cz.cvut.kbss.benchmark.model;

public class Vocabulary {

    public static final String BASE_URI = "http://krizik.felk.cvut.cz/ontologies/benchmark/";

    public final static String s_c_occurrence_report = "http://onto.fel.cvut.cz/ontologies/documentation/occurrence_report";
    public final static String s_c_Occurrence = "http://onto.fel.cvut.cz/ontologies/aviation-safety/Occurrence";
    public final static String s_c_Person = "http://onto.fel.cvut.cz/ontologies/ufo/Person";
    public final static String s_p_has_file_number = "http://onto.fel.cvut.cz/ontologies/documentation/has_file_number";
    public final static String s_p_documents = "http://onto.fel.cvut.cz/ontologies/documentation/documents";
    public final static String s_p_has_author = "http://onto.fel.cvut.cz/ontologies/documentation/has-author";
    public final static String s_p_created = "http://purl.org/dc/terms/created";
    public final static String s_p_modified = "http://purl.org/dc/terms/modified";
    public final static String s_p_has_last_editor = "http://onto.fel.cvut.cz/ontologies/documentation/has_last_editor";
    public final static String s_p_has_revision = "http://onto.fel.cvut.cz/ontologies/documentation/has_revision";
    public final static String s_p_description = "http://purl.org/dc/terms/description";
    public final static String s_p_label = "http://www.w3.org/2000/01/rdf-schema#label";
    public final static String s_p_has_start_time = "http://onto.fel.cvut.cz/ontologies/aviation-safety/has_start_time";
    public final static String s_p_has_end_time = "http://onto.fel.cvut.cz/ontologies/aviation-safety/has_end_time";
    public final static String s_p_firstName = "http://xmlns.com/foaf/0.1/firstName";
    public final static String s_p_lastName = "http://xmlns.com/foaf/0.1/lastName";
    public final static String s_p_accountName = "http://xmlns.com/foaf/0.1/accountName";
    public final static String s_p_password = "http://onto.fel.cvut.cz/ontologies/reporting-tool/password";

    private Vocabulary() {
        throw new AssertionError();
    }
}
