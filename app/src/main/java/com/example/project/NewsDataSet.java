/*source http://www.anddev.org/parsing_xml_from_the_net_-_using_the_saxparser-t353.html*/
package com.example.project;

public class NewsDataSet {
    private String title = "nulltitle";
    private String date = "nulldate";
    private String url = "nullurl";

    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getUrl() {
        return url;
    }
    public void setTitle(String s) {
        this.title = s;
    }
    public void setDate(String s) {
        this.date = s;
    }
    public void setUrl(String s) {
        this.url = s;
    }

    public String toString(){
        return title + " " + date +  " " + url + " ";
    }
}
