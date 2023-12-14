package org.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.example.models.Page;
import org.example.utils.JenaUtils;
import org.example.utils.RdfUtils;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
  String prefix = JenaUtils.getPrefix();

  List<List<String>> fields = new ArrayList<>();

  public RatingService() {
    // fill array on creation
    fields.add(new ArrayList<String>() {
      {
        add("ratingPageId");
        add("pageId");
      }
    });
    fields.add(new ArrayList<String>() {
      {
        add("ratingStars");
        add("stars");
      }
    });
    fields.add(new ArrayList<String>() {
      {
        add("ratingComment");
        add("comment");
      }
    });
  }

  public List<?> getAll() {
    String query = "SELECT ?individual ?ratingPageId ?ratingStars ?ratingComment\n" +
        "WHERE {\n" +
        "  ?individual a <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#Rating>.\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingPageId> ?ratingPageId }\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingStars> ?ratingStars }\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingComment> ?ratingComment }\n"
        +
        "}";

    return JenaUtils.get().executeSelect(query, fields);

  }

  public List<?> getByPageId(String pageId) {
    System.out.println("pageId: " + pageId);
    String query = "SELECT ?individual ?ratingPageId ?ratingStars ?ratingComment\n" +
        "WHERE {\n" +
        "  ?individual a <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#Rating>.\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingPageId> ?ratingPageId }\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingStars> ?ratingStars }\n"
        +
        "  OPTIONAL { ?individual <http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#ratingComment> ?ratingComment }\n"
        +
        "  FILTER regex(str(?ratingPageId), \"" + pageId + "\", \"i\")\n" +
        "}";

    return JenaUtils.get().executeSelect(query, fields);
  }

  public String add(Page page) {
    String pageId = UUID.randomUUID().toString();
    String template = templatePage(pageId, page.url, page.name, page.category, page.likesCount);
    RdfUtils.get().appendContentToRDF(template);
    return "Content added successfully.";
  }

  private String templatePage(String pageId, String pageUrl, String pageName, String pageCategory, int pageLikesCount) {
    String template = "<owl:NamedIndividual rdf:about=\"http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#"
        + pageId.substring(0, 4) + "\">\n" +
        "\t<rdf:type rdf:resource=\"http://www.semanticweb.org/mariem/ontologies/2023/9/untitled-ontology-2#Page\"/>\n"
        +
        "\t<untitled-ontology-2:pageId>" + pageId + "</untitled-ontology-2:pageId>\n" +
        "\t<untitled-ontology-2:pageLikesCount>" + pageLikesCount + "</untitled-ontology-2:pageLikesCount>\n" +
        "\t<untitled-ontology-2:pageCategory>" + pageCategory + "</untitled-ontology-2:pageCategory>\n" +
        "\t<untitled-ontology-2:pageName>" + pageName + "</untitled-ontology-2:pageName>\n" +
        "\t<untitled-ontology-2:pageUrl>" + pageUrl + "</untitled-ontology-2:pageUrl>\n" +
        "</owl:NamedIndividual>";

    return template;
  }

}
