/*Source : http://www.anddev.org/parsing_xml_from_the_net_-_using_the_saxparser-t353.html*/
package com.example.project;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.helpers.DefaultHandler;
import android.os.Handler;

import java.io.IOException;


public class RSSHandler extends DefaultHandler {

    // ===========================================================
    // Fields
    // ===========================================================

    private int tour;
    private int instance_tour = 0;
    private boolean in_rss = false;
    private boolean in_item = false;
    private boolean in_title = false;
    private boolean in_date = false;
    private boolean in_url = false;
    private boolean stop = false;

    private NewsDataSet thisNewsDataSet = new NewsDataSet();

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public  NewsDataSet getParsedData(int i) {
        setTour(i);
        stop = false;
        return this.thisNewsDataSet;
    }

    // ===========================================================
    // Methods
    // ===========================================================
    @Override
    public void startDocument() {
        this.thisNewsDataSet = new  NewsDataSet();
    }

    /** Gets be called on opening tags like:
     * <tag>
     * Can provide attribute(s), when xml was like:
     * <tag attribute="attributeValue">*/
    @Override
    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws SAXException {
        if(stop == false) {
            if (localName.equals("rss")) {
                this.in_rss = true;
            } else if (localName.equals("item")) {
                this.in_item = true;
            } else if (in_item == true) {
                if (localName.equals("title")) {
                    this.in_title = true;
                } else if (localName.equals("pubDate")) {
                    this.in_date = true;
                } else if (localName.equals("link")) {
                    this.in_url = true;
                }
            }
        }
    }

    /** Gets be called on closing tags like:
     * </tag> */
    @Override
    public void endElement(String namespaceURI, String localName, String qName)
            throws SAXException {
            if (localName.equals("rss")) {
                this.in_rss = false;

            }else if (in_item == true) {
                if (localName.equals("title")) {
                    this.in_title = false;
                } else if (localName.equals("link")) {
                    this.in_url = false;
                } else if (localName.equals("pubDate")) {
                    this.in_date = false;
                }

                if (localName.equals("item")) {
                    this.in_item = false;
                    if (getTour() <= instance_tour) {
                        stop = true;
                    } else {
                        instance_tour += 1;
                    }
                }
            }
    }

    public int getTour(){return tour;}

    public void setTour(int i){tour = i;}


    /** Gets be called on the following structure:
     * <tag>characters</tag>*/
    @Override
    public void characters(char ch[], int start, int length) {
        if(stop == false) {
            if (this.in_title) {
                thisNewsDataSet.setTitle(new String(ch, start, length));
            }
            if (this.in_date) {
                thisNewsDataSet.setDate(new String(ch, start, length));
            }
            if (this.in_url) {
                thisNewsDataSet.setUrl(new String(ch, start, length));
            }
        }
    }
}
