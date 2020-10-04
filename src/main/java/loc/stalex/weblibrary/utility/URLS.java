package loc.stalex.weblibrary.utility;

public enum URLS {
    REDIRECT("redirect:"),
    MAIN("/WEB-INF/pages/main.jsp"),
    LOGIN("/WEB-INF/pages/login.jsp"),
    REGISTRATION("/WEB-INF/pages/registration.jsp"),
    PROFILE_FORWARD("/WEB-INF/pages/profile.jsp"),
    PROFILE("/profile");

    private final String url;

    URLS(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
