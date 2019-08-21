package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoBoard implements Serializable {

  private static final long serialVersionUID = 1L;

  private int no; 
  private String title;
  private Date createDate;
  private int viewCount;
  private int lessonNo;
  
  @Override
  public String toString() {
    return "PhotoBoard [no=" + no + ", title=" + title + ", createDate=" + createDate
        + ", viewCount=" + viewCount + ", lessonNo=" + lessonNo + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public int getLessonNo() {
    return lessonNo;
  }
  public void setLessonNo(int lessonNo) {
    this.lessonNo = lessonNo;
  }

}
