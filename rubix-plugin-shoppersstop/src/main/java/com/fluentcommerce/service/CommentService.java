package com.fluentcommerce.service;

import com.fluentcommerce.commonv2.graphql.mutation.common.CreateCommentForEntityMutation;
import com.fluentcommerce.commonv2.graphql.query.comment.GetCommentsQuery;
import com.fluentcommerce.commonv2.graphql.type.CreateCommentInput;
import com.fluentcommerce.model.comment.Comment;
import com.fluentretail.rubix.v2.context.Context;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommentService {

    private static final String CLASS_NAME = CommentService.class.getSimpleName();

    private Context context;

    public CommentService(Context context) {
        this.context =  context;
    }

    public boolean createComment(String entityType,String entityID ,String comment){
        try{
            CreateCommentInput createCommentInput = CreateCommentInput.builder()
                    .entityType(entityType)
                    .entityId(entityID)
                    .text(comment)
                    .build();
            CreateCommentForEntityMutation  createComment = CreateCommentForEntityMutation.builder().input(createCommentInput).build();
            context.action().mutation(createComment);
        }catch (Exception ex){
            return false;
        }
        return true;
    }

    public List<Comment> getComments(List<String> entityTypeList,List<String> entityIdList){

        GetCommentsQuery query = GetCommentsQuery.builder()
                                    .entityId(entityIdList)
                                     .entityType(entityTypeList)
                                        .build();
        GetCommentsQuery.Data data = (GetCommentsQuery.Data) context.api().query(query);
        List<Comment> commentList = data.comments().edges().stream()
                .map(GetCommentsQuery.Edge::node)
                .filter(Objects::nonNull)
                .map(Comment::from)
                .collect(Collectors.toList());
        return commentList;

    }

}
