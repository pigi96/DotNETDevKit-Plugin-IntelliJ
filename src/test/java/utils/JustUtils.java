package utils;

import com.olvins.kit.dotnetdevkit.blocks.controls.Block;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JustUtils {
    public static String collectBlocks(List<Block> blocks) {
        return blocks.stream()
                .map(Block::value)
                .collect(Collectors.joining("\n\t"));
    }
}
