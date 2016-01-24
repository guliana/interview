package sk.ness.interview.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import sk.ness.interview.domain.Article;

/**
 * DAO for {@link Article} related DB operations
 *
 * @author michal.kmetka
 *
 */
@Repository
public class ArticleHibernateDAO implements ArticleDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Article findByID(final Integer articleId) {
		return (Article) this.sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findAll() {
		return this.sessionFactory.getCurrentSession().createSQLQuery("select * from articles").addEntity(Article.class)
				.list();
	}

	@Override
	public void persist(final Article article) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(article);
	}

	@Override
	public List<Article> findByText(String searchText) {
		// TODO Auto-generated method stub
		return (List<Article>) this.sessionFactory.getCurrentSession().get(Article.class, searchText);
	}

}
