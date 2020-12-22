package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.generator.demo.Article;
import com.aricsun.boot.launch.generator.demo.ArticleMapper;
import com.aricsun.boot.launch.generator.demo2.Message;
import com.aricsun.boot.launch.generator.demo2.MessageMapper;
import com.aricsun.boot.launch.model.ArticleVO;
import com.aricsun.boot.launch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 依赖 mybatis generator(better mybatis generator idea插件)生成的代码和配置文件
 * 由于使用Mybatis plus，故此代码被改造，具体看git快照
 * 多数据源测试，重新用回mybatis generator
 * @author AricSun
 * @date 2020.12.22 18:25
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private Mapper dozerMapper;
    @Resource
    private ArticleMapper articleMapper; // ArticleDao, 由mybatis generator 帮我们自动生成的代码
    @Resource
    private MessageMapper messageMapper;  // MessageDao, 由mybatis generator 帮我们自动生成的代码

    /*
     * function: 新增
     * @Param [article]
     * @Return void
     */
    @Override
    @Transactional
    public void saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);  // 注意Article的包，是com.aricsun.boot.launch.generator.Article;
        articleMapper.insert(articlePO);

        Message message = new Message();
        message.setContent("老是换来换去的烦不烦");
        message.setName("aricsun");
        messageMapper.insert(message);

//        int a = 10/0;  // 手动设置异常，测试transactional事务的原子性（Mybatis+atomikos）
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
