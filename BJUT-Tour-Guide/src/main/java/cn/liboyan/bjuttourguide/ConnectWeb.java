package cn.liboyan.bjuttourguide;

/**
 * Pop up the Internet Explorer
 * @author liboyan
 */
public class ConnectWeb {
    /**
     * Open the URL at Internet Explorer
     * @param url: path
     */
    public static void openUrl(String url) {
        try {
            String firefox = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
            Runtime.getRuntime().exec(new String[]{firefox, url});
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String url = "C:\\Users\\lbyto\\OneDrive\\2019-2020-1\\数据结构课设\\Project\\MapOnWeb\\index.html";
        openUrl(url);
    }
}