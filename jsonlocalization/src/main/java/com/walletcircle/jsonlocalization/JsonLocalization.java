package com.walletcircle.jsonlocalization;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.util.Locale;

public class JsonLocalization {

    private static JsonLocalization mInstance;
    private String language = "en";
    private JSONObject jsonData = new JSONObject();

    public static JsonLocalization getInstance() {
        if(mInstance == null)
        {
            mInstance = new JsonLocalization();
            mInstance.setLanguage(Locale.getDefault().getLanguage());
        }
        return mInstance;
    }

    private JsonLocalization() {
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void loadFromData(JSONObject jsonData) {
        this.jsonData = jsonData;
    }

    public void loadFromData(String jsonString) {
        try {
            this.loadFromData(new JSONObject(jsonString));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFileName(Context context, String fileName) {
        FileInputStream fis;
        StringBuffer fileContent;
        try {
            fis = context.openFileInput(fileName);
            fileContent = new StringBuffer("");
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1)
            {
                fileContent.append(new String(buffer, 0, n));
            }
            this.loadFromData(fileContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String stringForKey(String key) {
        JSONObject localData = null;
        try {
            localData = this.jsonData.getJSONObject(this.language);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String value = key; // key is the default value returned if key is not found in json
        if(localData != null) {
            if (localData.has(key)) {
                try {
                    value = localData.getString(key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

}
