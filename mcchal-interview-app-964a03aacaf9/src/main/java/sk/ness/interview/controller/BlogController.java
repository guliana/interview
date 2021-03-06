package sk.ness.interview.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.Comment;
import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;
import sk.ness.interview.service.ArticleService;
import sk.ness.interview.service.ArticleServiceImpl;
import sk.ness.interview.service.AuthorService;
import sk.ness.interview.service.CommentService;
import sk.ness.interview.service.CommentServiceImpl;

@Api
@RestController
public class BlogController {

	@Resource
	private ArticleService articleService;

	@Resource
	private AuthorService authorService;

	@Resource
	private CommentService commentService;

	// ~~ Article

	@RequestMapping(value = "articles", method = RequestMethod.GET)
	public List<Article> getAllArticles() {
		return this.articleService.findAll();
	}

	@RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
	public Article getArticle(@PathVariable final Integer articleId) {
		return this.articleService.findByID(articleId);
	}

	@RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
	public List<Article> searchArticle(@PathVariable final String searchText) {
		return this.articleService.findByText(searchText);
		//throw new UnsupportedOperationException("Full text search not implemented.");
	}

	@RequestMapping(value = "articles/add", method = RequestMethod.PUT)
	public void addArticle(@RequestBody final Article article) {
		this.articleService.createArticle(article);
	}

	// ~~ Comments

	@RequestMapping(value = "comments", method = RequestMethod.GET)
	public List<Comment> getAllComments() {
		return this.commentService.findAll();
	}

	@RequestMapping(value = "comments/add", method = RequestMethod.PUT)
	public void addComment(@RequestBody final Comment comment) {
		this.commentService.createComment(comment);
	}

	// ~~ Author

	@RequestMapping(value = "authors", method = RequestMethod.GET)
	public List<Author> getAllAuthors() {
		return this.authorService.findAll();
	}

	@RequestMapping(value = "authors/stats", method = RequestMethod.GET)
	public List<AuthorStats> authorStats() {
		throw new UnsupportedOperationException("Author statistics not implemented.");
	}

}
