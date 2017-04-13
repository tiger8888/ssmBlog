package global;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
/**
 * 对数据库的操作会事务回滚
 * @author Administrator
 *测试过程对数据库的操作，会产生脏数据，影响我们数据的正确性
 *不方便循环测试，即假如这次我们将一个记录删除了，下次就无法再进行这个Junit测试了，因为该记录已经删除，将会报错。
 *如果不使用事务回滚，我们需要在代码中显式的对我们的增删改数据库操作进行恢复，将多很多和测试无关的代码 
 */
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class BaseTest {

}
