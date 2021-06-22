package com.example.conversionapplication.db;

import android.provider.BaseColumns;

public final class CategoryContract {
    private CategoryContract(){}
    public  static class CategoryEntry implements BaseColumns{
        public static final String TABLE_NAME = "category";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NAMES= "name";
    }
}