package com.clone.service.comments.services;

import com.clone.service.comments.dtos.CommentDTO;
import com.clone.service.comments.models.Comment;
import com.clone.service.comments.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CommentDTO> findAll() {
        List<Comment>comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO findById(Long id) {
        return null;
    }

    @Override
    public  CommentDTO create(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        Comment saveComment = commentRepository.save(comment);
        return modelMapper.map(saveComment, CommentDTO.class);
    }
}
