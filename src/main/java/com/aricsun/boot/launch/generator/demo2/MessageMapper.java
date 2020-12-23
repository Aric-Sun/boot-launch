//package com.aricsun.boot.launch.generator.demo2;
//
//import java.util.List;
//import org.apache.ibatis.annotations.Param;
///**
// * function:注释掉，由于测试Spring data rest，搭配spring data jpa（45）
// * @Param
// * @Return
// */
//public interface MessageMapper {
//    long countByExample(MessageExample example);
//
//    int deleteByExample(MessageExample example);
//
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Message record);
//
//    int insertSelective(Message record);
//
//    List<Message> selectByExample(MessageExample example);
//
//    Message selectByPrimaryKey(Long id);
//
//    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);
//
//    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);
//
//    int updateByPrimaryKeySelective(Message record);
//
//    int updateByPrimaryKey(Message record);
//}