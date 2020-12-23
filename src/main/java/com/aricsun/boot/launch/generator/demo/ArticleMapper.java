//package com.aricsun.boot.launch.generator.demo;
//
//import java.util.List;
//import org.apache.ibatis.annotations.Param;
///**
// * function: 注释掉，由于测试Spring data rest，搭配spring data jpa（45）
// * @Param
// * @Return
// */
//public interface ArticleMapper {
//    long countByExample(ArticleExample example);
//
//    int deleteByExample(ArticleExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Article record);
//
//    int insertSelective(Article record);
//
//    List<Article> selectByExample(ArticleExample example);
//
//    Article selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);
//
//    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);
//
//    int updateByPrimaryKeySelective(Article record);
//
//    int updateByPrimaryKey(Article record);
//}