package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.validators.IValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main code class that is contained as coding block, used for generation of code,
 * deep stacking code, and TBD
 */
public class Block {
    protected String template;
    protected HashMap<String, Object> index;
    protected BlockType blockType;
    protected IValidator validator;

    public Block(String template, BlockType blockType, IValidator validator, Object... objects) {
        this.template = template;
        this.blockType = blockType;
        this.validator = validator;

        modifyTemplate(objects);
    }

    public String value() {
        String generatedCode = template;
        for (Map.Entry<String, Object> entry : index.entrySet()) {
            String placeholder = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof List) {
                String innerBlocks = ((List<Block>) value).stream()
                        .map(Block::value)
                        .collect(Collectors.joining("\n\t"));
                generatedCode = generatedCode.replace(placeholder, innerBlocks);
            } else if (value instanceof Block) {
                Block block = (Block) value;
                generatedCode = generatedCode.replace(placeholder, block.value());
            } else {
                generatedCode = generatedCode.replace(placeholder, value.toString());
            }
        }

        if (validator != null) {
            validator.validate(generatedCode);
        }

        return generatedCode;
    }

    public BlockType getBlockType() {
        return this.blockType;
    }

    private void modifyTemplate(Object... objects) throws ConditionalException {
        index = new HashMap<>();

        for (Object block : objects) {
            if (block instanceof List) {
                List<Block> innerBlocks = (List<Block>) block;
                index.put(BlockType.BLOCK.getValue(), innerBlocks);
            } else if (block instanceof Block) {
                Block blockBlock = (Block) block;
                index.put(blockBlock.getBlockType().getValue(), blockBlock);
            } else {
                String stringBlock = (String) block;
                index.put(BlockType.STRING_BLOCK.getValue(), stringBlock);
            }
        }
    }
}
