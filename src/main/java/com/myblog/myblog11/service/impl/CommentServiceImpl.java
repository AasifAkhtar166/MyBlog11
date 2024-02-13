package com.myblog.myblog11.service.impl;

import com.myblog.myblog11.entity.Comment;
import com.myblog.myblog11.entity.Post;
import com.myblog.myblog11.exception.ResourceNotFoundException;
import com.myblog.myblog11.payload.CommentDto;
import com.myblog.myblog11.repository.CommentRepository;
import com.myblog.myblog11.repository.PostRepository;
import com.myblog.myblog11.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private ModelMapper modelMapper;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDto createComments(CommentDto commentDto, long postId) {

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found with id: " + postId)
        );

        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment saveComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setId(saveComment.getId());
        dto.setEmail(saveComment.getEmail());
        dto.setText(saveComment.getText());



        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found for Id: " + id)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found for Id: " + id)
        );

        Comment c = mapToEntity(commentDto);
        c.setId(comment.getId());
        c.setPost(post);
        Comment saveComment = commentRepository.save(c);

        return mapToDto(saveComment);
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment dto = modelMapper.map(commentDto, Comment.class);
        return dto;
    }
}
