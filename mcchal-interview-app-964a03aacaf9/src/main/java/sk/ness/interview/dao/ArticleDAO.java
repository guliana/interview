package sk.ness.interview.dao;

import java.util.List;


import sk.ness.interview.domain.Article;

public interface ArticleDAO {

  /** Returns {@link Article} with provided ID */
  Article findByID(Integer articleId);

  /** Returns all available {@link Article}s */
  List<Article> findAll();
  
  /** Returns all available {@link Article}s which contain provided word- searchedText */
  List<Article> findByText(String searchText);

  /** Persists {@link Article} into the DB */
  void persist(Article article);
}

