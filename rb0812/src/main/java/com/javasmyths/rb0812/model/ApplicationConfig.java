/*
 * Copyright (C) 2018 JavaSmyths javasmyths@javasmyths.com
 */
package com.javasmyths.rb0812.model;

import com.javasmyths.rb0812.model.GsonString;
import com.javasmyths.rb0812.model.Tool;
import java.util.HashMap;

/**
 *
 * @author Richard
 */
public class ApplicationConfig extends GsonString {
  
  public HashMap<String, Tool> tools = new HashMap();

  public ApplicationConfig() {
  }

  public void addTool (String toolCode, Tool tool) {
    tools.put(toolCode, tool);
  }
  
  public HashMap getTools() {
    return tools;
  }
  public void setTools(HashMap tools) {
    this.tools = tools;
  }
}
