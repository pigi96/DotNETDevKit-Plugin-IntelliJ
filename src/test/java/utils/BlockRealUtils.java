package utils;

import com.olvins.kit.ClassBlockBuilder;
import com.olvins.kit.ConditionBlockBuilder;
import com.olvins.kit.DoWhileBlockBuilder;
import com.olvins.kit.ForBlockBuilder;
import com.olvins.kit.FunctionBlockBuilder;
import com.olvins.kit.IdentifierBlockBuilder;
import com.olvins.kit.IfBlockBuilder;
import com.olvins.kit.IfDecisionBlockBuilder;
import com.olvins.kit.InitializationBlockBuilder;
import com.olvins.kit.IterationBlockBuilder;
import com.olvins.kit.MemberModifierBlockBuilder;
import com.olvins.kit.MemberTypeBlockBuilder;
import com.olvins.kit.ObjectTypeBlockBuilder;
import com.olvins.kit.ParameterBlockBuilder;
import com.olvins.kit.StatementBlockBuilder;
import com.olvins.kit.WhileBlockBuilder;
import com.olvins.kit.dotnetdevkit.blocks.controls.Block;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ClassBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.FunctionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.components.ParameterBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ConditionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IdentifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.InitializationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.IterationBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberModifierBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.MemberTypeBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.ObjectTypeBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.declarations.StatementBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.DoWhileBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.ForBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfDecisionBlock;
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.WhileBlock;

import java.util.Arrays;
import java.util.List;

public class BlockRealUtils {
    public static ConditionBlock validDefaultConditionBlock() {
        return conditionBlock(SyntaxConstants.VALID_CONDITION);
    }

    public static ConditionBlock invalidDefaultConditionBlock() {
        return conditionBlock(SyntaxConstants.INVALID_CONDITION);
    }

    public static ConditionBlock conditionBlock(String condition) {
        return ConditionBlockBuilder.start()
                .condition(condition)
                .build();
    }

    public static InitializationBlock validDefaultInitializationBlock() {
        return initializationBlock(SyntaxConstants.VALID_INT_INITIALIZATION);
    }

    public static InitializationBlock invalidDefaultInitializationBlock() {
        return initializationBlock(SyntaxConstants.INVALID_INT_INITIALIZATION);
    }

    public static InitializationBlock initializationBlock(String initialization) {
        return InitializationBlockBuilder.start()
                .initialization(initialization)
                .build();
    }

    public static IterationBlock validDefaultIterationBlock() {
        return iterationBlock(SyntaxConstants.VALID_INT_ITERATION);
    }

    public static IterationBlock invalidDefaultIterationBlock() {
        return iterationBlock(SyntaxConstants.INVALID_INT_ITERATION);
    }

    public static IterationBlock iterationBlock(String iteration) {
        return IterationBlockBuilder.start()
                .initialization(iteration)
                .build();
    }

    public static IdentifierBlock validDefaultIdentifierBlock() {
        return identifierBlock(SyntaxConstants.VALID_IDENTIFIER);
    }

    public static IdentifierBlock invalidDefaultIdentifierBlock() {
        return identifierBlock(SyntaxConstants.INVALID_IDENTIFIER);
    }

    public static IdentifierBlock identifierBlock(String identifier) {
        return IdentifierBlockBuilder.start()
                .identifier(identifier)
                .build();
    }

    public static StatementBlock validDefaultStatementBlock() {
        return statementBlock(SyntaxConstants.VALID_STRING_DECLARATION);
    }

    public static StatementBlock invalidDefaultStatementBlock() {
        return statementBlock(SyntaxConstants.INVALID_DECLARATION_1);
    }

    public static StatementBlock statementBlock(String statement) {
        return StatementBlockBuilder.start()
                .condition(statement)
                .build();
    }

