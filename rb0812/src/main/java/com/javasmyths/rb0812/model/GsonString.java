/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0812.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Richard
 */
abstract class GsonString {
  public String toGsonString () {
    Gson gson = new GsonBuilder().setDateFormat("MM/dd/yy").create();           // Or use new GsonBuilder().create();
    String json = gson.toJson(this);  // serializes target to Json
    return json;
  }
}
