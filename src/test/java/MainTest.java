import koschei.KoscheiTheDeathless;
import koschei.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class MainTest {

  private final String ANSI_RESET = "\u001B[0m";
  private final String ANSI_CL1 = "\u001B[33m";
  private final String ANSI_CL2 = "\u001B[35m";

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void mainTest() {
    String text = "На свете есть океан , на океане остров , на острове дерево , на дереве заяц , в зайце утка , в утке яйцо , в яйце иголка , смерть Кощея на игле :(";

    KoscheiTheDeathless koscheiTheDeathless = applicationContext.getBean(KoscheiTheDeathless.class);
    System.out.println(ANSI_CL2 + koscheiTheDeathless.getRulesByDeth() + ANSI_RESET);
    String testText = koscheiTheDeathless.getRulesByDeth();

    if (!testText.contains(text) && testText.length() <= text.length()) {
      Assert.fail(ANSI_CL1 + "Тест провален, не корректная связь бинов. Итоговая фраза не верна." + ANSI_RESET);
    }
  }

}
