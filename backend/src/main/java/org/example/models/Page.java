package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Page {
  public String id;
  public String category;
  public String name;
  public String url;
  public int likesCount;
  public List<?> ratings = new ArrayList<>();
}
