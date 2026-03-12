package jp.terasoluna.batch.sample.common;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jp.terasoluna.batch.sample.sample001.SMP001Dao;

public class MyBatisConnTest {

	public static void main(String[] args) {
		// 加载Spring配置
		ApplicationContext context = new ClassPathXmlApplicationContext("beansDef/SMP001.xml");
		try {
            // 方式1：直接获取SMP001Dao Bean（推荐，验证Dao是否创建成功）
            SMP001Dao smp001Dao = context.getBean(SMP001Dao.class);
            Integer testResult = smp001Dao.testConnection(); // 调用Dao的测试方法
            System.out.println("✅ SMP001Dao创建成功，测试SQL结果：" + testResult);

            // 方式2：通过SqlSessionTemplate手动调用（备用）
            SqlSessionTemplate sqlSession = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
            List<NyusyukkinData> resultList = sqlSession.selectList("jp.terasoluna.batch.sample.sample001.SMP001Dao.collectNyusyukkinData");
            System.out.println("✅ SqlSessionTemplate调用成功，测试结果：" + "");
            System.out.println("===== collectNyusyukkinData 查询结果 =====");
            System.out.println("总数据条数：" + resultList.size());
            for (int i = 0; i < resultList.size(); i++) {
            	NyusyukkinData resultData = resultList.get(i);
                System.out.println("第" + (i+1) + "条数据："  + resultData.getShitenName());
            }

        } catch (Exception e) {
            System.err.println("❌ 执行失败：" + e.getMessage());
            e.printStackTrace();
        }

	}

}
