package top.grandma.lifefavorite.model;

public enum BookmarkType {

    FREQUENT ("frequent"),
    TODO ("todo"),
    INTEREST ("interest"),
    DEVELOP ("develop"),
    DELETED ("deleted");

    private final String type;

    BookmarkType(String type) {
        this.type = type;
    }

    public static BookmarkType getEnumByType(String value) {
        for (BookmarkType type : BookmarkType.values()) {
            if (type.type.equals(value)) {
                return type;
            }
        }
        return null;
    }

    public String getType() {
        return this.type;
    }
}
