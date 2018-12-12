package com.qiniu.pili.droid.shortvideo.demo;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.kiwi.tracker.bean.KwFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FilterManager {

    public static List<KwFilter> filters = null;
    public static int currentFilterPos = 0;

    public static List<KwFilter> getFilters(Context context) {
        InputStream input = null;
        BufferedReader reader = null;
        String jsonStr = "";
        try {
            input = context.getAssets().open("filters.json");
            reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!TextUtils.isEmpty(jsonStr)) {
            FilterSetConfig filterSetConfig = new Gson().fromJson(jsonStr, FilterSetConfig.class);
            if (filterSetConfig != null) {
                filters = filterSetConfig.getFilters();
            }
        }
        return filters;
    }
}
