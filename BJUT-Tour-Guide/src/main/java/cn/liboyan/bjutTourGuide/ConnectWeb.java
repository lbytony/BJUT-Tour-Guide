package cn.liboyan.bjutTourGuide;

public class ConnectWeb {
    public static void openURL(String url) {
        try {
            String firefox = "C:\\Program Files\\Internet Explorer\\iexplore.exe";
            Runtime.getRuntime().exec(new String[]{firefox, url});
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        String url = "C:\\Users\\lbyto\\OneDrive\\2019-2020-1\\数据结构课设\\Project\\MapOnWeb\\index.html";
        openURL(url);
    }
}