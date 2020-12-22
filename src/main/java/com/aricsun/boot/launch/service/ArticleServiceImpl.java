package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.generator.Article;
import com.aricsun.boot.launch.generator.ArticleMapper;
import com.aricsun.boot.launch.model.ArticleVO;
import com.aricsun.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author AricSun
 * @date 2020.12.22 18:25
 */
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private Mapper dozerMapper;
    @Resource
    private ArticleMapper articleMapper; // ArticleDao, 由mybatis generator 帮我们自动生成的代码

    /*
     * function: 新增
     * @Param [article]
     * @Return void
     */
    @Override
    public void saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);  // 注意Article的包，是com.aricsun.boot.launch.generator.Article;
        articleMapper.insert(articlePO);
    }

    /*
     * function: 删除
     * @Param [id]
     * @Return void
     */
    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);  //该方法由自动代码生成提供，下同
    }

    /*
     * function: 修改
     * @Param [article]
     * @Return void
     */
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        // updateByPrimaryKeySelective由自动代码生成提供
        articleMapper.updateByPrimaryKeySelective(articlePO);  // Selective表示哪个字段有值，就更新哪个字段，没有这个Selective，就说明是全部更新，没有的值就是null
    }

    /*
     * function: 获取一篇文章
     * @Param [id]
     * @Return com.aricsun.boot.launch.model.ArticleVO
     */
    @Override
    public ArticleVO getArticle(Long id) {
        // selectByPrimaryKey由自动代码生成提供
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id), ArticleVO.class);
    }

    /*
     * function: 获取所有文章
     * @Param []
     * @Return java.util.List<com.aricsun.boot.launch.model.ArticleVO>
     */
    @Override
    public List<ArticleVO> getAll() {
        // selectByExample由自动代码生成提供, Example表示条件，参数null表示查询所有
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles, ArticleVO.class);
    }
}
