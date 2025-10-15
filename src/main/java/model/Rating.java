package model;

public class Rating {
    private String id;
    private String mediaId;
    private String username;
    private int score;
    private String comment;

    public Rating(String id, String mediaId, String username, int score) {
        this.id = id;
        this.mediaId = mediaId;
        this.username = username;
        this.score = score;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMediaId() { return mediaId; }
    public void setMediaId(String mediaId) { this.mediaId = mediaId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
