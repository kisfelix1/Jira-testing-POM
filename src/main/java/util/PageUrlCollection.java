package util;

public enum PageUrlCollection {
    INDEX("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa"),
    LOGIN("https://jira-auto.codecool.metastage.net/login.jsp"),
    PROFIL("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa"),
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
