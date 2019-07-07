package com.test;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.company.config.MybatisConfig;
import com.company.mapper.SysLogMapper;

public class TestSysLog01 {
	@Test
	public void testFindPageObjects() {
		//1.获取sqlsession对象
		SqlSession session=
		MybatisConfig.getSqlSessionFactory().openSession(true);
		//2.获取接口对象的实现类对象
		Class<SysLogMapper> c1=SysLogMapper.class;
		System.out.println(c1.getName());//com.company.mapper.SysLogMapper
		System.out.println(c1.getSimpleName());//SysLogMapper
		SysLogMapper mapper=
		session.getMapper(c1);
		//3.基于接口进行删除
		List<Map<String,Object>> list=
		mapper.findPageObjects(0, 3);
		System.out.println(list);
		//4.释放资源
		session.close();
	}
	@Test
	public void testDeleteObject() {
		//1.获取sqlsession对象
		SqlSession session=
		MybatisConfig.getSqlSessionFactory()
		.openSession(ExecutorType.BATCH);
		//2.获取接口对象的实现类对象
		SysLogMapper mapper=
		session.getMapper(SysLogMapper.class);
		//3.基于接口进行删除
		int rows=mapper.deleteObject(16);
		session.commit();
		System.out.println("rows="+rows);
		//4.释放资源
		session.close();
	}
}