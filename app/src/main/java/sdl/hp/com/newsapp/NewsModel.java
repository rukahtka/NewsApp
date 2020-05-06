package sdl.hp.com.newsapp;

public class NewsModel {
    private String sourceID;
    private String sourceNAme;
    private String authorName;
    private String newsTitle;
    private String newsDescription;
    private String newsURL;
    private String newsImageURL;
    private String newsPublishTime;

    public NewsModel() {
    }

    public NewsModel(String sourceID, String sourceNAme, String authorName, String newsTitle, String newsDescription,
                     String newsURL, String newsImageURL, String newsPublishTime) {
        this.sourceID = sourceID;
        this.sourceNAme = sourceNAme;
        this.authorName = authorName;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newsURL = newsURL;
        this.newsImageURL = newsImageURL;
        this.newsPublishTime = newsPublishTime;
    }

    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    public String getSourceNAme() {
        return sourceNAme;
    }

    public void setSourceNAme(String sourceNAme) {
        this.sourceNAme = sourceNAme;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsURL() {
        return newsURL;
    }

    public void setNewsURL(String newsURL) {
        this.newsURL = newsURL;
    }

    public String getNewsImageURL() {
        return newsImageURL;
    }

    public void setNewsImageURL(String newsImageURL) {
        this.newsImageURL = newsImageURL;
    }

    public String getNewsPublishTime() {
        return newsPublishTime;
    }

    public void setNewsPublishTime(String newsPublishTime) {
        this.newsPublishTime = newsPublishTime;
    }
}
