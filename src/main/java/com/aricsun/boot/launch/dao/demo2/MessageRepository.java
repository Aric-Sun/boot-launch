package com.aricsun.boot.launch.dao.demo2;

import com.aricsun.boot.launch.model.demo2.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类似于 com.aricsun.boot.launch.dao.demo.ArticleRepository
 * @author AricSun
 * @date 2020.12.19 21:07
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
