package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectStudent();
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1005);
        student.setName("武器");
        student.setEmail("wq@qq.com");
        student.setAge(32);
        int nums = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加数量=" +nums);
    }
}