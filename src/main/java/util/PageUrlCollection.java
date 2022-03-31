package util;

public enum PageUrlCollection {
    INDEX("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa"),
    LOGIN("https://jira-auto.codecool.metastage.net/login.jsp"),
    PROFILE("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa"),
    EDIT_DUMMY_ISSUE("https://jira-auto.codecool.metastage.net/browse/MTP-1845"),
    CANCEL_EDIT_DUMMY_ISSUE("https://jira-auto.codecool.metastage.net/browse/MTP-1846"),
    MTP_PROJECT("https://jira-auto.codecool.metastage.net/projects/MTP/summary"),
    COALA_PROJECT("https://jira-auto.codecool.metastage.net/projects/COALA/summary"),
    TOUCAN_PROJECT("https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary"),
    JETI_PROJECT("https://jira-auto.codecool.metastage.net/projects/JETI/summary"),
    MTP_ISSUE("https://jira-auto.codecool.metastage.net/issues/?jql=project%20%3D%20%22Main%20Testing%20Project%22%20AND%20summary%20~%20MTP-8982431"),
    MTP_ISSUE_FOR_BROWSE("https://jira-auto.codecool.metastage.net/projects/MTP/issues/MTP-1841?filter=allopenissues"),
    COALA_ISSUE_ID_1("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-1?filter=allopenissues"),
    COALA_ISSUE_ID_2("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-2?filter=allopenissues"),
    COALA_ISSUE_ID_3("https://jira-auto.codecool.metastage.net/projects/COALA/issues/COALA-3?filter=allopenissues"),
    JETI_ISSUE_ID_1("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-1?filter=allopenissues"),
    JETI_ISSUE_ID_2("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-2?filter=allopenissues"),
    JETI_ISSUE_ID_3("https://jira-auto.codecool.metastage.net/projects/JETI/issues/JETI-3?filter=allopenissues"),
    TOUCAN_ISSUE_ID_1("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-1?filter=allissues"),
    TOUCAN_ISSUE_ID_2("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-2?filter=allissues"),
    TOUCAN_ISSUE_ID_3("https://jira-auto.codecool.metastage.net/projects/TOUCAN/issues/TOUCAN-3?filter=allissues");


    private final String url;

    PageUrlCollection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