    public static IfDecisionBlock validDefaultIfBlock() {
        return ifBlock(validDefaultConditionBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static IfDecisionBlock invalidDefaultIfBlock() {
        return ifBlock(validDefaultConditionBlock(), Arrays.asList(invalidDefaultStatementBlock()));
    }

    public static IfDecisionBlock ifBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        return IfDecisionBlockBuilder.start()
                .blocks(blocks)
                .build();
    }

    public static ForBlock validDefaultForBlock() {
        return forBlock(validDefaultInitializationBlock(), validDefaultConditionBlock(), validDefaultIterationBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static ForBlock invalidDefaultForBlock() {
        return forBlock(validDefaultInitializationBlock(), validDefaultConditionBlock(), validDefaultIterationBlock(), Arrays.asList(invalidDefaultStatementBlock()));
    }

    public static ForBlock forBlock(InitializationBlock initializationBlock, ConditionBlock conditionBlock, IterationBlock iterationBlock, List<Block> blocks) {
        return ForBlockBuilder.start()
                .initializationBlock(initializationBlock)
                .conditionBlock(conditionBlock)
                .iterationBlock(iterationBlock)
                .blocks(blocks)
                .build();
    }

    public static WhileBlock validDefaultWhileBlock() {
        return whileBlock(validDefaultConditionBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static WhileBlock invalidDefaultWhileBlock() {
        return whileBlock(validDefaultConditionBlock(), Arrays.asList(invalidDefaultStatementBlock()));
    }

    public static WhileBlock whileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        return WhileBlockBuilder.start()
                .conditionBlock(conditionBlock)
                .blocks(blocks)
                .build();
    }

    public static DoWhileBlock validDefaultDoWhileBlock() {
        return doWhileBlock(validDefaultConditionBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static DoWhileBlock invalidDefaultDoWhileBlock() {
        return doWhileBlock(validDefaultConditionBlock(), Arrays.asList(invalidDefaultStatementBlock()));
    }

    public static DoWhileBlock doWhileBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        return DoWhileBlockBuilder.start()
                .conditionBlock(conditionBlock)
                .blocks(blocks)
                .build();
    }

    public static MemberModifierBlock validDefaultMemberModifierBlock() {
        return memberModifierBlock(SyntaxConstants.VALID_MEMBER_MODIFIER);
    }

    public static MemberModifierBlock invalidDefaultMemberModifierBlock() {
        return memberModifierBlock(SyntaxConstants.INVALID_MEMBER_MODIFIER);
    }

    public static MemberModifierBlock memberModifierBlock(String memberModifier) {
        return MemberModifierBlockBuilder.start()
                .classModifier(memberModifier)
                .build();
    }

    public static MemberTypeBlock validDefaultMemberTypeBlock() {
        return memberTypeBlock(SyntaxConstants.VALID_MEMBER_TYPE);
    }

    public static MemberTypeBlock invalidDefaultMemberTypeBlock() {
        return memberTypeBlock(SyntaxConstants.INVALID_MEMBER_TYPE);
    }

    public static MemberTypeBlock memberTypeBlock(String memberType) {
        return MemberTypeBlockBuilder.start()
                .classType(memberType)
                .build();
    }

    public static ClassBlock validDefaultClassBlock() {
        return classBlock(validDefaultMemberModifierBlock(), validDefaultMemberTypeBlock(), validDefaultIdentifierBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static ClassBlock invalidDefaultClassBlock() {
        return classBlock(validDefaultMemberModifierBlock(), validDefaultMemberTypeBlock(), validDefaultIdentifierBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static ClassBlock classBlock(MemberModifierBlock memberModifierBlock, MemberTypeBlock memberTypeBlock, IdentifierBlock identifierBlock, List<Block> blocks) {
        return ClassBlockBuilder.start()
                .memberModifierBlock(memberModifierBlock)
                .memberTypeBlock(memberTypeBlock)
                .identifierBlock(identifierBlock)
                .blocks(blocks)
                .build();
    }

    public static FunctionBlock validDefaultFunctionBlock() {
        return functionBlock(validDefaultMemberModifierBlock(), validDefaultObjectTypeBlock(), validDefaultIdentifierBlock(), Arrays.asList(validDefaultParameterBlock()), Arrays.asList(validDefaultStatementBlock()));
    }

    public static FunctionBlock invalidDefaultFunctionBlock() {
        return functionBlock(validDefaultMemberModifierBlock(), validDefaultObjectTypeBlock(), validDefaultIdentifierBlock(), Arrays.asList(validDefaultParameterBlock()), Arrays.asList(validDefaultStatementBlock()));
    }

    public static FunctionBlock functionBlock(MemberModifierBlock memberModifierBlock, ObjectTypeBlock objectTypeBlock, IdentifierBlock identifierBlock, List<ParameterBlock> parameterBlocks, List<Block> blocks) {
        return FunctionBlockBuilder.start()
                .memberModifierBlock(memberModifierBlock)
                .objectTypeBlock(objectTypeBlock)
                .identifierBlock(identifierBlock)
                .parameterBlocks(parameterBlocks)
                .blocks(blocks)
                .build();
    }

    public static ParameterBlock validDefaultParameterBlock() {
        return parameterBlock(validDefaultObjectTypeBlock(), validDefaultIdentifierBlock());
    }

    public static ParameterBlock invalidDefaultParameterBlock() {
        return parameterBlock(validDefaultObjectTypeBlock(), validDefaultIdentifierBlock());
    }

    public static ParameterBlock parameterBlock(ObjectTypeBlock objectTypeBlock, IdentifierBlock identifierBlock) {
        return ParameterBlockBuilder.start()
                .objectTypeBlock(objectTypeBlock)
                .identifierBlock(identifierBlock)
                .build();
    }

    public static ObjectTypeBlock validDefaultObjectTypeBlock() {
        return objectTypeBlock(SyntaxConstants.VALID_OBJECT_TYPE);
    }

    public static ObjectTypeBlock invalidDefaultObjectTypeBlock() {
        return objectTypeBlock(SyntaxConstants.INVALID_OBJECT_TYPE);
    }

    public static ObjectTypeBlock objectTypeBlock(String objectType) {
        return ObjectTypeBlockBuilder.start()
                .objectType(objectType)
                .build();
    }
}
