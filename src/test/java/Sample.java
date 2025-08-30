import com.ivan.pronin.learning.trees.util.TreeFactory;
import org.junit.jupiter.api.Test;

/**
 * @author Ivan Pronin
 * @since 26.08.2025
 */
public class Sample {

    @Test
    public void test() {
        var tree = TreeFactory.createSampleBST();
        System.out.println(tree);
    }

}
