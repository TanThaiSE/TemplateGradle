package training.config;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chiaki.hasegawa on 2015/01/08.
 */
@AnnotateWith(annotations = {@Annotation(target = AnnotationTarget.CLASS, type = Component.class),
    @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class)})
public @interface ConfigAutowireable {
}
