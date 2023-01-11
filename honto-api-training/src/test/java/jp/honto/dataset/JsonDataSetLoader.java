package jp.honto.dataset;

import org.dbunit.dataset.IDataSet;
import org.jboss.arquillian.persistence.dbunit.dataset.json.JsonDataSet;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.github.springtestdbunit.dataset.AbstractDataSetLoader;

/**
 * テストデータ用JSONファイルのローダー.
 *
 * Created by chiaki.hasegawa on 2015/02/10.
 */
public class JsonDataSetLoader extends AbstractDataSetLoader {

  /**
   * {@inheritDoc}
   */
  @Override
  public IDataSet loadDataSet(Class<?> testClass, String location) throws Exception {
    ResourceLoader resourceLoader = getResourceLoader(testClass);

    // get json path.
    String packageDir = testClass.getPackage().toString();
    packageDir = packageDir.replaceAll("package ", "");
    packageDir = packageDir.replaceAll("\\.", "/");
    packageDir = packageDir + "/";

    String[] resourceLocations = getResourceLocations(testClass, "classpath:".concat(packageDir).concat(location));
    for (String resourceLocation : resourceLocations) {
      Resource resource = resourceLoader.getResource(resourceLocation);
      if (resource.exists()) {
        return createDataSet(resource);
      }
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected IDataSet createDataSet(Resource resource) throws Exception {
    return new JsonDataSet(resource.getFile());
  }

}
