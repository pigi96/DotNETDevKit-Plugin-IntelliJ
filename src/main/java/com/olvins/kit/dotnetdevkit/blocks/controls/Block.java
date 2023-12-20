package com.olvins.kit.dotnetdevkit.blocks.controls;

import com.olvins.kit.dotnetdevkit.errors.ConditionalException;
import com.olvins.kit.dotnetdevkit.types.BlockType;
import com.olvins.kit.dotnetdevkit.types.FormatStyle;
import com.olvins.kit.dotnetdevkit.utils.BaseListBlock;
import com.olvins.kit.dotnetdevkit.utils.Formatters;
import com.olvins.kit.dotnetdevkit.utils.IFormatter;
import com.olvins.kit.dotnetdevkit.utils.IValidator;
import com.olvins.kit.dotnetdevkit.utils.ListBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main code class that is contained as coding block, used for generation of code,
 * deep stacking code, and TBD
 */
public abstract class Block implements IBlock {
    protected String template;
    protected String generatedCode;
    protected HashMap<String, Object> index;
    protected BlockType blockType;
    protected IValidator validator;
    protected int depth;

    private static FormatStyle formatStyle = FormatStyle.StandaloneBrace; // Can only be set for all code at once, this way different styles cannot be used in the same code generation

    public Block(String template, BlockType blockType, IValidator validator, Object... objects) {
        this.template = template;
        this.blockType = blockType;
        this.validator = validator;

        modifyTemplate(objects);
    }

    public String generate() {
        String generatedCode = template;
        for (Map.Entry<String, Object> entry : index.entrySet()) {
            String placeholder = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof BaseListBlock) {
                generatedCode = generatedCode.replace(placeholder, ((BaseListBlock) value).getCode());
            } else if (value instanceof Block) {
                Block block = (Block) value;
                generatedCode = generatedCode.replace(placeholder, block.generate());
            } else {
                generatedCode = generatedCode.replace(placeholder, value.toString());
            }
        }

        if (validator != null) {
            validator.validate(generatedCode);
        }

        this.generatedCode = generatedCode;
        return generatedCode;
    }

    public String getGeneratedCode() {
        generate();
        return generatedCode;
    }

    public String getGeneratedFormattedCode() {
        generate();
        formatCode();
        return generatedCode;
    }

    public String getCode() {
        return generatedCode;
    }

    public BlockType getBlockType() {
        return this.blockType;
    }

    private void modifyTemplate(Object... objects) throws ConditionalException {
        index = new HashMap<>();

        for (Object block : objects) {
            if (block instanceof BaseListBlock) {
                BaseListBlock innerBlocks = (BaseListBlock) block;
                index.put(innerBlocks.getBlockType().getValue(), innerBlocks);
            } else if (block instanceof Block) {
                Block blockBlock = (Block) block;
                index.put(blockBlock.getBlockType().getValue(), blockBlock);
            } else {
                String stringBlock = (String) block;
                index.put(BlockType.STRING_BLOCK.getValue(), stringBlock);
            }
        }
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getTemplate() {
        return this.index;
    }

    public void formatCode() {
        formatCode(this.formatStyle);
    }

    public void formatCode(FormatStyle formatStyle) {
        IFormatter formatter;
        switch (formatStyle) {
            case EndOfLineBrace:
                formatter = new Formatters.EndOfLineBraceFormat();
                break;
            case StandaloneBrace:
                formatter = new Formatters.StandaloneBraceFormat();
                break;
            default:
                formatter = new Formatters.StandaloneBraceFormat();
        }

        if (generatedCode == null) {
            throw new IllegalStateException("Code formatting can only be called after code has been generated");
        }

        this.generatedCode = formatter.format(this.generatedCode);
    }

    public static void setFormatStyle(FormatStyle formatStyleNew) {
        formatStyle = formatStyleNew;
    }
}
