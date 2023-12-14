package com.jdl.wps.component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;


public interface CacheHelper {
    Cache<String, List<Integer>> YearMonthHolidayCache = CacheBuilder.newBuilder().maximumSize(10000).expireAfterAccess(30, TimeUnit.DAYS).build();
}
