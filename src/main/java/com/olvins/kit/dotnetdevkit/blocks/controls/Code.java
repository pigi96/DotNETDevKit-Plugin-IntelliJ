package com.olvins.kit.dotnetdevkit.blocks.controls;

import java.util.HashMap;
import java.util.Map;

/**
 * Main code class that is contained as coding block, used for generation of code,
 * deep stacking code, and TBD
 */
public class Code {
    protected String template;
    protected HashMap<String, Object> index;

    public Code(String template, HashMap<String, Object> index) {
        this.template = template;
        this.index = index;
    }

    public String value() {
        String generatedCode = template;
        for (Map.Entry<String, Object> entry : index.entrySet()) {
            String placeholder = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Code) {
                generatedCode = generatedCode.replace(placeholder, ((Code) value).value());
            } else {
                generatedCode = generatedCode.replace(placeholder, value.toString());
            }
        }
        return generatedCode;
    }
}
