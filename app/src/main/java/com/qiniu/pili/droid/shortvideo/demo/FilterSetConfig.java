package com.qiniu.pili.droid.shortvideo.demo;

import com.kiwi.tracker.bean.KwFilter;

import java.util.ArrayList;
import java.util.List;

public class FilterSetConfig {
    List<KwFilter> filters = new ArrayList();

    public FilterSetConfig() {
    }

    public List<KwFilter> getFilters() {
        return this.filters;
    }
}
