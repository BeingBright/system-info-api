package nl.brighton.systeminfoapi.util;

import nl.brighton.systeminfoapi.SystemInfoApiApplication;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class IntegrationTestStartup implements BeforeAllCallback,
    ExtensionContext.Store.CloseableResource {

  private static ConfigurableApplicationContext ctx;

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    String key = this.getClass().getName();
    Object value = context.getRoot().getStore(Namespace.GLOBAL).get(key);
    if (value == null) {
      context.getRoot().getStore(Namespace.GLOBAL).put(key, this);
      startup();
    }
  }

  private void startup() {
    ctx = SpringApplication.run(SystemInfoApiApplication.class);
  }

  @Override
  public void close() throws Throwable {
    ctx.close();
  }
}
