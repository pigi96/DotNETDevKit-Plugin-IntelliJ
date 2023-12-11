package utils;

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
import com.olvins.kit.dotnetdevkit.blocks.controls.flow.IfBlock;
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
                .withValue(condition)
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
                .withValue(initialization)
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
                .withValue(iteration)
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
                .withValue(identifier)
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
                .withValue(statement)
                .build();
    }

    public static IfBlock validDefaultIfBlock() {
        return ifBlock(validDefaultConditionBlock(), Arrays.asList(validDefaultStatementBlock()));
    }

    public static IfBlock invalidDefaultIfBlock() {
        return ifBlock(validDefaultConditionBlock(), Arrays.asList(invalidDefaultStatementBlock()));
    }

    public static IfBlock ifBlock(ConditionBlock conditionBlock, List<Block> blocks) {
        return IfBlockBuilder.start()
                .withCondition(conditionBlock)
                .withBlocks(blocks)
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
                .withInitialization(initializationBlock)
                .withCondition(conditionBlock)
                .withIteration(iterationBlock)
                .withBlocks(blocks)
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
                .withCondition(conditionBlock)
                .withBlocks(blocks)
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
                .withCondition(conditionBlock)
                .withBlocks(blocks)
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
                .withValue(memberModifier)
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
                .withValue(memberType)
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
                .withMemberModifier(memberModifierBlock)
                .withMemberType(memberTypeBlock)
                .withIdentifier(identifierBlock)
                .withBlocks(blocks)
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
                .withMemberModifier(memberModifierBlock)
                .withObjectType(objectTypeBlock)
                .withIdentifier(identifierBlock)
                .withParameters(parameterBlocks)
                .withBlocks(blocks)
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
                .withObjectTypeBlock(objectTypeBlock)
                .withIdentifierBlock(identifierBlock)
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
                .withValue(objectType)
                .build();
    }
}
