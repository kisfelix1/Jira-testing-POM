package base;

import pages.IndexPage;
import pages.IssuePage;

public class BaseBrowseIssueTest extends BaseTests{

    protected IndexPage indexPage = new IndexPage(driver);
    protected IssuePage issuePage = new IssuePage(driver);

    public final String MTP_ISSUE_KEY = "MTP-1841";
    public final String TOUCAN_ISSUE_KEY_1 = "TOUCAN-1";
    public final String TOUCAN_ISSUE_KEY_2 = "TOUCAN-2";
    public final String TOUCAN_ISSUE_KEY_3 = "TOUCAN-3";
    public final String JETI_ISSUE_KEY_1 = "JETI-1";
    public final String JETI_ISSUE_KEY_2 = "JETI-2";
    public final String JETI_ISSUE_KEY_3 = "JETI-3";
    public final String COALA_ISSUE_KEY_1 = "COALA-1";
    public final String COALA_ISSUE_KEY_2 = "COALA-2";
    public final String COALA_ISSUE_KEY_3 = "COALA-3";



}
