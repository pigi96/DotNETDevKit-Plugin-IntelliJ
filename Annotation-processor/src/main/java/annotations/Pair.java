package annotations;

import java.util.Objects;

/**
 * Pair class that can be used in conjunction with Set/Map classes or any other similar class, the comparison is used
 * with only the left pair, since the right pair should be used for additional info only, type can be used to set for
 * additional filtering or mapping info
 */
public class Pair {
    private String left;
    private String right;
    private Type type;

    public Pair(String left, String right) {
        this.left = left;
        this.right = right;
        this.type = Type.NONE;
    }

    public Pair(String left, String right, Type type) {
        this.left = left;
        this.right = right;
        this.type = type;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair that = (Pair) o;
        return Objects.equals(left, that.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left);
    }
}
