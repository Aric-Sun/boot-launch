package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.dao.ArticleRepository;
import com.aricsun.boot.launch.model.Article;
import com.aricsun.boot.launch.model.ArticleVO;
import com.aricsun.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author AricSun
 * @date 2020.12.16 21:50
 */
@Service
public class ArticleJPAServiceImpl implements ArticleService {

    // 讲JPA仓库对象注入
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Override
    public void saveArticle(ArticleVO articleVO) {
        Article articlePO = dozerMapper.map(articleVO, Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        // 和新增一样，实际上是根据articlePO.id去update，没有id就变成新增了
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        // Optional可能有，可能为空
        Optional<Article> article = articleRepository.findById(id);
        return dozerMapper.map(article.get(), ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleList = articleRepository.findAll();
        return DozerUtils.mapList(articleList, ArticleVO.class);
    }
}
