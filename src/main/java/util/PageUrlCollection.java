package util;

public enum PageUrlCollection {
    INDEX("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa"),
    LOGIN("https://jira-auto.codecool.metastage.net/login.jsp"),
    PROFIL("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa"),
    MTP_ISSUE("https://jira-auto.codecool.metastage.net/issues/?jql=project%20%3D%20%22Main%20Testing%20Project%22%20AND%20summary%20~%20MTP-8982431");

    private final String url;

    PageUrlCollection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
