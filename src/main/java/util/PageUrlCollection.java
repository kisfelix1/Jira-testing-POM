package util;

public enum PageUrlCollection {
    INDEX("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa"),
    LOGIN("https://jira-auto.codecool.metastage.net/login.jsp"),
    PROFILE("https://jira-auto.codecool.metastage.net/secure/ViewProfile.jspa");

    private final String url;

    PageUrlCollection(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
