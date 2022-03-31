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
    JETI_PROJECT("https://jira-auto.codecool.metastage.net/projects/JETI/summary");


    private final String url;

    PageUrlCollection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
