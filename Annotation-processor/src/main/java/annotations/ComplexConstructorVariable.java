package annotations;

public class ComplexConstructorVariable {
    private String type;
    private String oldType;
    private String name;
    private boolean simplified;

    public ComplexConstructorVariable(String type, String oldType, String name, boolean simplified) {
        this.type = type;
        this.oldType = oldType;
        this.name = name;
        this.simplified = simplified;
    }

    public ComplexConstructorVariable(String type, String name, boolean simplified) {
        this.type = type;
        this.oldType = type;
        this.name = name;
        this.simplified = simplified;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getVariable() {
        return type + " " + name;
    }

    public String getOldObject() {
        return "new " + oldType + "(" + name + ")";
    }

    public String builderComplexAddition() {
        if (!simplified) {
            return name + "(" + name + ")";
        } else {
            return name + "(new " + oldType + "(" + name + "))";
        }
    }

    public boolean isSimplified() {
        return simplified;
    }
}
