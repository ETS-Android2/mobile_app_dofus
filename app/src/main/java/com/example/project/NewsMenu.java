/*source http://www.anddev.org/parsing_xml_from_the_net_-_using_the_saxparser-t353.html*/
package com.example.project;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NewsMenu extends Activity {

    private final String MY_DEBUG_TAG = "rss";
    private ListView mListView;
    public static final String PREFS_NAME = "MyPrefsFile";
    private String[][] actus = new String[2][10];

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        int theme = prefs.getInt("theme", 0);

        if(theme == 1){
            setTheme(R.style.DarkAppTheme);
        }
        else{
            setTheme(R.style.AppTheme);
        }

        setContentView(R.layout.activity_news_menu);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        actus[0][0] = "Pas de nouvelles actualités";
        actus[1][0] = "Pas de nouvelles actualités";

        /* Create a new TextView to display the parsingresult later. */
        TextView tv = new TextView(this);
        RSSHandler myExampleHandler = new RSSHandler();

        try {
            /* Create a URL we want to load some xml-data from. */
            URL url = new URL("https://www.dofus.com/fr/rss/news.xml");

            /* Get a SAXParser from the SAXPArserFactory. */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            /* Get the XMLReader of the SAXParser we created. */
            XMLReader xr = sp.getXMLReader();
            /* Create a new ContentHandler and apply it to the XML-Reader*/
            xr.setContentHandler(myExampleHandler);

            /* Parse the xml-data from our URL. */
            xr.parse(new InputSource(url.openStream()));
            /* Parsing has finished. */


            NewsDataSet parsedNews = null;
            for(int i = 0; i<10;i ++){

                parsedNews = myExampleHandler.getParsedData();
                actus[0][i] = parsedNews.toString();
                actus[1][i] = parsedNews.getUrl();

            }

            mListView = (ListView) findViewById(R.id.listView);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewsMenu.this,
                    android.R.layout.simple_list_item_1, actus[0]);
            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, final View view,
                                        int position, long id) {
                    Uri uri = Uri.parse(actus[1][position]);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    // Verify that the intent will resolve to an activity
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        // Here we use an intent without a Chooser unlike the next example
                        startActivity(intent);
                    }
                }

            });
        }
        catch (Exception e) {
            /* Display any Error to the GUI. */
            tv.setText("Error: " + e.getMessage());
            Log.e(MY_DEBUG_TAG, "rss", e);
        }
    }



    public void refreshClick (View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
