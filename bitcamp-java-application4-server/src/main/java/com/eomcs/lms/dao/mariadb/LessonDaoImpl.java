package com.eomcs.lms.dao.mariadb;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {

<<<<<<< HEAD
  SqlSessionFactory sqlSessionFactory;

  public LessonDaoImpl(
      SqlSessionFactory sqlSessionFactory) {
=======
  DataSource dataSource;
  SqlSessionFactory sqlSessionFactory;

  public LessonDaoImpl(
      DataSource conFactory, 
      SqlSessionFactory sqlSessionFactory) {
    this.dataSource = conFactory;
>>>>>>> b225cc774c43d8536e867dc57d78b74678850023
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public int insert(Lesson lesson) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.insert("LessonDao.insert", lesson);
    }
  }

  @Override
  public List<Lesson> findAll() throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("LessonDao.findAll");
    }
  }

  @Override
  public Lesson findBy(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("LessonDao.findBy", no);
    }
  }

  @Override
  public int update(Lesson lesson) throws Exception { 
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.update("LessonDao.update", lesson);
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      return sqlSession.delete("LessonDao.delete", no);
    }
  }

}










