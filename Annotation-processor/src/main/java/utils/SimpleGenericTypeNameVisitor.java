package utils;

import javax.lang.model.type.IntersectionType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.SimpleTypeVisitor8;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

public class SimpleGenericTypeNameVisitor extends SimpleTypeVisitor8<String, Void> {

    private Elements elementUtils;

    public SimpleGenericTypeNameVisitor(Elements elementUtils) {
        this.elementUtils = elementUtils;
    }

    @Override
    public String visitIntersection(IntersectionType t, Void p) {
        TypeElement typeElement = elementUtils.getTypeElement(t.toString());
        if (typeElement == null) {
            return t.toString(); // Fallback to full type name
        }
        return typeElement.getSimpleName().toString();
    }

    // You can override other methods if needed to handle different kinds of types
}
