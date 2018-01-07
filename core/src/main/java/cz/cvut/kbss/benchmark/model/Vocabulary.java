package cz.cvut.kbss.benchmark.model;

public class Vocabulary {

    public static final String BASE_URI = "http://krizik.felk.cvut.cz/ontologies/benchmark/";

    public static final String s_c_occurrence_report = "http://onto.fel.cvut.cz/ontologies/documentation/occurrence_report";
    public final static String s_c_Event = "http://onto.fel.cvut.cz/ontologies/ufo/Event";
    public static final String s_c_Occurrence = "http://onto.fel.cvut.cz/ontologies/aviation-safety/Occurrence";
    public static final String s_c_Person = "http://onto.fel.cvut.cz/ontologies/ufo/Person";
    public static final String s_c_Resource = "http://onto.fel.cvut.cz/ontologies/aviation/documentation/resource";
    public static final String s_p_has_file_number = "http://onto.fel.cvut.cz/ontologies/documentation/has_file_number";
    public static final String s_p_documents = "http://onto.fel.cvut.cz/ontologies/documentation/documents";
    public static final String s_p_has_author = "http://onto.fel.cvut.cz/ontologies/documentation/has-author";
    public static final String s_p_created = "http://purl.org/dc/terms/created";
    public static final String s_p_modified = "http://purl.org/dc/terms/modified";
    public static final String s_p_has_last_editor = "http://onto.fel.cvut.cz/ontologies/documentation/has_last_editor";
    public static final String s_p_has_revision = "http://onto.fel.cvut.cz/ontologies/documentation/has_revision";
    public static final String s_p_description = "http://purl.org/dc/terms/description";
    public static final String s_p_label = "http://www.w3.org/2000/01/rdf-schema#label";
    public static final String s_p_has_start_time = "http://onto.fel.cvut.cz/ontologies/aviation-safety/has_start_time";
    public static final String s_p_has_end_time = "http://onto.fel.cvut.cz/ontologies/aviation-safety/has_end_time";
    public static final String s_p_firstName = "http://xmlns.com/foaf/0.1/firstName";
    public static final String s_p_lastName = "http://xmlns.com/foaf/0.1/lastName";
    public static final String s_p_accountName = "http://xmlns.com/foaf/0.1/accountName";
    public static final String s_p_password = "http://onto.fel.cvut.cz/ontologies/reporting-tool/password";
    public static final String s_p_has_id = "http://purl.org/dc/elements/1.1/identifier";
    public static final String s_p_contact = "http://xmlns.com/foaf/0.1/mbox";
    public static final String s_p_references = "http://purl.org/dc/terms/references";
    public final static String s_p_has_severity_assessment = "http://onto.fel.cvut.cz/ontologies/documentation/has_severity_assessment";
    public final static String s_p_has_part = "http://onto.fel.cvut.cz/ontologies/ufo/has_part";
    public final static String s_p_has_event_type = "http://onto.fel.cvut.cz/ontologies/reporting-tool/has_event_type";
    public final static String s_p_has_key = "http://onto.fel.cvut.cz/ontologies/documentation/has_key";

    private Vocabulary() {
        throw new AssertionError();
    }
}
